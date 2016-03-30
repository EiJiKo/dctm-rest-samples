package com.emc.documentum.delegates;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import com.emc.documentum.dtos.DocumentCreation;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.DocumentCreationException;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.FolderNotFoundException;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;
import com.emc.documentum.model.JsonObject;
import com.emc.documentum.transformation.CoreRestTransformation;
import com.emc.documentum.wrappers.DCRestAPIWrapper;

@Component("DocumentumRestDelegate")
public class DocumentumRestDelegate implements DocumentumDelegate {

	Logger log = Logger.getLogger(DocumentumRestDelegate.class.getCanonicalName());
	@Autowired
	DCRestAPIWrapper dcAPI;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.delegates.DocumentumDelegate#createFolder(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public DocumentumFolder createFolder(String cabinetName, String folderName)
			throws FolderCreationException, CabinetNotFoundException, RepositoryNotAvailableException {
		log.entering(DocumentumRestDelegate.class.getSimpleName(), "CreateFolder");
		JsonObject cabinet;
		JsonObject folder;
		try {
			cabinet = dcAPI.getCabinet(cabinetName);
			folder = dcAPI.createFolder(cabinet, folderName);
			return CoreRestTransformation.convertCoreRSFolder(folder);
		} catch (ResourceAccessException e) {
			throw new RepositoryNotAvailableException("CoreRest");
		} catch (CabinetNotFoundException | FolderCreationException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.delegates.DocumentumDelegate#createFolder(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public DocumentumFolder createFolderByParentId(String ParentId, String folderName)
			throws FolderCreationException, RepositoryNotAvailableException {
		log.entering(DocumentumRestDelegate.class.getSimpleName(), "CreateFolder");
		JsonObject parent = dcAPI.getObjectById(ParentId);
		JsonObject folder;
		try {
			folder = dcAPI.createFolder(parent, folderName);
			return CoreRestTransformation.convertCoreRSFolder(folder);
		} catch (ResourceAccessException e) {
			throw new RepositoryNotAvailableException("CoreRest");
		} catch (FolderCreationException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.delegates.DocumentumDelegate#createDocument(com.emc.
	 * documentum.dtos.DocumentCreation)
	 */
	@Override
	public DocumentumDocument createDocument(DocumentCreation docCreation) throws DocumentumException {
		log.entering(DocumentumRestDelegate.class.getSimpleName(), "createDocument");
		JsonObject document;
		JsonObject folder;
		try {
			folder = dcAPI.getFolderByPath(docCreation.getFolderPath());
			document = dcAPI.createDocument(folder, docCreation.getProperties());
			return CoreRestTransformation.convertCoreRSDocument(document);
		} catch (ResourceAccessException e) {
			throw new RepositoryNotAvailableException("CoreRest");
		} catch (FolderNotFoundException | DocumentCreationException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.delegates.DocumentumDelegate#getCabinetByName(java.
	 * lang.String)
	 */
	@Override
	public DocumentumFolder getCabinetByName(String cabinetName)
			throws CabinetNotFoundException, RepositoryNotAvailableException {

		try {
			return CoreRestTransformation.convertCoreRSFolder(dcAPI.getCabinet(cabinetName));
		} catch (ResourceAccessException e) {
			throw new RepositoryNotAvailableException("CoreRest");
		} catch (CabinetNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.delegates.DocumentumDelegate#getObjectById(java.lang.
	 * String)
	 */
	@Override
	public DocumentumObject getObjectById(String cabinetId)
			throws CabinetNotFoundException, RepositoryNotAvailableException {
		try {
			return CoreRestTransformation.convertCoreRSObject(dcAPI.getObjectById(cabinetId));
		} catch (ResourceAccessException e) {
			throw new RepositoryNotAvailableException("CoreRest");
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
			// TODO Object Not Found Exception
			throw new CabinetNotFoundException(cabinetId);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.emc.documentum.delegates.DocumentumDelegate#getAllCabinets()
	 */
	@Override
	public ArrayList<DocumentumFolder> getAllCabinets() throws RepositoryNotAvailableException {
		try {
			return CoreRestTransformation.convertCoreRSEntryList(dcAPI.getAllCabinets(), DocumentumFolder.class);
		} catch (ResourceAccessException e) {
			throw new RepositoryNotAvailableException("CoreRest");
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.delegates.DocumentumDelegate#getChildren(java.lang.
	 * String)
	 */
	@Override
	public ArrayList<DocumentumObject> getChildren(String folderId) throws RepositoryNotAvailableException {
		try {
			return CoreRestTransformation.convertCoreRSEntryList(dcAPI.getChildren(folderId));
		} catch (ResourceAccessException e) {
			throw new RepositoryNotAvailableException("CoreRest");
		} catch (Exception e) {
			// TODO Object Not Found Exception
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.documentum.delegates.DocumentumDelegate#getDocumentContentById(
	 * java.lang.String)
	 */
	@Override
	public byte[] getDocumentContentById(String documentId)
			throws DocumentNotFoundException, RepositoryNotAvailableException {
		try {
			return dcAPI.getDocumentContentById(documentId);
		} catch (ResourceAccessException e) {
			throw new RepositoryNotAvailableException("CoreRest");
		}
	}

	@Override
	public ArrayList<DocumentumObject> getDocumentByName(String name) throws RepositoryNotAvailableException {
		try {
			return CoreRestTransformation.convertCoreRSEntryList(dcAPI.getDocumentByName(name));
		} catch (ResourceAccessException e) {
			throw new RepositoryNotAvailableException("CoreRest");
		} catch (DocumentNotFoundException e) {
			return new ArrayList<DocumentumObject>();
		}

	}

	@Override
	public DocumentumDocument checkoutDocument(String documentId) throws RepositoryNotAvailableException {
		try {
			return CoreRestTransformation.convertCoreRSDocument(dcAPI.checkOutDocument(documentId));
		} catch (ResourceAccessException e) {
			throw new RepositoryNotAvailableException("CoreRest");
		}
	}

	@Override
	public DocumentumDocument checkinDocument(String documentId, byte[] content)
			throws RepositoryNotAvailableException {
		try {
			return CoreRestTransformation.convertCoreRSDocument(dcAPI.checkinDocument(documentId, content));
		} catch (ResourceAccessException e) {
			throw new RepositoryNotAvailableException("CoreRest");
		}

	}

	@Override
	public ArrayList<DocumentumFolder> getPaginatedResult(String folderId, int startIndex, int pageSize) throws RepositoryNotAvailableException {
		try {
			return dcAPI.getPaginatedResult(folderId, startIndex, pageSize);
		} catch (ResourceAccessException e) {
			throw new RepositoryNotAvailableException("CoreRest");
		}
	}

	@Override
	public String getIdentifier() {
		return "corerest";
	}

	@Override
	public ArrayList<DocumentumObject> getChildren(String folderId, int pageNumber, int pageSize)
			throws RepositoryNotAvailableException {
		// TODO Auto-generated method stub
		return null;
	}

}
