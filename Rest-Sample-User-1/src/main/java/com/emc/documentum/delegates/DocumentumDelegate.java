package com.emc.documentum.delegates;

import java.util.ArrayList;

import com.emc.documentum.dtos.DocumentCreation;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.model.JsonFeed;
import com.emc.documentum.model.JsonObject;

public interface DocumentumDelegate {

	DocumentumFolder createFolder(String cabinetName, String folderName)
			throws FolderCreationException, CabinetNotFoundException;

	DocumentumDocument createDocument(DocumentCreation docCreation) throws DocumentumException;

	DocumentumFolder getCabinetByName(String cabinetName) throws CabinetNotFoundException;

	DocumentumObject getObjectById(String cabinetId) throws CabinetNotFoundException;

	ArrayList<DocumentumFolder> getAllCabinets();

	ArrayList<DocumentumObject> getChildren(String folderId);

	byte[] getDocumentContentById(String documentId) throws DocumentNotFoundException;

	ArrayList<DocumentumObject> getDocumentByName(String name);
	
	JsonFeed getPaginatedResult(String folderId , int startIndex , int pageSize);

	DocumentumFolder createFolderByParentId(String ParentId, String folderName)
			throws FolderCreationException;
}