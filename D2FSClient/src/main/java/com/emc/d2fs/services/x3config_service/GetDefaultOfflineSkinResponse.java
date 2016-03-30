
package com.emc.d2fs.services.x3config_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.x3_skin.X3Skin;


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
 *         &lt;element name="skin" type="{http://www.emc.com/d2fs/models/x3_skin}x3_skin" minOccurs="0"/&gt;
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
    "skin"
})
@XmlRootElement(name = "getDefaultOfflineSkinResponse")
public class GetDefaultOfflineSkinResponse {

    protected X3Skin skin;

    /**
     * Gets the value of the skin property.
     * 
     * @return
     *     possible object is
     *     {@link X3Skin }
     *     
     */
    public X3Skin getSkin() {
        return skin;
    }

    /**
     * Sets the value of the skin property.
     * 
     * @param value
     *     allowed object is
     *     {@link X3Skin }
     *     
     */
    public void setSkin(X3Skin value) {
        this.skin = value;
    }

}
