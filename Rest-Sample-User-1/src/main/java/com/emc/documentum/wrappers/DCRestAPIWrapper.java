package com.emc.documentum.wrappers;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.emc.documentum.constants.*;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.DocumentCreationException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.FolderNotFoundException;
import com.emc.documentum.model.JsonEntry;
import com.emc.documentum.model.JsonFeed;
import com.emc.documentum.model.JsonObject;
import com.emc.documentum.model.Properties;
import com.emc.documentum.model.UserModel;
import com.emc.documentum.wrappers.view.DocumentumAPIWrapper;

@Component
@PropertySource("classpath:application.properties")
public class DCRestAPIWrapper implements DocumentumAPIWrapper {

	@Autowired
	DCRestAPIWrapperData data;
	/* (non-Javadoc)
	 * @see com.emc.documentum.wrappers.DocumentumAPIWrapper#getUserInfo(java.lang.String, java.lang.String)
	 */
	@Override
	public UserModel getUserInfo(String username, String password) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserModel> response = restTemplate.exchange(data.currentUserURI, HttpMethod.GET,
				new HttpEntity<Object>(createHeaders(username, password)), UserModel.class);

		return response.getBody();

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

	/* (non-Javadoc)
	 * @see com.emc.documentum.wrappers.DocumentumAPIWrapper#createFolder(com.emc.documentum.model.JsonObject, java.lang.String)
	 */
	@Override
	public JsonObject createFolder(JsonObject parent, String folderName) throws FolderCreationException {

		RestTemplate restTemplate = new RestTemplate();
		String folderUri = parent.getHref(LinkRelation.folder);
		Properties creationProperties = new Properties();
		creationProperties.addProperty("object_name", folderName);
		HttpHeaders httpHeader = createHeaders(data.username, data.password);
		httpHeader.add("Content-Type", "application/vnd.emc.documentum+json");
		ResponseEntity<JsonObject> response;
		try {
			response = restTemplate.exchange(folderUri, HttpMethod.POST,
					new HttpEntity<Object>(creationProperties, httpHeader), JsonObject.class);
			return response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			throw new FolderCreationException(folderName);
		}

	}
	
	/* (non-Javadoc)
	 * @see com.emc.documentum.wrappers.DocumentumAPIWrapper#createDocument(com.emc.documentum.model.JsonObject, java.util.HashMap)
	 */
	@Override
	public JsonObject createDocument(JsonObject parent, HashMap<String,Object> properties) throws DocumentCreationException{
		RestTemplate restTemplate = new RestTemplate();
		String folderUri = parent.getHref(LinkRelation.document);
		Properties creationProperties = new Properties();
		creationProperties.setProperties(properties);
		HttpHeaders httpHeader = createHeaders(data.username, data.password);
		httpHeader.add("Content-Type", "application/vnd.emc.documentum+json");
		ResponseEntity<JsonObject> response;
		try {
			response = restTemplate.exchange(folderUri, HttpMethod.POST,
					new HttpEntity<Object>(creationProperties, httpHeader), JsonObject.class);
			return response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DocumentCreationException(properties.get("object_name").toString());
		}
	}
	
	/* (non-Javadoc)
	 * @see com.emc.documentum.wrappers.DocumentumAPIWrapper#createDocument(com.emc.documentum.model.JsonObject, java.lang.String, java.lang.String)
	 */
	@Override
	public JsonObject createDocument(JsonObject parent, String documentName , String documentType) throws DocumentCreationException {

		HashMap<String,Object> properties =new HashMap<>();
		properties.put("object_name", (Object) documentName);
		properties.put("object_type", (Object)  documentType);
		return createDocument(parent, properties);

	}

	/* (non-Javadoc)
	 * @see com.emc.documentum.wrappers.DocumentumAPIWrapper#getCabinet(java.lang.String)
	 */
	@Override
	public JsonObject getCabinet(String cabinetName) throws CabinetNotFoundException {
		System.out.println("Entering Get Cabinet");
		RestTemplate restTemplate = new RestTemplate();
		String URI = data.fetchCabinetURI + "?filter=starts-with(object_name,'" + cabinetName + "')";
		System.out.println("Fetch Cabinet URI is " + URI);
		ResponseEntity<JsonFeed> response = restTemplate.exchange(URI, HttpMethod.GET,
				new HttpEntity<Object>(createHeaders(data.username, data.password)), JsonFeed.class);

		JsonFeed feed = response.getBody();

		for (JsonEntry entry : feed.getEntries()) {
			if (entry.getTitle().equals(cabinetName)) {
				return getObject(entry.getContentSrc());
			}
		}
		throw new CabinetNotFoundException(cabinetName);
	}

	/* (non-Javadoc)
	 * @see com.emc.documentum.wrappers.DocumentumAPIWrapper#getObject(java.lang.String)
	 */
	@Override
	public JsonObject getObject(String uri) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Fetch Object with URI is " + uri);
		ResponseEntity<JsonObject> response = restTemplate.exchange(uri, HttpMethod.GET,
				new HttpEntity<Object>(createHeaders(data.username, data.password)), JsonObject.class);

		return response.getBody();

	}
	
	/* (non-Javadoc)
	 * @see com.emc.documentum.wrappers.DocumentumAPIWrapper#getObjectById(java.lang.String)
	 */
	@Override
	public JsonObject getObjectById(String id){
		RestTemplate restTemplate = new RestTemplate();
		String uri = data.fetchObjectUri + "/" + id;
		System.out.println("Fetch Object with URI is " + uri);
		ResponseEntity<JsonObject> response = restTemplate.exchange(uri, HttpMethod.GET,
				new HttpEntity<Object>(createHeaders(data.username, data.password)), JsonObject.class);

		return response.getBody();
	}

	
	/* (non-Javadoc)
	 * @see com.emc.documentum.wrappers.DocumentumAPIWrapper#getFolderByPath(java.lang.String)
	 */
	@Override
	public JsonObject getFolderByPath(String queryFolderPath) throws FolderNotFoundException {
		RestTemplate restTemplate = new RestTemplate();
		String URI = String.format(data.dqlQuery + "select *,r_folder_path from dm_folder where any r_folder_path = '%s'",queryFolderPath);
		System.out.println("Fetch Folder URI is " + URI);
		ResponseEntity<JsonFeed> response = restTemplate.exchange(URI, HttpMethod.GET,
				new HttpEntity<Object>(createHeaders(data.username, data.password)), JsonFeed.class);

		JsonFeed feed = response.getBody();
		
		for (JsonEntry entry : feed.getEntries()) {
			@SuppressWarnings("unchecked")
			ArrayList<String> folderPaths = (ArrayList<String>) entry.getContent().getProperties().get("r_folder_path");
			for(String folderPath : folderPaths){
				if(folderPath.equals(queryFolderPath)){
					return getObjectById((String) entry.getContent().getProperties().get("r_object_id"));
				}
			}
		}
		
		throw new FolderNotFoundException(queryFolderPath);
	}

	@Override
	public JsonObject[] getAllCabinets() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
