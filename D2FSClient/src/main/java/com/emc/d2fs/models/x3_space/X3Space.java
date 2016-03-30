
package com.emc.d2fs.models.x3_space;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x3_space complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="x3_space"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="spaceConfigName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="spaceLabel" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="spaceDescription" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="spaceXml" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="spacePreviewData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" /&gt;
 *       &lt;attribute name="spacePreviewDataString" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="spacePreviewMime" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="spaceIconData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" /&gt;
 *       &lt;attribute name="spaceIconDataString" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="spaceIconMime" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="locked" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="skinConfigName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "x3_space")
public class X3Space {

    @XmlAttribute(name = "spaceConfigName", required = true)
    protected String spaceConfigName;
    @XmlAttribute(name = "spaceLabel", required = true)
    protected String spaceLabel;
    @XmlAttribute(name = "spaceDescription", required = true)
    protected String spaceDescription;
    @XmlAttribute(name = "spaceXml")
    protected String spaceXml;
    @XmlAttribute(name = "spacePreviewData")
    protected byte[] spacePreviewData;
    @XmlAttribute(name = "spacePreviewDataString")
    protected String spacePreviewDataString;
    @XmlAttribute(name = "spacePreviewMime")
    protected String spacePreviewMime;
    @XmlAttribute(name = "spaceIconData")
    protected byte[] spaceIconData;
    @XmlAttribute(name = "spaceIconDataString")
    protected String spaceIconDataString;
    @XmlAttribute(name = "spaceIconMime")
    protected String spaceIconMime;
    @XmlAttribute(name = "locked")
    protected Boolean locked;
    @XmlAttribute(name = "skinConfigName")
    protected String skinConfigName;

    /**
     * Gets the value of the spaceConfigName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaceConfigName() {
        return spaceConfigName;
    }

    /**
     * Sets the value of the spaceConfigName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaceConfigName(String value) {
        this.spaceConfigName = value;
    }

    /**
     * Gets the value of the spaceLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaceLabel() {
        return spaceLabel;
    }

    /**
     * Sets the value of the spaceLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaceLabel(String value) {
        this.spaceLabel = value;
    }

    /**
     * Gets the value of the spaceDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaceDescription() {
        return spaceDescription;
    }

    /**
     * Sets the value of the spaceDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaceDescription(String value) {
        this.spaceDescription = value;
    }

    /**
     * Gets the value of the spaceXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaceXml() {
        return spaceXml;
    }

    /**
     * Sets the value of the spaceXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaceXml(String value) {
        this.spaceXml = value;
    }

    /**
     * Gets the value of the spacePreviewData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSpacePreviewData() {
        return spacePreviewData;
    }

    /**
     * Sets the value of the spacePreviewData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSpacePreviewData(byte[] value) {
        this.spacePreviewData = value;
    }

    /**
     * Gets the value of the spacePreviewDataString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpacePreviewDataString() {
        return spacePreviewDataString;
    }

    /**
     * Sets the value of the spacePreviewDataString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpacePreviewDataString(String value) {
        this.spacePreviewDataString = value;
    }

    /**
     * Gets the value of the spacePreviewMime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpacePreviewMime() {
        return spacePreviewMime;
    }

    /**
     * Sets the value of the spacePreviewMime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpacePreviewMime(String value) {
        this.spacePreviewMime = value;
    }

    /**
     * Gets the value of the spaceIconData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSpaceIconData() {
        return spaceIconData;
    }

    /**
     * Sets the value of the spaceIconData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSpaceIconData(byte[] value) {
        this.spaceIconData = value;
    }

    /**
     * Gets the value of the spaceIconDataString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaceIconDataString() {
        return spaceIconDataString;
    }

    /**
     * Sets the value of the spaceIconDataString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaceIconDataString(String value) {
        this.spaceIconDataString = value;
    }

    /**
     * Gets the value of the spaceIconMime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaceIconMime() {
        return spaceIconMime;
    }

    /**
     * Sets the value of the spaceIconMime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaceIconMime(String value) {
        this.spaceIconMime = value;
    }

    /**
     * Gets the value of the locked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLocked() {
        return locked;
    }

    /**
     * Sets the value of the locked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLocked(Boolean value) {
        this.locked = value;
    }

    /**
     * Gets the value of the skinConfigName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinConfigName() {
        return skinConfigName;
    }

    /**
     * Sets the value of the skinConfigName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinConfigName(String value) {
        this.skinConfigName = value;
    }

}
