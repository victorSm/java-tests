package com.vitek.stringtest;

import java.nio.ByteBuffer;

public class ByteStripper_Test
{
  public static void main(String[] args)
  {
    String outStr = "";
    String inStr = "389715";
    byte[] bArray = inStr.getBytes();
    ByteBuffer buff = ByteBuffer.wrap(bArray, 0, bArray.length-1);
    
    outStr = new String(buff.array());
    System.out.println("output string..."+outStr);
    System.out.println("Bytes..."+bArray.toString());
  }
}
