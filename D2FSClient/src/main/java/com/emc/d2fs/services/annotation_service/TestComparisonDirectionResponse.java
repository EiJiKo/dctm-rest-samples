
package com.emc.d2fs.services.annotation_service;

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
 *       &lt;attribute name="fromIdNewerThanToId" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "testComparisonDirectionResponse")
public class TestComparisonDirectionResponse {

    @XmlAttribute(name = "fromIdNewerThanToId", required = true)
    protected boolean fromIdNewerThanToId;

    /**
     * Gets the value of the fromIdNewerThanToId property.
     * 
     */
    public boolean isFromIdNewerThanToId() {
        return fromIdNewerThanToId;
    }

    /**
     * Sets the value of the fromIdNewerThanToId property.
     * 
     */
    public void setFromIdNewerThanToId(boolean value) {
        this.fromIdNewerThanToId = value;
    }

}
