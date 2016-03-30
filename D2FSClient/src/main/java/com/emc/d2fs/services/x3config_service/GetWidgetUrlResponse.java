
package com.emc.d2fs.services.x3config_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="resolvedUrl" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "getWidgetUrlResponse")
public class GetWidgetUrlResponse {

    @XmlAttribute(name = "resolvedUrl")
    protected String resolvedUrl;

    /**
     * Gets the value of the resolvedUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResolvedUrl() {
        return resolvedUrl;
    }

    /**
     * Sets the value of the resolvedUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResolvedUrl(String value) {
        this.resolvedUrl = value;
    }

}
