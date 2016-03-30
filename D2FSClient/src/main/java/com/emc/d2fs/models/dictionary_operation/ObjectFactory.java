
package com.emc.d2fs.models.dictionary_operation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.dictionary_operation package. 
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

    private final static QName _Operations_QNAME = new QName("http://www.emc.com/d2fs/models/dictionary_operation", "operations");
    private final static QName _Results_QNAME = new QName("http://www.emc.com/d2fs/models/dictionary_operation", "results");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.dictionary_operation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DictionaryOperation }
     * 
     */
    public DictionaryOperation createDictionaryOperation() {
        return new DictionaryOperation();
    }

    /**
     * Create an instance of {@link DictionaryOperationResult }
     * 
     */
    public DictionaryOperationResult createDictionaryOperationResult() {
        return new DictionaryOperationResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictionaryOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/dictionary_operation", name = "operations")
    public JAXBElement<DictionaryOperation> createOperations(DictionaryOperation value) {
        return new JAXBElement<DictionaryOperation>(_Operations_QNAME, DictionaryOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictionaryOperationResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/dictionary_operation", name = "results")
    public JAXBElement<DictionaryOperationResult> createResults(DictionaryOperationResult value) {
        return new JAXBElement<DictionaryOperationResult>(_Results_QNAME, DictionaryOperationResult.class, null, value);
    }

}
