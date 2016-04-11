package com.emc.documentum.delegates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import org.apache.chemistry.opencmis.client.api.CmisObject;
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
import com.emc.documentum.exceptions.CanNotDeleteFolderException;
import com.emc.documentum.exceptions.DocumentCheckoutException;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.FolderNotFoundException;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;
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

		Folder folder = (Folder) dcAPI.getObjectById(docCreation.getParentId());
		return CMISTransformation.convertCMISDocument(dcAPI.createDocument(folder, docCreation.getProperties()));
	}

	@Override
	public DocumentumFolder getCabinetByName(String cabinetName)
			throws CabinetNotFoundException, RepositoryNotAvailableException {
		try {
			Folder folder = dcAPI.getFolderByPath("/" + cabinetName);
			return CMISTransformation.convertCMISFolder(folder);
		} catch (FolderNotFoundException e) {
			// TODO
		}
		return null;
	}

	@Override
	public DocumentumObject getObjectById(String cabinetId)
			throws CabinetNotFoundException, RepositoryNotAvailableException {
		return CMISTransformation.convertCMISObject(dcAPI.getObjectById(cabinetId));
	}

	@Override
	public ArrayList<DocumentumFolder> getAllCabinets(int pageNumber, int pageSize)
			throws RepositoryNotAvailableException {

		return CMISTransformation.convertCmisObjectList(dcAPI.getAllCabinets(pageNumber, pageSize),
				DocumentumFolder.class);
	}

	@Override
	public ArrayList<DocumentumObject> getChildren(String folderId) throws RepositoryNotAvailableException {
		return CMISTransformation.convertCmisObjectList(dcAPI.getChildren(folderId, 1, 20), DocumentumObject.class);
	}

	@Override
	public byte[] getDocumentContentById(String documentId)
			throws DocumentNotFoundException, RepositoryNotAvailableException {
		return dcAPI.getDocumentContentById(documentId);
	}

	@Override
	public ArrayList<DocumentumObject> getDocumentByName(String name) throws RepositoryNotAvailableException {
		log.info("Get Objecy By Name :" + name);
		ItemIterable<QueryResult> documentList = dcAPI.getObjectsByName(name);
		return CMISTransformation.convertCMISQueryResultList(documentList);
	}

	@Override
	public DocumentumDocument checkoutDocument(String documentId) throws DocumentCheckoutException {
		log.info("checkout document" + documentId);
		return CMISTransformation.convertCMISDocument(dcAPI.checkoutDocument(documentId));

	}

	@Override
	public DocumentumDocument checkinDocument(String documentId, byte[] content) {
		return CMISTransformation.convertCMISDocument(dcAPI.checkinDocument(documentId, content));
	}

	@Override
	public ArrayList<DocumentumFolder> getPaginatedResult(String folderId, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumFolder createFolderByParentId(String ParentId, String folderName) throws FolderCreationException {
		try {
			Folder parentFolder = (Folder) dcAPI.getObjectById(ParentId);
			return CMISTransformation.convertCMISFolder(dcAPI.createFolder(parentFolder, folderName));
		} catch (RepositoryNotAvailableException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getIdentifier() {
		return "cmis";
	}

	@Override
	public ArrayList<DocumentumObject> getChildren(String folderId, int pageNumber, int pageSize)
			throws RepositoryNotAvailableException {
		return CMISTransformation.convertCmisObjectList(dcAPI.getChildren(folderId, pageNumber, pageSize),
				DocumentumObject.class);

	}

	@Override
	public ArrayList<DocumentumFolder> getAllCabinets() throws RepositoryNotAvailableException {
		return getAllCabinets(1, 20);
	}

	@Override
	public void deleteObject(String objectId, boolean deleteChildrenOrNot) throws CanNotDeleteFolderException {
		try {
			CmisObject object = dcAPI.getObjectById(objectId);
			dcAPI.deleteObject(object, deleteChildrenOrNot);
		} catch (RepositoryNotAvailableException e) {
			e.printStackTrace();
		}
	}

	public DocumentumDocument cancelCheckout(String documentId)
			throws RepositoryNotAvailableException, DocumentCheckoutException {
		return CMISTransformation.convertCMISDocument(dcAPI.cancelCheckout(documentId));
	}

	@Override
	public DocumentumFolder createFolder(String parentId, HashMap<String, Object> properties)
			throws FolderCreationException, RepositoryNotAvailableException, DocumentumException {
		throw new UnsupportedOperationException();
	}

	@Override
	public DocumentumDocument createDocument(String parentId, DocumentumDocument document)
			throws RepositoryNotAvailableException {
		Folder folder = (Folder) dcAPI.getObjectById(parentId);
		HashMap<String, Object> properties = document.getPropertiesAsMap();
		if (!properties.containsKey("cmis:objectTypeId")) {
			properties.put("cmis:objectTypeId", "cmis:document");
		}

		if (!properties.containsKey("cmis:name")) {
			properties.put("cmis:name", document.getName());
		}
		return CMISTransformation.convertCMISDocument(dcAPI.createDocument(folder, properties));
	}

}
