
package com.emc.d2fs.models.comment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for comment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="comment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.emc.com/d2fs/models/comment}comments" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://www.emc.com/d2fs/models/common}id use="required""/&gt;
 *       &lt;attribute name="comment_id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="owner_name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="modify_date" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="content_value" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="parent_id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="title" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="canDelete" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="canReply" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comment", propOrder = {
    "comments"
})
public class Comment {

    protected List<Comment> comments;
    @XmlAttribute(name = "id", namespace = "http://www.emc.com/d2fs/models/common", required = true)
    protected String id;
    @XmlAttribute(name = "comment_id")
    protected String commentId;
    @XmlAttribute(name = "owner_name")
    protected String ownerName;
    @XmlAttribute(name = "modify_date")
    protected String modifyDate;
    @XmlAttribute(name = "content_value")
    protected String contentValue;
    @XmlAttribute(name = "parent_id")
    protected String parentId;
    @XmlAttribute(name = "title")
    protected String title;
    @XmlAttribute(name = "canDelete")
    protected Boolean canDelete;
    @XmlAttribute(name = "canReply")
    protected Boolean canReply;

    /**
     * Gets the value of the comments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Comment }
     * 
     * 
     */
    public List<Comment> getComments() {
        if (comments == null) {
            comments = new ArrayList<Comment>();
        }
        return this.comments;
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
     * Gets the value of the commentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     * Sets the value of the commentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentId(String value) {
        this.commentId = value;
    }

    /**
     * Gets the value of the ownerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Sets the value of the ownerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerName(String value) {
        this.ownerName = value;
    }

    /**
     * Gets the value of the modifyDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModifyDate() {
        return modifyDate;
    }

    /**
     * Sets the value of the modifyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifyDate(String value) {
        this.modifyDate = value;
    }

    /**
     * Gets the value of the contentValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentValue() {
        return contentValue;
    }

    /**
     * Sets the value of the contentValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentValue(String value) {
        this.contentValue = value;
    }

    /**
     * Gets the value of the parentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * Sets the value of the parentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentId(String value) {
        this.parentId = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the canDelete property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanDelete() {
        return canDelete;
    }

    /**
     * Sets the value of the canDelete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanDelete(Boolean value) {
        this.canDelete = value;
    }

    /**
     * Gets the value of the canReply property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanReply() {
        return canReply;
    }

    /**
     * Sets the value of the canReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanReply(Boolean value) {
        this.canReply = value;
    }

}
