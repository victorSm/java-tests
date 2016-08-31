
package com.vitek.api.clientsocket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;

/*
 * This class is a basic model for a socket client input/output controller, it depends on the SocketClientModel class.
 * It is meant to be instantiated in a class extending Thread, so it's non-blocking.The calling class must implement the specifics of when to 
 * start a session how many reads and writes to do per session, and how to ultimately end the session (aka. the protocol). The EndSession()
 * method provides accessors to a variable from the model that can be used to signal the thread to end when a session is ending, so the 
 * lifetime of a thread instance is as long as the duration of the session.
 */
public class SocketClient_Controller
{
  private SocketClient_Model sockSettings = new SocketClient_Model();
  private Socket sockClient = null;
  private PrintWriter pw = null;
  private BufferedReader buffRead = null;

  public void Init(String host, int port)
  {
    sockSettings.setHost(host);
    sockSettings.setPort(port);
    
    if(sockSettings.getHost() == null || sockSettings.getHost() == "")
    {
      sockSettings.setErrorOutput("Enter a valid ip address..."+"\r\n");
      sockSettings.setIsReady(false);
    }
    else if(sockSettings.getPort() <= 255 || sockSettings.getPort() > 65535)
    {
      sockSettings.setErrorOutput("Enter a port number between 256 and 65535..."+"\r\n");
      sockSettings.setIsReady(false);
    }
    else
    {
      sockSettings.setIsReady(true);
    }
  }
  
  public void SendData(String data) throws IOException
  {
    if(sockSettings.getIsReady())
    {
      try
      {
        sockSettings.setDataOut(data);
        sockClient = new Socket(sockSettings.getHost(), sockSettings.getPort());
        pw = new PrintWriter(sockClient.getOutputStream(), true);
        System.out.println("Socket Init, and data sent...."+sockSettings.getDataOut());
        pw.write(sockSettings.getDataOut());
      }
      catch(Exception e)
      {
        System.out.println("Socket Connection Error..."+e.getMessage());
        e.printStackTrace();
        sockSettings.setErrorOutput("Socket Connection Error..."+e.getMessage());
      }
      finally
      {
        pw.close();
        sockClient.close();
      }
    }
    else
    {
      System.out.println("Socket Send Data error, no connection available..."+ "\r\n");
      sockSettings.setErrorOutput("Socket Send Data Error in the SocketClient_Controller Class, SendData() method..."+"\r\n");
    }
  }
    
  public void ReadData()
  {
   String input = ""; 
    try
    {
      if(sockClient != null){}
      else{sockClient = new Socket(sockSettings.getHost(), sockSettings.getPort());}
      
      buffRead = new BufferedReader( new InputStreamReader(sockClient.getInputStream()));     
      while((input = buffRead.readLine()) != null)
      {
        sockSettings.setDataIn(input);
      }
      System.out.println("Socket read op done...");
    }
    catch (IOException e)
    { 
      System.out.println("IO Error..."+ "\r\n"); e.printStackTrace(); 
      sockSettings.setErrorOutput("IO Exception in the SocketClient_Controller Class, ReadData() method..."+e.getMessage()+"\r\n");
    }
  }
  
  public void SocketClose(){
    try{
      sockClient.close();
      sockSettings.setIsReady(false);
    }catch(IOException e)
    { 
      System.out.println("IO Error trying to close the socket: "+e.getMessage()); 
      e.printStackTrace(); 
      sockSettings.setErrorOutput("IO Error trying to close the socket: "+e.getMessage());
    }
  }
  
}