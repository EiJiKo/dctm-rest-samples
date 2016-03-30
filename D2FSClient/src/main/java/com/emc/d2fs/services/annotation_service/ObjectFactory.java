
package com.emc.d2fs.services.annotation_service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.emc.d2fs.services.annotation_service package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.emc.d2fs.services.annotation_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetNativeAnnotationRequest }
     * 
     */
    public GetNativeAnnotationRequest createGetNativeAnnotationRequest() {
        return new GetNativeAnnotationRequest();
    }

    /**
     * Create an instance of {@link GetNativeAnnotationResponse }
     * 
     */
    public GetNativeAnnotationResponse createGetNativeAnnotationResponse() {
        return new GetNativeAnnotationResponse();
    }

    /**
     * Create an instance of {@link TestComparisonDirectionRequest }
     * 
     */
    public TestComparisonDirectionRequest createTestComparisonDirectionRequest() {
        return new TestComparisonDirectionRequest();
    }

    /**
     * Create an instance of {@link TestComparisonDirectionResponse }
     * 
     */
    public TestComparisonDirectionResponse createTestComparisonDirectionResponse() {
        return new TestComparisonDirectionResponse();
    }

    /**
     * Create an instance of {@link GetUserNativeAnnotationCheckoutIdsRequest }
     * 
     */
    public GetUserNativeAnnotationCheckoutIdsRequest createGetUserNativeAnnotationCheckoutIdsRequest() {
        return new GetUserNativeAnnotationCheckoutIdsRequest();
    }

    /**
     * Create an instance of {@link GetUserNativeAnnotationCheckoutIdsResponse }
     * 
     */
    public GetUserNativeAnnotationCheckoutIdsResponse createGetUserNativeAnnotationCheckoutIdsResponse() {
        return new GetUserNativeAnnotationCheckoutIdsResponse();
    }

    /**
     * Create an instance of {@link GetContentIdAndNativeAnnotationIdsRequest }
     * 
     */
    public GetContentIdAndNativeAnnotationIdsRequest createGetContentIdAndNativeAnnotationIdsRequest() {
        return new GetContentIdAndNativeAnnotationIdsRequest();
    }

    /**
     * Create an instance of {@link GetContentIdAndNativeAnnotationIdsResponse }
     * 
     */
    public GetContentIdAndNativeAnnotationIdsResponse createGetContentIdAndNativeAnnotationIdsResponse() {
        return new GetContentIdAndNativeAnnotationIdsResponse();
    }

}
