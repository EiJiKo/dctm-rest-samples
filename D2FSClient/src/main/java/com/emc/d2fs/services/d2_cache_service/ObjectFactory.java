
package com.emc.d2fs.services.d2_cache_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.d2_cache_service package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.d2_cache_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RefreshDictionaryCacheRequest }
     * 
     */
    public RefreshDictionaryCacheRequest createRefreshDictionaryCacheRequest() {
        return new RefreshDictionaryCacheRequest();
    }

    /**
     * Create an instance of {@link RefreshDictionaryCacheResponse }
     * 
     */
    public RefreshDictionaryCacheResponse createRefreshDictionaryCacheResponse() {
        return new RefreshDictionaryCacheResponse();
    }

    /**
     * Create an instance of {@link RefreshTaxonomyCacheRequest }
     * 
     */
    public RefreshTaxonomyCacheRequest createRefreshTaxonomyCacheRequest() {
        return new RefreshTaxonomyCacheRequest();
    }

    /**
     * Create an instance of {@link RefreshTaxonomyCacheResponse }
     * 
     */
    public RefreshTaxonomyCacheResponse createRefreshTaxonomyCacheResponse() {
        return new RefreshTaxonomyCacheResponse();
    }

}
