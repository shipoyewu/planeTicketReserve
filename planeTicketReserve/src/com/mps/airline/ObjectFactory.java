
package com.mps.airline;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the airportscheduleint package. 
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

    private final static QName _DataSet_QNAME = new QName("http://WebXml.com.cn/", "DataSet");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: airportscheduleint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDomesticCityResponse }
     * 
     */
    public GetDomesticCityResponse createGetDomesticCityResponse() {
        return new GetDomesticCityResponse();
    }

    /**
     * Create an instance of {@link GetDomesticAirlinesTimeResponse }
     * 
     */
    public GetDomesticAirlinesTimeResponse createGetDomesticAirlinesTimeResponse() {
        return new GetDomesticAirlinesTimeResponse();
    }

    /**
     * Create an instance of {@link GetDomesticCity }
     * 
     */
    public GetDomesticCity createGetDomesticCity() {
        return new GetDomesticCity();
    }

    /**
     * Create an instance of {@link GetDomesticAirlinesTime }
     * 
     */
    public GetDomesticAirlinesTime createGetDomesticAirlinesTime() {
        return new GetDomesticAirlinesTime();
    }

    /**
     * Create an instance of {@link DataSet }
     * 
     */
    public DataSet createDataSet() {
        return new DataSet();
    }

    /**
     * Create an instance of {@link GetDomesticCityResponse.GetDomesticCityResult }
     * 
     */
    public GetDomesticCityResponse.GetDomesticCityResult createGetDomesticCityResponseGetDomesticCityResult() {
        return new GetDomesticCityResponse.GetDomesticCityResult();
    }

    /**
     * Create an instance of {@link GetDomesticAirlinesTimeResponse.GetDomesticAirlinesTimeResult }
     * 
     */
    public GetDomesticAirlinesTimeResponse.GetDomesticAirlinesTimeResult createGetDomesticAirlinesTimeResponseGetDomesticAirlinesTimeResult() {
        return new GetDomesticAirlinesTimeResponse.GetDomesticAirlinesTimeResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebXml.com.cn/", name = "DataSet")
    public JAXBElement<DataSet> createDataSet(DataSet value) {
        return new JAXBElement<DataSet>(_DataSet_QNAME, DataSet.class, null, value);
    }

}
