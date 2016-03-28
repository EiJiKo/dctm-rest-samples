package com.emc.documentum.delegates;

import java.util.ArrayList;

import com.emc.documentum.dtos.DocumentCreation;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.dtos.NavigationObject;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.exceptions.FolderCreationException;

public interface DocumentumDelegate {

	DocumentumFolder createFolder(String cabinetName, String folderName)
			throws FolderCreationException, CabinetNotFoundException;

	DocumentumDocument createDocument(DocumentCreation docCreation) throws DocumentumException;

	DocumentumFolder getCabinetByName(String cabinetName) throws CabinetNotFoundException;

	DocumentumObject getObjectById(String cabinetId) throws CabinetNotFoundException;

	ArrayList<NavigationObject> getAllCabinets();

	ArrayList<NavigationObject> getChildren(String folderId);

	byte[] getDocumentContentById(String documentId) throws DocumentNotFoundException;

	ArrayList<DocumentumObject> getDocumentByName(String name);
	
	DocumentumDocument checkoutDocument(String documentId);
	
	DocumentumDocument checkinDocument(String documentId,byte[]content);
}