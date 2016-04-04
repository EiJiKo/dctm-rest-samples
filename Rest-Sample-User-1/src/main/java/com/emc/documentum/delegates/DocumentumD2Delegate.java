package com.emc.documentum.delegates;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emc.documentum.dtos.DocumentCreation;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.DocumentCheckoutException;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;
import com.emc.documentum.transformation.DCD2Transformation;
import com.emc.documentum.wrappers.DCD2APIWrapper;

@Component("DocumentumD2Delegate")
public class DocumentumD2Delegate implements DocumentumDelegate{

	@Autowired
	DCD2APIWrapper dcAPI;
	
	@Override
	public DocumentumFolder createFolder(String cabinetName, String folderName)
			throws FolderCreationException, CabinetNotFoundException, RepositoryNotAvailableException {
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
			throws CabinetNotFoundException, RepositoryNotAvailableException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumObject getObjectById(String cabinetId)
			throws CabinetNotFoundException, RepositoryNotAvailableException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DocumentumFolder> getAllCabinets() throws RepositoryNotAvailableException {
		return DCD2Transformation.convertD2DocItemObjectList(dcAPI.getAllCabinets());
	
	}

	@Override
	public ArrayList<DocumentumObject> getChildren(String folderId) throws RepositoryNotAvailableException {
		return DCD2Transformation.convertD2DocItemObjectList(dcAPI.getChildren(folderId));
	}

	@Override
	public byte[] getDocumentContentById(String documentId)
			throws DocumentNotFoundException, RepositoryNotAvailableException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DocumentumObject> getDocumentByName(String name) throws RepositoryNotAvailableException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumDocument checkoutDocument(String documentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumDocument checkinDocument(String documentId, byte[] content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DocumentumFolder> getPaginatedResult(String folderId, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumFolder createFolderByParentId(String ParentId, String folderName) throws FolderCreationException {
		// TODO Auto-generated method stub
		return null;
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
		return DCD2Transformation.convertD2DocItemObjectList(dcAPI.getChildren(folderId,pageNumber,pageSize));
	}

	@Override
	public ArrayList<DocumentumFolder> getAllCabinets(int pageNumber, int pageSize)
			throws RepositoryNotAvailableException {
		// TODO Auto-generated method stub
		return DCD2Transformation.convertD2DocItemObjectList(dcAPI.getAllCabinets());
	}

	@Override
	public void deleteObject(String objectId , boolean deleteChildrenOrNot) {
		// TODO Auto-generated method stub
	}
	
	public DocumentumDocument cancelCheckout(String documentId)
			throws RepositoryNotAvailableException, DocumentCheckoutException {
		// TODO Auto-generated method stub
		return null;
	}

}
