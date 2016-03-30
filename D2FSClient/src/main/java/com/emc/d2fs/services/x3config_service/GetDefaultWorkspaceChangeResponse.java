
package com.emc.d2fs.services.x3config_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="defaultWorkspaceChange" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "defaultWorkspaceChange"
})
@XmlRootElement(name = "getDefaultWorkspaceChangeResponse")
public class GetDefaultWorkspaceChangeResponse {

    protected boolean defaultWorkspaceChange;

    /**
     * Gets the value of the defaultWorkspaceChange property.
     * 
     */
    public boolean isDefaultWorkspaceChange() {
        return defaultWorkspaceChange;
    }

    /**
     * Sets the value of the defaultWorkspaceChange property.
     * 
     */
    public void setDefaultWorkspaceChange(boolean value) {
        this.defaultWorkspaceChange = value;
    }

}
