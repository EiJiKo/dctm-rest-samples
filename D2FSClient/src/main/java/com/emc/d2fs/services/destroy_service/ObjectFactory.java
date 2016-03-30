
package com.emc.d2fs.services.destroy_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.destroy_service package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.destroy_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DestroyRequest }
     * 
     */
    public DestroyRequest createDestroyRequest() {
        return new DestroyRequest();
    }

    /**
     * Create an instance of {@link DestroyResponse }
     * 
     */
    public DestroyResponse createDestroyResponse() {
        return new DestroyResponse();
    }

    /**
     * Create an instance of {@link DestroyAllRequest }
     * 
     */
    public DestroyAllRequest createDestroyAllRequest() {
        return new DestroyAllRequest();
    }

    /**
     * Create an instance of {@link DestroyAllResponse }
     * 
     */
    public DestroyAllResponse createDestroyAllResponse() {
        return new DestroyAllResponse();
    }

    /**
     * Create an instance of {@link IsDialogRequiredRequest }
     * 
     */
    public IsDialogRequiredRequest createIsDialogRequiredRequest() {
        return new IsDialogRequiredRequest();
    }

    /**
     * Create an instance of {@link IsDialogRequiredResponse }
     * 
     */
    public IsDialogRequiredResponse createIsDialogRequiredResponse() {
        return new IsDialogRequiredResponse();
    }

}
