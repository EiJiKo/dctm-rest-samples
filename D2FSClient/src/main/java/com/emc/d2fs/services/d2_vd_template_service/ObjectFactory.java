
package com.emc.d2fs.services.d2_vd_template_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.d2_vd_template_service package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.d2_vd_template_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetVdTemplateRequest }
     * 
     */
    public SetVdTemplateRequest createSetVdTemplateRequest() {
        return new SetVdTemplateRequest();
    }

    /**
     * Create an instance of {@link SetVdTemplateResponse }
     * 
     */
    public SetVdTemplateResponse createSetVdTemplateResponse() {
        return new SetVdTemplateResponse();
    }

    /**
     * Create an instance of {@link GetVdTemplatesRequest }
     * 
     */
    public GetVdTemplatesRequest createGetVdTemplatesRequest() {
        return new GetVdTemplatesRequest();
    }

    /**
     * Create an instance of {@link GetVdTemplatesResponse }
     * 
     */
    public GetVdTemplatesResponse createGetVdTemplatesResponse() {
        return new GetVdTemplatesResponse();
    }

}
