
package com.emc.d2fs.services.d2_dictionary_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.w3._2005._05.xmlmime.Base64Binary;


/**
 * <p>Java class for MtomAttachmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MtomAttachmentType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;restriction base="&lt;http://www.w3.org/2005/05/xmlmime&gt;base64Binary"&gt;
 *       &lt;attribute ref="{http://www.w3.org/2005/05/xmlmime}contentType use="required""/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MtomAttachmentType")
public class MtomAttachmentType
    extends Base64Binary
{


}
