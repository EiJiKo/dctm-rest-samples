
package com.emc.d2fs.models.x3_skin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x3_graphic_css_rule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="x3_graphic_css_rule"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="selector" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="declaration" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "x3_graphic_css_rule")
public class X3GraphicCssRule {

    @XmlAttribute(name = "selector", required = true)
    protected String selector;
    @XmlAttribute(name = "declaration", required = true)
    protected String declaration;

    /**
     * Gets the value of the selector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelector() {
        return selector;
    }

    /**
     * Sets the value of the selector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelector(String value) {
        this.selector = value;
    }

    /**
     * Gets the value of the declaration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeclaration() {
        return declaration;
    }

    /**
     * Sets the value of the declaration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeclaration(String value) {
        this.declaration = value;
    }

}
