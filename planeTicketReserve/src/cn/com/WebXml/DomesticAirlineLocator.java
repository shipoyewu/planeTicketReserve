/**
 * DomesticAirlineLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.WebXml;

public class DomesticAirlineLocator extends org.apache.axis.client.Service implements cn.com.WebXml.DomesticAirline {

/**
 * <a href="http://www.webxml.com.cn/" target="_blank">WebXml.com.cn</a>
 * <strong>国内飞机航班时刻表 WEB 服务</strong>提供：通过出发城市和到达城市查询飞机航班、出发和到达时间、飞行周期、航空公司、机型等信息。国内飞机航班时刻表
 * WEB 服务提供的飞机航班时刻表数据仅供参考，如有异议请以当地飞机场提供的讯息为准。</br>此国内飞机航班时刻表Web Services请不要用于任何商业目的，若有需要请<a
 * href="http://www.webxml.com.cn/zh_cn/contact_us.aspx" target="_blank">联系我们</a>，欢迎技术交流。
 * QQ：8409035<br /><strong>使用本站 WEB 服务请注明或链接本站：http://www.webxml.com.cn/
 * 感谢大家的支持</strong>！<br /><br />&nbsp;
 */

    public DomesticAirlineLocator() {
    }


    public DomesticAirlineLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DomesticAirlineLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DomesticAirlineSoap
    private java.lang.String DomesticAirlineSoap_address = "http://ws.webxml.com.cn/webservices/DomesticAirline.asmx";

    public java.lang.String getDomesticAirlineSoapAddress() {
        return DomesticAirlineSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DomesticAirlineSoapWSDDServiceName = "DomesticAirlineSoap";

    public java.lang.String getDomesticAirlineSoapWSDDServiceName() {
        return DomesticAirlineSoapWSDDServiceName;
    }

    public void setDomesticAirlineSoapWSDDServiceName(java.lang.String name) {
        DomesticAirlineSoapWSDDServiceName = name;
    }

    public cn.com.WebXml.DomesticAirlineSoap getDomesticAirlineSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DomesticAirlineSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDomesticAirlineSoap(endpoint);
    }

    public cn.com.WebXml.DomesticAirlineSoap getDomesticAirlineSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.WebXml.DomesticAirlineSoapStub _stub = new cn.com.WebXml.DomesticAirlineSoapStub(portAddress, this);
            _stub.setPortName(getDomesticAirlineSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDomesticAirlineSoapEndpointAddress(java.lang.String address) {
        DomesticAirlineSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.com.WebXml.DomesticAirlineSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.WebXml.DomesticAirlineSoapStub _stub = new cn.com.WebXml.DomesticAirlineSoapStub(new java.net.URL(DomesticAirlineSoap_address), this);
                _stub.setPortName(getDomesticAirlineSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("DomesticAirlineSoap".equals(inputPortName)) {
            return getDomesticAirlineSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://WebXml.com.cn/", "DomesticAirline");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://WebXml.com.cn/", "DomesticAirlineSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DomesticAirlineSoap".equals(portName)) {
            setDomesticAirlineSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
