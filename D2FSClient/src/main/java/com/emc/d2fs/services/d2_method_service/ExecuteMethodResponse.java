
package com.emc.d2fs.services.d2_method_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.method_result.MethodResult;


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
 *         &lt;element ref="{http://www.emc.com/d2fs/models/method_result}method_result"/&gt;
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
    "methodResult"
})
@XmlRootElement(name = "executeMethodResponse")
public class ExecuteMethodResponse {

    @XmlElement(name = "method_result", namespace = "http://www.emc.com/d2fs/models/method_result", required = true)
    protected MethodResult methodResult;

    /**
     * Gets the value of the methodResult property.
     * 
     * @return
     *     possible object is
     *     {@link MethodResult }
     *     
     */
    public MethodResult getMethodResult() {
        return methodResult;
    }

    /**
     * Sets the value of the methodResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link MethodResult }
     *     
     */
    public void setMethodResult(MethodResult value) {
        this.methodResult = value;
    }

}
