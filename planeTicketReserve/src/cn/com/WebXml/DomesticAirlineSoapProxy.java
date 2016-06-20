package cn.com.WebXml;

public class DomesticAirlineSoapProxy implements cn.com.WebXml.DomesticAirlineSoap {
  private String _endpoint = null;
  private cn.com.WebXml.DomesticAirlineSoap domesticAirlineSoap = null;
  
  public DomesticAirlineSoapProxy() {
    _initDomesticAirlineSoapProxy();
  }
  
  public DomesticAirlineSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initDomesticAirlineSoapProxy();
  }
  
  private void _initDomesticAirlineSoapProxy() {
    try {
      domesticAirlineSoap = (new cn.com.WebXml.DomesticAirlineLocator()).getDomesticAirlineSoap();
      if (domesticAirlineSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)domesticAirlineSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)domesticAirlineSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (domesticAirlineSoap != null)
      ((javax.xml.rpc.Stub)domesticAirlineSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.com.WebXml.DomesticAirlineSoap getDomesticAirlineSoap() {
    if (domesticAirlineSoap == null)
      _initDomesticAirlineSoapProxy();
    return domesticAirlineSoap;
  }
  
  public cn.com.WebXml.GetDomesticCityResponseGetDomesticCityResult getDomesticCity() throws java.rmi.RemoteException{
    if (domesticAirlineSoap == null)
      _initDomesticAirlineSoapProxy();
    return domesticAirlineSoap.getDomesticCity();
  }
  
  public cn.com.WebXml.GetDomesticAirlinesTimeResponseGetDomesticAirlinesTimeResult getDomesticAirlinesTime(java.lang.String startCity, java.lang.String lastCity, java.lang.String theDate, java.lang.String userID) throws java.rmi.RemoteException{
    if (domesticAirlineSoap == null)
      _initDomesticAirlineSoapProxy();
    return domesticAirlineSoap.getDomesticAirlinesTime(startCity, lastCity, theDate, userID);
  }
  
  
}