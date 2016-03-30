
package com.emc.d2fs.models.dialog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dialog complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dialog"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="xmlData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" /&gt;
 *       &lt;attribute name="xmlContent" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="jsonContent" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dialog")
public class Dialog {

    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "value")
    protected String value;
    @XmlAttribute(name = "xmlData")
    protected byte[] xmlData;
    @XmlAttribute(name = "xmlContent")
    protected String xmlContent;
    @XmlAttribute(name = "jsonContent")
    protected String jsonContent;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the xmlData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getXmlData() {
        return xmlData;
    }

    /**
     * Sets the value of the xmlData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setXmlData(byte[] value) {
        this.xmlData = value;
    }

    /**
     * Gets the value of the xmlContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlContent() {
        return xmlContent;
    }

    /**
     * Sets the value of the xmlContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlContent(String value) {
        this.xmlContent = value;
    }

    /**
     * Gets the value of the jsonContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJsonContent() {
        return jsonContent;
    }

    /**
     * Sets the value of the jsonContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJsonContent(String value) {
        this.jsonContent = value;
    }

}
