
package com.emc.d2fs.models.x3_space;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.x3_space package. 
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

    private final static QName _X3Space_QNAME = new QName("http://www.emc.com/d2fs/models/x3_space", "x3_space");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.x3_space
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link X3Space }
     * 
     */
    public X3Space createX3Space() {
        return new X3Space();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link X3Space }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/x3_space", name = "x3_space")
    public JAXBElement<X3Space> createX3Space(X3Space value) {
        return new JAXBElement<X3Space>(_X3Space_QNAME, X3Space.class, null, value);
    }

}
