
package com.emc.d2fs.models.x3_skin;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.x3_skin package. 
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

    private final static QName _X3Skin_QNAME = new QName("http://www.emc.com/d2fs/models/x3_skin", "x3_skin");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.x3_skin
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link X3Skin }
     * 
     */
    public X3Skin createX3Skin() {
        return new X3Skin();
    }

    /**
     * Create an instance of {@link X3GraphicCssRule }
     * 
     */
    public X3GraphicCssRule createX3GraphicCssRule() {
        return new X3GraphicCssRule();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link X3Skin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/x3_skin", name = "x3_skin")
    public JAXBElement<X3Skin> createX3Skin(X3Skin value) {
        return new JAXBElement<X3Skin>(_X3Skin_QNAME, X3Skin.class, null, value);
    }

}
