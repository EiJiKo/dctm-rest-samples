
package com.emc.d2fs.services.creation_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.structure.ConvertStructureConfig;


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
 *         &lt;element ref="{http://www.emc.com/d2fs/models/structure}convert_structure_config"/&gt;
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
    "convertStructureConfig"
})
@XmlRootElement(name = "getConvertStructureConfigResponse")
public class GetConvertStructureConfigResponse {

    @XmlElement(name = "convert_structure_config", namespace = "http://www.emc.com/d2fs/models/structure", required = true)
    protected ConvertStructureConfig convertStructureConfig;

    /**
     * Gets the value of the convertStructureConfig property.
     * 
     * @return
     *     possible object is
     *     {@link ConvertStructureConfig }
     *     
     */
    public ConvertStructureConfig getConvertStructureConfig() {
        return convertStructureConfig;
    }

    /**
     * Sets the value of the convertStructureConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConvertStructureConfig }
     *     
     */
    public void setConvertStructureConfig(ConvertStructureConfig value) {
        this.convertStructureConfig = value;
    }

}
