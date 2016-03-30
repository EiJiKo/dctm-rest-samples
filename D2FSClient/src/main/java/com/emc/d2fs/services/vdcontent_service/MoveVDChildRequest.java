
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
 *       &lt;attribute name="srcParentId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="tgtParentId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="moveId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="moveNum" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="toNum" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
@XmlRootElement(name = "moveVDChildRequest")
public class MoveVDChildRequest {

    @XmlElement(namespace = "http://www.emc.com/d2fs/models/context", required = true)
    protected Context context;
    @XmlElement(namespace = "http://www.emc.com/d2fs/models/attribute")
    protected List<Attribute> attributes;
    @XmlAttribute(name = "srcParentId", required = true)
    protected String srcParentId;
    @XmlAttribute(name = "tgtParentId", required = true)
    protected String tgtParentId;
    @XmlAttribute(name = "moveId", required = true)
    protected String moveId;
    @XmlAttribute(name = "moveNum", required = true)
    protected String moveNum;
    @XmlAttribute(name = "toNum", required = true)
    protected String toNum;

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
     * Gets the value of the srcParentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcParentId() {
        return srcParentId;
    }

    /**
     * Sets the value of the srcParentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcParentId(String value) {
        this.srcParentId = value;
    }

    /**
     * Gets the value of the tgtParentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTgtParentId() {
        return tgtParentId;
    }

    /**
     * Sets the value of the tgtParentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTgtParentId(String value) {
        this.tgtParentId = value;
    }

    /**
     * Gets the value of the moveId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoveId() {
        return moveId;
    }

    /**
     * Sets the value of the moveId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoveId(String value) {
        this.moveId = value;
    }

    /**
     * Gets the value of the moveNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoveNum() {
        return moveNum;
    }

    /**
     * Sets the value of the moveNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoveNum(String value) {
        this.moveNum = value;
    }

    /**
     * Gets the value of the toNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToNum() {
        return toNum;
    }

    /**
     * Sets the value of the toNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToNum(String value) {
        this.toNum = value;
    }

}
