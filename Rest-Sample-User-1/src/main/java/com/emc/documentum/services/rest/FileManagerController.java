package com.emc.documentum.services.rest;

import java.util.ArrayList;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.emc.documentum.delegates.DocumentumDelegate;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.model.JsonEntry;
import com.emc.documentum.model.JsonFeed;
import com.emc.documentum.model.JsonObject;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;

@CrossOrigin(origins = "*")
@RestController
public class FileManagerController {

	@Autowired
	@Qualifier("DocumentumRestDelegate")
	DocumentumDelegate dcRestDelegate;

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
				ArrayList<DocumentumFolder> cabinets = dcRestDelegate.getAllCabinets() ;
				resultJson = transformFoldersToJson(cabinets) ;
			}
			else
			{
				System.out.println("-----getting children for folder ID : " + folderId);
				ArrayList<DocumentumObject> folders = dcRestDelegate.getChildren(folderId);
				resultJson = transformChildrenFromDocumentumObjects(folders) ;
				//JsonFeed feed = dcRestDelegate.getPaginatedResult(folderId, 0, 0);
				//resultJson = transformJsonFeedToJson(feed) ;
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
			DocumentumFolder folder = dcRestDelegate.createFolderByParentId(parentFolderId, folderName) ;
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
		JsonFeed feed = dcRestDelegate.getPaginatedResult(folderId, 0, 0);
		resultJson = transformJsonFeedToJson(feed) ;
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
	
	
	
	private JSONObject transformFoldersToJson(ArrayList<DocumentumFolder> folders) {
		JSONArray children = new JSONArray() ;
		for (int i = 0 ; i < folders.size() ; i++) 
		{	
			JSONObject json = new JSONObject() ;
			json.put("id", folders.get(i).getId()) ;
			json.put("name", folders.get(i).getName()) ;
			json.put("rights", "drwxr-xr-x") ;
			json.put("size", "4096") ;
			//StringBuffer dateString = new StringBuffer((String) folders.get(i).getProperties().get("r_creation_date")) ;
			//dateString.replace(10, 11, " ").delete(18,28) ;
			//json.put("date", dateString.toString()) ;
			json.put("date", "2016-03-05 04:33:27") ;
			json.put("type", "dir") ;
			children.add(json) ;
		}		
		JSONObject returnJson = new JSONObject() ;
		returnJson.put("result", children) ;
		return returnJson ;
	}
	
	private JSONObject transformChildrenFromDocumentumObjects(ArrayList<DocumentumObject> objects)
	{
		JSONArray children = new JSONArray() ;
		for (int i = 0 ; i < objects.size() ; i++) {
			if(objects.get(i).getType().endsWith("Document") || objects.get(i).getType().endsWith("Object") || objects.get(i).getType().endsWith("Folder")){
				String type = "";
				if(objects.get(i).getType().endsWith("Document")){
					type = "file";
				}else if(objects.get(i).getType().endsWith("Folder")){
					type = "dir";
				}
				else if (objects.get(i).getType().endsWith("Object")){
					continue ;
				}
				
				JSONObject json = new JSONObject() ;					
				json.put("id", objects.get(i).getId()) ;
				json.put("name", objects.get(i).getName()) ;
				json.put("rights", "drwxr-xr-x") ;
				json.put("size", objects.get(i).getProperties().get("r_content_size")) ;										
				//parsing date
				//StringBuffer dateString = new StringBuffer((String) folders.get(i).getProperties().get("r_creation_date")) ;
				//dateString.replace(10, 11, " ").delete(18,28) ;
				//json.put("date", dateString.toString()) ;
				json.put("date", "2016-03-05 04:33:27") ;
				json.put("type", type) ;
				children.add(json) ;
			}
		}
		JSONObject returnJson = new JSONObject() ;
		returnJson.put("result", children) ;
		return returnJson ;
	}
	
	
	private JSONObject transformJsonFeedToJson(JsonFeed feed)
	{
		JSONArray children = new JSONArray() ;
		for (JsonEntry entry : feed.getEntries()) {			
			JSONObject json = new JSONObject() ;
			
			String type = (String) entry.getContent().getProperties().get("r_object_type") ;
			if(type.contains("folder"))
			{
				
			}
			json.put("id", (String) entry.getContent().getProperties().get("r_object_id")) ;
			json.put("name", (String) entry.getContent().getProperties().get("object_name")) ;
			json.put("rights", "drwxr-xr-x") ;
			json.put("size", "4096") ;
			StringBuffer dateString = new StringBuffer((String) entry.getContent().getProperties().get("r_creation_date")) ;
			dateString.replace(10, 11, " ").delete(18,28) ;
			json.put("date", dateString.toString()) ;
			json.put("type", "dir") ;
			children.add(json) ;
		}
		
		JSONObject returnJson = new JSONObject() ;
		returnJson.put("result", children) ;
		return returnJson ;	
	}
}