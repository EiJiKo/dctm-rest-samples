
package com.emc.d2fs.services.thumbnails_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.thumbnails_service package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.thumbnails_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetThumbnailUrlRequest }
     * 
     */
    public GetThumbnailUrlRequest createGetThumbnailUrlRequest() {
        return new GetThumbnailUrlRequest();
    }

    /**
     * Create an instance of {@link GetThumbnailUrlResponse }
     * 
     */
    public GetThumbnailUrlResponse createGetThumbnailUrlResponse() {
        return new GetThumbnailUrlResponse();
    }

    /**
     * Create an instance of {@link GetThumbnailUrlsRequest }
     * 
     */
    public GetThumbnailUrlsRequest createGetThumbnailUrlsRequest() {
        return new GetThumbnailUrlsRequest();
    }

    /**
     * Create an instance of {@link GetThumbnailUrlsResponse }
     * 
     */
    public GetThumbnailUrlsResponse createGetThumbnailUrlsResponse() {
        return new GetThumbnailUrlsResponse();
    }

    /**
     * Create an instance of {@link IsProtectedInControlledViewRequest }
     * 
     */
    public IsProtectedInControlledViewRequest createIsProtectedInControlledViewRequest() {
        return new IsProtectedInControlledViewRequest();
    }

    /**
     * Create an instance of {@link IsProtectedInControlledViewResponse }
     * 
     */
    public IsProtectedInControlledViewResponse createIsProtectedInControlledViewResponse() {
        return new IsProtectedInControlledViewResponse();
    }

}
