
package com.emc.d2fs.services.move_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.move_service package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.move_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MoveRequest }
     * 
     */
    public MoveRequest createMoveRequest() {
        return new MoveRequest();
    }

    /**
     * Create an instance of {@link MoveResponse }
     * 
     */
    public MoveResponse createMoveResponse() {
        return new MoveResponse();
    }

    /**
     * Create an instance of {@link CopyRequest }
     * 
     */
    public CopyRequest createCopyRequest() {
        return new CopyRequest();
    }

    /**
     * Create an instance of {@link CopyResponse }
     * 
     */
    public CopyResponse createCopyResponse() {
        return new CopyResponse();
    }

    /**
     * Create an instance of {@link LinkRequest }
     * 
     */
    public LinkRequest createLinkRequest() {
        return new LinkRequest();
    }

    /**
     * Create an instance of {@link LinkResponse }
     * 
     */
    public LinkResponse createLinkResponse() {
        return new LinkResponse();
    }

    /**
     * Create an instance of {@link PasteRequest }
     * 
     */
    public PasteRequest createPasteRequest() {
        return new PasteRequest();
    }

    /**
     * Create an instance of {@link PasteResponse }
     * 
     */
    public PasteResponse createPasteResponse() {
        return new PasteResponse();
    }

    /**
     * Create an instance of {@link PasteFolderStructureRequest }
     * 
     */
    public PasteFolderStructureRequest createPasteFolderStructureRequest() {
        return new PasteFolderStructureRequest();
    }

    /**
     * Create an instance of {@link PasteFolderStructureResponse }
     * 
     */
    public PasteFolderStructureResponse createPasteFolderStructureResponse() {
        return new PasteFolderStructureResponse();
    }

}
