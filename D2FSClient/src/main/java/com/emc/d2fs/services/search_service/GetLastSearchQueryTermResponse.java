
package com.emc.d2fs.services.search_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.search_query_term.SearchQueryTerm;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="searchQueryTerm" type="{http://www.emc.com/d2fs/models/search_query_term}search_query_term" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "getLastSearchQueryTermResponse")
public class GetLastSearchQueryTermResponse {

    protected SearchQueryTerm searchQueryTerm;

    /**
     * Gets the value of the searchQueryTerm property.
     * 
     * @return
     *     possible object is
     *     {@link SearchQueryTerm }
     *     
     */
    public SearchQueryTerm getSearchQueryTerm() {
        return searchQueryTerm;
    }

    /**
     * Sets the value of the searchQueryTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchQueryTerm }
     *     
     */
    public void setSearchQueryTerm(SearchQueryTerm value) {
        this.searchQueryTerm = value;
    }

}
