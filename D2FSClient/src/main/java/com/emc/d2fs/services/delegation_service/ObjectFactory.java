
package com.emc.d2fs.services.delegation_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.delegation_service package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.delegation_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ApplyDelegationRequest }
     * 
     */
    public ApplyDelegationRequest createApplyDelegationRequest() {
        return new ApplyDelegationRequest();
    }

    /**
     * Create an instance of {@link ApplyDelegationResponse }
     * 
     */
    public ApplyDelegationResponse createApplyDelegationResponse() {
        return new ApplyDelegationResponse();
    }

    /**
     * Create an instance of {@link UndoDelegationRequest }
     * 
     */
    public UndoDelegationRequest createUndoDelegationRequest() {
        return new UndoDelegationRequest();
    }

    /**
     * Create an instance of {@link UndoDelegationResponse }
     * 
     */
    public UndoDelegationResponse createUndoDelegationResponse() {
        return new UndoDelegationResponse();
    }

    /**
     * Create an instance of {@link DeleteDelegationRequest }
     * 
     */
    public DeleteDelegationRequest createDeleteDelegationRequest() {
        return new DeleteDelegationRequest();
    }

    /**
     * Create an instance of {@link DeleteDelegationResponse }
     * 
     */
    public DeleteDelegationResponse createDeleteDelegationResponse() {
        return new DeleteDelegationResponse();
    }

}
