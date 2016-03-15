package com.emc.documentum.delegates;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emc.documentum.dtos.DocumentCreation;
import com.emc.documentum.dtos.NavigationObject;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.DocumentCreationException;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.FolderNotFoundException;
import com.emc.documentum.model.JsonObject;
import com.emc.documentum.services.rest.DCRestRepositoryController;
import com.emc.documentum.wrappers.view.DocumentumAPIWrapper;

@Component
public class DocumentumRepositoryDelegate {
	
	Logger log = Logger.getLogger(DCRestRepositoryController.class.getCanonicalName());
	@Autowired
	DocumentumAPIWrapper dcAPI;
	
	public JsonObject createFolder( String cabinetName,
			String folderName) throws FolderCreationException,CabinetNotFoundException {
		log.entering(DCRestRepositoryController.class.getSimpleName(), "CreateFolder");
		JsonObject cabinet;
		JsonObject folder;
		try {
			cabinet = dcAPI.getCabinet(cabinetName);
			folder = dcAPI.createFolder(cabinet, folderName);
			return folder;
		} catch (CabinetNotFoundException  | FolderCreationException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		} 
		

	}
	
	public JsonObject createDocument(DocumentCreation docCreation) throws DocumentumException{
		log.entering(DCRestRepositoryController.class.getSimpleName(), "createDocument");
		JsonObject document;
		JsonObject folder;
		try {
			folder = dcAPI.getFolderByPath(docCreation.getFolderPath());
			document = dcAPI.createDocument(folder, docCreation.getProperties());
			return document;
		} catch (FolderNotFoundException | DocumentCreationException e ) {
			log.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		} 
	}

	public JsonObject getCabinetByName(String cabinetName) throws CabinetNotFoundException {
		
		try {
			return dcAPI.getCabinet(cabinetName);
		} catch (CabinetNotFoundException e) {
			log.log(Level.SEVERE,e.getMessage(),e);
			throw e;
		}
	}

	public JsonObject getObjectById(String cabinetId) throws CabinetNotFoundException {
		try {
			return dcAPI.getObjectById(cabinetId);
		} catch (Exception e) {
			log.log(Level.SEVERE,e.getMessage(),e);
			//TODO Object Not Found Exception
			throw new CabinetNotFoundException(cabinetId);
		}
	}

	public ArrayList<NavigationObject> getAllCabinets() {
		try {
			return dcAPI.getAllCabinets();
		} catch (Exception e) {
			throw e;
		}
	}

	public ArrayList<NavigationObject> getChildren(String folderId) {
		try {
			return dcAPI.getChildren(folderId);
		} catch (Exception e) {
			//TODO Object Not Found Exception
			throw e;
		}
	}
	
	public Object getDocumentContentById(String documentId) throws DocumentNotFoundException{
		return dcAPI.getDocumentContentById(documentId);
	}
}
