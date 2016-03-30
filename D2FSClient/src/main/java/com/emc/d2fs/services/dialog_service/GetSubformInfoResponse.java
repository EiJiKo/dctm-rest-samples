
package com.emc.d2fs.services.dialog_service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.subform_info.SubformInfo;


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
 *         &lt;element name="subforms" type="{http://www.emc.com/d2fs/models/subform_info}subform_info" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "subforms"
})
@XmlRootElement(name = "getSubformInfoResponse")
public class GetSubformInfoResponse {

    protected List<SubformInfo> subforms;

    /**
     * Gets the value of the subforms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subforms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubforms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubformInfo }
     * 
     * 
     */
    public List<SubformInfo> getSubforms() {
        if (subforms == null) {
            subforms = new ArrayList<SubformInfo>();
        }
        return this.subforms;
    }

}
