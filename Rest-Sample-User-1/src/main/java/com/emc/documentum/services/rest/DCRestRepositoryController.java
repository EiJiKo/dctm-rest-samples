package com.emc.documentum.services.rest;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emc.documentum.delegates.DocumentumRepositoryDelegate;
import com.emc.documentum.dtos.DocumentCreation;
import com.emc.documentum.dtos.NavigationObject;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.model.JsonObject;

@RestController
@RequestMapping("/services")
public class DCRestRepositoryController {

	Logger log = Logger.getLogger(DCRestRepositoryController.class.getCanonicalName());

	@Autowired
	DocumentumRepositoryDelegate dcRestDelegate;

	@RequestMapping("/folder/create/{cabinetName}/{folderName}")
	public JsonObject createFolder(@PathVariable(value = "cabinetName") String cabinetName,
			@PathVariable(value = "folderName") String folderName) throws DocumentumException {
		try {
			return dcRestDelegate.createFolder(cabinetName, folderName);
		} catch (DocumentumException e) {
			// TODO Customize Error Handling
			throw e;
		}
	}

	@RequestMapping(value = "/document/create", method = RequestMethod.POST)
	public JsonObject createDocument(@RequestBody DocumentCreation docCreation) throws DocumentumException {
		try {
			return dcRestDelegate.createDocument(docCreation);
		} catch (DocumentumException e) {
			// TODO Customize Error Handling
			throw e;
		}
	}
	
	@RequestMapping(value = "get/cabinet/name/{cabinetName}")
	public JsonObject getCabinetByName(@PathVariable(value = "cabinetName") String cabinetName) throws CabinetNotFoundException{
		
		
			try {
				return dcRestDelegate.getCabinetByName(cabinetName);
			} catch (CabinetNotFoundException e) {
				// TODO Auto-generated catch block
				throw e;
			}
		
	}
	
	@RequestMapping(value = "get/cabinet/id/{cabinetId}")
	public JsonObject getCabinetById(@PathVariable(value="cabinetId") String cabinetId) throws CabinetNotFoundException{
		try {
			return dcRestDelegate.getObjectById(cabinetId);
		} catch (CabinetNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "get/cabinets")
	public ArrayList<NavigationObject> getAllCabinets(){
		try {
			return dcRestDelegate.getAllCabinets();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "get/{folderId}/children")
	public ArrayList<NavigationObject> getChilderen(@PathVariable(value="folderId") String folderId){
		try {
			return dcRestDelegate.getChilderen(folderId);
		} catch (Exception e) {
			// TODO ObjectNotFoundException
			throw e;
		}
	}
	
	@RequestMapping(value= "get/document/content/id/{documentId}")
	public Object getDocumentContentById(@PathVariable(value="documentId")String documentId) throws DocumentNotFoundException{
		return dcRestDelegate.getDocumentContentById(documentId);
	}

}
