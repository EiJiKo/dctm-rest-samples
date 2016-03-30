
package com.emc.d2fs.models.rendering_options;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rendering_option complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rendering_option"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="key" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="fontColor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="iconClass" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="iconOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rendering_option")
public class RenderingOption {

    @XmlAttribute(name = "key", required = true)
    protected String key;
    @XmlAttribute(name = "fontColor")
    protected String fontColor;
    @XmlAttribute(name = "iconClass")
    protected String iconClass;
    @XmlAttribute(name = "iconOnly")
    protected Boolean iconOnly;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the fontColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontColor() {
        return fontColor;
    }

    /**
     * Sets the value of the fontColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontColor(String value) {
        this.fontColor = value;
    }

    /**
     * Gets the value of the iconClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIconClass() {
        return iconClass;
    }

    /**
     * Sets the value of the iconClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIconClass(String value) {
        this.iconClass = value;
    }

    /**
     * Gets the value of the iconOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIconOnly() {
        return iconOnly;
    }

    /**
     * Sets the value of the iconOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIconOnly(Boolean value) {
        this.iconOnly = value;
    }

}
