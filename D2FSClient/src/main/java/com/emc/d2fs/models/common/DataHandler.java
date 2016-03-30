
package com.emc.d2fs.models.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataHandler complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataHandler"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="data" use="required" type="{http://www.w3.org/2001/XMLSchema}base64Binary" /&gt;
 *       &lt;attribute name="dataString" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="mime" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataHandler")
public class DataHandler {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "data", required = true)
    protected byte[] data;
    @XmlAttribute(name = "dataString")
    protected String dataString;
    @XmlAttribute(name = "mime", required = true)
    protected String mime;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setData(byte[] value) {
        this.data = value;
    }

    /**
     * Gets the value of the dataString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataString() {
        return dataString;
    }

    /**
     * Sets the value of the dataString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataString(String value) {
        this.dataString = value;
    }

    /**
     * Gets the value of the mime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMime() {
        return mime;
    }

    /**
     * Sets the value of the mime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMime(String value) {
        this.mime = value;
    }

}
