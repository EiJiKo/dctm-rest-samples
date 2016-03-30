
package com.emc.d2fs.models.filecontent;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.filecontent package. 
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

    private final static QName _FileContents_QNAME = new QName("http://www.emc.com/d2fs/models/filecontent", "fileContents");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.filecontent
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FileContent }
     * 
     */
    public FileContent createFileContent() {
        return new FileContent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileContent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/filecontent", name = "fileContents")
    public JAXBElement<FileContent> createFileContents(FileContent value) {
        return new JAXBElement<FileContent>(_FileContents_QNAME, FileContent.class, null, value);
    }

}
