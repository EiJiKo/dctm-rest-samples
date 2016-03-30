
package com.emc.d2fs.services.vdcontent_service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.attribute.Attribute;
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
 *         &lt;element ref="{http://www.emc.com/d2fs/models/attribute}attributes" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="srcVdId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="vdTemplateName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="inheritedComponentId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="overrideExistingComponent" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
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
    "attributes"
})
@XmlRootElement(name = "insertVDInheritedComponentRequest")
public class InsertVDInheritedComponentRequest {

    @XmlElement(namespace = "http://www.emc.com/d2fs/models/context", required = true)
    protected Context context;
    @XmlElement(namespace = "http://www.emc.com/d2fs/models/attribute")
    protected List<Attribute> attributes;
    @XmlAttribute(name = "srcVdId", required = true)
    protected String srcVdId;
    @XmlAttribute(name = "vdTemplateName", required = true)
    protected String vdTemplateName;
    @XmlAttribute(name = "inheritedComponentId", required = true)
    protected String inheritedComponentId;
    @XmlAttribute(name = "overrideExistingComponent", required = true)
    protected boolean overrideExistingComponent;

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
     * Gets the value of the attributes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attribute }
     * 
     * 
     */
    public List<Attribute> getAttributes() {
        if (attributes == null) {
            attributes = new ArrayList<Attribute>();
        }
        return this.attributes;
    }

    /**
     * Gets the value of the srcVdId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcVdId() {
        return srcVdId;
    }

    /**
     * Sets the value of the srcVdId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcVdId(String value) {
        this.srcVdId = value;
    }

    /**
     * Gets the value of the vdTemplateName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVdTemplateName() {
        return vdTemplateName;
    }

    /**
     * Sets the value of the vdTemplateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVdTemplateName(String value) {
        this.vdTemplateName = value;
    }

    /**
     * Gets the value of the inheritedComponentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInheritedComponentId() {
        return inheritedComponentId;
    }

    /**
     * Sets the value of the inheritedComponentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInheritedComponentId(String value) {
        this.inheritedComponentId = value;
    }

    /**
     * Gets the value of the overrideExistingComponent property.
     * 
     */
    public boolean isOverrideExistingComponent() {
        return overrideExistingComponent;
    }

    /**
     * Sets the value of the overrideExistingComponent property.
     * 
     */
    public void setOverrideExistingComponent(boolean value) {
        this.overrideExistingComponent = value;
    }

}
