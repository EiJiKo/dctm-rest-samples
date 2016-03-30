
package com.emc.d2fs.services.x3config_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence&gt;
 *         &lt;element name="spaceXmlContent" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "spaceXmlContent"
})
@XmlRootElement(name = "fetchSpaceXmlContentResponse")
public class FetchSpaceXmlContentResponse {

    @XmlElement(required = true)
    protected String spaceXmlContent;

    /**
     * Gets the value of the spaceXmlContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaceXmlContent() {
        return spaceXmlContent;
    }

    /**
     * Sets the value of the spaceXmlContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaceXmlContent(String value) {
        this.spaceXmlContent = value;
    }

}
