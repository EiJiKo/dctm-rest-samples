
package com.emc.d2fs.services.locate_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *       &lt;/sequence&gt;
 *       &lt;attribute name="pathInfos" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "getLocationForBreadCrumbResponse")
public class GetLocationForBreadCrumbResponse {

    @XmlAttribute(name = "pathInfos")
    protected String pathInfos;

    /**
     * Gets the value of the pathInfos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathInfos() {
        return pathInfos;
    }

    /**
     * Sets the value of the pathInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathInfos(String value) {
        this.pathInfos = value;
    }

}
