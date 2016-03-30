
package com.emc.d2fs.services.favorites_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.favorites_service package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.favorites_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddToFavoritesRequest }
     * 
     */
    public AddToFavoritesRequest createAddToFavoritesRequest() {
        return new AddToFavoritesRequest();
    }

    /**
     * Create an instance of {@link AddToFavoritesResponse }
     * 
     */
    public AddToFavoritesResponse createAddToFavoritesResponse() {
        return new AddToFavoritesResponse();
    }

    /**
     * Create an instance of {@link RemoveFromFavoritesRequest }
     * 
     */
    public RemoveFromFavoritesRequest createRemoveFromFavoritesRequest() {
        return new RemoveFromFavoritesRequest();
    }

    /**
     * Create an instance of {@link RemoveFromFavoritesResponse }
     * 
     */
    public RemoveFromFavoritesResponse createRemoveFromFavoritesResponse() {
        return new RemoveFromFavoritesResponse();
    }

}
