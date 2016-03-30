
package com.emc.d2fs.services.d2_audit_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.d2_audit_service package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.d2_audit_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsPropertyAuditedRequest }
     * 
     */
    public IsPropertyAuditedRequest createIsPropertyAuditedRequest() {
        return new IsPropertyAuditedRequest();
    }

    /**
     * Create an instance of {@link IsPropertyAuditedResponse }
     * 
     */
    public IsPropertyAuditedResponse createIsPropertyAuditedResponse() {
        return new IsPropertyAuditedResponse();
    }

    /**
     * Create an instance of {@link IsEventAuditedRequest }
     * 
     */
    public IsEventAuditedRequest createIsEventAuditedRequest() {
        return new IsEventAuditedRequest();
    }

    /**
     * Create an instance of {@link IsEventAuditedResponse }
     * 
     */
    public IsEventAuditedResponse createIsEventAuditedResponse() {
        return new IsEventAuditedResponse();
    }

    /**
     * Create an instance of {@link ApplyAuditMessagesRequest }
     * 
     */
    public ApplyAuditMessagesRequest createApplyAuditMessagesRequest() {
        return new ApplyAuditMessagesRequest();
    }

    /**
     * Create an instance of {@link ApplyAuditMessagesResponse }
     * 
     */
    public ApplyAuditMessagesResponse createApplyAuditMessagesResponse() {
        return new ApplyAuditMessagesResponse();
    }

}
