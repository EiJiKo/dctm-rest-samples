
package com.emc.d2fs.models.repository;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for repository complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="repository"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute ref="{http://www.emc.com/d2fs/models/common}id"/&gt;
 *       &lt;attribute name="repositoryName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="serverName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="docbaseDescription" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="serverVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="repositoryType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="hideDomain" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "repository")
public class Repository {

    @XmlAttribute(name = "id", namespace = "http://www.emc.com/d2fs/models/common")
    protected String id;
    @XmlAttribute(name = "repositoryName", required = true)
    protected String repositoryName;
    @XmlAttribute(name = "serverName")
    protected String serverName;
    @XmlAttribute(name = "docbaseDescription")
    protected String docbaseDescription;
    @XmlAttribute(name = "serverVersion", required = true)
    protected String serverVersion;
    @XmlAttribute(name = "repositoryType", required = true)
    protected String repositoryType;
    @XmlAttribute(name = "hideDomain", required = true)
    protected boolean hideDomain;

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
     * Gets the value of the repositoryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepositoryName() {
        return repositoryName;
    }

    /**
     * Sets the value of the repositoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepositoryName(String value) {
        this.repositoryName = value;
    }

    /**
     * Gets the value of the serverName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * Sets the value of the serverName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerName(String value) {
        this.serverName = value;
    }

    /**
     * Gets the value of the docbaseDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocbaseDescription() {
        return docbaseDescription;
    }

    /**
     * Sets the value of the docbaseDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocbaseDescription(String value) {
        this.docbaseDescription = value;
    }

    /**
     * Gets the value of the serverVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerVersion() {
        return serverVersion;
    }

    /**
     * Sets the value of the serverVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerVersion(String value) {
        this.serverVersion = value;
    }

    /**
     * Gets the value of the repositoryType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepositoryType() {
        return repositoryType;
    }

    /**
     * Sets the value of the repositoryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepositoryType(String value) {
        this.repositoryType = value;
    }

    /**
     * Gets the value of the hideDomain property.
     * 
     */
    public boolean isHideDomain() {
        return hideDomain;
    }

    /**
     * Sets the value of the hideDomain property.
     * 
     */
    public void setHideDomain(boolean value) {
        this.hideDomain = value;
    }

}
