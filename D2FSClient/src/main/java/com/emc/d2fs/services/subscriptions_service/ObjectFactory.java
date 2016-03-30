
package com.emc.d2fs.services.subscriptions_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.subscriptions_service package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.subscriptions_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SubscribeRequest }
     * 
     */
    public SubscribeRequest createSubscribeRequest() {
        return new SubscribeRequest();
    }

    /**
     * Create an instance of {@link SubscribeResponse }
     * 
     */
    public SubscribeResponse createSubscribeResponse() {
        return new SubscribeResponse();
    }

    /**
     * Create an instance of {@link UnsubscribeAllRequest }
     * 
     */
    public UnsubscribeAllRequest createUnsubscribeAllRequest() {
        return new UnsubscribeAllRequest();
    }

    /**
     * Create an instance of {@link UnsubscribeAllResponse }
     * 
     */
    public UnsubscribeAllResponse createUnsubscribeAllResponse() {
        return new UnsubscribeAllResponse();
    }

}
