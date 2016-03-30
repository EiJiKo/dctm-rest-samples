
package com.emc.d2fs.services.vdconvert_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.vdconvert_service package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.vdconvert_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConvertToVDRequest }
     * 
     */
    public ConvertToVDRequest createConvertToVDRequest() {
        return new ConvertToVDRequest();
    }

    /**
     * Create an instance of {@link ConvertToVDResponse }
     * 
     */
    public ConvertToVDResponse createConvertToVDResponse() {
        return new ConvertToVDResponse();
    }

    /**
     * Create an instance of {@link ConvertToSimpleDocRequest }
     * 
     */
    public ConvertToSimpleDocRequest createConvertToSimpleDocRequest() {
        return new ConvertToSimpleDocRequest();
    }

    /**
     * Create an instance of {@link ConvertToSimpleDocResponse }
     * 
     */
    public ConvertToSimpleDocResponse createConvertToSimpleDocResponse() {
        return new ConvertToSimpleDocResponse();
    }

    /**
     * Create an instance of {@link ConvertFolderToVDRequest }
     * 
     */
    public ConvertFolderToVDRequest createConvertFolderToVDRequest() {
        return new ConvertFolderToVDRequest();
    }

    /**
     * Create an instance of {@link ConvertFolderToVDResponse }
     * 
     */
    public ConvertFolderToVDResponse createConvertFolderToVDResponse() {
        return new ConvertFolderToVDResponse();
    }

}
