package com.emc.documentum.services.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emc.documentum.delegate.provider.APIDelegateProvider;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping(value="configuration")
@CrossOrigin("*")
public class DocumentumConfigurationController {

	@Autowired
	APIDelegateProvider delegateProvider;
	
	@ApiOperation(value = "Return Configured Repositories identifiers", notes = "Return the identifiers for the configured repositories")
	@RequestMapping(value="/repositories",method=RequestMethod.GET)
	public String [] getAvailableRepositories(){
		return delegateProvider.getAllDelegates();
	}
}
