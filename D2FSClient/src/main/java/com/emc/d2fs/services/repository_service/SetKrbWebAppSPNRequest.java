
package com.emc.d2fs.services.repository_service;

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
 *       &lt;attribute name="SPN" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "setKrbWebAppSPNRequest")
public class SetKrbWebAppSPNRequest {

    @XmlAttribute(name = "SPN", required = true)
    protected String spn;

    /**
     * Gets the value of the spn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPN() {
        return spn;
    }

    /**
     * Sets the value of the spn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPN(String value) {
        this.spn = value;
    }

}
