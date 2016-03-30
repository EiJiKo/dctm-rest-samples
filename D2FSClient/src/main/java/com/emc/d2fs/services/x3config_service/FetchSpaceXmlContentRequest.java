
package com.emc.d2fs.services.x3config_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.context.Context;


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
 *         &lt;element ref="{http://www.emc.com/d2fs/models/context}context"/&gt;
 *         &lt;element name="spaceName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="resetSpace" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "context",
    "spaceName",
    "resetSpace"
})
@XmlRootElement(name = "fetchSpaceXmlContentRequest")
public class FetchSpaceXmlContentRequest {

    @XmlElement(namespace = "http://www.emc.com/d2fs/models/context", required = true)
    protected Context context;
    @XmlElement(required = true)
    protected String spaceName;
    protected boolean resetSpace;

    /**
     * Gets the value of the context property.
     * 
     * @return
     *     possible object is
     *     {@link Context }
     *     
     */
    public Context getContext() {
        return context;
    }

    /**
     * Sets the value of the context property.
     * 
     * @param value
     *     allowed object is
     *     {@link Context }
     *     
     */
    public void setContext(Context value) {
        this.context = value;
    }

    /**
     * Gets the value of the spaceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaceName() {
        return spaceName;
    }

    /**
     * Sets the value of the spaceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaceName(String value) {
        this.spaceName = value;
    }

    /**
     * Gets the value of the resetSpace property.
     * 
     */
    public boolean isResetSpace() {
        return resetSpace;
    }

    /**
     * Sets the value of the resetSpace property.
     * 
     */
    public void setResetSpace(boolean value) {
        this.resetSpace = value;
    }

}
