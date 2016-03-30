
package com.emc.d2fs.models.x3_skin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.common.DataHandler;


/**
 * <p>Java class for x3_skin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="x3_skin"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="skinHeaderLogo" type="{http://www.emc.com/d2fs/models/common}dataHandler" minOccurs="0"/&gt;
 *         &lt;element name="skinBackgroundTexture" type="{http://www.emc.com/d2fs/models/common}dataHandler" minOccurs="0"/&gt;
 *         &lt;element name="thumbnailGraphicRules" type="{http://www.emc.com/d2fs/models/x3_skin}x3_graphic_css_rule" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="iconGraphicRules" type="{http://www.emc.com/d2fs/models/x3_skin}x3_graphic_css_rule" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="attributeGraphicRules" type="{http://www.emc.com/d2fs/models/x3_skin}x3_graphic_css_rule" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="skinName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinLabel" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinHeaderColor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinSpaceTitleColor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinSpaceBorderColor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinTabColoredText" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="skinTabActiveColor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinTabInactiveColor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinTabBorderColor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinBackgroundColorType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinBackgroundColor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinBackgroundGradientStart" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinBackgroundGradientEnd" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinSelectionColor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinSelectionBlurColor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinDialogBackgroundWhite" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="skinTabTextActive" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinTabTextInactive" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinMenuTextColor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="skinMenuHoverColor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "x3_skin", propOrder = {
    "skinHeaderLogo",
    "skinBackgroundTexture",
    "thumbnailGraphicRules",
    "iconGraphicRules",
    "attributeGraphicRules"
})
public class X3Skin {

    protected DataHandler skinHeaderLogo;
    protected DataHandler skinBackgroundTexture;
    protected List<X3GraphicCssRule> thumbnailGraphicRules;
    protected List<X3GraphicCssRule> iconGraphicRules;
    protected List<X3GraphicCssRule> attributeGraphicRules;
    @XmlAttribute(name = "skinName", required = true)
    protected String skinName;
    @XmlAttribute(name = "skinLabel", required = true)
    protected String skinLabel;
    @XmlAttribute(name = "skinHeaderColor")
    protected String skinHeaderColor;
    @XmlAttribute(name = "skinSpaceTitleColor")
    protected String skinSpaceTitleColor;
    @XmlAttribute(name = "skinSpaceBorderColor")
    protected String skinSpaceBorderColor;
    @XmlAttribute(name = "skinTabColoredText")
    protected Boolean skinTabColoredText;
    @XmlAttribute(name = "skinTabActiveColor")
    protected String skinTabActiveColor;
    @XmlAttribute(name = "skinTabInactiveColor")
    protected String skinTabInactiveColor;
    @XmlAttribute(name = "skinTabBorderColor")
    protected String skinTabBorderColor;
    @XmlAttribute(name = "skinBackgroundColorType")
    protected String skinBackgroundColorType;
    @XmlAttribute(name = "skinBackgroundColor")
    protected String skinBackgroundColor;
    @XmlAttribute(name = "skinBackgroundGradientStart")
    protected String skinBackgroundGradientStart;
    @XmlAttribute(name = "skinBackgroundGradientEnd")
    protected String skinBackgroundGradientEnd;
    @XmlAttribute(name = "skinSelectionColor")
    protected String skinSelectionColor;
    @XmlAttribute(name = "skinSelectionBlurColor")
    protected String skinSelectionBlurColor;
    @XmlAttribute(name = "skinDialogBackgroundWhite")
    protected Boolean skinDialogBackgroundWhite;
    @XmlAttribute(name = "skinTabTextActive")
    protected String skinTabTextActive;
    @XmlAttribute(name = "skinTabTextInactive")
    protected String skinTabTextInactive;
    @XmlAttribute(name = "skinMenuTextColor")
    protected String skinMenuTextColor;
    @XmlAttribute(name = "skinMenuHoverColor")
    protected String skinMenuHoverColor;

    /**
     * Gets the value of the skinHeaderLogo property.
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getSkinHeaderLogo() {
        return skinHeaderLogo;
    }

    /**
     * Sets the value of the skinHeaderLogo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setSkinHeaderLogo(DataHandler value) {
        this.skinHeaderLogo = value;
    }

    /**
     * Gets the value of the skinBackgroundTexture property.
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getSkinBackgroundTexture() {
        return skinBackgroundTexture;
    }

    /**
     * Sets the value of the skinBackgroundTexture property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setSkinBackgroundTexture(DataHandler value) {
        this.skinBackgroundTexture = value;
    }

    /**
     * Gets the value of the thumbnailGraphicRules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thumbnailGraphicRules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThumbnailGraphicRules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link X3GraphicCssRule }
     * 
     * 
     */
    public List<X3GraphicCssRule> getThumbnailGraphicRules() {
        if (thumbnailGraphicRules == null) {
            thumbnailGraphicRules = new ArrayList<X3GraphicCssRule>();
        }
        return this.thumbnailGraphicRules;
    }

    /**
     * Gets the value of the iconGraphicRules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iconGraphicRules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIconGraphicRules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link X3GraphicCssRule }
     * 
     * 
     */
    public List<X3GraphicCssRule> getIconGraphicRules() {
        if (iconGraphicRules == null) {
            iconGraphicRules = new ArrayList<X3GraphicCssRule>();
        }
        return this.iconGraphicRules;
    }

    /**
     * Gets the value of the attributeGraphicRules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributeGraphicRules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeGraphicRules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link X3GraphicCssRule }
     * 
     * 
     */
    public List<X3GraphicCssRule> getAttributeGraphicRules() {
        if (attributeGraphicRules == null) {
            attributeGraphicRules = new ArrayList<X3GraphicCssRule>();
        }
        return this.attributeGraphicRules;
    }

    /**
     * Gets the value of the skinName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinName() {
        return skinName;
    }

    /**
     * Sets the value of the skinName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinName(String value) {
        this.skinName = value;
    }

    /**
     * Gets the value of the skinLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinLabel() {
        return skinLabel;
    }

    /**
     * Sets the value of the skinLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinLabel(String value) {
        this.skinLabel = value;
    }

    /**
     * Gets the value of the skinHeaderColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinHeaderColor() {
        return skinHeaderColor;
    }

    /**
     * Sets the value of the skinHeaderColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinHeaderColor(String value) {
        this.skinHeaderColor = value;
    }

    /**
     * Gets the value of the skinSpaceTitleColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinSpaceTitleColor() {
        return skinSpaceTitleColor;
    }

    /**
     * Sets the value of the skinSpaceTitleColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinSpaceTitleColor(String value) {
        this.skinSpaceTitleColor = value;
    }

    /**
     * Gets the value of the skinSpaceBorderColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinSpaceBorderColor() {
        return skinSpaceBorderColor;
    }

    /**
     * Sets the value of the skinSpaceBorderColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinSpaceBorderColor(String value) {
        this.skinSpaceBorderColor = value;
    }

    /**
     * Gets the value of the skinTabColoredText property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkinTabColoredText() {
        return skinTabColoredText;
    }

    /**
     * Sets the value of the skinTabColoredText property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkinTabColoredText(Boolean value) {
        this.skinTabColoredText = value;
    }

    /**
     * Gets the value of the skinTabActiveColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinTabActiveColor() {
        return skinTabActiveColor;
    }

    /**
     * Sets the value of the skinTabActiveColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinTabActiveColor(String value) {
        this.skinTabActiveColor = value;
    }

    /**
     * Gets the value of the skinTabInactiveColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinTabInactiveColor() {
        return skinTabInactiveColor;
    }

    /**
     * Sets the value of the skinTabInactiveColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinTabInactiveColor(String value) {
        this.skinTabInactiveColor = value;
    }

    /**
     * Gets the value of the skinTabBorderColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinTabBorderColor() {
        return skinTabBorderColor;
    }

    /**
     * Sets the value of the skinTabBorderColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinTabBorderColor(String value) {
        this.skinTabBorderColor = value;
    }

    /**
     * Gets the value of the skinBackgroundColorType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinBackgroundColorType() {
        return skinBackgroundColorType;
    }

    /**
     * Sets the value of the skinBackgroundColorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinBackgroundColorType(String value) {
        this.skinBackgroundColorType = value;
    }

    /**
     * Gets the value of the skinBackgroundColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinBackgroundColor() {
        return skinBackgroundColor;
    }

    /**
     * Sets the value of the skinBackgroundColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinBackgroundColor(String value) {
        this.skinBackgroundColor = value;
    }

    /**
     * Gets the value of the skinBackgroundGradientStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinBackgroundGradientStart() {
        return skinBackgroundGradientStart;
    }

    /**
     * Sets the value of the skinBackgroundGradientStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinBackgroundGradientStart(String value) {
        this.skinBackgroundGradientStart = value;
    }

    /**
     * Gets the value of the skinBackgroundGradientEnd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinBackgroundGradientEnd() {
        return skinBackgroundGradientEnd;
    }

    /**
     * Sets the value of the skinBackgroundGradientEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinBackgroundGradientEnd(String value) {
        this.skinBackgroundGradientEnd = value;
    }

    /**
     * Gets the value of the skinSelectionColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinSelectionColor() {
        return skinSelectionColor;
    }

    /**
     * Sets the value of the skinSelectionColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinSelectionColor(String value) {
        this.skinSelectionColor = value;
    }

    /**
     * Gets the value of the skinSelectionBlurColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinSelectionBlurColor() {
        return skinSelectionBlurColor;
    }

    /**
     * Sets the value of the skinSelectionBlurColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinSelectionBlurColor(String value) {
        this.skinSelectionBlurColor = value;
    }

    /**
     * Gets the value of the skinDialogBackgroundWhite property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkinDialogBackgroundWhite() {
        return skinDialogBackgroundWhite;
    }

    /**
     * Sets the value of the skinDialogBackgroundWhite property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkinDialogBackgroundWhite(Boolean value) {
        this.skinDialogBackgroundWhite = value;
    }

    /**
     * Gets the value of the skinTabTextActive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinTabTextActive() {
        return skinTabTextActive;
    }

    /**
     * Sets the value of the skinTabTextActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinTabTextActive(String value) {
        this.skinTabTextActive = value;
    }

    /**
     * Gets the value of the skinTabTextInactive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinTabTextInactive() {
        return skinTabTextInactive;
    }

    /**
     * Sets the value of the skinTabTextInactive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinTabTextInactive(String value) {
        this.skinTabTextInactive = value;
    }

    /**
     * Gets the value of the skinMenuTextColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinMenuTextColor() {
        return skinMenuTextColor;
    }

    /**
     * Sets the value of the skinMenuTextColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinMenuTextColor(String value) {
        this.skinMenuTextColor = value;
    }

    /**
     * Gets the value of the skinMenuHoverColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkinMenuHoverColor() {
        return skinMenuHoverColor;
    }

    /**
     * Sets the value of the skinMenuHoverColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkinMenuHoverColor(String value) {
        this.skinMenuHoverColor = value;
    }

}
