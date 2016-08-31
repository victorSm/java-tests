package com.vitek.nettests;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class SocketClient_Test
{
    public static void main(String[] args) throws IOException
    {
   
      String Sender = "389715";
      Socket sockClient = null;
      PrintWriter pw = null;
      
      String Host = "10.2.11.70";
      int Port = 51201;
      
      try
      {
        sockClient = new Socket(Host,Port);
        pw = new PrintWriter(sockClient.getOutputStream(), true);
        System.out.println("Socket Init, and data sent...."+Sender);
        pw.write(Sender);
      }
      catch(Exception e){System.out.println("Socket Connection Error..."+e.getMessage());}
      finally
      {
        pw.close();
        sockClient.close();
      }
    }
}
