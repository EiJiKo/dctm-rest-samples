
package com.emc.d2fs.models.comment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.comment package. 
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

    private final static QName _Comments_QNAME = new QName("http://www.emc.com/d2fs/models/comment", "comments");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.comment
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Comment }
     * 
     */
    public Comment createComment() {
        return new Comment();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Comment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/comment", name = "comments")
    public JAXBElement<Comment> createComments(Comment value) {
        return new JAXBElement<Comment>(_Comments_QNAME, Comment.class, null, value);
    }

}
