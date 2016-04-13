package com.emc.documentum.test;

import java.text.DateFormat;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.emc.documentum.RestSampleUser1Application;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumProperty;

/**
 * Unit Tests for Integration Layer
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestSampleUser1Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0", "management.port=0" })
@DirtiesContext
public abstract class IntegrationLayerTests {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${local.server.port}")
	private int port;

	protected abstract String getAPI();

	@Test
	public void testCabinetsRetrieval() throws Exception {
		DocumentumFolder[] cabinets = null;
		cabinets = retrieveCabinets();
		Assert.assertTrue(getAPI() + " Zero Cabinets Returned", cabinets.length > 0);

	}

	@Test
	public void testCabinetsType() {
		DocumentumFolder[] cabinets = null;
		cabinets = retrieveCabinets();
		for (DocumentumFolder folder : cabinets) {
			Assert.assertTrue(getAPI() + " : Cabinet Type not equal Cabinet", folder.getType().equals("Cabinet"));
		}

	}

	@Test
	public void testCreateThenDeleteFolder() {
		DocumentumFolder [] cabinets = retrieveCabinets();
		if(cabinets.length == 0 || cabinets == null){
			Assert.fail("No Cabinets Available");
		}
		String folderName = "MySampleCreatedFolder" + (Math.random() * 10000);
		ResponseEntity<DocumentumFolder> folderCreationResponse = createFolder(cabinets[0].getId(),folderName);
		Assert.assertTrue("Unable to Create Folder",folderCreationResponse.getStatusCode() == HttpStatus.OK);
		Assert.assertNotNull("Created Folder Not Equal Null", folderCreationResponse.getBody().getId());
		logger.info("Created Folder with Id:- " + folderCreationResponse.getBody().getId());
		ResponseEntity<Void> responseEntity = deleteObject(folderCreationResponse.getBody().getId());
		Assert.assertTrue("unable to delete Folder", responseEntity.getStatusCode() == HttpStatus.OK);
		logger.info("Delete response equal " + responseEntity.getStatusCode());
	}
	@Test
	public void testCreateDocumentCheckoutThenCancelCheckout()
	{
		DocumentumFolder [] cabinets = retrieveCabinets();
		if(cabinets.length == 0 || cabinets == null){
			Assert.fail("No Cabinets Available");
		}
		String documentName = "MySampleCreatedDocument" + (Math.random() * 10000);
		ResponseEntity<DocumentumDocument> documentCreationResponse = createDocument(documentName,cabinets[0].getId());
		Assert.assertTrue("Unable to Create Document",documentCreationResponse.getBody().getId()!=null);
		logger.info("Created Document with Id:- " + documentCreationResponse.getBody().getId());
		ResponseEntity<DocumentumDocument> checkoutResponse = checkoutDocument(documentCreationResponse.getBody().getId());
		Assert.assertTrue("Checkout Failed. checked out object's isCheckedOut flag equals false", checkoutResponse.getBody().isCheckedOut());
		Assert.assertTrue("Checkout Failed. checked out object's lock user equals null", checkoutResponse.getBody().getLockUser()!=null );
		logger.info("document Checked out by user " + checkoutResponse.getBody().getLockUser());
		ResponseEntity<DocumentumDocument> cancelCheckoutResponse = cancelCheckoutDocument(documentCreationResponse.getBody().getId());
		Assert.assertTrue("cancel Checkout Failed. checked out object's isCheckedOut flag equals true", !cancelCheckoutResponse.getBody().isCheckedOut());
		Assert.assertTrue("cancel Checkout Failed. checked out object's lock user not equal null", cancelCheckoutResponse.getBody().getLockUser()==null);
		logger.info("document cancel checkout successful  ");
		ResponseEntity<Void> responseEntity = deleteObject(documentCreationResponse.getBody().getId());
		Assert.assertTrue("unable to delete Document", responseEntity.getStatusCode() == HttpStatus.OK);
		logger.info("Delete response equal " + responseEntity.getStatusCode());
	}
	

	private DocumentumFolder[] retrieveCabinets() {
		ResponseEntity<DocumentumFolder[]> entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + this.port + "/" + getAPI() + "/services/get/cabinets", DocumentumFolder[].class);
		return entity.getBody();
	}

	private ResponseEntity<DocumentumFolder> createFolder(String cabinetName, String folderName) {
		ResponseEntity<DocumentumFolder> entity = new TestRestTemplate().exchange("http://localhost:" + this.port
				+ "/" + getAPI() + "/services/folder/create/" + cabinetName + "/" + folderName,HttpMethod.POST,null, DocumentumFolder.class);
		return entity;
	}

	private ResponseEntity<Void> deleteObject(String objectId) {
		ResponseEntity<Void> entity = new TestRestTemplate().exchange(
				"http://localhost:" + this.port + "/" + getAPI() + "/services/delete/object/id/" + objectId, HttpMethod.DELETE,
				null, Void.class);
		return entity;
	}
	private ResponseEntity<DocumentumDocument> createDocument(String documentName,String folderId)
	{
		DocumentumDocument document = buildDocumentumDocument(documentName, "dm_document", null);
		ResponseEntity<DocumentumDocument> entity = new TestRestTemplate().exchange(
				"http://localhost:" + this.port + "/" + getAPI() + "/services/folder/"+folderId+"/document" , HttpMethod.POST,
				new HttpEntity<DocumentumDocument>(document), DocumentumDocument.class);
		return entity;
	}
	private DocumentumDocument buildDocumentumDocument(String documentName,String type,ArrayList<DocumentumProperty> properties)
	{
		DocumentumDocument document = new DocumentumDocument();
		document.setName(documentName);
		document.setType(type);
		document.setProperties(properties);
		return document;
	}
	private ResponseEntity<DocumentumDocument> checkoutDocument(String documentId)
	{
		
		ResponseEntity<DocumentumDocument> entity = new TestRestTemplate().exchange(
				"http://localhost:" + this.port + "/" + getAPI() + "/services/get/document/checkout/id/"+documentId , HttpMethod.POST,
				null, DocumentumDocument.class);
		return entity;
	}
	private ResponseEntity<DocumentumDocument> cancelCheckoutDocument(String documentId)
	{
		ResponseEntity<DocumentumDocument> entity = new TestRestTemplate().exchange(
				"http://localhost:" + this.port + "/" + getAPI() + "/services/get/document/cancelCheckout/id/"+documentId , HttpMethod.POST,
				null, DocumentumDocument.class);
		return entity;
	}
}
