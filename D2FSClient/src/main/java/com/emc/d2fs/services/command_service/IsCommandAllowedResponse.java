
package com.emc.d2fs.services.command_service;

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
 *       &lt;attribute name="commandAllowed" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "isCommandAllowedResponse")
public class IsCommandAllowedResponse {

    @XmlAttribute(name = "commandAllowed", required = true)
    protected boolean commandAllowed;

    /**
     * Gets the value of the commandAllowed property.
     * 
     */
    public boolean isCommandAllowed() {
        return commandAllowed;
    }

    /**
     * Sets the value of the commandAllowed property.
     * 
     */
    public void setCommandAllowed(boolean value) {
        this.commandAllowed = value;
    }

}
