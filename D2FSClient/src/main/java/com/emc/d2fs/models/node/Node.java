
package com.emc.d2fs.models.node;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.attribute.Attribute;
import com.emc.d2fs.models.rendering_options.RenderingOption;


/**
 * <p>Java class for node complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="node"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.emc.com/d2fs/models/node}nodes" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.emc.com/d2fs/models/attribute}attributes" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.emc.com/d2fs/models/node}attributeOptions" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.emc.com/d2fs/models/rendering_options}rendering_options" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://www.emc.com/d2fs/models/common}id use="required""/&gt;
 *       &lt;attribute name="label" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="icon" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="locked" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="immutable" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="children" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="pathId" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="facetCountInfo" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="facetSelectAt" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="facetLevel" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "node", propOrder = {
    "nodes",
    "attributes",
    "attributeOptions",
    "renderingOptions"
})
public class Node {

    protected List<Node> nodes;
    @XmlElement(namespace = "http://www.emc.com/d2fs/models/attribute")
    protected List<Attribute> attributes;
    protected List<AttributeOptions> attributeOptions;
    @XmlElement(name = "rendering_options", namespace = "http://www.emc.com/d2fs/models/rendering_options")
    protected List<RenderingOption> renderingOptions;
    @XmlAttribute(name = "id", namespace = "http://www.emc.com/d2fs/models/common", required = true)
    protected String id;
    @XmlAttribute(name = "label", required = true)
    protected String label;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "icon")
    protected String icon;
    @XmlAttribute(name = "locked")
    protected String locked;
    @XmlAttribute(name = "immutable")
    protected Boolean immutable;
    @XmlAttribute(name = "children")
    protected Boolean children;
    @XmlAttribute(name = "pathId")
    protected String pathId;
    @XmlAttribute(name = "facetCountInfo")
    protected String facetCountInfo;
    @XmlAttribute(name = "facetSelectAt")
    protected Integer facetSelectAt;
    @XmlAttribute(name = "facetLevel")
    protected Integer facetLevel;

    /**
     * Gets the value of the nodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Node }
     * 
     * 
     */
    public List<Node> getNodes() {
        if (nodes == null) {
            nodes = new ArrayList<Node>();
        }
        return this.nodes;
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
     * Gets the value of the attributeOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributeOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttributeOptions }
     * 
     * 
     */
    public List<AttributeOptions> getAttributeOptions() {
        if (attributeOptions == null) {
            attributeOptions = new ArrayList<AttributeOptions>();
        }
        return this.attributeOptions;
    }

    /**
     * Gets the value of the renderingOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the renderingOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRenderingOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RenderingOption }
     * 
     * 
     */
    public List<RenderingOption> getRenderingOptions() {
        if (renderingOptions == null) {
            renderingOptions = new ArrayList<RenderingOption>();
        }
        return this.renderingOptions;
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
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the icon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcon(String value) {
        this.icon = value;
    }

    /**
     * Gets the value of the locked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocked() {
        return locked;
    }

    /**
     * Sets the value of the locked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocked(String value) {
        this.locked = value;
    }

    /**
     * Gets the value of the immutable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isImmutable() {
        return immutable;
    }

    /**
     * Sets the value of the immutable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setImmutable(Boolean value) {
        this.immutable = value;
    }

    /**
     * Gets the value of the children property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChildren() {
        return children;
    }

    /**
     * Sets the value of the children property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChildren(Boolean value) {
        this.children = value;
    }

    /**
     * Gets the value of the pathId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathId() {
        return pathId;
    }

    /**
     * Sets the value of the pathId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathId(String value) {
        this.pathId = value;
    }

    /**
     * Gets the value of the facetCountInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacetCountInfo() {
        return facetCountInfo;
    }

    /**
     * Sets the value of the facetCountInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacetCountInfo(String value) {
        this.facetCountInfo = value;
    }

    /**
     * Gets the value of the facetSelectAt property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFacetSelectAt() {
        return facetSelectAt;
    }

    /**
     * Sets the value of the facetSelectAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFacetSelectAt(Integer value) {
        this.facetSelectAt = value;
    }

    /**
     * Gets the value of the facetLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFacetLevel() {
        return facetLevel;
    }

    /**
     * Sets the value of the facetLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFacetLevel(Integer value) {
        this.facetLevel = value;
    }

}
