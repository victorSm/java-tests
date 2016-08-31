package com.vitek.nettests;

import com.vitek.stringtest.StringParser;
import java.net.*;
import java.io.*;

public class URL_Test
{
  
  public static void main(String[] args)
  {
    try
    {
      URL testUrl = new URL("http://spauserlist.texaspowertrain.com");
      BufferedReader in = new BufferedReader(new InputStreamReader(testUrl.openStream()));
      StringBuffer Buffer = new StringBuffer();
      StringParser p = new StringParser();
      
      String inputLine;
      while ((inputLine = in.readLine()) !=null)
      {
        System.out.println(inputLine+"\r\n");
        Buffer.append(inputLine);
        
        p.parseInput(inputLine);
        
      }
      in.close();
      System.out.println("\r\nProtocol:  "+testUrl.getProtocol());
      System.out.println("Authority: "+testUrl.getAuthority());
      System.out.println("Host: "+testUrl.getHost());
      System.out.println("Port: "+testUrl.getPort());
    }
    catch (MalformedURLException e)
    {
      System.out.println("Network Error: "+e.getLocalizedMessage());
    }
    catch (IOException e)
    {
      System.out.println("Stream Error: "+e.getMessage());
    }
  }
}