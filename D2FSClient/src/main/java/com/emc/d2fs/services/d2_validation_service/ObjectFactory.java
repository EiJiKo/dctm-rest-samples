
package com.emc.d2fs.services.d2_validation_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.d2_validation_service package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.d2_validation_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckUniquenessRequest }
     * 
     */
    public CheckUniquenessRequest createCheckUniquenessRequest() {
        return new CheckUniquenessRequest();
    }

    /**
     * Create an instance of {@link CheckUniquenessResponse }
     * 
     */
    public CheckUniquenessResponse createCheckUniquenessResponse() {
        return new CheckUniquenessResponse();
    }

    /**
     * Create an instance of {@link CheckAttributesConstraintsRequest }
     * 
     */
    public CheckAttributesConstraintsRequest createCheckAttributesConstraintsRequest() {
        return new CheckAttributesConstraintsRequest();
    }

    /**
     * Create an instance of {@link CheckAttributesConstraintsResponse }
     * 
     */
    public CheckAttributesConstraintsResponse createCheckAttributesConstraintsResponse() {
        return new CheckAttributesConstraintsResponse();
    }

    /**
     * Create an instance of {@link CheckObjectConstraintsRequest }
     * 
     */
    public CheckObjectConstraintsRequest createCheckObjectConstraintsRequest() {
        return new CheckObjectConstraintsRequest();
    }

    /**
     * Create an instance of {@link CheckObjectConstraintsResponse }
     * 
     */
    public CheckObjectConstraintsResponse createCheckObjectConstraintsResponse() {
        return new CheckObjectConstraintsResponse();
    }

}
