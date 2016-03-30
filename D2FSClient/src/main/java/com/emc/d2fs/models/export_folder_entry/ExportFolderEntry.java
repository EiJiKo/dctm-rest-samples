
package com.emc.d2fs.models.export_folder_entry;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for exportFolderEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportFolderEntry"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="exportUrls" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://www.emc.com/d2fs/models/common}id use="required""/&gt;
 *       &lt;attribute name="exportPath" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportFolderEntry", propOrder = {
    "exportUrls"
})
public class ExportFolderEntry {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected List<String> exportUrls;
    @XmlAttribute(name = "id", namespace = "http://www.emc.com/d2fs/models/common", required = true)
    protected String id;
    @XmlAttribute(name = "exportPath", required = true)
    protected String exportPath;

    /**
     * Gets the value of the exportUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getExportUrls() {
        if (exportUrls == null) {
            exportUrls = new ArrayList<String>();
        }
        return this.exportUrls;
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
     * Gets the value of the exportPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExportPath() {
        return exportPath;
    }

    /**
     * Sets the value of the exportPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExportPath(String value) {
        this.exportPath = value;
    }

}
