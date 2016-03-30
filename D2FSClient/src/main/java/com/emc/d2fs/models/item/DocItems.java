
package com.emc.d2fs.models.item;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.attribute.Attribute;
import com.emc.d2fs.models.preference.ColumnPreference;
import com.emc.d2fs.models.repository.Repository;
import com.emc.d2fs.models.workflow_details.WorkflowDetails;


/**
 * <p>Java class for docItems complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="docItems"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="upperItem" type="{http://www.emc.com/d2fs/models/item}item" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.emc.com/d2fs/models/item}items" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="repository" type="{http://www.emc.com/d2fs/models/repository}repository" minOccurs="0"/&gt;
 *         &lt;element name="workflow_details" type="{http://www.emc.com/d2fs/models/workflow_details}workflow_details" minOccurs="0"/&gt;
 *         &lt;element name="columnPreference" type="{http://www.emc.com/d2fs/models/preference}columnPreference" minOccurs="0"/&gt;
 *         &lt;element name="customData" type="{http://www.emc.com/d2fs/models/attribute}attribute" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="uid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="menuType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="dragSourceEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="dropTargetEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="exportToExcelEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="changeColumnsEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="multiSelectionEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="nbItemPerPage" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "docItems", propOrder = {
    "upperItem",
    "items",
    "repository",
    "workflowDetails",
    "columnPreference",
    "customData"
})
public class DocItems {

    protected Item upperItem;
    protected List<Item> items;
    protected Repository repository;
    @XmlElement(name = "workflow_details")
    protected WorkflowDetails workflowDetails;
    protected ColumnPreference columnPreference;
    protected List<Attribute> customData;
    @XmlAttribute(name = "uid")
    protected String uid;
    @XmlAttribute(name = "count")
    protected Integer count;
    @XmlAttribute(name = "menuType")
    protected String menuType;
    @XmlAttribute(name = "dragSourceEnabled")
    protected Boolean dragSourceEnabled;
    @XmlAttribute(name = "dropTargetEnabled")
    protected Boolean dropTargetEnabled;
    @XmlAttribute(name = "exportToExcelEnabled")
    protected Boolean exportToExcelEnabled;
    @XmlAttribute(name = "changeColumnsEnabled")
    protected Boolean changeColumnsEnabled;
    @XmlAttribute(name = "multiSelectionEnabled")
    protected Boolean multiSelectionEnabled;
    @XmlAttribute(name = "nbItemPerPage")
    protected Integer nbItemPerPage;

    /**
     * Gets the value of the upperItem property.
     * 
     * @return
     *     possible object is
     *     {@link Item }
     *     
     */
    public Item getUpperItem() {
        return upperItem;
    }

    /**
     * Sets the value of the upperItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Item }
     *     
     */
    public void setUpperItem(Item value) {
        this.upperItem = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Item }
     * 
     * 
     */
    public List<Item> getItems() {
        if (items == null) {
            items = new ArrayList<Item>();
        }
        return this.items;
    }

    /**
     * Gets the value of the repository property.
     * 
     * @return
     *     possible object is
     *     {@link Repository }
     *     
     */
    public Repository getRepository() {
        return repository;
    }

    /**
     * Sets the value of the repository property.
     * 
     * @param value
     *     allowed object is
     *     {@link Repository }
     *     
     */
    public void setRepository(Repository value) {
        this.repository = value;
    }

    /**
     * Gets the value of the workflowDetails property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowDetails }
     *     
     */
    public WorkflowDetails getWorkflowDetails() {
        return workflowDetails;
    }

    /**
     * Sets the value of the workflowDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowDetails }
     *     
     */
    public void setWorkflowDetails(WorkflowDetails value) {
        this.workflowDetails = value;
    }

    /**
     * Gets the value of the columnPreference property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnPreference }
     *     
     */
    public ColumnPreference getColumnPreference() {
        return columnPreference;
    }

    /**
     * Sets the value of the columnPreference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnPreference }
     *     
     */
    public void setColumnPreference(ColumnPreference value) {
        this.columnPreference = value;
    }

    /**
     * Gets the value of the customData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attribute }
     * 
     * 
     */
    public List<Attribute> getCustomData() {
        if (customData == null) {
            customData = new ArrayList<Attribute>();
        }
        return this.customData;
    }

    /**
     * Gets the value of the uid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
    }

    /**
     * Gets the value of the count property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCount(Integer value) {
        this.count = value;
    }

    /**
     * Gets the value of the menuType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * Sets the value of the menuType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMenuType(String value) {
        this.menuType = value;
    }

    /**
     * Gets the value of the dragSourceEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDragSourceEnabled() {
        return dragSourceEnabled;
    }

    /**
     * Sets the value of the dragSourceEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDragSourceEnabled(Boolean value) {
        this.dragSourceEnabled = value;
    }

    /**
     * Gets the value of the dropTargetEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDropTargetEnabled() {
        return dropTargetEnabled;
    }

    /**
     * Sets the value of the dropTargetEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDropTargetEnabled(Boolean value) {
        this.dropTargetEnabled = value;
    }

    /**
     * Gets the value of the exportToExcelEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExportToExcelEnabled() {
        return exportToExcelEnabled;
    }

    /**
     * Sets the value of the exportToExcelEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExportToExcelEnabled(Boolean value) {
        this.exportToExcelEnabled = value;
    }

    /**
     * Gets the value of the changeColumnsEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChangeColumnsEnabled() {
        return changeColumnsEnabled;
    }

    /**
     * Sets the value of the changeColumnsEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChangeColumnsEnabled(Boolean value) {
        this.changeColumnsEnabled = value;
    }

    /**
     * Gets the value of the multiSelectionEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMultiSelectionEnabled() {
        return multiSelectionEnabled;
    }

    /**
     * Sets the value of the multiSelectionEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMultiSelectionEnabled(Boolean value) {
        this.multiSelectionEnabled = value;
    }

    /**
     * Gets the value of the nbItemPerPage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbItemPerPage() {
        return nbItemPerPage;
    }

    /**
     * Sets the value of the nbItemPerPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbItemPerPage(Integer value) {
        this.nbItemPerPage = value;
    }

}
