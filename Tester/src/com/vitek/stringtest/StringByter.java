package com.vitek.stringtest;

import java.util.ArrayList;

public class StringByter
{

  public static void main(String[]args)
  {

    String inStr = "5f253";
    int Codepoint = 0;
    byte[] bArray = inStr.getBytes();
    String parsedString = "";
    int hexInt = 0;
    
    StringBuffer cpBuff = new StringBuffer();
    StringBuffer byteBuff = new StringBuffer();
    StringBuffer hbyteBuff = new StringBuffer();
    StringBuffer charBuff = new StringBuffer();
    
    System.out.println(""+inStr+"\r\n");
    
    for(int i = 0; i <= bArray.length-1; ++i)
    {
//      System.out.println("Bity Bytes..."+bArray[i]);
      byteBuff.append(bArray[i]);
    }
    
    for(int i = 0; i <= bArray.length-1; ++i)
    {
//      System.out.println("Hexed Bytes..."+Integer.toHexString(bArray[i]));
      hbyteBuff.append(Integer.toHexString(bArray[i]));    }
    
//    System.out.println("\r\n");
    for(int i = 0; i <= inStr.length()-1; ++i)
    {
//     System.out.print("Codepoint..."+inStr.codePointAt(i)+"\r\n");
      cpBuff.append(inStr.codePointAt(i));
    }
    
    for(int i = 0; i <= inStr.length()-1; ++i)
    {
//      System.out.println("Char..."+inStr.charAt(i));
      charBuff.append(inStr.charAt(i));
    }
    
    System.out.println(cpBuff.toString());
    System.out.println(byteBuff.toString());
    System.out.println(hbyteBuff.toString());
    System.out.println(charBuff.toString());
    
    System.out.println("\r\n");
    hexInt = Integer.parseInt(inStr, 16);
    parsedString = Integer.toString(hexInt);
    System.out.println("Parsed Hex String..."+parsedString);
  }  
}
