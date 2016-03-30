
package com.emc.d2fs.services.download_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *       &lt;attribute name="masterId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="folderPath" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="structureConfigName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="baseUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
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
@XmlRootElement(name = "getImportStructureUrlsRequest")
public class GetImportStructureUrlsRequest {

    @XmlElement(namespace = "http://www.emc.com/d2fs/models/context", required = true)
    protected Context context;
    @XmlAttribute(name = "masterId", required = true)
    protected String masterId;
    @XmlAttribute(name = "folderPath", required = true)
    protected String folderPath;
    @XmlAttribute(name = "structureConfigName", required = true)
    protected String structureConfigName;
    @XmlAttribute(name = "baseUrl")
    @XmlSchemaType(name = "anyURI")
    protected String baseUrl;

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
     * Gets the value of the masterId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterId() {
        return masterId;
    }

    /**
     * Sets the value of the masterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterId(String value) {
        this.masterId = value;
    }

    /**
     * Gets the value of the folderPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolderPath() {
        return folderPath;
    }

    /**
     * Sets the value of the folderPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolderPath(String value) {
        this.folderPath = value;
    }

    /**
     * Gets the value of the structureConfigName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStructureConfigName() {
        return structureConfigName;
    }

    /**
     * Sets the value of the structureConfigName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStructureConfigName(String value) {
        this.structureConfigName = value;
    }

    /**
     * Gets the value of the baseUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Sets the value of the baseUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseUrl(String value) {
        this.baseUrl = value;
    }

}
