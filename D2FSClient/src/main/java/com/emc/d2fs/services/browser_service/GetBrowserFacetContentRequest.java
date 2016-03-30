
package com.emc.d2fs.services.browser_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://www.emc.com/d2fs/models/common}id"/&gt;
 *       &lt;attribute name="contentTypeName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="facetName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="facetValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="resetFacetName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="checkChildren" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="facetCountInfo" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "context"
})
@XmlRootElement(name = "getBrowserFacetContentRequest")
public class GetBrowserFacetContentRequest {

    @XmlElement(namespace = "http://www.emc.com/d2fs/models/context", required = true)
    protected Context context;
    @XmlAttribute(name = "id", namespace = "http://www.emc.com/d2fs/models/common")
    protected String id;
    @XmlAttribute(name = "contentTypeName", required = true)
    protected String contentTypeName;
    @XmlAttribute(name = "facetName")
    protected String facetName;
    @XmlAttribute(name = "facetValue")
    protected String facetValue;
    @XmlAttribute(name = "resetFacetName")
    protected String resetFacetName;
    @XmlAttribute(name = "checkChildren")
    protected String checkChildren;
    @XmlAttribute(name = "facetCountInfo")
    protected String facetCountInfo;

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
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the contentTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentTypeName() {
        return contentTypeName;
    }

    /**
     * Sets the value of the contentTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentTypeName(String value) {
        this.contentTypeName = value;
    }

    /**
     * Gets the value of the facetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacetName() {
        return facetName;
    }

    /**
     * Sets the value of the facetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacetName(String value) {
        this.facetName = value;
    }

    /**
     * Gets the value of the facetValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacetValue() {
        return facetValue;
    }

    /**
     * Sets the value of the facetValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacetValue(String value) {
        this.facetValue = value;
    }

    /**
     * Gets the value of the resetFacetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResetFacetName() {
        return resetFacetName;
    }

    /**
     * Sets the value of the resetFacetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResetFacetName(String value) {
        this.resetFacetName = value;
    }

    /**
     * Gets the value of the checkChildren property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckChildren() {
        return checkChildren;
    }

    /**
     * Sets the value of the checkChildren property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckChildren(String value) {
        this.checkChildren = value;
    }

    /**
     * Gets the value of the facetCountInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacetCountInfo() {
        return facetCountInfo;
    }

    /**
     * Sets the value of the facetCountInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacetCountInfo(String value) {
        this.facetCountInfo = value;
    }

}
