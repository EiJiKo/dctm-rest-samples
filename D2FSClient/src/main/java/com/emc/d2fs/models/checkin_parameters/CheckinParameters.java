
package com.emc.d2fs.models.checkin_parameters;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkin_parameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkin_parameters"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="file_url" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;attribute name="log_entry" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="a_content_type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="checkin_version" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="make_current" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="retain_lock" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="keep_symbolic_label" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="keep_log_entry" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="queue_rendition" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkin_parameters")
public class CheckinParameters {

    @XmlAttribute(name = "file_url")
    @XmlSchemaType(name = "anyURI")
    protected String fileUrl;
    @XmlAttribute(name = "log_entry")
    protected String logEntry;
    @XmlAttribute(name = "a_content_type")
    protected String aContentType;
    @XmlAttribute(name = "checkin_version")
    protected String checkinVersion;
    @XmlAttribute(name = "make_current")
    protected Boolean makeCurrent;
    @XmlAttribute(name = "retain_lock")
    protected Boolean retainLock;
    @XmlAttribute(name = "keep_symbolic_label")
    protected Boolean keepSymbolicLabel;
    @XmlAttribute(name = "keep_log_entry")
    protected Boolean keepLogEntry;
    @XmlAttribute(name = "queue_rendition")
    protected Boolean queueRendition;

    /**
     * Gets the value of the fileUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * Sets the value of the fileUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileUrl(String value) {
        this.fileUrl = value;
    }

    /**
     * Gets the value of the logEntry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogEntry() {
        return logEntry;
    }

    /**
     * Sets the value of the logEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogEntry(String value) {
        this.logEntry = value;
    }

    /**
     * Gets the value of the aContentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAContentType() {
        return aContentType;
    }

    /**
     * Sets the value of the aContentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAContentType(String value) {
        this.aContentType = value;
    }

    /**
     * Gets the value of the checkinVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckinVersion() {
        return checkinVersion;
    }

    /**
     * Sets the value of the checkinVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckinVersion(String value) {
        this.checkinVersion = value;
    }

    /**
     * Gets the value of the makeCurrent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMakeCurrent() {
        return makeCurrent;
    }

    /**
     * Sets the value of the makeCurrent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMakeCurrent(Boolean value) {
        this.makeCurrent = value;
    }

    /**
     * Gets the value of the retainLock property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRetainLock() {
        return retainLock;
    }

    /**
     * Sets the value of the retainLock property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRetainLock(Boolean value) {
        this.retainLock = value;
    }

    /**
     * Gets the value of the keepSymbolicLabel property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isKeepSymbolicLabel() {
        return keepSymbolicLabel;
    }

    /**
     * Sets the value of the keepSymbolicLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setKeepSymbolicLabel(Boolean value) {
        this.keepSymbolicLabel = value;
    }

    /**
     * Gets the value of the keepLogEntry property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isKeepLogEntry() {
        return keepLogEntry;
    }

    /**
     * Sets the value of the keepLogEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setKeepLogEntry(Boolean value) {
        this.keepLogEntry = value;
    }

    /**
     * Gets the value of the queueRendition property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isQueueRendition() {
        return queueRendition;
    }

    /**
     * Sets the value of the queueRendition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setQueueRendition(Boolean value) {
        this.queueRendition = value;
    }

}
