
package com.emc.d2fs.models.massupdateinformations;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MassUpdateInformations complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MassUpdateInformations"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="updatedIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="updatedCount" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="nonUpdatedCount" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="nonUpdatedNames" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="partiallyUpdatedCount" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="partiallyUpdatedNames" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="warningMessage" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MassUpdateInformations", propOrder = {
    "updatedIds"
})
public class MassUpdateInformations {

    protected List<String> updatedIds;
    @XmlAttribute(name = "updatedCount")
    protected Integer updatedCount;
    @XmlAttribute(name = "nonUpdatedCount")
    protected Integer nonUpdatedCount;
    @XmlAttribute(name = "nonUpdatedNames")
    protected String nonUpdatedNames;
    @XmlAttribute(name = "partiallyUpdatedCount")
    protected Integer partiallyUpdatedCount;
    @XmlAttribute(name = "partiallyUpdatedNames")
    protected String partiallyUpdatedNames;
    @XmlAttribute(name = "warningMessage")
    protected String warningMessage;

    /**
     * Gets the value of the updatedIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the updatedIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpdatedIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUpdatedIds() {
        if (updatedIds == null) {
            updatedIds = new ArrayList<String>();
        }
        return this.updatedIds;
    }

    /**
     * Gets the value of the updatedCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUpdatedCount() {
        return updatedCount;
    }

    /**
     * Sets the value of the updatedCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUpdatedCount(Integer value) {
        this.updatedCount = value;
    }

    /**
     * Gets the value of the nonUpdatedCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNonUpdatedCount() {
        return nonUpdatedCount;
    }

    /**
     * Sets the value of the nonUpdatedCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNonUpdatedCount(Integer value) {
        this.nonUpdatedCount = value;
    }

    /**
     * Gets the value of the nonUpdatedNames property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonUpdatedNames() {
        return nonUpdatedNames;
    }

    /**
     * Sets the value of the nonUpdatedNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonUpdatedNames(String value) {
        this.nonUpdatedNames = value;
    }

    /**
     * Gets the value of the partiallyUpdatedCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPartiallyUpdatedCount() {
        return partiallyUpdatedCount;
    }

    /**
     * Sets the value of the partiallyUpdatedCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPartiallyUpdatedCount(Integer value) {
        this.partiallyUpdatedCount = value;
    }

    /**
     * Gets the value of the partiallyUpdatedNames property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartiallyUpdatedNames() {
        return partiallyUpdatedNames;
    }

    /**
     * Sets the value of the partiallyUpdatedNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartiallyUpdatedNames(String value) {
        this.partiallyUpdatedNames = value;
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

}
