package com.emc.documentum.delegates;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emc.documentum.dtos.DocumentCreation;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.FolderNotFoundException;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;
import com.emc.documentum.model.JsonFeed;
import com.emc.documentum.transformation.CMISTransformation;
import com.emc.documentum.wrappers.DCCMISAPIWrapper;

@Component("DocumentumCMISDelegate")
public class DocumentumCMISDelegate implements DocumentumDelegate {

	Logger log = Logger.getLogger(DocumentumCMISDelegate.class.getCanonicalName());

	@Autowired
	DCCMISAPIWrapper dcAPI;

	public DocumentumFolder createFolder(String cabinetName, String folderName)
			throws FolderCreationException, CabinetNotFoundException, RepositoryNotAvailableException {
		try {
			Folder folder = dcAPI.getFolderByPath("/" + cabinetName);
			return CMISTransformation.convertCMISFolder(dcAPI.createFolder(folder, folderName));

		} catch (FolderNotFoundException e) {
			// TODO
		}
		// TODO
		return null;
	}

	@Override
	public DocumentumDocument createDocument(DocumentCreation docCreation) throws DocumentumException {

		Folder folder = dcAPI.getFolderByPath(docCreation.getFolderPath());
		return CMISTransformation.convertCMISDocument(dcAPI.createDocument(folder, docCreation.getProperties()));
	}

	@Override
	public DocumentumFolder getCabinetByName(String cabinetName) throws CabinetNotFoundException, RepositoryNotAvailableException {
		try {
			Folder folder = dcAPI.getFolderByPath("/" + cabinetName);
			return CMISTransformation.convertCMISFolder(folder);
		} catch (FolderNotFoundException e) {
			// TODO
		}
		return null;
	}

	@Override
	public DocumentumObject getObjectById(String cabinetId) throws CabinetNotFoundException, RepositoryNotAvailableException {
		return CMISTransformation.convertCMISObject(dcAPI.getObjectById(cabinetId));
	}

	@Override
	public ArrayList<DocumentumFolder> getAllCabinets() throws RepositoryNotAvailableException {

		return dcAPI.getAllCabinets();
	}

	@Override
	public ArrayList<DocumentumObject> getChildren(String folderId) throws RepositoryNotAvailableException {
		return dcAPI.getChildren(folderId);
	}

	@Override
	public byte[] getDocumentContentById(String documentId) throws DocumentNotFoundException, RepositoryNotAvailableException {
		return dcAPI.getDocumentContentById(documentId);
	}

	@Override
	public ArrayList<DocumentumObject> getDocumentByName(String name) throws RepositoryNotAvailableException {
		log.info("Get Objecy By Name :" + name);
		ItemIterable<QueryResult> documentList = dcAPI.getObjectsByName(name);
		return CMISTransformation.convertCMISQueryResultList(documentList);
	}

	@Override
	public JsonFeed getPaginatedResult(String folderId, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumFolder createFolderByParentId(String ParentId, String folderName) throws FolderCreationException {
		// TODO Auto-generated method stub
		return null;
	}

}
