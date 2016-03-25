package com.emc.documentum.services.rest;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.emc.documentum.delegates.DocumentumRepositoryDelegate;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.model.JsonObject;
import com.emc.documentum.model.UserModel;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;

@CrossOrigin(origins = "*")
@RestController
public class FileManagerController {

	@Autowired
	DocumentumRepositoryDelegate dcRestDelegate;

	@RequestMapping("/Hello")
	public String indexTwo() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserModel> result = restTemplate.exchange("http://192.168.210.128:8080/dctm-rest/repositories/MyRepo/currentuser", HttpMethod.GET,new HttpEntity<String>(createHeaders("dmadmin", "password")), UserModel.class);
		System.out.println(result.getBody());
		System.out.println(result.getBody().getName());
		return result.getBody().getName();
	}

	HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}

	@RequestMapping(value = "/api/listUrl", method = RequestMethod.POST, headers = "Content-Type=application/json;charset=UTF-8")
	public String listURL(@RequestBody String jsonString) {

		JSONObject jsonRequest = null;
		JSONObject jsonRequestParams = null;
		JSONObject resultJson = null ;
		
		try {
			jsonRequest = (JSONObject) JSONValue.parseWithException(jsonString);
			jsonRequestParams = (JSONObject) jsonRequest.get("params");
			String folderId = (String) jsonRequestParams.get("folderId");
			System.out.println(jsonRequestParams);
			System.out.println("folder id " + folderId);
			
			if (folderId == null || folderId.equals("")) {
				System.out.println("-----getting cabinets : " + folderId);
				resultJson = dcRestDelegate.getAllCabinetsForFileManager();
			}
			else
			{
				System.out.println("-----getting children for folder ID : " + folderId);
				resultJson = dcRestDelegate.getChildrenForFileManager(folderId);
				//resultJson = dcRestDelegate.getPaginatedResult(folderId, 0, 0);
			}
			return resultJson.toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}

	@RequestMapping(value = "/api/renameUrl", method = RequestMethod.POST)
	public String renameUrl() {
		return commonResponse();
	}

	@RequestMapping(value = "/api/copyUrl", method = RequestMethod.POST)
	public String copyUrl() {
		return commonResponse();
	}

	@RequestMapping(value = "/api/removeUrl", method = RequestMethod.POST)
	public String removeUrl() {
		return commonResponse();
	}

	@RequestMapping(value = "/api/editUrl", method = RequestMethod.POST)
	public String editUrl() {
		return commonResponse();
	}

	@RequestMapping(value = "/api/createFolderUrl", method = RequestMethod.POST)
	public String createFolderUrl(@RequestBody String jsonString) {
		
		JSONObject jsonRequest = null;
		JSONObject jsonRequestParams = null;
		JsonObject resultJson = null ;
		try {
			jsonRequest = (JSONObject) JSONValue.parseWithException(jsonString);
			jsonRequestParams = (JSONObject) jsonRequest.get("params");
			String parentFolderId = (String) jsonRequestParams.get("parentFolderId");
			String folderName = (String) jsonRequestParams.get("name");
			System.out.println(jsonRequestParams);
			System.out.println("parent Folder  id " + parentFolderId);
			//
			resultJson = dcRestDelegate.createFolderForFileManager(parentFolderId, folderName) ;
			return commonResponse();
		} catch (FolderCreationException | ParseException e) {
			e.printStackTrace();
			return errorResponse("can't create folder");
		}		
	}

	@RequestMapping(value = "/api/permissionsUrl", method = RequestMethod.POST)
	public String permissionsUrl() {
		return commonResponse();
	}

	@RequestMapping(value = "/api/extractUrl", method = RequestMethod.POST)
	public String extractUrl() {
		return commonResponse();
	}

	@RequestMapping(value = "/api/uploadUrl", method = RequestMethod.POST)
	public String uploadUrl() {
		return commonResponse();
	}
	
	@RequestMapping(value= "/api/document/content/{documentId}" , produces = "application/pdf")
	public byte[] getDocumentContentById(@PathVariable(value="documentId")String documentId) throws DocumentNotFoundException{
		try {
			byte[] enCodedfileContent = (byte[]) dcRestDelegate.getDocumentContentById(documentId);
			return Base64.decodeBase64(enCodedfileContent);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	@RequestMapping(value= "/api/document/open/{documentId}" )
	public JSONObject openDocumentById(@PathVariable(value="documentId")String documentId) throws DocumentNotFoundException{
		try {
			byte[] enCodedfileContent = (byte[]) dcRestDelegate.getDocumentContentById(documentId);
			byte[] decoded = Base64.decodeBase64(enCodedfileContent);		
			JSONObject json = new JSONObject();
			json.put("data", decoded);
			return json ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}

	// TODO getContentUrl
	
	@RequestMapping(value= "/api/folder/content/{folderId}/startIndex/pageSize")
	public String paginationService(@PathVariable(value="folderId")String folderId , @PathVariable(value="startIndex")String startIndex , @PathVariable(value="pageSize")String pageSize){		
		//TODO to be implemented
		JSONObject resultJson = null ;
		try {
			resultJson = dcRestDelegate.getPaginatedResult(folderId, 0, 0);
		} catch (DocumentNotFoundException e) {
			e.printStackTrace();
		}
		return resultJson.toJSONString() ;
	}	
	
	String commonResponse() {
		JSONObject resultJson = new JSONObject();
		JSONObject json = new JSONObject();
		json.put("success", true);
		json.put("error", null);

		resultJson.put("result", json);
		return resultJson.toJSONString();
	}
	
	
	String errorResponse(String error) {
		JSONObject resultJson = new JSONObject();
		JSONObject json = new JSONObject();
		json.put("success", false);
		json.put("error", error);

		resultJson.put("result", json);
		return resultJson.toJSONString();
	}
}