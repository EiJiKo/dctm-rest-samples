
package com.emc.d2fs.services.property_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.property_service package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.property_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DumpRequest }
     * 
     */
    public DumpRequest createDumpRequest() {
        return new DumpRequest();
    }

    /**
     * Create an instance of {@link DumpResponse }
     * 
     */
    public DumpResponse createDumpResponse() {
        return new DumpResponse();
    }

    /**
     * Create an instance of {@link GetPropertiesRequest }
     * 
     */
    public GetPropertiesRequest createGetPropertiesRequest() {
        return new GetPropertiesRequest();
    }

    /**
     * Create an instance of {@link GetPropertiesResponse }
     * 
     */
    public GetPropertiesResponse createGetPropertiesResponse() {
        return new GetPropertiesResponse();
    }

    /**
     * Create an instance of {@link SavePropertiesRequest }
     * 
     */
    public SavePropertiesRequest createSavePropertiesRequest() {
        return new SavePropertiesRequest();
    }

    /**
     * Create an instance of {@link SavePropertiesResponse }
     * 
     */
    public SavePropertiesResponse createSavePropertiesResponse() {
        return new SavePropertiesResponse();
    }

}
