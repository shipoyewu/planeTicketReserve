/**
 * GetDomesticAirlinesTimeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.WebXml;

public class GetDomesticAirlinesTimeResponse  implements java.io.Serializable {
    private cn.com.WebXml.GetDomesticAirlinesTimeResponseGetDomesticAirlinesTimeResult getDomesticAirlinesTimeResult;

    public GetDomesticAirlinesTimeResponse() {
    }

    public GetDomesticAirlinesTimeResponse(
           cn.com.WebXml.GetDomesticAirlinesTimeResponseGetDomesticAirlinesTimeResult getDomesticAirlinesTimeResult) {
           this.getDomesticAirlinesTimeResult = getDomesticAirlinesTimeResult;
    }


    /**
     * Gets the getDomesticAirlinesTimeResult value for this GetDomesticAirlinesTimeResponse.
     * 
     * @return getDomesticAirlinesTimeResult
     */
    public cn.com.WebXml.GetDomesticAirlinesTimeResponseGetDomesticAirlinesTimeResult getGetDomesticAirlinesTimeResult() {
        return getDomesticAirlinesTimeResult;
    }


    /**
     * Sets the getDomesticAirlinesTimeResult value for this GetDomesticAirlinesTimeResponse.
     * 
     * @param getDomesticAirlinesTimeResult
     */
    public void setGetDomesticAirlinesTimeResult(cn.com.WebXml.GetDomesticAirlinesTimeResponseGetDomesticAirlinesTimeResult getDomesticAirlinesTimeResult) {
        this.getDomesticAirlinesTimeResult = getDomesticAirlinesTimeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDomesticAirlinesTimeResponse)) return false;
        GetDomesticAirlinesTimeResponse other = (GetDomesticAirlinesTimeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getDomesticAirlinesTimeResult==null && other.getGetDomesticAirlinesTimeResult()==null) || 
             (this.getDomesticAirlinesTimeResult!=null &&
              this.getDomesticAirlinesTimeResult.equals(other.getGetDomesticAirlinesTimeResult())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getGetDomesticAirlinesTimeResult() != null) {
            _hashCode += getGetDomesticAirlinesTimeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDomesticAirlinesTimeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://WebXml.com.cn/", ">getDomesticAirlinesTimeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getDomesticAirlinesTimeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://WebXml.com.cn/", "getDomesticAirlinesTimeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://WebXml.com.cn/", ">>getDomesticAirlinesTimeResponse>getDomesticAirlinesTimeResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
