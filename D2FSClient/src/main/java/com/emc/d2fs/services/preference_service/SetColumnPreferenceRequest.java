
package com.emc.d2fs.services.preference_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.context.Context;
import com.emc.d2fs.models.preference.ColumnPreference;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.emc.com/d2fs/models/context}context"/&gt;
 *         &lt;element ref="{http://www.emc.com/d2fs/models/preference}column_preference"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "context",
    "columnPreference"
})
@XmlRootElement(name = "setColumnPreferenceRequest")
public class SetColumnPreferenceRequest {

    @XmlElement(namespace = "http://www.emc.com/d2fs/models/context", required = true)
    protected Context context;
    @XmlElement(name = "column_preference", namespace = "http://www.emc.com/d2fs/models/preference", required = true)
    protected ColumnPreference columnPreference;
    @XmlAttribute(name = "default")
    protected Boolean _default;

    /**
     * Gets the value of the context property.
     * 
     * @return
     *     possible object is
     *     {@link Context }
     *     
     */
    public Context getContext() {
        return context;
    }

    /**
     * Sets the value of the context property.
     * 
     * @param value
     *     allowed object is
     *     {@link Context }
     *     
     */
    public void setContext(Context value) {
        this.context = value;
    }

    /**
     * Gets the value of the columnPreference property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnPreference }
     *     
     */
    public ColumnPreference getColumnPreference() {
        return columnPreference;
    }

    /**
     * Sets the value of the columnPreference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnPreference }
     *     
     */
    public void setColumnPreference(ColumnPreference value) {
        this.columnPreference = value;
    }

    /**
     * Gets the value of the default property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDefault() {
        return _default;
    }

    /**
     * Sets the value of the default property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDefault(Boolean value) {
        this._default = value;
    }

}
