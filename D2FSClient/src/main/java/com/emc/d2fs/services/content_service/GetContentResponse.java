
package com.emc.d2fs.services.content_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.item.DocItems;


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
 *         &lt;element ref="{http://www.emc.com/d2fs/models/item}docItems" minOccurs="0"/&gt;
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
    "docItems"
})
@XmlRootElement(name = "getContentResponse")
public class GetContentResponse {

    @XmlElement(namespace = "http://www.emc.com/d2fs/models/item")
    protected DocItems docItems;

    /**
     * Gets the value of the docItems property.
     * 
     * @return
     *     possible object is
     *     {@link DocItems }
     *     
     */
    public DocItems getDocItems() {
        return docItems;
    }

    /**
     * Sets the value of the docItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocItems }
     *     
     */
    public void setDocItems(DocItems value) {
        this.docItems = value;
    }

}
