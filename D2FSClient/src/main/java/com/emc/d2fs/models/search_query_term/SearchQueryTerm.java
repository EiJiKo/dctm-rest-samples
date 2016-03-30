
package com.emc.d2fs.models.search_query_term;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for search_query_term complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="search_query_term"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="searchedTypes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="conditionLogicalList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="conditionOpenBracketList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="conditionAttributeNameList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="conditionOperatorList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="conditionAttributeValueList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="conditionCloseBracketList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="pathList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="colNames" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="facets" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="objectId" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="objectName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="fullTextCondition" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="fullTextOperator" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="fullTextWords" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="descend" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="orderBy" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="orderByDirection" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "search_query_term", propOrder = {
    "searchedTypes",
    "conditionLogicalList",
    "conditionOpenBracketList",
    "conditionAttributeNameList",
    "conditionOperatorList",
    "conditionAttributeValueList",
    "conditionCloseBracketList",
    "pathList",
    "colNames",
    "facets"
})
public class SearchQueryTerm {

    protected List<String> searchedTypes;
    protected List<String> conditionLogicalList;
    protected List<String> conditionOpenBracketList;
    protected List<String> conditionAttributeNameList;
    protected List<String> conditionOperatorList;
    protected List<String> conditionAttributeValueList;
    protected List<String> conditionCloseBracketList;
    protected List<String> pathList;
    protected List<String> colNames;
    protected List<String> facets;
    @XmlAttribute(name = "objectId")
    protected String objectId;
    @XmlAttribute(name = "objectName")
    protected String objectName;
    @XmlAttribute(name = "fullTextCondition")
    protected String fullTextCondition;
    @XmlAttribute(name = "fullTextOperator")
    protected String fullTextOperator;
    @XmlAttribute(name = "fullTextWords")
    protected String fullTextWords;
    @XmlAttribute(name = "descend")
    protected Boolean descend;
    @XmlAttribute(name = "orderBy")
    protected String orderBy;
    @XmlAttribute(name = "orderByDirection")
    protected String orderByDirection;

    /**
     * Gets the value of the searchedTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchedTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchedTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSearchedTypes() {
        if (searchedTypes == null) {
            searchedTypes = new ArrayList<String>();
        }
        return this.searchedTypes;
    }

    /**
     * Gets the value of the conditionLogicalList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conditionLogicalList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConditionLogicalList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getConditionLogicalList() {
        if (conditionLogicalList == null) {
            conditionLogicalList = new ArrayList<String>();
        }
        return this.conditionLogicalList;
    }

    /**
     * Gets the value of the conditionOpenBracketList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conditionOpenBracketList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConditionOpenBracketList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getConditionOpenBracketList() {
        if (conditionOpenBracketList == null) {
            conditionOpenBracketList = new ArrayList<String>();
        }
        return this.conditionOpenBracketList;
    }

    /**
     * Gets the value of the conditionAttributeNameList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conditionAttributeNameList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConditionAttributeNameList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getConditionAttributeNameList() {
        if (conditionAttributeNameList == null) {
            conditionAttributeNameList = new ArrayList<String>();
        }
        return this.conditionAttributeNameList;
    }

    /**
     * Gets the value of the conditionOperatorList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conditionOperatorList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConditionOperatorList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getConditionOperatorList() {
        if (conditionOperatorList == null) {
            conditionOperatorList = new ArrayList<String>();
        }
        return this.conditionOperatorList;
    }

    /**
     * Gets the value of the conditionAttributeValueList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conditionAttributeValueList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConditionAttributeValueList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getConditionAttributeValueList() {
        if (conditionAttributeValueList == null) {
            conditionAttributeValueList = new ArrayList<String>();
        }
        return this.conditionAttributeValueList;
    }

    /**
     * Gets the value of the conditionCloseBracketList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conditionCloseBracketList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConditionCloseBracketList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getConditionCloseBracketList() {
        if (conditionCloseBracketList == null) {
            conditionCloseBracketList = new ArrayList<String>();
        }
        return this.conditionCloseBracketList;
    }

    /**
     * Gets the value of the pathList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pathList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPathList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPathList() {
        if (pathList == null) {
            pathList = new ArrayList<String>();
        }
        return this.pathList;
    }

    /**
     * Gets the value of the colNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getColNames() {
        if (colNames == null) {
            colNames = new ArrayList<String>();
        }
        return this.colNames;
    }

    /**
     * Gets the value of the facets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the facets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFacets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFacets() {
        if (facets == null) {
            facets = new ArrayList<String>();
        }
        return this.facets;
    }

    /**
     * Gets the value of the objectId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * Sets the value of the objectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectId(String value) {
        this.objectId = value;
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
     * Gets the value of the fullTextCondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullTextCondition() {
        return fullTextCondition;
    }

    /**
     * Sets the value of the fullTextCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullTextCondition(String value) {
        this.fullTextCondition = value;
    }

    /**
     * Gets the value of the fullTextOperator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullTextOperator() {
        return fullTextOperator;
    }

    /**
     * Sets the value of the fullTextOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullTextOperator(String value) {
        this.fullTextOperator = value;
    }

    /**
     * Gets the value of the fullTextWords property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullTextWords() {
        return fullTextWords;
    }

    /**
     * Sets the value of the fullTextWords property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullTextWords(String value) {
        this.fullTextWords = value;
    }

    /**
     * Gets the value of the descend property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDescend() {
        return descend;
    }

    /**
     * Sets the value of the descend property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDescend(Boolean value) {
        this.descend = value;
    }

    /**
     * Gets the value of the orderBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * Sets the value of the orderBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderBy(String value) {
        this.orderBy = value;
    }

    /**
     * Gets the value of the orderByDirection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderByDirection() {
        return orderByDirection;
    }

    /**
     * Sets the value of the orderByDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderByDirection(String value) {
        this.orderByDirection = value;
    }

}
