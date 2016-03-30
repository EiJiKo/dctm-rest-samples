
package com.emc.d2fs.services.d2_pdfrender_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.pdfrender_result.PdfQueueResult;


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
 *         &lt;element ref="{http://www.emc.com/d2fs/models/pdfrender_result}pdfQueue_result"/&gt;
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
    "pdfQueueResult"
})
@XmlRootElement(name = "queuePdfRenderResponse")
public class QueuePdfRenderResponse {

    @XmlElement(name = "pdfQueue_result", namespace = "http://www.emc.com/d2fs/models/pdfrender_result", required = true)
    protected PdfQueueResult pdfQueueResult;

    /**
     * Gets the value of the pdfQueueResult property.
     * 
     * @return
     *     possible object is
     *     {@link PdfQueueResult }
     *     
     */
    public PdfQueueResult getPdfQueueResult() {
        return pdfQueueResult;
    }

    /**
     * Sets the value of the pdfQueueResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PdfQueueResult }
     *     
     */
    public void setPdfQueueResult(PdfQueueResult value) {
        this.pdfQueueResult = value;
    }

}
