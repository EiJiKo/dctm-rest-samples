
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
 *       &lt;attribute name="locationView" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="locationCheckout" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "getDownloadLocationsResponse")
public class GetDownloadLocationsResponse {

    @XmlAttribute(name = "locationView")
    protected String locationView;
    @XmlAttribute(name = "locationCheckout")
    protected String locationCheckout;

    /**
     * Gets the value of the locationView property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationView() {
        return locationView;
    }

    /**
     * Sets the value of the locationView property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationView(String value) {
        this.locationView = value;
    }

    /**
     * Gets the value of the locationCheckout property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationCheckout() {
        return locationCheckout;
    }

    /**
     * Sets the value of the locationCheckout property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationCheckout(String value) {
        this.locationCheckout = value;
    }

}
