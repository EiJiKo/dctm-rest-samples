
package com.emc.d2fs.models.link_info;

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
 *       &lt;attribute name="linkType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="relationName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="creationProfile" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="warningMessage" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="linkRequired" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="linkSilent" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "link_info")
public class LinkInfo {

    @XmlAttribute(name = "linkType", required = true)
    protected String linkType;
    @XmlAttribute(name = "relationName", required = true)
    protected String relationName;
    @XmlAttribute(name = "creationProfile", required = true)
    protected String creationProfile;
    @XmlAttribute(name = "warningMessage")
    protected String warningMessage;
    @XmlAttribute(name = "linkRequired", required = true)
    protected boolean linkRequired;
    @XmlAttribute(name = "linkSilent", required = true)
    protected boolean linkSilent;

    /**
     * Gets the value of the linkType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkType() {
        return linkType;
    }

    /**
     * Sets the value of the linkType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkType(String value) {
        this.linkType = value;
    }

    /**
     * Gets the value of the relationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationName() {
        return relationName;
    }

    /**
     * Sets the value of the relationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationName(String value) {
        this.relationName = value;
    }

    /**
     * Gets the value of the creationProfile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationProfile() {
        return creationProfile;
    }

    /**
     * Sets the value of the creationProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationProfile(String value) {
        this.creationProfile = value;
    }

    /**
     * Gets the value of the warningMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarningMessage() {
        return warningMessage;
    }

    /**
     * Sets the value of the warningMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarningMessage(String value) {
        this.warningMessage = value;
    }

    /**
     * Gets the value of the linkRequired property.
     * 
     */
    public boolean isLinkRequired() {
        return linkRequired;
    }

    /**
     * Sets the value of the linkRequired property.
     * 
     */
    public void setLinkRequired(boolean value) {
        this.linkRequired = value;
    }

    /**
     * Gets the value of the linkSilent property.
     * 
     */
    public boolean isLinkSilent() {
        return linkSilent;
    }

    /**
     * Sets the value of the linkSilent property.
     * 
     */
    public void setLinkSilent(boolean value) {
        this.linkSilent = value;
    }

}
