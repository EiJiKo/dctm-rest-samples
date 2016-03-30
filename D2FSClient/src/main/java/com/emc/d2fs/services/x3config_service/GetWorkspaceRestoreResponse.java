
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
 *         &lt;element name="workspaceRestore" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "workspaceRestore"
})
@XmlRootElement(name = "getWorkspaceRestoreResponse")
public class GetWorkspaceRestoreResponse {

    protected boolean workspaceRestore;

    /**
     * Gets the value of the workspaceRestore property.
     * 
     */
    public boolean isWorkspaceRestore() {
        return workspaceRestore;
    }

    /**
     * Sets the value of the workspaceRestore property.
     * 
     */
    public void setWorkspaceRestore(boolean value) {
        this.workspaceRestore = value;
    }

}
