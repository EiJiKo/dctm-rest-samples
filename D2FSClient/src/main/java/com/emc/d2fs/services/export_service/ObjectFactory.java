
package com.emc.d2fs.services.export_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.export_service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.export_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetExportUrlRequest }
     * 
     */
    public GetExportUrlRequest createGetExportUrlRequest() {
        return new GetExportUrlRequest();
    }

    /**
     * Create an instance of {@link GetExportUrlResponse }
     * 
     */
    public GetExportUrlResponse createGetExportUrlResponse() {
        return new GetExportUrlResponse();
    }

    /**
     * Create an instance of {@link GetExportFolderRequest }
     * 
     */
    public GetExportFolderRequest createGetExportFolderRequest() {
        return new GetExportFolderRequest();
    }

    /**
     * Create an instance of {@link GetExportFolderResponse }
     * 
     */
    public GetExportFolderResponse createGetExportFolderResponse() {
        return new GetExportFolderResponse();
    }

    /**
     * Create an instance of {@link GetExportTicketRequest }
     * 
     */
    public GetExportTicketRequest createGetExportTicketRequest() {
        return new GetExportTicketRequest();
    }

}
