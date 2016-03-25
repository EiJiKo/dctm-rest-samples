package com.emc.documentum.wrappers.view;

import java.util.ArrayList;
import java.util.HashMap;

import com.emc.documentum.dtos.NavigationObject;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.DocumentCreationException;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.FolderNotFoundException;
import com.emc.documentum.model.JsonFeed;
import com.emc.documentum.model.JsonObject;
import com.emc.documentum.model.UserModel;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public interface DocumentumAPIWrapper {

	UserModel getUserInfo(String username, String password);

	JsonObject createFolder(JsonObject parent, String folderName) throws FolderCreationException;

	JsonObject createDocument(JsonObject parent, HashMap<String, Object> properties) throws DocumentCreationException;

	JsonObject createDocument(JsonObject parent, String documentName, String documentType)
			throws DocumentCreationException;

	JsonObject getCabinet(String cabinetName) throws CabinetNotFoundException;

	JsonObject getObjectByUri(String uri);

	JsonObject getObjectById(String id);

	JsonObject getFolderByPath(String queryFolderPath) throws FolderNotFoundException;
	
	ArrayList<NavigationObject> getAllCabinets();

	ArrayList<NavigationObject> getChildren(String folderId);
	
	JsonFeed getObjects(String uri);
	
	Object getDocumentContentById(String documentId) throws DocumentNotFoundException;

	JSONObject getChildrenForFileManager(String folderId) ;
	
	JSONObject getAllCabinetsForFileManager() ;
	
	JSONObject getPaginatedResult(String folderId , int startIndex , int pageSize) ;
	
	JsonObject createFolderForFileManager(String parentFolderId , String folderName) throws FolderCreationException  ;
}