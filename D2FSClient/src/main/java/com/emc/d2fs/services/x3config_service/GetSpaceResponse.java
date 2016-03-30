
package com.emc.d2fs.services.x3config_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.x3_space.X3Space;


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
 *         &lt;element ref="{http://www.emc.com/d2fs/models/x3_space}x3_space" minOccurs="0"/&gt;
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
    "x3Space"
})
@XmlRootElement(name = "getSpaceResponse")
public class GetSpaceResponse {

    @XmlElement(name = "x3_space", namespace = "http://www.emc.com/d2fs/models/x3_space")
    protected X3Space x3Space;

    /**
     * Gets the value of the x3Space property.
     * 
     * @return
     *     possible object is
     *     {@link X3Space }
     *     
     */
    public X3Space getX3Space() {
        return x3Space;
    }

    /**
     * Sets the value of the x3Space property.
     * 
     * @param value
     *     allowed object is
     *     {@link X3Space }
     *     
     */
    public void setX3Space(X3Space value) {
        this.x3Space = value;
    }

}
