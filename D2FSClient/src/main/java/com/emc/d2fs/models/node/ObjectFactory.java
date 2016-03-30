
package com.emc.d2fs.models.node;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.node package. 
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

    private final static QName _Nodes_QNAME = new QName("http://www.emc.com/d2fs/models/node", "nodes");
    private final static QName _AttributeOptions_QNAME = new QName("http://www.emc.com/d2fs/models/node", "attributeOptions");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.node
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Node }
     * 
     */
    public Node createNode() {
        return new Node();
    }

    /**
     * Create an instance of {@link AttributeOptions }
     * 
     */
    public AttributeOptions createAttributeOptions() {
        return new AttributeOptions();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Node }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/node", name = "nodes")
    public JAXBElement<Node> createNodes(Node value) {
        return new JAXBElement<Node>(_Nodes_QNAME, Node.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttributeOptions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/node", name = "attributeOptions")
    public JAXBElement<AttributeOptions> createAttributeOptions(AttributeOptions value) {
        return new JAXBElement<AttributeOptions>(_AttributeOptions_QNAME, AttributeOptions.class, null, value);
    }

}
