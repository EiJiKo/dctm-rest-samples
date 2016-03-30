
package com.emc.d2fs.models.taxonomy_operation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.taxonomy_operation package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Operations_QNAME = new QName("http://www.emc.com/d2fs/models/taxonomy_operation", "operations");
    private final static QName _Results_QNAME = new QName("http://www.emc.com/d2fs/models/taxonomy_operation", "results");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.taxonomy_operation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TaxonomyOperation }
     * 
     */
    public TaxonomyOperation createTaxonomyOperation() {
        return new TaxonomyOperation();
    }

    /**
     * Create an instance of {@link TaxonomyOperationResult }
     * 
     */
    public TaxonomyOperationResult createTaxonomyOperationResult() {
        return new TaxonomyOperationResult();
    }

    /**
     * Create an instance of {@link GetTaxonomieContentRequest }
     * 
     */
    public GetTaxonomieContentRequest createGetTaxonomieContentRequest() {
        return new GetTaxonomieContentRequest();
    }

    /**
     * Create an instance of {@link GetTaxonomieContentResponse }
     * 
     */
    public GetTaxonomieContentResponse createGetTaxonomieContentResponse() {
        return new GetTaxonomieContentResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaxonomyOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/taxonomy_operation", name = "operations")
    public JAXBElement<TaxonomyOperation> createOperations(TaxonomyOperation value) {
        return new JAXBElement<TaxonomyOperation>(_Operations_QNAME, TaxonomyOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaxonomyOperationResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/taxonomy_operation", name = "results")
    public JAXBElement<TaxonomyOperationResult> createResults(TaxonomyOperationResult value) {
        return new JAXBElement<TaxonomyOperationResult>(_Results_QNAME, TaxonomyOperationResult.class, null, value);
    }

}
