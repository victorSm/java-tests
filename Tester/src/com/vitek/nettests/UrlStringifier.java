package com.vitek.nettests;

import com.vitek.stringtest.StringParser;
import java.io.*;
import java.net.*;

public class UrlStringifier
{
  
  String urlString = "";
  String url = "";
  
  public String getUrl(){ return url; }
  public void setUrl(String u){ url = u; }
  
  public String getUrlString(){ return urlString; }
  public void setUrlString(String string){ urlString = string; }
  
  
  public String urlStringify()
  {
    try
    {
      URL testUrl = new URL(this.getUrl());
      BufferedReader in = new BufferedReader(new InputStreamReader(testUrl.openStream()));
      StringBuffer Buffer = new StringBuffer();
      StringParser p = new StringParser();
      
      String inputLine;
      while ((inputLine = in.readLine()) !=null)
      {
        System.out.println(inputLine+"\r\n");
        Buffer.append(inputLine+"\r\n");
        
        
      }
//      setUrlString(Buffer.toString());
      String Utf8UrlString = new String(Buffer.toString().getBytes("UTF8"), "UTF8");
      setUrlString(Utf8UrlString);
      in.close();

      System.out.println("\r\nProtocol:  "+testUrl.getProtocol());
      System.out.println("Authority: "+testUrl.getAuthority());
      System.out.println("Host: "+testUrl.getHost());
      System.out.println("Port: "+testUrl.getPort());
     
    }
    catch (MalformedURLException e)
    {
      System.out.println("Network Error: "+e.getMessage());
    }
    catch (IOException ioe)
    {
      System.out.println("Stream Error: "+ioe.getMessage());
    }
    return urlString;
  }
  
}
