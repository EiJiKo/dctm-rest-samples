
package com.emc.d2fs.models.x3_widget;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.x3_widget package. 
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

    private final static QName _X3Widgets_QNAME = new QName("http://www.emc.com/d2fs/models/x3_widget", "x3_widgets");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.x3_widget
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link X3Widget }
     * 
     */
    public X3Widget createX3Widget() {
        return new X3Widget();
    }

    /**
     * Create an instance of {@link WidgetParameter }
     * 
     */
    public WidgetParameter createWidgetParameter() {
        return new WidgetParameter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link X3Widget }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/x3_widget", name = "x3_widgets")
    public JAXBElement<X3Widget> createX3Widgets(X3Widget value) {
        return new JAXBElement<X3Widget>(_X3Widgets_QNAME, X3Widget.class, null, value);
    }

}
