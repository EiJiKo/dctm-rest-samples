package com.emc.documentum.wrappers.view;

import java.util.ArrayList;
import java.util.HashMap;

import com.emc.documentum.dtos.NavigationObject;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.DocumentCreationException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.FolderNotFoundException;
import com.emc.documentum.model.JsonFeed;
import com.emc.documentum.model.JsonObject;
import com.emc.documentum.model.UserModel;

public interface DocumentumAPIWrapper {

	UserModel getUserInfo(String username, String password);

	JsonObject createFolder(JsonObject parent, String folderName) throws FolderCreationException;

	JsonObject createDocument(JsonObject parent, HashMap<String, Object> properties) throws DocumentCreationException;

	JsonObject createDocument(JsonObject parent, String documentName, String documentType)
			throws DocumentCreationException;

	JsonObject getCabinet(String cabinetName) throws CabinetNotFoundException;

	JsonObject getObject(String uri);

	JsonObject getObjectById(String id);

	JsonObject getFolderByPath(String queryFolderPath) throws FolderNotFoundException;
	
	ArrayList<NavigationObject> getAllCabinets();

	ArrayList<NavigationObject> getChilderen(String folderId);
	
	JsonFeed getObjects(String uri);
	
	


}