package com.vitek.formattest;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class CsvStringReader
{
    
  private boolean exitThread = false;
  public void setExitThread(boolean ext){ exitThread = ext; }
  
  private String urlString = "";
  public void setUrlString(String us){ urlString = us; }
  public String getUrlString(){ return urlString; }
  
  ///////Factory pattern List making method///////////////////////////////////  
  public ArrayList makeList()
  {
    ArrayList List = new ArrayList();
    int Hash = List.hashCode();
    System.out.println("New List obj's hashcode:  "+Hash);
    return List;
  }

//////////Factory pattern Tokenizer making method//////////////////////////////////  
  public StringTokenizer makeTokenizer(String tobeTokenized, String delimiter)
  {
    StringTokenizer Tokenizer = new StringTokenizer(tobeTokenized,delimiter);
    int Hash  = Tokenizer.hashCode();
    System.out.println("New Tokenizer obj's hashcode:  "+Hash);
    return Tokenizer;
  }

/////////////CSV file reader method/////////////////////////////////////////////  

  public void doRead()
  {
    StringReader_Thread Reader = new StringReader_Thread(); 
    Reader.start();
    System.out.println("Reader thread is alive..."+Reader.isAlive());
    System.out.println("This reader is..."+Reader.hashCode());
    if(!Reader.isAlive())
    {
      setExitThread(false);
      System.out.println("Reader thread is dead..."+Reader.isAlive());
    }
  }

  class StringReader_Thread extends Thread
  {
  
  public void run()throws ArrayIndexOutOfBoundsException
  {
    System.out.println("Reader thread is running... from inside run() method....");

    int columns = 0;
    int rows = 0;
    String delimiter1 = ",";
    String delimiter2 = "\r\n";
    String csvHeader = "";
    String csvData = getUrlString();
    boolean matchFound = false;

    StringTokenizer contentTokenizer = new StringTokenizer(csvData,delimiter2);

    ArrayList ContentList = makeList();
    while(contentTokenizer.hasMoreTokens())
    {
      System.out.println("Content Token count:  "+contentTokenizer.countTokens());
      String nexT = contentTokenizer.nextToken(); 
      ContentList.add(nexT.trim());
    }        
    ContentList.trimToSize();
    for(ListIterator it = ContentList.listIterator(); it.hasNext();)
    {  
      System.out.println("ContentList Record:  "+it.next().toString().trim());
      rows++;      
    }  

    String[] contentArr = new String[rows];
    ContentList.toArray(contentArr);
    csvHeader = contentArr[0];

    StringTokenizer headTokenizer = new StringTokenizer(csvHeader,delimiter1);

    ArrayList HeaderList = makeList();     
    while(headTokenizer.hasMoreTokens())
    {  
      System.out.println("Header Token count:  "+headTokenizer.countTokens());
      String nexT = headTokenizer.nextToken();
      HeaderList.add(nexT);
    }        
    for(ListIterator it = HeaderList.listIterator(); it.hasNext();)
    {
      columns++;
      System.out.println("HeaderList item:  "+it.next());
    }

    for(int i = 1; i < contentArr.length; i+=1)
    {
      System.out.println("From array:  "+contentArr[i]);
      ArrayList RecordList = makeList();
      StringTokenizer recordTokenizer = makeTokenizer(contentArr[i], delimiter1);                     
      while(recordTokenizer.hasMoreTokens())
      {
        System.out.println("Record Token count:  "+recordTokenizer.countTokens());
        String nexT = recordTokenizer.nextToken();
        RecordList.add(nexT);
      }
      for(ListIterator it = RecordList.listIterator(); it.hasNext();)
      {
        System.out.println("RecordList item:  "+it.next()+"_"+it.nextIndex());                    
      }
      System.out.print("RecordList GET:  "+RecordList.get(0).toString()+"___"+RecordList.get(1).toString()+"___"+RecordList.get(2).toString()+"\n");
    }
    setExitThread(true); 
    System.out.println("End of thread...");
  } 
 }  
}
