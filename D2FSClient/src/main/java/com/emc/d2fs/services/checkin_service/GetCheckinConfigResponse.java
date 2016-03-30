
package com.emc.d2fs.services.checkin_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.checkin_config.CheckinConfig;


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
 *         &lt;element name="checkin_config" type="{http://www.emc.com/d2fs/models/checkin_config}checkin_config"/&gt;
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
    "checkinConfig"
})
@XmlRootElement(name = "getCheckinConfigResponse")
public class GetCheckinConfigResponse {

    @XmlElement(name = "checkin_config", required = true)
    protected CheckinConfig checkinConfig;

    /**
     * Gets the value of the checkinConfig property.
     * 
     * @return
     *     possible object is
     *     {@link CheckinConfig }
     *     
     */
    public CheckinConfig getCheckinConfig() {
        return checkinConfig;
    }

    /**
     * Sets the value of the checkinConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckinConfig }
     *     
     */
    public void setCheckinConfig(CheckinConfig value) {
        this.checkinConfig = value;
    }

}
