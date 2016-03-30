
package com.emc.d2fs.models.menu;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.menu package. 
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

    private final static QName _Menus_QNAME = new QName("http://www.emc.com/d2fs/models/menu", "menus");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.menu
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Menu }
     * 
     */
    public Menu createMenu() {
        return new Menu();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Menu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/menu", name = "menus")
    public JAXBElement<Menu> createMenus(Menu value) {
        return new JAXBElement<Menu>(_Menus_QNAME, Menu.class, null, value);
    }

}
