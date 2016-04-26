package com.emc.documentum.exceptionHandling;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.emc.documentum.exceptions.CreationException;
import com.emc.documentum.exceptions.DocumentCreationException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.ObjectNotFoundException;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;

//@ControllerAdvice
public class CommonExceptionHandler {
	@ExceptionHandler(DocumentumException.class)
	//TODO  @ResponseStatus(HttpStatus.NOT_FOUND)
	public DocumentumException docuemntumException(DocumentumException e)
	{
		Logger log = Logger.getAnonymousLogger();
		log.severe("documentum exception");
		return e;
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Document Not Found")
	public ObjectNotFoundException documentNotFoundException(ObjectNotFoundException e,HttpServletRequest res)
	{
		Logger log = Logger.getAnonymousLogger();
		log.severe("object not found exception");
		return e;
	}
	
	
	@ExceptionHandler(FolderCreationException.class)
	//TODO  @ResponseStatus(HttpStatus.NOT_FOUND)
	public FolderCreationException folderCreationException(FolderCreationException e)
	{
		return e;       
	}
	
	@ExceptionHandler(DocumentCreationException.class)
	//TODO  @ResponseStatus(HttpStatus.NOT_FOUND)
	public DocumentCreationException documentCreationException(DocumentCreationException e)
	{
		return e;      
	}
	
	
	@ExceptionHandler(CreationException.class)
	//TODO  @ResponseStatus(HttpStatus.NOT_FOUND)
	public CreationException creationException(CreationException e)
	{
		return e;
	}
	
	@ExceptionHandler(RepositoryNotAvailableException.class)
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	public RepositoryNotAvailableException repositroyNotAvailableException(RepositoryNotAvailableException e)
	{
		System.out.println("Repository Exception");
		return e;
	}
	
	@ExceptionHandler(Exception.class)
	//TODO  @ResponseStatus(HttpStatus.NOT_FOUND)
	public Exception generalException(Exception e)
	{
		return e;
	}
	
	
	
	
	
}
