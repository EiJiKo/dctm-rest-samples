
package com.emc.d2fs.models.repository;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.repository package. 
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

    private final static QName _Repositories_QNAME = new QName("http://www.emc.com/d2fs/models/repository", "repositories");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.repository
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Repository }
     * 
     */
    public Repository createRepository() {
        return new Repository();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Repository }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/repository", name = "repositories")
    public JAXBElement<Repository> createRepositories(Repository value) {
        return new JAXBElement<Repository>(_Repositories_QNAME, Repository.class, null, value);
    }

}
