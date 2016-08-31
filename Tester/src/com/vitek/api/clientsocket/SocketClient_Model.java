package com.vitek.api.clientsocket;

public class SocketClient_Model
{
  StringBuffer dataIn = null;
  boolean isReady = false;
  String errorOutput = "";
  String dataOut = "";
  String host = "";
  int port = 0;
  
  public void setDataIn(String data) { dataIn.append(data); }
  public StringBuffer getDataIn() { return dataIn; }
  
  public void setIsReady(boolean connection) { isReady = connection; }
  public boolean getIsReady() { return isReady; }

  public void setErrorOutput(String errorString){ errorOutput = errorString; }
  public String getErrorOutput(){ return errorOutput; }
  
  public void setDataOut(String data) { dataOut = data; }
  public String getDataOut() { return dataOut; }
  
  public void setHost(String hostname) { host = hostname; }
  public String getHost() { return host; }
  
  public void setPort(int portNumber) { port = portNumber; }
  public int getPort() { return port; }
}
