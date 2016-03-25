package com.emc.documentum.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emc.documentum.delegates.DocumentumDelegate;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;

@Controller
public class DCRepositoryController {

	Logger log = Logger.getLogger(DCRepositoryController.class.getCanonicalName());
	
	@Autowired
	@Qualifier("DocumentumCMISDelegate")
	DocumentumDelegate dcRestDelegate;

	@RequestMapping("/folder/create/{cabinetName}/{folderName}")
	public String createFolder(@PathVariable(value = "cabinetName") String cabinetName,
			@PathVariable(value = "folderName") String folderName, Model model) throws RepositoryNotAvailableException {
		log.entering(DCRepositoryController.class.getSimpleName(), "CreateFolder");
		
		
		DocumentumFolder folder;
		try {
			folder = dcRestDelegate.createFolder(cabinetName, folderName);
			model.addAttribute("folder",folder);
		} catch (CabinetNotFoundException  | FolderCreationException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
			model.addAttribute("exception", e);
		} 
		

		return "FolderCreate";
	}
	
	
}
