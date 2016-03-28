package com.emc.documentum.wrappers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.emc.documentum.constants.DCCoreRestConstants;
import com.emc.documentum.constants.LinkRelation;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.DocumentCreationException;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.FolderNotFoundException;
import com.emc.documentum.model.JsonEntry;
import com.emc.documentum.model.JsonFeed;
import com.emc.documentum.model.JsonLink;
import com.emc.documentum.model.JsonObject;
import com.emc.documentum.model.Properties;
import com.emc.documentum.model.UserModel;

@Component("DCRestAPIWrapper")
@PropertySource("classpath:application.properties")
public class DCRestAPIWrapper {

	Logger log = Logger.getLogger(this.getClass().getCanonicalName());
	@Autowired
	DCCoreRestConstants data;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.wrappers.DocumentumAPIWrapper#getUserInfo(java.lang.
	 * String, java.lang.String)
	 */

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.wrappers.DocumentumAPIWrapper#createFolder(com.emc.
	 * documentum.model.JsonObject, java.lang.String)
	 */

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.wrappers.DocumentumAPIWrapper#createDocument(com.emc.
	 * documentum.model.JsonObject, java.util.HashMap)
	 */

	public JsonObject createDocument(JsonObject parent, HashMap<String, Object> properties)
			throws DocumentCreationException {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.wrappers.DocumentumAPIWrapper#createDocument(com.emc.
	 * documentum.model.JsonObject, java.lang.String, java.lang.String)
	 */

	public JsonObject createDocument(JsonObject parent, String documentName, String documentType)
			throws DocumentCreationException {

		HashMap<String, Object> properties = new HashMap<>();
		properties.put("object_name", (Object) documentName);
		properties.put("object_type", (Object) documentType);
		return createDocument(parent, properties);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.wrappers.DocumentumAPIWrapper#getCabinet(java.lang.
	 * String)
	 */

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
				return getObjectByUri(entry.getContentSrc());
			}
		}
		throw new CabinetNotFoundException(cabinetName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.wrappers.DocumentumAPIWrapper#getObject(java.lang.
	 * String)
	 */

	public JsonObject getObjectByUri(String uri) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Fetch Object with URI is " + uri);
		ResponseEntity<JsonObject> response = restTemplate.exchange(uri, HttpMethod.GET,
				new HttpEntity<Object>(createHeaders(data.username, data.password)), JsonObject.class);

		return response.getBody();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.wrappers.DocumentumAPIWrapper#getObjectById(java.lang.
	 * String)
	 */

	public JsonObject getObjectById(String id) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = data.fetchObjectUri + "/" + id;
		System.out.println("Fetch Object with URI is " + uri);
		ResponseEntity<JsonObject> response = restTemplate.exchange(uri, HttpMethod.GET,
				new HttpEntity<Object>(createHeaders(data.username, data.password)), JsonObject.class);

		return response.getBody();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.wrappers.DocumentumAPIWrapper#getFolderByPath(java.
	 * lang.String)
	 */

	public JsonObject getFolderByPath(String queryFolderPath) throws FolderNotFoundException {
		RestTemplate restTemplate = new RestTemplate();
		String URI = String.format(
				data.dqlQuery + "select *,r_folder_path from dm_folder where any r_folder_path = '%s'",
				queryFolderPath);
		System.out.println("Fetch Folder URI is " + URI);
		ResponseEntity<JsonFeed> response = restTemplate.exchange(URI, HttpMethod.GET,
				new HttpEntity<Object>(createHeaders(data.username, data.password)), JsonFeed.class);

		JsonFeed feed = response.getBody();

		for (JsonEntry entry : feed.getEntries()) {
			@SuppressWarnings("unchecked")
			ArrayList<String> folderPaths = (ArrayList<String>) entry.getContent().getProperties().get("r_folder_path");
			for (String folderPath : folderPaths) {
				if (folderPath.equals(queryFolderPath)) {
					return getObjectById((String) entry.getContent().getProperties().get("r_object_id"));
				}
			}
		}

		throw new FolderNotFoundException(queryFolderPath);
	}

	public List<JsonEntry> getAllCabinets() {
		RestTemplate restTemplate = new RestTemplate();
		String URI = data.dqlQuery + "select * from dm_cabinet";
		System.out.println("Fetch Cabinets URI is " + URI);
		ResponseEntity<JsonFeed> response = restTemplate.exchange(URI, HttpMethod.GET,
				new HttpEntity<Object>(createHeaders(data.username, data.password)), JsonFeed.class);

		JsonFeed feed = response.getBody();

		return feed.getEntries();
	}

	/**
	 * TODO Reimplement using DQL
	 * @param folderId
	 * @return
	 */
	public ArrayList<DocumentumObject> getChildren(String folderId) {
		RestTemplate restTemplate = new RestTemplate();
		String URI = data.fetchFolderURI + "/" + folderId;
		System.out.println("Fetch Folder URI is " + URI);
		ResponseEntity<JsonObject> response = restTemplate.exchange(URI, HttpMethod.GET,
				new HttpEntity<Object>(createHeaders(data.username, data.password)), JsonObject.class);

		JsonObject feed = response.getBody();

		ArrayList<DocumentumObject> children = new ArrayList<>();

		for (JsonLink link : feed.getLinks()) {
			if (link.getHref().endsWith("documents") || link.getHref().endsWith("folders")) {
				String type = "";
				if (link.getHref().endsWith("documents")) {
					type = "Document";
				} else if (link.getHref().endsWith("folders")) {
					type = "Folder";
				}
				JsonFeed child = getObjects(link.getHref());
				if (child != null && child.getEntries() != null) {
					for (JsonEntry entry : child.getEntries()) {
						children.add(new DocumentumObject(
								(String) getObjectByUri(entry.getContentSrc()).getProperties().get("r_object_id"),
								(String) getObjectByUri(entry.getContentSrc()).getProperties().get("object_name"),
								type));
						//TODO add properties
					}
				}
			}
		}
		return children;
	}

	public JsonFeed getObjects(String uri) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Fetch Object with URI is " + uri);
		ResponseEntity<JsonFeed> response = restTemplate.exchange(uri, HttpMethod.GET,
				new HttpEntity<Object>(createHeaders(data.username, data.password)), JsonFeed.class);

		return response.getBody();
	}

	public byte[] getDocumentContentById(String documentId) throws DocumentNotFoundException {
		JsonObject document = getObjectById(documentId);
		JsonLink link = getLink(document.getLinks(), LinkRelation.mainContent);
		JsonObject content = getObjectByUri(link.getHref());
		return getContentBase64Content(content);
	}
	public JsonObject checkOutDocument(String documentId)
	{
		JsonObject document = getObjectById(documentId);
		JsonLink link = getLink(document.getLinks(), LinkRelation.checkOutDocument);
		RestTemplate restTemplate = new RestTemplate();
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.ALL);
		HttpHeaders httpHeader = createHeaders(data.username, data.password);
		httpHeader.setAccept(mediaTypes);
		ResponseEntity<JsonObject> jsonDocuemnt;

		jsonDocuemnt = restTemplate.exchange(link.getHref(), HttpMethod.PUT,
				new HttpEntity<Object>(httpHeader), JsonObject.class);
		return jsonDocuemnt.getBody();
	}
	private byte[] getContentBase64Content(JsonObject content) {
		try {
			JsonLink link = getLink(content.getLinks(), LinkRelation.enclosure);
			String url = link.getHref();
			System.out.println("ACS URL IS");
			System.out.println(url);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders httpHeader = createHeaders(data.username, data.password);
			List<MediaType> mediaTypes = new ArrayList<MediaType>();
			mediaTypes.add(MediaType.ALL);
			httpHeader.setAccept(mediaTypes);
			ResponseEntity<Resource> resource;

			resource = restTemplate.exchange(URLDecoder.decode(url, "UTF-8"), HttpMethod.GET,
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
				log.fine(content.getName() + " has empty content");
			}
		} catch (IOException e) {
			log.log(Level.SEVERE, "IO Exception while reading dm_document input stream", e);
		}

		return new byte[0];
	}

	public static JsonLink getLink(List<JsonLink> links, String linkRelation) {
		for (JsonLink link : links) {
			if (link.getRel().equals(linkRelation)) {
				return link;
			}
		}
		return null;

	}

	public List<JsonEntry> getDocumentByName(String name) throws DocumentNotFoundException {
		RestTemplate restTemplate = new RestTemplate();
		String URI = String.format(data.dqlQuery + "select * from dm_document where object_name like '%s'",
				"%" + name + "%");
		ResponseEntity<JsonFeed> response = restTemplate.exchange(URI, HttpMethod.GET,
				new HttpEntity<Object>(createHeaders(data.username, data.password)), JsonFeed.class);

		JsonFeed feed = response.getBody();
		
		if(feed == null){
			throw new DocumentNotFoundException(name);
		}
		
		return feed.getEntries();

	}
	
	public JsonObject checkinDocument(String documentId,byte[]content)
	{
		JsonObject document = getObjectById(documentId);
		JsonLink link = getLink(document.getLinks(), LinkRelation.checkInNextMajor);
		Properties creationProperties = new Properties();
		HashMap<String, Object> properties = new HashMap<>();
//		properties.put("object_name", "Sample Name");
//		properties.put("title", "Sample Type");
		creationProperties.setProperties(properties);
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		HttpHeaders httpHeader = createHeaders(data.username, data.password);
		httpHeader.add("Content-Type", "multipart/form-data");
		HttpHeaders firstPartHeader = new HttpHeaders();
		firstPartHeader.set("Content-Type", "application/vnd.emc.documentum+json");
		parts.add("metadata", new HttpEntity<Object>(creationProperties,firstPartHeader));
		parts.add("binary", content);
		RestTemplate template = new RestTemplate();
		ResponseEntity<JsonObject> response = template.exchange(link.getHref(), HttpMethod.POST, new HttpEntity<Object>(parts, httpHeader), JsonObject.class);
		response.getHeaders();
		return response.getBody();
	}

	
	
	public ArrayList<DocumentumFolder> getPaginatedResult(String folderId , int startIndex , int pageSize) {
		//TODO check count first and check it against page size		
		String query = String.format("select * from dm_folder where folder(id('%s')) ENABLE(RETURN_RANGE 1 1 'r_creation_date ASC' ) ", folderId);
		ResponseEntity<JsonFeed> response = executeDQL(query) ;				
		JsonFeed feed = response.getBody();
		
		ArrayList<DocumentumFolder> folders = new ArrayList<>();
		for (JsonEntry entry : feed.getEntries()) {
			folders.add(new DocumentumFolder((String) entry.getContent().getProperties().get("r_object_id"),
					(String) entry.getContent().getProperties().get("object_name"), "Cabinet"));
		}
		return folders;
	}
	
	private ResponseEntity<JsonFeed> executeDQL(String query)
	{
		RestTemplate restTemplate = new RestTemplate();
		//log.log(level, msg, thrown);
		String URI = data.dqlQuery + query ;
		ResponseEntity<JsonFeed> response = restTemplate.exchange(URI, HttpMethod.GET,new HttpEntity<Object>(createHeaders(data.username, data.password)), JsonFeed.class);
		return response ;
	}
	
	private ResponseEntity<JsonObject> executeDQLObject(String query)
	{
		RestTemplate restTemplate = new RestTemplate();
		//log.log(level, msg, thrown);
		String URI = data.dqlQuery + query ;
		ResponseEntity<JsonObject> response = restTemplate.exchange(URI, HttpMethod.GET,new HttpEntity<Object>(createHeaders(data.username, data.password)), JsonObject.class);
		return response ;
	}
}