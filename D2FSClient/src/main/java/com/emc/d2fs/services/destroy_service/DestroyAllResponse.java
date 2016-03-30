
package com.emc.d2fs.services.destroy_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.destroyresult.Destroyresult;


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
 *         &lt;element ref="{http://www.emc.com/d2fs/models/destroyresult}destroyresult"/&gt;
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
    "destroyresult"
})
@XmlRootElement(name = "destroyAllResponse")
public class DestroyAllResponse {

    @XmlElement(namespace = "http://www.emc.com/d2fs/models/destroyresult", required = true)
    protected Destroyresult destroyresult;

    /**
     * Gets the value of the destroyresult property.
     * 
     * @return
     *     possible object is
     *     {@link Destroyresult }
     *     
     */
    public Destroyresult getDestroyresult() {
        return destroyresult;
    }

    /**
     * Sets the value of the destroyresult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Destroyresult }
     *     
     */
    public void setDestroyresult(Destroyresult value) {
        this.destroyresult = value;
    }

}
