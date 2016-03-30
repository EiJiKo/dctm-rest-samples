
package com.emc.d2fs.services.reference_service;

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
 *         &lt;element name="targetContext" type="{http://www.emc.com/d2fs/models/context}context"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://www.emc.com/d2fs/models/common}id use="required""/&gt;
 *       &lt;attribute name="targetFolderId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="bindingRule" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="bindingValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
    "targetContext"
})
@XmlRootElement(name = "addReferenceRequest")
public class AddReferenceRequest {

    @XmlElement(namespace = "http://www.emc.com/d2fs/models/context", required = true)
    protected Context context;
    @XmlElement(required = true)
    protected Context targetContext;
    @XmlAttribute(name = "id", namespace = "http://www.emc.com/d2fs/models/common", required = true)
    protected String id;
    @XmlAttribute(name = "targetFolderId", required = true)
    protected String targetFolderId;
    @XmlAttribute(name = "bindingRule")
    protected String bindingRule;
    @XmlAttribute(name = "bindingValue")
    protected String bindingValue;

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
     * Gets the value of the targetContext property.
     * 
     * @return
     *     possible object is
     *     {@link Context }
     *     
     */
    public Context getTargetContext() {
        return targetContext;
    }

    /**
     * Sets the value of the targetContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link Context }
     *     
     */
    public void setTargetContext(Context value) {
        this.targetContext = value;
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
     * Gets the value of the targetFolderId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetFolderId() {
        return targetFolderId;
    }

    /**
     * Sets the value of the targetFolderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetFolderId(String value) {
        this.targetFolderId = value;
    }

    /**
     * Gets the value of the bindingRule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBindingRule() {
        return bindingRule;
    }

    /**
     * Sets the value of the bindingRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBindingRule(String value) {
        this.bindingRule = value;
    }

    /**
     * Gets the value of the bindingValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBindingValue() {
        return bindingValue;
    }

    /**
     * Sets the value of the bindingValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBindingValue(String value) {
        this.bindingValue = value;
    }

}
