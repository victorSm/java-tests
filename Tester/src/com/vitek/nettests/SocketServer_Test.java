package com.vitek.nettests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer_Test
{
  private static String input = "";
  private static String tester = "389715";
  private static boolean stringTest = false;
  
  public static String getInput() { return input; }
  
  public static boolean getResult() { return stringTest; }
  public static void setResult(boolean result) { stringTest = result; }
  
  public static void Test()
  {
    if(tester.equals(getInput()))
    {
      setResult(true);
    }
    else
    {
      setResult(false);
    }
    System.out.println("String comparison result is..."+getResult());
  }

  public static void main(String[] args) throws IOException
  {
   
    int Port = 51200;
    ServerSocket ServeSock = null;
    BufferedReader bufInput = null;
    
    while(true){
     try
      {      
       ServeSock = new ServerSocket(Port);
       Socket clientSock = ServeSock.accept();
       bufInput = new BufferedReader(new InputStreamReader(clientSock.getInputStream())); 
       while((input = bufInput.readLine()) !=null)
        {
          System.out.println("Socket input: "+input+"\r\n");
          
          Test();
        }
      }catch(Exception e){System.out.println("Socket Error: "+e.getMessage()+"\r\n"); e.printStackTrace();}
       finally
       {
         try
       {
         ServeSock.close();
         bufInput.close();
       }
       catch (IOException e)
       {
         System.out.println("IO Error, trying to close the stream: "+e.getMessage());
       }
     }
   }
 }

}
