
package com.emc.d2fs.models.destroyresult;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.destroyresult package. 
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

    private final static QName _Destroyresult_QNAME = new QName("http://www.emc.com/d2fs/models/destroyresult", "destroyresult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.destroyresult
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Destroyresult }
     * 
     */
    public Destroyresult createDestroyresult() {
        return new Destroyresult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Destroyresult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/destroyresult", name = "destroyresult")
    public JAXBElement<Destroyresult> createDestroyresult(Destroyresult value) {
        return new JAXBElement<Destroyresult>(_Destroyresult_QNAME, Destroyresult.class, null, value);
    }

}
