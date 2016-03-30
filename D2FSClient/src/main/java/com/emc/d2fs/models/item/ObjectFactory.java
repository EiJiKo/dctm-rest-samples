
package com.emc.d2fs.models.item;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.item package. 
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

    private final static QName _Items_QNAME = new QName("http://www.emc.com/d2fs/models/item", "items");
    private final static QName _DocItems_QNAME = new QName("http://www.emc.com/d2fs/models/item", "docItems");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.item
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link DocItems }
     * 
     */
    public DocItems createDocItems() {
        return new DocItems();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/item", name = "items")
    public JAXBElement<Item> createItems(Item value) {
        return new JAXBElement<Item>(_Items_QNAME, Item.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocItems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/item", name = "docItems")
    public JAXBElement<DocItems> createDocItems(DocItems value) {
        return new JAXBElement<DocItems>(_DocItems_QNAME, DocItems.class, null, value);
    }

}
