package com.emc.documentum.emcworld;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emc.documentum.delegate.provider.APIDelegateProvider;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.exceptions.DelegateNotFoundException;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;

@RestController
@RequestMapping("demo/corerest")
@CrossOrigin("*")
public class EMCWorldDemo {

	@Autowired
	APIDelegateProvider delegateProvider;

	@RequestMapping("query")
	public ArrayList<DocumentumObject> executeDQLQuery(@RequestParam(name = "query") String query)
			throws DelegateNotFoundException, RepositoryNotAvailableException {
		return delegateProvider.getDelegate("corerest").query(query);
	}

	@RequestMapping(value = "document/content/{documentId}")
	public Object getDocumentContentById(@PathVariable(value = "documentId") String documentId)
			throws DocumentNotFoundException, RepositoryNotAvailableException, DelegateNotFoundException {
		return delegateProvider.getDelegate("corerest").getDocumentContentById(documentId);
	}
}
