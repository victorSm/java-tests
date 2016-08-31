package com.vitek.nettests;

import com.vitek.stringtest.StringParser;
import java.net.URL;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

public class Ssl_URL_Test
{
  public static void main(String[] args) throws Exception
  {
    URL httpsURL = new URL("https://spaaccessmgr.texaspowertrain.com");
    HttpsURLConnection scon = (HttpsURLConnection)httpsURL.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(scon.getInputStream()));
    
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
    System.out.println("\r\nProtocol:  "+httpsURL.getProtocol());
    System.out.println("Authority: "+httpsURL.getAuthority());
    System.out.println("Host: "+httpsURL.getHost());
    System.out.println("Port: "+httpsURL.getPort());
  }
}
