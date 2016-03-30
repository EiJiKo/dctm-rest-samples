
package com.emc.d2fs.models.dump;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dump complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dump"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="config" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="dump" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dump")
public class Dump {

    @XmlAttribute(name = "config")
    protected String config;
    @XmlAttribute(name = "dump")
    protected String dump;

    /**
     * Gets the value of the config property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfig() {
        return config;
    }

    /**
     * Sets the value of the config property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfig(String value) {
        this.config = value;
    }

    /**
     * Gets the value of the dump property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDump() {
        return dump;
    }

    /**
     * Sets the value of the dump property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDump(String value) {
        this.dump = value;
    }

}
