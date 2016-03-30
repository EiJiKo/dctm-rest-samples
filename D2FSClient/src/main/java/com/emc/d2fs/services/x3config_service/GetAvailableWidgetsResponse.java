
package com.emc.d2fs.services.x3config_service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.x3_widget.X3Widget;


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
 *         &lt;element ref="{http://www.emc.com/d2fs/models/x3_widget}x3_widgets" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "x3Widgets"
})
@XmlRootElement(name = "getAvailableWidgetsResponse")
public class GetAvailableWidgetsResponse {

    @XmlElement(name = "x3_widgets", namespace = "http://www.emc.com/d2fs/models/x3_widget")
    protected List<X3Widget> x3Widgets;

    /**
     * Gets the value of the x3Widgets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the x3Widgets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getX3Widgets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link X3Widget }
     * 
     * 
     */
    public List<X3Widget> getX3Widgets() {
        if (x3Widgets == null) {
            x3Widgets = new ArrayList<X3Widget>();
        }
        return this.x3Widgets;
    }

}
