
package com.emc.d2fs.services.property_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.dump.Dump;


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
 *         &lt;element ref="{http://www.emc.com/d2fs/models/dump}dump"/&gt;
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
    "dump"
})
@XmlRootElement(name = "dumpResponse")
public class DumpResponse {

    @XmlElement(namespace = "http://www.emc.com/d2fs/models/dump", required = true)
    protected Dump dump;

    /**
     * Gets the value of the dump property.
     * 
     * @return
     *     possible object is
     *     {@link Dump }
     *     
     */
    public Dump getDump() {
        return dump;
    }

    /**
     * Sets the value of the dump property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dump }
     *     
     */
    public void setDump(Dump value) {
        this.dump = value;
    }

}
