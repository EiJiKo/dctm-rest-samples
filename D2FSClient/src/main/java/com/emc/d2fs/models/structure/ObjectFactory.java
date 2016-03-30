
package com.emc.d2fs.models.structure;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.models.structure package. 
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

    private final static QName _ImportStructureConfigs_QNAME = new QName("http://www.emc.com/d2fs/models/structure", "import_structure_configs");
    private final static QName _ConvertStructureConfig_QNAME = new QName("http://www.emc.com/d2fs/models/structure", "convert_structure_config");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.models.structure
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ImportStructureConfig }
     * 
     */
    public ImportStructureConfig createImportStructureConfig() {
        return new ImportStructureConfig();
    }

    /**
     * Create an instance of {@link ConvertStructureConfig }
     * 
     */
    public ConvertStructureConfig createConvertStructureConfig() {
        return new ConvertStructureConfig();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportStructureConfig }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/structure", name = "import_structure_configs")
    public JAXBElement<ImportStructureConfig> createImportStructureConfigs(ImportStructureConfig value) {
        return new JAXBElement<ImportStructureConfig>(_ImportStructureConfigs_QNAME, ImportStructureConfig.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertStructureConfig }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.emc.com/d2fs/models/structure", name = "convert_structure_config")
    public JAXBElement<ConvertStructureConfig> createConvertStructureConfig(ConvertStructureConfig value) {
        return new JAXBElement<ConvertStructureConfig>(_ConvertStructureConfig_QNAME, ConvertStructureConfig.class, null, value);
    }

}
