
package com.emc.d2fs.models.x3_widget;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x3_widget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="x3_widget"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="widgetChannels" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="widgetParameters" type="{http://www.emc.com/d2fs/models/x3_widget}widgetParameter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="widgetId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="widgetType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="widgetLabel" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="widgetDescription" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="widgetPreviewData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" /&gt;
 *       &lt;attribute name="widgetPreviewDataString" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="widgetPreviewMime" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="widgetUrl" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="widgetIsOAJ" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "x3_widget", propOrder = {
    "widgetChannels",
    "widgetParameters"
})
public class X3Widget {

    protected List<String> widgetChannels;
    protected List<WidgetParameter> widgetParameters;
    @XmlAttribute(name = "widgetId", required = true)
    protected String widgetId;
    @XmlAttribute(name = "widgetType", required = true)
    protected String widgetType;
    @XmlAttribute(name = "widgetLabel")
    protected String widgetLabel;
    @XmlAttribute(name = "widgetDescription")
    protected String widgetDescription;
    @XmlAttribute(name = "widgetPreviewData")
    protected byte[] widgetPreviewData;
    @XmlAttribute(name = "widgetPreviewDataString")
    protected String widgetPreviewDataString;
    @XmlAttribute(name = "widgetPreviewMime")
    protected String widgetPreviewMime;
    @XmlAttribute(name = "widgetUrl")
    protected String widgetUrl;
    @XmlAttribute(name = "widgetIsOAJ")
    protected Boolean widgetIsOAJ;

    /**
     * Gets the value of the widgetChannels property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the widgetChannels property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWidgetChannels().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getWidgetChannels() {
        if (widgetChannels == null) {
            widgetChannels = new ArrayList<String>();
        }
        return this.widgetChannels;
    }

    /**
     * Gets the value of the widgetParameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the widgetParameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWidgetParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WidgetParameter }
     * 
     * 
     */
    public List<WidgetParameter> getWidgetParameters() {
        if (widgetParameters == null) {
            widgetParameters = new ArrayList<WidgetParameter>();
        }
        return this.widgetParameters;
    }

    /**
     * Gets the value of the widgetId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidgetId() {
        return widgetId;
    }

    /**
     * Sets the value of the widgetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidgetId(String value) {
        this.widgetId = value;
    }

    /**
     * Gets the value of the widgetType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidgetType() {
        return widgetType;
    }

    /**
     * Sets the value of the widgetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidgetType(String value) {
        this.widgetType = value;
    }

    /**
     * Gets the value of the widgetLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidgetLabel() {
        return widgetLabel;
    }

    /**
     * Sets the value of the widgetLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidgetLabel(String value) {
        this.widgetLabel = value;
    }

    /**
     * Gets the value of the widgetDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidgetDescription() {
        return widgetDescription;
    }

    /**
     * Sets the value of the widgetDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidgetDescription(String value) {
        this.widgetDescription = value;
    }

    /**
     * Gets the value of the widgetPreviewData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getWidgetPreviewData() {
        return widgetPreviewData;
    }

    /**
     * Sets the value of the widgetPreviewData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setWidgetPreviewData(byte[] value) {
        this.widgetPreviewData = value;
    }

    /**
     * Gets the value of the widgetPreviewDataString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidgetPreviewDataString() {
        return widgetPreviewDataString;
    }

    /**
     * Sets the value of the widgetPreviewDataString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidgetPreviewDataString(String value) {
        this.widgetPreviewDataString = value;
    }

    /**
     * Gets the value of the widgetPreviewMime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidgetPreviewMime() {
        return widgetPreviewMime;
    }

    /**
     * Sets the value of the widgetPreviewMime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidgetPreviewMime(String value) {
        this.widgetPreviewMime = value;
    }

    /**
     * Gets the value of the widgetUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidgetUrl() {
        return widgetUrl;
    }

    /**
     * Sets the value of the widgetUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidgetUrl(String value) {
        this.widgetUrl = value;
    }

    /**
     * Gets the value of the widgetIsOAJ property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWidgetIsOAJ() {
        return widgetIsOAJ;
    }

    /**
     * Sets the value of the widgetIsOAJ property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWidgetIsOAJ(Boolean value) {
        this.widgetIsOAJ = value;
    }

}
