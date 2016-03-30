
package com.emc.d2fs.models.template;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for template complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="template"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://www.emc.com/d2fs/models/common}id use="required""/&gt;
 *       &lt;attribute name="label" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="previewUrl" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="previewMime" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "template")
public class Template {

    @XmlAttribute(name = "id", namespace = "http://www.emc.com/d2fs/models/common", required = true)
    protected String id;
    @XmlAttribute(name = "label", required = true)
    protected String label;
    @XmlAttribute(name = "description")
    protected String description;
    @XmlAttribute(name = "previewUrl")
    protected String previewUrl;
    @XmlAttribute(name = "previewMime", required = true)
    protected String previewMime;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the previewUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     * Sets the value of the previewUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviewUrl(String value) {
        this.previewUrl = value;
    }

    /**
     * Gets the value of the previewMime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviewMime() {
        return previewMime;
    }

    /**
     * Sets the value of the previewMime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviewMime(String value) {
        this.previewMime = value;
    }

}
