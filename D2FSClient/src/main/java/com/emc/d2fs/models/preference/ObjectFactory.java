
package com.emc.d2fs.models.preference;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.preference package. 
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

    private final static QName _Preference_QNAME = new QName("http://www.emc.com/d2fs/models/preference", "preference");
    private final static QName _Columns_QNAME = new QName("http://www.emc.com/d2fs/models/preference", "columns");
    private final static QName _ColumnPreference_QNAME = new QName("http://www.emc.com/d2fs/models/preference", "column_preference");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.preference
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Preference }
     * 
     */
    public Preference createPreference() {
        return new Preference();
    }

    /**
     * Create an instance of {@link Column }
     * 
     */
    public Column createColumn() {
        return new Column();
    }

    /**
     * Create an instance of {@link ColumnPreference }
     * 
     */
    public ColumnPreference createColumnPreference() {
        return new ColumnPreference();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Preference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/preference", name = "preference")
    public JAXBElement<Preference> createPreference(Preference value) {
        return new JAXBElement<Preference>(_Preference_QNAME, Preference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Column }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/preference", name = "columns")
    public JAXBElement<Column> createColumns(Column value) {
        return new JAXBElement<Column>(_Columns_QNAME, Column.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColumnPreference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/preference", name = "column_preference")
    public JAXBElement<ColumnPreference> createColumnPreference(ColumnPreference value) {
        return new JAXBElement<ColumnPreference>(_ColumnPreference_QNAME, ColumnPreference.class, null, value);
    }

}
