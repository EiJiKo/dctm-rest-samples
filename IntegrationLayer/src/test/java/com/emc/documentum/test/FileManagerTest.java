package com.emc.documentum.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.emc.documentum.IntegrationLayer;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IntegrationLayer.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=8080", "management.port=0" })
public class FileManagerTest {

	public static final String BASE_URL = "http://localhost:8080/api/" ;
	public static final String DELEGATE_KEY = "Rest" ;
	public static final String DOCUMENT_ID = "090007c280007113" ;
	public static final String CREATED_FOLDER_NAME = "new_folder" ;
	public static String PARENT_FOLDER_ID = "0b0007c280007108" ;
	
	@Test
	public void testFolderCrud()
	{
		try {
		String createFolderUrl = "createFolderUrl" ;
		String listUrl = "listUrl" ;
		String deleteURL = "deleteFolderUrl" ;
		
		HttpEntity<?> httpEntityListUrl = createRequestForListURL("",DELEGATE_KEY) ;
		ResponseEntity<String> listURLEntity = new TestRestTemplate().exchange( BASE_URL + listUrl  , HttpMethod.POST, httpEntityListUrl , String.class);
		JSONObject body = (JSONObject) JSONValue.parseWithException(listURLEntity.getBody());
		JSONArray array = (JSONArray) body.get("result") ;
		PARENT_FOLDER_ID = getCabinetIdFromArray(array) ;
		
		HttpEntity<?> httpEntityCreateFolder = createRequestForCreateFolder(PARENT_FOLDER_ID , DELEGATE_KEY , CREATED_FOLDER_NAME) ;
		ResponseEntity<String> createFolderEntity = new TestRestTemplate().exchange( BASE_URL + createFolderUrl , HttpMethod.POST, httpEntityCreateFolder , String.class);
		
		httpEntityListUrl = createRequestForListURL(PARENT_FOLDER_ID ,DELEGATE_KEY) ;
		listURLEntity = new TestRestTemplate().exchange( BASE_URL + listUrl  , HttpMethod.POST , httpEntityListUrl , String.class);
		
		//getting created folder ID 
		body = (JSONObject) JSONValue.parseWithException(listURLEntity.getBody());
		JSONArray array2 = (JSONArray) body.get("result") ;
		String createdFolderId = getFolderIdFromArray(array2, CREATED_FOLDER_NAME) ;
		
		HttpEntity<?> httpEntityForDelete = createRequestForDeleteFolder(createdFolderId , DELEGATE_KEY) ;
		ResponseEntity<String> deleteFolderURL = new TestRestTemplate().postForEntity( BASE_URL + deleteURL , httpEntityForDelete , String.class);
		//listURLEntity = new TestRestTemplate().exchange( BASE_URL + listUrl  , HttpMethod.POST , deleteFolderURL , String.class);		
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	
	//@Test
	public void testOpenDocument()
	{
		//TODO document id here should not be static ... this will be changed as soon as we can create document
		String documentContent = "document/content/" ;
		String documentOpen = "document/open/" ;
		ResponseEntity<String> documentContentEntity = new TestRestTemplate().getForEntity( BASE_URL + documentContent + DOCUMENT_ID , null , String.class);
		Assert.assertNotNull(documentContentEntity);
		ResponseEntity<String> documentOpenEntity = new TestRestTemplate().getForEntity( BASE_URL + documentOpen + DOCUMENT_ID  , null , String.class);
		Assert.assertNotNull(documentOpenEntity);

	}

	@Test
	public void testRenameURL()
	{
		String renameUrl = "renameUrl" ;
		ResponseEntity<JSONObject> renameUrlEntity = new TestRestTemplate().postForEntity( BASE_URL + renameUrl , null , JSONObject.class);
		JSONObject body = renameUrlEntity.getBody() ;
		String s = (String) body.get("result") ;
		Assert.assertNotNull(s);
		//JSONObject result = (JSONObject) body.get("result") ;
		//"/api/copyUrl" "/api/removeUrl" "/api/editUrl"  "/api/permissionsUrl" "/api/extractUrl" "/api/uploadUrl")
	}	
	
	
	private HttpEntity<?> createRequestForCreateFolder(String parentId , String delegatekey , String folderName)
	{
		JSONObject body = new JSONObject() ;
		body.put("parentFolderId", parentId);
		body.put("name", folderName);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();     
		headers.add("delegateKey", delegatekey);
		return createRequest(body,headers) ;
	}
	
	private HttpEntity<?> createRequestForListURL(String folderId , String delegatekey)
	{
		JSONObject json = new JSONObject() ;
		json.put("folderId", folderId);
		JSONObject body = new JSONObject() ;
		body.put("params", json) ;
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();     
		headers.add("delegateKey", delegatekey);
		headers.add("Content-Type","application/json;charset=UTF-8");
		return createRequest(body,headers) ;
	}
	
	private HttpEntity<?> createRequestForDeleteFolder(String folderId , String delegatekey)
	{
		String[] stringArray = new String[1] ;
		stringArray[0] = folderId ;
		JSONObject body = new JSONObject() ;
		body.put("items", stringArray) ;
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();     
		headers.add("delegateKey", delegatekey);
		return createRequest(body,headers) ;
	}
	
	private HttpEntity<?> createRequest(JSONObject body , MultiValueMap<String, String> headers)
	{
		HttpEntity<?> httpEntity = new HttpEntity<Object>(body, headers);
		return httpEntity ;		
	}
	
	private String getFolderIdFromArray(JSONArray array2 , String folderName)
	{
		String createdFolderId = null ;
		for(int i = 0 ; i < array2.size() ; i++)
		{
			if(((JSONObject) array2.get(i)).get("name").equals(folderName))
			{
				createdFolderId = (String) ((JSONObject) array2.get(i)).get("id") ;
				break ;
			}
		}
		return createdFolderId ;
	}
	
	private String getCabinetIdFromArray(JSONArray array2)
	{
		return (String) ((JSONObject) array2.get(0)).get("id") ;
	}
}