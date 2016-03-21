package com.emc.documentum.exceptionHandling;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.emc.documentum.exceptions.CabinetNotFoundException;
import com.emc.documentum.exceptions.CreationException;
import com.emc.documentum.exceptions.DocumentCreationException;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.FolderNotFoundException;

@ControllerAdvice
public class CommonExceptionHandler {
	@ExceptionHandler(DocumentumException.class)
	//TODO  @ResponseStatus(HttpStatus.NOT_FOUND)
	public void docuemntumException(DocumentumException e)
	{
		Logger log = Logger.getAnonymousLogger();
		log.severe("documentum exception");
	}
	
	@ExceptionHandler(DocumentNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Document Not Found")
	public void documentNotFoundException(DocumentNotFoundException e,HttpServletRequest res)
	{
		Logger log = Logger.getAnonymousLogger();
		log.severe("document not found exception");
		
	}
	
	@ExceptionHandler(CabinetNotFoundException.class)
	//TODO  @ResponseStatus(HttpStatus.NOT_FOUND)
	public void cabinetNotFoundException(CabinetNotFoundException e)
	{
		           
	}
	
	@ExceptionHandler(FolderNotFoundException.class)
	//TODO  @ResponseStatus(HttpStatus.NOT_FOUND)
	public void folderNotFoundException(FolderNotFoundException e)
	{
		           
	}
	
	@ExceptionHandler(FolderCreationException.class)
	//TODO  @ResponseStatus(HttpStatus.NOT_FOUND)
	public void folderCreationException(FolderCreationException e)
	{
		           
	}
	
	@ExceptionHandler(DocumentCreationException.class)
	//TODO  @ResponseStatus(HttpStatus.NOT_FOUND)
	public void documentCreationException(DocumentCreationException e)
	{
		           
	}
	
	
	@ExceptionHandler(CreationException.class)
	//TODO  @ResponseStatus(HttpStatus.NOT_FOUND)
	public void creationException(CreationException e)
	{
		
	}
	
	@ExceptionHandler(Exception.class)
	//TODO  @ResponseStatus(HttpStatus.NOT_FOUND)
	public void generalException(Exception e)
	{
		
	}
	
	
	
	
	
}
