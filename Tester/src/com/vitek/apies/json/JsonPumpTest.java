package com.vitek.apies.json;

import java.io.IOException;

import com.vitek.api.clientsocket.SocketClient_Controller;

public class JsonPumpTest
{
  
  
  public static void main(String[] args) throws InterruptedException, IOException
  {
    double load = 0;
    double loadJPH = 0;
    double loadPPHH = 0;
    
    double rig = 0;
    double rigJPH = 0;
    double rigPPHH = 0;
    
    double unload = 0;
    double unlJPH = 0;
    double unlPPHH = 0;

    while(true)
    {
      load = Math.random();
      loadJPH = Math.random();
      loadPPHH = Math.random();
      
      rig = Math.random();
      rigJPH = Math.random();
      rigPPHH = Math.random();
      
      unload = Math.random();
      unlJPH = Math.random();
      unlPPHH = Math.random();
      
      JsModel model = new JsModel();
      
      model.addData("Load", Math.round(load*10));
      model.addData("loadJPH", Math.round(loadJPH*10));
      model.addData("loadPPHH", Math.round(loadPPHH*10));
      
      model.addData("Rig", Math.round(rig*10));
      model.addData("rigJPH", Math.round(rigJPH*10));
      model.addData("rigPPHH", Math.round(rigPPHH*10));
      
      model.addData("Unload", Math.round(unload*10));
      model.addData("unlJPH", Math.round(unlJPH*10));
      model.addData("unlPPHH", Math.round(unlPPHH*10));
            
      pump(model);
      
      Thread.sleep(500);
    }
  }
  
  public static void pump(JsModel model) throws IOException
  {
    SocketClient_Controller sockClient = new SocketClient_Controller();
    
    String output = model.jsonWrap();
    sockClient.Init("127.0.0.1", 5555);
    sockClient.SendData(output);
    sockClient.SocketClose();
  }  
}
