package com.vitek.formattest;


import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ParseXMLTest
{
  public static void main(String[] args)
  {
    try
    {
      File inputFile = new File("c:\\Users\\smolivm\\Desktop\\xmlTest1.txt");
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(inputFile);
      doc.getDocumentElement().normalize();
      
      System.out.println("Root element... "+doc.getDocumentElement().getNodeName());
      
      NodeList nList = doc.getElementsByTagName("Executive");
      
     System.out.println("Number of xml elements... "+nList.getLength());
      
    }catch(Exception e){e.printStackTrace();}
  }  
}  
