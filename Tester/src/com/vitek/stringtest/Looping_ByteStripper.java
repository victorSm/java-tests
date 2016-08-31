package com.vitek.stringtest;

import java.io.UnsupportedEncodingException;

public class Looping_ByteStripper
{
  public static void main(String[] args)
  {
    
    String inStr = "389715";
    byte[] bloopArray = inStr.getBytes();
    byte byty = 0;
    
    for(int i = 0; i < bloopArray.length; ++i)
    {
      byty = bloopArray[i];
      System.out.println("Single byte..."+byty);
    }

    String outStr = new String(bloopArray, 0, bloopArray.length);
    System.out.println("Output String..."+outStr);
  }
  
}
