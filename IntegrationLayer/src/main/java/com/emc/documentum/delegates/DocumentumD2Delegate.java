package com.emc.documentum.delegates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emc.documentum.dtos.DocumentCreation;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.dtos.DocumentumProperty;
import com.emc.documentum.exceptions.CanNotDeleteFolderException;
import com.emc.documentum.exceptions.DocumentCheckoutException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.ObjectNotFoundException;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;
import com.emc.documentum.transformation.DCD2Transformation;
import com.emc.documentum.wrappers.DCD2APIWrapper;

@Component("DocumentumD2Delegate")
public class DocumentumD2Delegate implements DocumentumDelegate {

	@Autowired
	DCD2APIWrapper dcAPI;

	@Override
	public DocumentumFolder createFolder(String cabinetName, String folderName)
			throws FolderCreationException, ObjectNotFoundException, RepositoryNotAvailableException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumDocument createDocument(DocumentCreation docCreation) throws DocumentumException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumFolder getCabinetByName(String cabinetName)
			throws ObjectNotFoundException, RepositoryNotAvailableException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumObject getObjectById(String cabinetId)
			throws ObjectNotFoundException, RepositoryNotAvailableException {
		return DCD2Transformation.convertD2DocItemObject(dcAPI.getObjectById(cabinetId), dcAPI.getContext());

	}

	@Override
	public ArrayList<DocumentumFolder> getAllCabinets() throws RepositoryNotAvailableException {
		return DCD2Transformation.convertD2DocItemObjectList(dcAPI.getAllCabinets(), dcAPI.getContext());

	}

	@Override
	public ArrayList<DocumentumObject> getChildren(String folderId) throws RepositoryNotAvailableException {
		return DCD2Transformation.convertD2DocItemObjectList(dcAPI.getChildren(folderId), dcAPI.getContext());
	}

	@Override
	public byte[] getDocumentContentById(String documentId)
			throws ObjectNotFoundException, RepositoryNotAvailableException {
		return dcAPI.getDocumentContent(documentId);
	}

	@Override
	public ArrayList<DocumentumObject> getDocumentByName(String name) throws RepositoryNotAvailableException {
		try {
			return DCD2Transformation.convertD2DocItemObjectList(dcAPI.getDocumentByName(name), dcAPI.getContext());
		} catch (ObjectNotFoundException e) {
			return new ArrayList<DocumentumObject>();
		}
	}

	@Override
	public DocumentumDocument checkoutDocument(String documentId)
			throws DocumentCheckoutException, RepositoryNotAvailableException {
		DocumentumDocument document = DCD2Transformation.convertD2DocItemObject(dcAPI.checkoutDocument(documentId),
				dcAPI.getContext());
		return document;
	}

	@Override
	public DocumentumDocument checkinDocument(String documentId, byte[] content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumFolder createFolderByParentId(String ParentId, String folderName)
			throws FolderCreationException, RepositoryNotAvailableException {
		return DCD2Transformation.convertD2DocItemObject(dcAPI.createFolder(ParentId, folderName), dcAPI.getContext());
	}

	@Override
	public String getIdentifier() {
		// TODO Auto-generated method stub
		return "D2";
	}

	@Override
	public ArrayList<DocumentumObject> getChildren(String folderId, int pageNumber, int pageSize)
			throws RepositoryNotAvailableException {
		// TODO Auto-generated method stub
		return DCD2Transformation.convertD2DocItemObjectList(dcAPI.getChildren(folderId, pageNumber, pageSize),
				dcAPI.getContext());
	}

	@Override
	public ArrayList<DocumentumFolder> getAllCabinets(int pageNumber, int pageSize)
			throws RepositoryNotAvailableException {
		// TODO Auto-generated method stub
		return DCD2Transformation.convertD2DocItemObjectList(dcAPI.getAllCabinets(pageNumber, pageSize),
				dcAPI.getContext());
	}

	@Override
	public void deleteObject(String objectId, boolean deleteChildrenOrNot) throws CanNotDeleteFolderException {
		dcAPI.deleteObject(objectId, deleteChildrenOrNot);
	}

	@Override
	public DocumentumDocument cancelCheckout(String documentId)
			throws RepositoryNotAvailableException, DocumentCheckoutException {
		return DCD2Transformation.convertD2DocItemObject(dcAPI.cancelCheckout(documentId), dcAPI.getContext());
	}

	@Override
	public DocumentumFolder createFolder(String parentId, HashMap<String, Object> properties)
			throws FolderCreationException, RepositoryNotAvailableException, DocumentumException {
		throw new UnsupportedOperationException("Method not Implemented");
	}

	@Override
	public DocumentumDocument createDocument(String parentId, DocumentumDocument docCreation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DocumentumProperty> getObjectProperties(String objectId) throws RepositoryNotAvailableException {
		return DCD2Transformation.convertD2PropertiesList(dcAPI.getObjectProperties(objectId));
	}

	@Override
	public ArrayList<DocumentumObject> getDocumentRelationsByRelationName(String objectId, String relationName,
			int pageNumber) {
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
		return DCD2Transformation.convertD2DocItemObjectList(dcAPI.getDocumentRenditions(doumentId),
				dcAPI.getContext());
	}

	@Override
	public DocumentumObject renameObject(String documentId, String newName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public DocumentumObject addCommentToDocument(String documentId, String comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override

	public ArrayList<DocumentumObject> getDocumentComments(String documentId, String relationName)
			throws DocumentumException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumObject moveObject(String objectId, String targetFolderId)
			throws DocumentumException, RepositoryNotAvailableException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumObject copyObject(String objectId, String targetFolderId)
			throws DocumentumException, RepositoryNotAvailableException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumObject updateProperties(String objectId, Map<String, Object> newProperties)
			throws ObjectNotFoundException, RepositoryNotAvailableException {
		// TODO Auto-generated method stub
		return null;
	}

}
