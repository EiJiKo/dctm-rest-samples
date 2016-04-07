package com.emc.documentum.wrappers;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.remoting.soap.SoapFaultException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.emc.d2fs.models.attribute.Attribute;
import com.emc.d2fs.models.context.Context;
import com.emc.d2fs.models.destroyresult.Destroyresult;
import com.emc.d2fs.models.item.Item;
import com.emc.d2fs.models.repository.Repository;
import com.emc.d2fs.schemas.models.ModelPort;
import com.emc.d2fs.schemas.models.ModelPortService;
import com.emc.d2fs.services.browser_service.GetBrowserContentRequest;
import com.emc.d2fs.services.checkout_service.CancelCheckoutRequest;
import com.emc.d2fs.services.checkout_service.CancelCheckoutResponse;
import com.emc.d2fs.services.checkout_service.CheckoutRequest;
import com.emc.d2fs.services.checkout_service.CheckoutResponse;
import com.emc.d2fs.services.checkout_service.TestCheckoutRequest;
import com.emc.d2fs.services.checkout_service.TestCheckoutResponse;
import com.emc.d2fs.services.content_service.GetDQLContentRequest;
import com.emc.d2fs.services.content_service.GetDQLContentResponse;
import com.emc.d2fs.services.destroy_service.DestroyRequest;
import com.emc.d2fs.services.destroy_service.DestroyResponse;
import com.emc.d2fs.services.download_service.GetDispatchDownloadUrlRequest;
import com.emc.d2fs.services.download_service.GetDispatchDownloadUrlResponse;
import com.emc.d2fs.services.property_service.GetPropertiesRequest;
import com.emc.d2fs.services.property_service.GetPropertiesResponse;
import com.emc.d2fs.services.repository_service.CheckLoginRequest;
import com.emc.d2fs.services.repository_service.CheckLoginResponse;
import com.emc.d2fs.services.repository_service.GetRepositoryRequest;
import com.emc.documentum.constants.DCD2Constants;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.CanNotDeleteFolderException;
import com.emc.documentum.exceptions.DocumentCheckoutException;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;

@Component("DCD2APIWrapper")
public class DCD2APIWrapper {
	Logger log = Logger.getLogger(this.getClass().getCanonicalName());

	@Autowired
	DCD2Constants data;

	ModelPortService service = new ModelPortService();
	ModelPort port;
	public List<Item> getAllCabinets() throws RepositoryNotAvailableException {
		try {
			ModelPort port = getPort();
			Context context = getContext(port, data.repo, data.username, data.password, data.UID);
			// Validate user credential
			CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
			checkLoginRequest.setContext(context);
			CheckLoginResponse checkLoginResponse = port.checkLogin(checkLoginRequest);
			if (!checkLoginResponse.isResult())
				System.out.println("login failed");
			GetDQLContentRequest r = new GetDQLContentRequest();
			r.setContext(context);
			r.setDql("select * from dm_cabinet");
			GetDQLContentResponse response = port.getDQLContent(r);
			if (response.getDocItems() != null && response.getDocItems().getItems() != null)
				return response.getDocItems().getItems();
			throw new RepositoryNotAvailableException(data.repo);

		} catch (Exception e) {
			throw new RepositoryNotAvailableException(data.repo);
		}

	}
	public List<Item> getAllCabinets(int pageNumber,int pageSize) throws RepositoryNotAvailableException {
		try {
			ModelPort port = getPort();
			Context context = getContext(port, data.repo, data.username, data.password, data.UID);
			// Validate user credential
			CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
			checkLoginRequest.setContext(context);
			CheckLoginResponse checkLoginResponse = port.checkLogin(checkLoginRequest);
			if (!checkLoginResponse.isResult())
				System.out.println("login failed");
			GetDQLContentRequest r = new GetDQLContentRequest();
			r.setContext(context);
			r.setDql("select * from dm_cabinet");
			GetDQLContentResponse response = port.getDQLContent(r);
			if (response.getDocItems() != null && !response.getDocItems().getItems().isEmpty()){
			List<Item> returnedNodes =new ArrayList<Item>();
			List<Item> responseNodes = response.getDocItems().getItems();
			for (int i = ((pageNumber - 1) * pageSize); i < responseNodes.size() && i < (pageNumber * pageSize); i++)
				returnedNodes.add(responseNodes.get(i));
			return returnedNodes;
			}
			else
				throw new RepositoryNotAvailableException(data.repo);

		} catch (Exception e) {
			throw new RepositoryNotAvailableException(data.repo);
		}

	}
	public Item getObjectById(String id) throws RepositoryNotAvailableException
	{
		try {
			ModelPort port = getPort();
			Context context = getContext(port, data.repo, data.username, data.password, data.UID);
			// Validate user credential
			CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
			checkLoginRequest.setContext(context);
			CheckLoginResponse checkLoginResponse = port.checkLogin(checkLoginRequest);
			if (!checkLoginResponse.isResult())
				System.out.println("login failed");
			GetDQLContentRequest r = new GetDQLContentRequest();
			r.setContext(context);
			r.setDql(String.format("select * from dm_sysobject where r_object_id =  '%s'",
					id));
			GetDQLContentResponse response = port.getDQLContent(r);
			if (response.getDocItems() != null && !response.getDocItems().getItems().isEmpty())
				return response.getDocItems().getItems().get(0);
			else
				throw new CabinetNotFoundException("");

		} catch (Exception e) {
			throw new RepositoryNotAvailableException(data.repo);
		}

	}
	public List<Item> getChildren(String folderId) {
		ModelPort port = getPort();
		Context context = getContext(port, data.repo, data.username, data.password, data.UID);
		// Validate user credentials
		CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
		checkLoginRequest.setContext(context);
		CheckLoginResponse checkLoginResponse = port.checkLogin(checkLoginRequest);
		if (!checkLoginResponse.isResult())
			System.out.println("login failed");
		GetBrowserContentRequest request = new GetBrowserContentRequest();
		GetDQLContentRequest r = new GetDQLContentRequest();
		r.setContext(context);
		r.setDql("select *,r_lock_owner from dm_folder where  FOLDER(ID('" + folderId
				+ "')) union select *,r_lock_owner from dm_document where FOLDER(ID('" + folderId + "'))");
		GetDQLContentResponse response = port.getDQLContent(r);
		return response.getDocItems().getItems();

	}
	public Item checkoutDocument(String documentId) throws DocumentCheckoutException, RepositoryNotAvailableException
	{
		ModelPort port = getPort();
		Context context = getContext(port, data.repo, data.username, data.password, data.UID);
		// Validate user credentials
		CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
		checkLoginRequest.setContext(context);
		CheckLoginResponse checkLoginResponse = port.checkLogin(checkLoginRequest);
		if (!checkLoginResponse.isResult())
			System.out.println("login failed");
		TestCheckoutRequest checkoutTest = new TestCheckoutRequest();
		checkoutTest.setContext(context);
		checkoutTest.setId(documentId);
		TestCheckoutResponse checkoutTestResponse = port.testCheckout(checkoutTest);
		String[] testResult =  checkoutTestResponse.getResult().split(" ");
		if (testResult.length > 1) {
			String isCheckout = checkoutTestResponse.getResult().split(" ")[1];
			if (isCheckout.indexOf("true") != -1) {
				throw new DocumentCheckoutException("document already Checked out.");
			}
		}
		CheckoutRequest request = new CheckoutRequest();
		request.setContext(context);
		request.setId(documentId);
		CheckoutResponse response = port.checkout(request);
		if(response.isDone())
		{
			return getObjectById(documentId);
		}
		else
			throw new DocumentCheckoutException("document check out failed.");
	}
	public Item cancelCheckout(String documentId) throws RepositoryNotAvailableException, DocumentCheckoutException
	{
		try{
		ModelPort port = getPort();
		Context context = getContext(port, data.repo, data.username, data.password, data.UID);
		// Validate user credentials
		CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
		checkLoginRequest.setContext(context);
		CheckLoginResponse checkLoginResponse = port.checkLogin(checkLoginRequest);
		if (!checkLoginResponse.isResult())
			System.out.println("login failed");
		CancelCheckoutRequest r = new CancelCheckoutRequest();
		r.setContext(context);
		r.setId(documentId);
		CancelCheckoutResponse s = port.cancelCheckout(r);
		if(s.isDone())
		{
			return getObjectById(documentId);
		}
		else
		{
			throw new DocumentCheckoutException("cancel check out failed.");
		}}
		catch(SOAPFaultException e)
		{
			throw new DocumentCheckoutException("cancel check out failed.");
		}
	}
	public List<Item> getChildren(String folderId, int pageNumber, int pageSize) {
		ModelPort port = getPort();
		Context context = getContext(port, data.repo, data.username, data.password, data.UID);
		// Validate user credentials
		CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
		checkLoginRequest.setContext(context);
		CheckLoginResponse checkLoginResponse = port.checkLogin(checkLoginRequest);
		if (!checkLoginResponse.isResult())
			System.out.println("login failed");
		GetBrowserContentRequest request = new GetBrowserContentRequest();
		GetDQLContentRequest r = new GetDQLContentRequest();
		r.setContext(context);
		r.setDql("select *,r_lock_owner from dm_folder where  FOLDER(ID('" + folderId
				+ "')) union select *,r_lock_owner from dm_document where FOLDER(ID('" + folderId + "'))");
		GetDQLContentResponse response = port.getDQLContent(r);
		List<Item> returnedNodes = new ArrayList<>();
		List<Item> responseNodes = response.getDocItems().getItems();
		for (int i = ((pageNumber - 1) * pageSize); i < responseNodes.size() && i < (pageNumber * pageSize); i++)
			returnedNodes.add(responseNodes.get(i));
		return returnedNodes;

	}
	public void deleteObject(String objectId,boolean deleteChildren) throws CanNotDeleteFolderException
	{
		ModelPort port = getPort();
		Context context = getContext(port, data.repo, data.username, data.password, data.UID);
		// Validate user credentials
		CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
		checkLoginRequest.setContext(context);
		CheckLoginResponse checkLoginResponse = port.checkLogin(checkLoginRequest);
		if (!checkLoginResponse.isResult())
			System.out.println("login failed");
		Attribute deepFolders = new Attribute();
		deepFolders.setName("deepFolders");
		deepFolders.setType(0);   // DF_BOOLEAN DfType: see AttributeUtils in JavaDoc
		deepFolders.setValue(deleteChildren ? "true": "false");

		// "version" Attribute
		Attribute version = new Attribute();
		version.setName("version");
		version.setType(1);     // DF_INTEGER
		version.setValue("2");  // ALL_VERSIONS
		
		
		// Create DestroyRequest
		DestroyRequest destroyRequest = new DestroyRequest();
		destroyRequest.setContext(context);
		destroyRequest.setId(objectId);

		// add attributes to request
		List<Attribute> attributes = destroyRequest.getAttributes(); 
		attributes.add(deepFolders);
		attributes.add(version);
		DestroyResponse destroyResponse = port.destroy(destroyRequest);
		Destroyresult destroyResult = destroyResponse.getDestroyresult();
		if(!destroyResult.isIsDestroyed())
		{
			throw new CanNotDeleteFolderException(objectId);
		}
			
	}
	public byte[] getDocumentContent(String documentId) {

		try {
			ModelPort port = getPort();
			Context context = getContext(port, data.repo, data.username, data.password, data.UID);
			CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
			checkLoginRequest.setContext(context);
			CheckLoginResponse checkLoginResponse = port.checkLogin(checkLoginRequest);
			if (!checkLoginResponse.isResult())
				System.out.println("login failed");
			GetDispatchDownloadUrlRequest request = new GetDispatchDownloadUrlRequest();
			request.setId(documentId);
			request.setContext(context);
			request.setCurrent(true);
			request.setViewNative(true);
			GetDispatchDownloadUrlResponse response = port.getDispatchDownloadUrl(request);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders httpHeader = createHeaders(data.username, data.password);
			List<MediaType> mediaTypes = new ArrayList<MediaType>();
			mediaTypes.add(MediaType.ALL);
			httpHeader.setAccept(mediaTypes);
			ResponseEntity<Resource> resource;
			resource = restTemplate.exchange(URLDecoder.decode(response.getUrl(), "UTF-8"), HttpMethod.GET,
					new HttpEntity<Object>(httpHeader), Resource.class);

			if (resource == null) {

			} else {

				System.out.println("Response Headers: " + resource.getHeaders());
				System.out.println("Response status: " + resource.getStatusCode());
			}

			if (resource.getBody() != null) {
				InputStream docStream = resource.getBody().getInputStream();
				byte[] fileContent = IOUtils.toByteArray(docStream);
				byte[] encodedfile = Base64.encodeBase64(fileContent);
				return encodedfile;

			} else {
				log.fine(documentId + " has empty content");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, "IO Exception while reading dm_document input stream", e);
		}
		return new byte[0];
	}

	public List<Attribute> getObjectProperties(String objectId) {
		ModelPort port = getPort();
		Context context = getContext(port, data.repo, data.username, data.password, data.UID);

		GetPropertiesRequest req = new GetPropertiesRequest();
		req.setContext(context);
		req.setId(objectId);
		GetPropertiesResponse res = port.getProperties(req);
		return res.getAttributes();
	}

	private ModelPort getPort() {
		if(port == null)
			port = service.getModelPortSoap11();
		return port;
	}

	private Context getContext(ModelPort port, String repoId, String username, String password, String UID) {

		System.out.println("Invoking operation on the port.");
		// Get the repository information from the docbroker
		String host = data.host + ":" + data.port + "/D2";
		GetRepositoryRequest repoReq = new GetRepositoryRequest();
		repoReq.setId(repoId);
		Repository repo = port.getRepository(repoReq).getRepository();
		if (repo == null)
			System.out.println("could not connect to repository: " + repoId);
		Context context = new Context();
		context.setRepository(repo);
		context.setLogin(username);
		context.setPassword(password);
		context.setUid(UID);
		context.setWebAppURL(host);
		return context;
	}
	
	private HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			private static final long serialVersionUID = -3310695110391522574L;

			{
				String usernameAndPassword = username + ":" + password;
				String authHeader = "Basic " + new String(Base64.encodeBase64(usernameAndPassword.getBytes()));
				set("Authorization", authHeader);
			}
		};

	}
}
