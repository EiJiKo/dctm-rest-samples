package com.emc.documentum.services.rest;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emc.documentum.delegates.DocumentumDelegate;
import com.emc.documentum.dtos.DocumentCreation;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;

@RestController
@RequestMapping("/services")
public class DCRestRepositoryController {

	Logger log = Logger.getLogger(DCRestRepositoryController.class.getCanonicalName());

	@Autowired
	@Qualifier("DocumentumCMISDelegate")
	// @Qualifier("DocumentumRestDelegate")
	DocumentumDelegate dcRestDelegate;

	@RequestMapping("/folder/create/{cabinetName}/{folderName}")
	public DocumentumFolder createFolder(@PathVariable(value = "cabinetName") String cabinetName,
			@PathVariable(value = "folderName") String folderName) throws DocumentumException {
			return dcRestDelegate.createFolder(cabinetName, folderName);
	}

	@RequestMapping(value = "/document/create", method = RequestMethod.POST)
	public DocumentumDocument createDocument(@RequestBody DocumentCreation docCreation) throws DocumentumException {
			return dcRestDelegate.createDocument(docCreation);

	}

	@RequestMapping(value = "get/cabinet/name/{cabinetName}")
	public DocumentumFolder getCabinetByName(@PathVariable(value = "cabinetName") String cabinetName)
			throws CabinetNotFoundException, RepositoryNotAvailableException {

		return dcRestDelegate.getCabinetByName(cabinetName);

	}

	@CrossOrigin("*")
	@RequestMapping(value = "get/cabinet/id/{cabinetId}")
	public DocumentumObject getCabinetById(@PathVariable(value = "cabinetId") String cabinetId)
			throws CabinetNotFoundException, RepositoryNotAvailableException {
		return dcRestDelegate.getObjectById(cabinetId);
	}

	@CrossOrigin("*")
	@RequestMapping(value = "get/cabinets")
	public ArrayList<DocumentumFolder> getAllCabinets() throws RepositoryNotAvailableException {
		return dcRestDelegate.getAllCabinets();

	}

	@CrossOrigin("*")
	@RequestMapping(value = "get/{folderId}/children")
	public ArrayList<DocumentumObject> getChildren(@PathVariable(value = "folderId") String folderId)
			throws RepositoryNotAvailableException {
		return dcRestDelegate.getChildren(folderId);

	}

	@RequestMapping(value = "get/document/content/id/{documentId}")
	public Object getDocumentContentById(@PathVariable(value = "documentId") String documentId)
			throws DocumentNotFoundException, RepositoryNotAvailableException {
		return dcRestDelegate.getDocumentContentById(documentId);
	}

	@RequestMapping(value = "document/search/{name:.+}")
	public ArrayList<DocumentumObject> searchDocumentByName(@PathVariable(value = "name") String name)
			throws RepositoryNotAvailableException {
		log.entering("searchDocumentByName", name);
		return dcRestDelegate.getDocumentByName(name);

	}

}
