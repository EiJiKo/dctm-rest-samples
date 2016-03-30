
package com.emc.d2fs.models.rendering_options;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.rendering_options package. 
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

    private final static QName _RenderingOptions_QNAME = new QName("http://www.emc.com/d2fs/models/rendering_options", "rendering_options");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.rendering_options
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RenderingOption }
     * 
     */
    public RenderingOption createRenderingOption() {
        return new RenderingOption();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RenderingOption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/rendering_options", name = "rendering_options")
    public JAXBElement<RenderingOption> createRenderingOptions(RenderingOption value) {
        return new JAXBElement<RenderingOption>(_RenderingOptions_QNAME, RenderingOption.class, null, value);
    }

}
