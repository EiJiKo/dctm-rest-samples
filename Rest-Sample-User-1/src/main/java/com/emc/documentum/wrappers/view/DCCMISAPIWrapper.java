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

public class DCCMISAPIWrapper implements DocumentumAPIWrapper {

	@Override
	public UserModel getUserInfo(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject createFolder(JsonObject parent, String folderName) throws FolderCreationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject createDocument(JsonObject parent, HashMap<String, Object> properties)
			throws DocumentCreationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject createDocument(JsonObject parent, String documentName, String documentType)
			throws DocumentCreationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject getCabinet(String cabinetName) throws CabinetNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject getObjectByUri(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject getObjectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject getFolderByPath(String queryFolderPath) throws FolderNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NavigationObject> getAllCabinets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NavigationObject> getChildren(String folderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonFeed getObjects(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDocumentContentById(String documentId) throws DocumentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
