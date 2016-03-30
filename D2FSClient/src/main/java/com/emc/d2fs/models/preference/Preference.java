
package com.emc.d2fs.models.preference;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for preference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="preference"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="column" type="{http://www.emc.com/d2fs/models/preference}column" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="columnPreferences" type="{http://www.emc.com/d2fs/models/preference}columnPreference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="language" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="folderBefore" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="folderHidden" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="formatDate" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="formatDateTime" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="formatDateInput" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="thumbnailFormat" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="thumbnailSize" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="contentViewMode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="vdShowNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="vdShowVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="paginationNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="assistColKeyType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "preference", propOrder = {
    "column",
    "columnPreferences"
})
public class Preference {

    protected List<Column> column;
    protected List<ColumnPreference> columnPreferences;
    @XmlAttribute(name = "language")
    protected String language;
    @XmlAttribute(name = "folderBefore", required = true)
    protected boolean folderBefore;
    @XmlAttribute(name = "folderHidden", required = true)
    protected boolean folderHidden;
    @XmlAttribute(name = "formatDate", required = true)
    protected String formatDate;
    @XmlAttribute(name = "formatDateTime", required = true)
    protected String formatDateTime;
    @XmlAttribute(name = "formatDateInput")
    protected String formatDateInput;
    @XmlAttribute(name = "thumbnailFormat", required = true)
    protected String thumbnailFormat;
    @XmlAttribute(name = "thumbnailSize", required = true)
    protected String thumbnailSize;
    @XmlAttribute(name = "contentViewMode", required = true)
    protected String contentViewMode;
    @XmlAttribute(name = "vdShowNumber", required = true)
    protected boolean vdShowNumber;
    @XmlAttribute(name = "vdShowVersion", required = true)
    protected boolean vdShowVersion;
    @XmlAttribute(name = "paginationNumber", required = true)
    protected int paginationNumber;
    @XmlAttribute(name = "assistColKeyType")
    protected String assistColKeyType;

    /**
     * Gets the value of the column property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the column property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Column }
     * 
     * 
     */
    public List<Column> getColumn() {
        if (column == null) {
            column = new ArrayList<Column>();
        }
        return this.column;
    }

    /**
     * Gets the value of the columnPreferences property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the columnPreferences property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumnPreferences().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColumnPreference }
     * 
     * 
     */
    public List<ColumnPreference> getColumnPreferences() {
        if (columnPreferences == null) {
            columnPreferences = new ArrayList<ColumnPreference>();
        }
        return this.columnPreferences;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the folderBefore property.
     * 
     */
    public boolean isFolderBefore() {
        return folderBefore;
    }

    /**
     * Sets the value of the folderBefore property.
     * 
     */
    public void setFolderBefore(boolean value) {
        this.folderBefore = value;
    }

    /**
     * Gets the value of the folderHidden property.
     * 
     */
    public boolean isFolderHidden() {
        return folderHidden;
    }

    /**
     * Sets the value of the folderHidden property.
     * 
     */
    public void setFolderHidden(boolean value) {
        this.folderHidden = value;
    }

    /**
     * Gets the value of the formatDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatDate() {
        return formatDate;
    }

    /**
     * Sets the value of the formatDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatDate(String value) {
        this.formatDate = value;
    }

    /**
     * Gets the value of the formatDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatDateTime() {
        return formatDateTime;
    }

    /**
     * Sets the value of the formatDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatDateTime(String value) {
        this.formatDateTime = value;
    }

    /**
     * Gets the value of the formatDateInput property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatDateInput() {
        return formatDateInput;
    }

    /**
     * Sets the value of the formatDateInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatDateInput(String value) {
        this.formatDateInput = value;
    }

    /**
     * Gets the value of the thumbnailFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThumbnailFormat() {
        return thumbnailFormat;
    }

    /**
     * Sets the value of the thumbnailFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThumbnailFormat(String value) {
        this.thumbnailFormat = value;
    }

    /**
     * Gets the value of the thumbnailSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThumbnailSize() {
        return thumbnailSize;
    }

    /**
     * Sets the value of the thumbnailSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThumbnailSize(String value) {
        this.thumbnailSize = value;
    }

    /**
     * Gets the value of the contentViewMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentViewMode() {
        return contentViewMode;
    }

    /**
     * Sets the value of the contentViewMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentViewMode(String value) {
        this.contentViewMode = value;
    }

    /**
     * Gets the value of the vdShowNumber property.
     * 
     */
    public boolean isVdShowNumber() {
        return vdShowNumber;
    }

    /**
     * Sets the value of the vdShowNumber property.
     * 
     */
    public void setVdShowNumber(boolean value) {
        this.vdShowNumber = value;
    }

    /**
     * Gets the value of the vdShowVersion property.
     * 
     */
    public boolean isVdShowVersion() {
        return vdShowVersion;
    }

    /**
     * Sets the value of the vdShowVersion property.
     * 
     */
    public void setVdShowVersion(boolean value) {
        this.vdShowVersion = value;
    }

    /**
     * Gets the value of the paginationNumber property.
     * 
     */
    public int getPaginationNumber() {
        return paginationNumber;
    }

    /**
     * Sets the value of the paginationNumber property.
     * 
     */
    public void setPaginationNumber(int value) {
        this.paginationNumber = value;
    }

    /**
     * Gets the value of the assistColKeyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssistColKeyType() {
        return assistColKeyType;
    }

    /**
     * Sets the value of the assistColKeyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssistColKeyType(String value) {
        this.assistColKeyType = value;
    }

}
