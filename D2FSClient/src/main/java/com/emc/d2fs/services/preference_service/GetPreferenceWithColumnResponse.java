
package com.emc.d2fs.services.preference_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.preference.Preference;


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
 *         &lt;element ref="{http://www.emc.com/d2fs/models/preference}preference" minOccurs="0"/&gt;
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
    "preference"
})
@XmlRootElement(name = "getPreferenceWithColumnResponse")
public class GetPreferenceWithColumnResponse {

    @XmlElement(namespace = "http://www.emc.com/d2fs/models/preference")
    protected Preference preference;

    /**
     * Gets the value of the preference property.
     * 
     * @return
     *     possible object is
     *     {@link Preference }
     *     
     */
    public Preference getPreference() {
        return preference;
    }

    /**
     * Sets the value of the preference property.
     * 
     * @param value
     *     allowed object is
     *     {@link Preference }
     *     
     */
    public void setPreference(Preference value) {
        this.preference = value;
    }

}
