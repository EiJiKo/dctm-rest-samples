
package com.emc.d2fs.models.checkin_config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkin_config complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkin_config"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="config_name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="object_name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="r_lock_machine" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="checked_out" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="locked_by_user" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="checkin_from_file_allowed" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="queue_rendition" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="silent_minor" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="silent_same" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="keep_log_entry" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="keep_symbolic_label" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="offline" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="checkout_vd" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="has_content" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="can_log_entry" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="log_entry_required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="can_major_version" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkin_config")
public class CheckinConfig {

    @XmlAttribute(name = "config_name")
    protected String configName;
    @XmlAttribute(name = "object_name")
    protected String objectName;
    @XmlAttribute(name = "r_lock_machine")
    protected Boolean rLockMachine;
    @XmlAttribute(name = "checked_out")
    protected Boolean checkedOut;
    @XmlAttribute(name = "locked_by_user")
    protected Boolean lockedByUser;
    @XmlAttribute(name = "checkin_from_file_allowed")
    protected Boolean checkinFromFileAllowed;
    @XmlAttribute(name = "queue_rendition")
    protected Boolean queueRendition;
    @XmlAttribute(name = "silent_minor")
    protected Boolean silentMinor;
    @XmlAttribute(name = "silent_same")
    protected Boolean silentSame;
    @XmlAttribute(name = "keep_log_entry")
    protected Boolean keepLogEntry;
    @XmlAttribute(name = "keep_symbolic_label")
    protected Boolean keepSymbolicLabel;
    @XmlAttribute(name = "offline")
    protected Boolean offline;
    @XmlAttribute(name = "checkout_vd")
    protected Boolean checkoutVd;
    @XmlAttribute(name = "has_content")
    protected Boolean hasContent;
    @XmlAttribute(name = "can_log_entry")
    protected Boolean canLogEntry;
    @XmlAttribute(name = "log_entry_required")
    protected Boolean logEntryRequired;
    @XmlAttribute(name = "can_major_version")
    protected Boolean canMajorVersion;

    /**
     * Gets the value of the configName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * Sets the value of the configName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigName(String value) {
        this.configName = value;
    }

    /**
     * Gets the value of the objectName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * Sets the value of the objectName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectName(String value) {
        this.objectName = value;
    }

    /**
     * Gets the value of the rLockMachine property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRLockMachine() {
        return rLockMachine;
    }

    /**
     * Sets the value of the rLockMachine property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRLockMachine(Boolean value) {
        this.rLockMachine = value;
    }

    /**
     * Gets the value of the checkedOut property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCheckedOut() {
        return checkedOut;
    }

    /**
     * Sets the value of the checkedOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCheckedOut(Boolean value) {
        this.checkedOut = value;
    }

    /**
     * Gets the value of the lockedByUser property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLockedByUser() {
        return lockedByUser;
    }

    /**
     * Sets the value of the lockedByUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLockedByUser(Boolean value) {
        this.lockedByUser = value;
    }

    /**
     * Gets the value of the checkinFromFileAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCheckinFromFileAllowed() {
        return checkinFromFileAllowed;
    }

    /**
     * Sets the value of the checkinFromFileAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCheckinFromFileAllowed(Boolean value) {
        this.checkinFromFileAllowed = value;
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

    /**
     * Gets the value of the silentMinor property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSilentMinor() {
        return silentMinor;
    }

    /**
     * Sets the value of the silentMinor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSilentMinor(Boolean value) {
        this.silentMinor = value;
    }

    /**
     * Gets the value of the silentSame property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSilentSame() {
        return silentSame;
    }

    /**
     * Sets the value of the silentSame property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSilentSame(Boolean value) {
        this.silentSame = value;
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
     * Gets the value of the offline property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOffline() {
        return offline;
    }

    /**
     * Sets the value of the offline property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOffline(Boolean value) {
        this.offline = value;
    }

    /**
     * Gets the value of the checkoutVd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCheckoutVd() {
        return checkoutVd;
    }

    /**
     * Sets the value of the checkoutVd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCheckoutVd(Boolean value) {
        this.checkoutVd = value;
    }

    /**
     * Gets the value of the hasContent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasContent() {
        return hasContent;
    }

    /**
     * Sets the value of the hasContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasContent(Boolean value) {
        this.hasContent = value;
    }

    /**
     * Gets the value of the canLogEntry property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanLogEntry() {
        return canLogEntry;
    }

    /**
     * Sets the value of the canLogEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanLogEntry(Boolean value) {
        this.canLogEntry = value;
    }

    /**
     * Gets the value of the logEntryRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLogEntryRequired() {
        return logEntryRequired;
    }

    /**
     * Sets the value of the logEntryRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLogEntryRequired(Boolean value) {
        this.logEntryRequired = value;
    }

    /**
     * Gets the value of the canMajorVersion property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanMajorVersion() {
        return canMajorVersion;
    }

    /**
     * Sets the value of the canMajorVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanMajorVersion(Boolean value) {
        this.canMajorVersion = value;
    }

}
