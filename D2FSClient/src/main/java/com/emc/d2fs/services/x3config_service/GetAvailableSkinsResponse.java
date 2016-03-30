
package com.emc.d2fs.services.x3config_service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{http://www.emc.com/d2fs/models/x3_skin}x3_skin" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "x3Skin"
})
@XmlRootElement(name = "getAvailableSkinsResponse")
public class GetAvailableSkinsResponse {

    @XmlElement(name = "x3_skin", namespace = "http://www.emc.com/d2fs/models/x3_skin")
    protected List<X3Skin> x3Skin;

    /**
     * Gets the value of the x3Skin property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the x3Skin property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getX3Skin().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link X3Skin }
     * 
     * 
     */
    public List<X3Skin> getX3Skin() {
        if (x3Skin == null) {
            x3Skin = new ArrayList<X3Skin>();
        }
        return this.x3Skin;
    }

}
