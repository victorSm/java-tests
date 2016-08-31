package com.vitek.stringtest;
public class testMain
{

  public static void main(String[] args)
  {
    String testString = "";
    String[] strArray = new String[4];
    
    strArray[0] = "Hello";
    strArray[1] = "this";
    strArray[2] = "will";
    strArray[3] = "work";
    
    for(int i = 0; i < strArray.length; i++)
    {
      testString += strArray[i]+" ";
    }
    
    System.out.println(testString);
  }

}
