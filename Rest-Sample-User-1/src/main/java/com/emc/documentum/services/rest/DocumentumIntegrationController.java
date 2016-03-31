package com.emc.documentum.services.rest;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emc.documentum.delegate.provider.APIDelegateProvider;
import com.emc.documentum.dtos.DocumentCreation;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.DelegateNotFoundException;
import com.emc.documentum.exceptions.DocumentCheckinException;
import com.emc.documentum.exceptions.DocumentCheckoutException;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;

@RestController
@RequestMapping("{api}/services")
@CrossOrigin("*")
public class DocumentumIntegrationController {

	Logger log = Logger.getLogger(DocumentumIntegrationController.class.getCanonicalName());

	@Autowired
	APIDelegateProvider delegateProvider;

	@RequestMapping("/folder/create/{cabinetName}/{folderName}")
	public DocumentumFolder createFolder(@PathVariable(value = "api") String api,
			@PathVariable(value = "cabinetName") String cabinetName,
			@PathVariable(value = "folderName") String folderName)
			throws DocumentumException, DelegateNotFoundException {
		try {
			return delegateProvider.getDelegate(api).createFolder(cabinetName, folderName);
		} catch (DocumentumException e) {
			// TODO Customize Error Handling
			throw e;
		}
	}

	@RequestMapping(value = "/document/create", method = RequestMethod.POST)
	public DocumentumDocument createDocument(@PathVariable(value = "api") String api,
			@RequestBody DocumentCreation docCreation) throws DocumentumException, DelegateNotFoundException {
		try {
			return (delegateProvider.getDelegate(api)).createDocument(docCreation);
		} catch (DocumentumException e) {
			// TODO Customize Error Handling
			throw e;
		}
	}

	@RequestMapping(value = "get/cabinet/name/{cabinetName}")
	public DocumentumFolder getCabinetByName(@PathVariable(value = "api") String api,
			@PathVariable(value = "cabinetName") String cabinetName)
			throws CabinetNotFoundException, RepositoryNotAvailableException, DelegateNotFoundException {

		try {
			return (delegateProvider.getDelegate(api)).getCabinetByName(cabinetName);
		} catch (CabinetNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		}

	}

	@RequestMapping(value = "get/cabinet/id/{cabinetId}")
	public DocumentumObject getCabinetById(@PathVariable(value = "api") String api,
			@PathVariable(value = "cabinetId") String cabinetId)
			throws CabinetNotFoundException, RepositoryNotAvailableException, DelegateNotFoundException {
		return (delegateProvider.getDelegate(api)).getObjectById(cabinetId);

	}

	@RequestMapping(value = "get/cabinets")
	public ArrayList<DocumentumFolder> getAllCabinets(@PathVariable(value = "api") String api,@RequestParam(name="pageNumber",defaultValue="1") int pageNumber , @RequestParam(name="pageSize",defaultValue="20") int pageSize)
			throws RepositoryNotAvailableException, DelegateNotFoundException {
		return (delegateProvider.getDelegate(api)).getAllCabinets(pageNumber,pageSize);
	}

	@RequestMapping(value = "get/{folderId}/children")
	public ArrayList<DocumentumObject> getChildren(@PathVariable(value = "api") String api,
			@PathVariable(value = "folderId") String folderId ,@RequestParam(name="pageNumber",defaultValue="1") int pageNumber , @RequestParam(name="pageSize",defaultValue="20") int pageSize) throws Exception {
		System.out.println("Page Number: " + pageNumber + " Page Size: " + pageSize);
		return (delegateProvider.getDelegate(api)).getChildren(folderId,pageNumber,pageSize);
	}

	@RequestMapping(value = "get/document/content/id/{documentId}")
	public Object getDocumentContentById(@PathVariable(value = "api") String api,
			@PathVariable(value = "documentId") String documentId)
			throws DocumentNotFoundException, RepositoryNotAvailableException, DelegateNotFoundException {
		return (delegateProvider.getDelegate(api)).getDocumentContentById(documentId);
	}

	@RequestMapping(value = "document/search/{name}")
	public ArrayList<DocumentumObject> searchDocumentByName(@PathVariable(value = "api") String api,
			@PathVariable(value = "name") String name)
			throws RepositoryNotAvailableException, DelegateNotFoundException {
		log.entering("searchDocumentByName", name);
		return (delegateProvider.getDelegate(api)).getDocumentByName(name);
	}

	@RequestMapping(value = "get/document/checkout/id/{documentId}")
	public DocumentumDocument checkoutDocuement(@PathVariable(value = "api") String api,
			@PathVariable(value = "documentId") String documentId) throws DelegateNotFoundException, RepositoryNotAvailableException, DocumentCheckoutException {
		log.entering("checkout document ", documentId);
		return (delegateProvider.getDelegate(api)).checkoutDocument(documentId);
	}

	@RequestMapping(value = "get/document/checkin/id/{documentId}", method = RequestMethod.POST)
	public DocumentumDocument checkinDocuement(@PathVariable(value = "api") String api,
			@PathVariable(value = "documentId") String documentId, @RequestBody byte[] content)
			throws DelegateNotFoundException, RepositoryNotAvailableException, DocumentCheckinException {
		log.entering("checkin document ", documentId);
		return (delegateProvider.getDelegate(api)).checkinDocument(documentId, content);
	}
	@RequestMapping(value = "get/document/cancelCheckout/id/{documentId}", method = RequestMethod.GET)
	public DocumentumDocument cancelCheckout(@PathVariable(value = "api") String api,
			@PathVariable(value = "documentId") String documentId) throws RepositoryNotAvailableException, DocumentCheckoutException, DelegateNotFoundException
	{
		log.entering("checkin document ", documentId);
		return (delegateProvider.getDelegate(api)).cancelCheckout(documentId);
	}
}
