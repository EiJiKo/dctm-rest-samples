
package com.emc.d2fs.services.d2_archive_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.d2_archive_service package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.d2_archive_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateVersionRequest }
     * 
     */
    public CreateVersionRequest createCreateVersionRequest() {
        return new CreateVersionRequest();
    }

    /**
     * Create an instance of {@link CreateVersionResponse }
     * 
     */
    public CreateVersionResponse createCreateVersionResponse() {
        return new CreateVersionResponse();
    }

    /**
     * Create an instance of {@link ListArchivesRequest }
     * 
     */
    public ListArchivesRequest createListArchivesRequest() {
        return new ListArchivesRequest();
    }

    /**
     * Create an instance of {@link ListArchivesResponse }
     * 
     */
    public ListArchivesResponse createListArchivesResponse() {
        return new ListArchivesResponse();
    }

    /**
     * Create an instance of {@link TestExistsRequest }
     * 
     */
    public TestExistsRequest createTestExistsRequest() {
        return new TestExistsRequest();
    }

    /**
     * Create an instance of {@link TestExistsResponse }
     * 
     */
    public TestExistsResponse createTestExistsResponse() {
        return new TestExistsResponse();
    }

}
