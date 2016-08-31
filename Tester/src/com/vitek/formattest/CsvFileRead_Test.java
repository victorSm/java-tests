package com.vitek.formattest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;


public class CsvFileRead_Test
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader bufRead = null;
    int columns = 0;
    String header = "";
    String str = "";
    char set[] = new char[1000];
    
    File file = new File("c:\\Users\\smolivm\\Desktop\\Access.csv");
    
    try
    {
      bufRead = new BufferedReader(new FileReader(file));
      
      header =  bufRead.readLine();     
      bufRead.read(set);
      str = new String(set);
      String csvHeader[] = header.split(",");
      ArrayList col = new ArrayList();
      String csvContent[] = str.split(",");
      
      System.out.println("Csv Header:  "+header);
      System.out.println("");
      
      for(int i = 0; i < csvHeader.length; i++)
      {
        columns++;
      }
      
      System.out.println("No of Columns:  "+columns);      
      
      for(int i = 0; i < csvContent.length; i++)
      {
         col.add(csvContent[i]);
      }

      for(ListIterator it = col.listIterator(); it.hasNext();)
      {
        System.out.println(it.next());
      }

      System.out.println("Size of List:  "+col.size());
      
    }
    catch (FileNotFoundException e1)
    {
      System.out.println("File Not Found Error:  "+e1.getMessage());
    }
    catch(IOException e2){System.out.println("File IO Error:  "+e2.getMessage());}
    finally{bufRead.close();}
  }
}
