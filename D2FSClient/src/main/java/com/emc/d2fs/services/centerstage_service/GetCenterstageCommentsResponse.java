
package com.emc.d2fs.services.centerstage_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.getcomments_result.GetCommentsResult;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.emc.com/d2fs/models/getcomments_result}getComments_result"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCommentsResult"
})
@XmlRootElement(name = "getCenterstageCommentsResponse")
public class GetCenterstageCommentsResponse {

    @XmlElement(name = "getComments_result", namespace = "http://www.emc.com/d2fs/models/getcomments_result", required = true)
    protected GetCommentsResult getCommentsResult;

    /**
     * Gets the value of the getCommentsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetCommentsResult }
     *     
     */
    public GetCommentsResult getGetCommentsResult() {
        return getCommentsResult;
    }

    /**
     * Sets the value of the getCommentsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCommentsResult }
     *     
     */
    public void setGetCommentsResult(GetCommentsResult value) {
        this.getCommentsResult = value;
    }

}
