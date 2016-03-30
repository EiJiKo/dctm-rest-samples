
package com.emc.d2fs.services.rendition_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.rendition_result.RemoveRenditionResult;


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
 *         &lt;element ref="{http://www.emc.com/d2fs/models/rendition_result}removeRenditionResult"/&gt;
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
    "removeRenditionResult"
})
@XmlRootElement(name = "removeRenditionResponse")
public class RemoveRenditionResponse {

    @XmlElement(namespace = "http://www.emc.com/d2fs/models/rendition_result", required = true)
    protected RemoveRenditionResult removeRenditionResult;

    /**
     * Gets the value of the removeRenditionResult property.
     * 
     * @return
     *     possible object is
     *     {@link RemoveRenditionResult }
     *     
     */
    public RemoveRenditionResult getRemoveRenditionResult() {
        return removeRenditionResult;
    }

    /**
     * Sets the value of the removeRenditionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoveRenditionResult }
     *     
     */
    public void setRemoveRenditionResult(RemoveRenditionResult value) {
        this.removeRenditionResult = value;
    }

}
