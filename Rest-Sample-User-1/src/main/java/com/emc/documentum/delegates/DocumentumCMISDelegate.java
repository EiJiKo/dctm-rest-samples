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
import com.emc.documentum.dtos.DocumentumProperty;
import com.emc.documentum.exceptions.CanNotDeleteFolderException;
import com.emc.documentum.exceptions.DocumentCheckoutException;
import com.emc.documentum.exceptions.DocumentCreationException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.ObjectNotFoundException;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;
import com.emc.documentum.transformation.CMISTransformation;
import com.emc.documentum.wrappers.DCCMISAPIWrapper;

@Component("DocumentumCMISDelegate")
public class DocumentumCMISDelegate implements DocumentumDelegate {

	Logger log = Logger.getLogger(DocumentumCMISDelegate.class.getCanonicalName());

	@Autowired
	DCCMISAPIWrapper dcAPI;

	@Override
	public DocumentumFolder createFolder(String cabinetName, String folderName)
			throws FolderCreationException, ObjectNotFoundException, RepositoryNotAvailableException {
		try {
			Folder folder = dcAPI.getFolderByPath("/" + cabinetName);
			return CMISTransformation.convertCMISFolder(dcAPI.createFolder(folder, folderName));

		} catch (ObjectNotFoundException e) {
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
			throws ObjectNotFoundException, RepositoryNotAvailableException {
		try {
			Folder folder = dcAPI.getFolderByPath("/" + cabinetName);
			return CMISTransformation.convertCMISFolder(folder);
		} catch (ObjectNotFoundException e) {
			// TODO
		}
		return null;
	}

	@Override
	public DocumentumObject getObjectById(String cabinetId)
			throws ObjectNotFoundException, RepositoryNotAvailableException {
		return CMISTransformation.convertCMISObject(dcAPI.getObjectById(cabinetId));
	}

	@Override
	public ArrayList<DocumentumFolder> getAllCabinets(int pageNumber, int pageSize)
			throws RepositoryNotAvailableException {

		return CMISTransformation.convertCmisObjectList(dcAPI.getAllCabinets(pageNumber, pageSize),
				DocumentumFolder.class);
	}

	@Override
	public ArrayList<DocumentumObject> getChildren(String folderId) throws DocumentumException {
		return CMISTransformation.convertCmisObjectList(dcAPI.getChildren(folderId, 1, 20), DocumentumObject.class);
	}

	@Override
	public byte[] getDocumentContentById(String documentId)
			throws ObjectNotFoundException, RepositoryNotAvailableException {
		return dcAPI.getDocumentContentById(documentId);
	}

	@Override
	public ArrayList<DocumentumObject> getDocumentByName(String name) throws RepositoryNotAvailableException {
		log.info("Get Objecy By Name :" + name);
		ItemIterable<QueryResult> documentList = dcAPI.getObjectsByName(name);
		return CMISTransformation.convertCMISQueryResultList(documentList);
	}

	@Override
	public DocumentumDocument checkoutDocument(String documentId)
			throws DocumentCheckoutException, RepositoryNotAvailableException {
		log.info("checkout document" + documentId);
		return CMISTransformation.convertCMISDocument(dcAPI.checkoutDocument(documentId));

	}

	@Override
	public DocumentumDocument checkinDocument(String documentId, byte[] content)
			throws RepositoryNotAvailableException {
		return CMISTransformation.convertCMISDocument(dcAPI.checkinDocument(documentId, content));
	}

	@Override
	public DocumentumFolder createFolderByParentId(String ParentId, String folderName) throws FolderCreationException {
		try {
			CmisObject object = dcAPI.getObjectById(ParentId);
			if (!object.getBaseType().getLocalName().equals("dm_folder")) {
				throw new FolderCreationException(ParentId + " is not a folder.");
			}
			Folder parentFolder = (Folder) object;
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
			throws DocumentumException {
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

	@Override
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
			throws DocumentCreationException, RepositoryNotAvailableException {
		CmisObject object = dcAPI.getObjectById(parentId);
		if (!object.getBaseType().getLocalName().equals("dm_folder")) {
			throw new DocumentCreationException(parentId + " is not a folder.");
		}
		Folder folder = (Folder) object;
		HashMap<String, Object> properties = document.getPropertiesAsMap();
		if (!properties.containsKey("cmis:objectTypeId")) {
			properties.put("cmis:objectTypeId", "cmis:document");
		}

		if (!properties.containsKey("cmis:name")) {
			properties.put("cmis:name", document.getName());
		}
		return CMISTransformation.convertCMISDocument(dcAPI.createDocument(folder, properties));
	}

	@Override
	public ArrayList<DocumentumProperty> getObjectProperties(String objectId) throws RepositoryNotAvailableException {
		return CMISTransformation.convertCMISObject(dcAPI.getObjectById(objectId)).getProperties();
	}

	@Override
	public ArrayList<DocumentumObject> getDocumentRelationsByRelationName(String objectId , String relationName,int pageNumber)
			throws RepositoryNotAvailableException, DocumentumException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumObject createDocumentAnnotation(String documentId, byte[] content,
			HashMap<String, Object> properties) throws DocumentumException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DocumentumObject> getRenditionsByDocumentId(String doumentId) {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public DocumentumObject renameObject(String documentId, String newName) throws RepositoryNotAvailableException, ObjectNotFoundException {
		return CMISTransformation.convertCMISObject(dcAPI.renameObject(documentId, newName));
	}

	@Override
	public void addCommentToDocument(String documentId, String comment) {
		// TODO Auto-generated method stub
		
	}

	@Override

	public ArrayList<DocumentumObject> getDocumentComments(String documentId, String relationName)
			throws DocumentumException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public DocumentumObject copyObject(String objectId, String targetFolderId)
			throws DocumentumException, RepositoryNotAvailableException {
		if(objectId.equals(targetFolderId))
		{
			throw new DocumentumException("source object equals target folder Id.");
		}
		return CMISTransformation.convertCMISObject(dcAPI.copyObject(objectId, targetFolderId));
	}

	@Override
	public DocumentumObject moveObject(String objectId, String targetFolderId)
			throws DocumentumException, RepositoryNotAvailableException {
		if(objectId.equals(targetFolderId))
		{
			throw new DocumentumException("source object equals target folder Id.");
		}
		return CMISTransformation.convertCMISObject(dcAPI.moveObject(objectId, targetFolderId));

	}

}
