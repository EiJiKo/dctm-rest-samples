
package com.emc.d2fs.services.d2_pdfrender_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.pdfrender_result.PdfRenderResult;


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
 *         &lt;element ref="{http://www.emc.com/d2fs/models/pdfrender_result}pdfRender_result"/&gt;
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
    "pdfRenderResult"
})
@XmlRootElement(name = "testPdfRenderResponse")
public class TestPdfRenderResponse {

    @XmlElement(name = "pdfRender_result", namespace = "http://www.emc.com/d2fs/models/pdfrender_result", required = true)
    protected PdfRenderResult pdfRenderResult;

    /**
     * Gets the value of the pdfRenderResult property.
     * 
     * @return
     *     possible object is
     *     {@link PdfRenderResult }
     *     
     */
    public PdfRenderResult getPdfRenderResult() {
        return pdfRenderResult;
    }

    /**
     * Sets the value of the pdfRenderResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PdfRenderResult }
     *     
     */
    public void setPdfRenderResult(PdfRenderResult value) {
        this.pdfRenderResult = value;
    }

}
