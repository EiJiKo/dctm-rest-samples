
package com.emc.d2fs.services.d2_massupdate_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.massupdateinformations.MassUpdateInformations;


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
 *         &lt;element name="massupdateinformations" type="{http://www.emc.com/d2fs/models/massupdateinformations}MassUpdateInformations"/&gt;
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
    "massupdateinformations"
})
@XmlRootElement(name = "getMassUpdateInformationsResponse")
public class GetMassUpdateInformationsResponse {

    @XmlElement(required = true)
    protected MassUpdateInformations massupdateinformations;

    /**
     * Gets the value of the massupdateinformations property.
     * 
     * @return
     *     possible object is
     *     {@link MassUpdateInformations }
     *     
     */
    public MassUpdateInformations getMassupdateinformations() {
        return massupdateinformations;
    }

    /**
     * Sets the value of the massupdateinformations property.
     * 
     * @param value
     *     allowed object is
     *     {@link MassUpdateInformations }
     *     
     */
    public void setMassupdateinformations(MassUpdateInformations value) {
        this.massupdateinformations = value;
    }

}
