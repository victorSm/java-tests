package com.vitek.stringtest;

public class StringParser
{
  
  char charString[] = null;
  int value = 0;
  boolean isNumber = false;
  boolean isBoolean = false;
  double numeric = 0.0;
  boolean bool = false;
  int intNumeric = 0;
  boolean makeInt = false;
  
  public void setAsInteger(double parsedDouble){ intNumeric = (int)parsedDouble; }
  public int getIntNumeric(){ return intNumeric; }
  
  public boolean getBool(){ return bool; }
  public double getNumeric(){ return numeric; }
  
  public void parseInput(String testString)
  {
    charString = testString.toCharArray();
    for(int i = 0; i < charString.length; i++)
    {
      if(Character.isDigit(charString[i]))
      {
        value = charString[i];
        System.out.println("this is a number..."+value);
        isNumber = true;
      }
      else
      {
        System.out.println("this is not a number..."+value);
        isNumber = false;
      }
    }    
    if(testString.equals("true") || testString.equals("false"))
    {
      System.out.println("this is a boolean string..."+testString);
      isBoolean = true;
    }
    else
    {
      isBoolean = false;
    }
/////////////////////////////////////////////////////////////////////////////////////    
/////////////AFTER PARSING--DATA MODELING//////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////    
    
    if(isNumber)
    {
      numeric = Double.parseDouble(testString);
      System.out.println("DOUBLE DATA TYPE..."+numeric);
    }
    else if(isBoolean)
    {
      bool = Boolean.parseBoolean(testString);
      System.out.println("BOOLEAN DATA TYPE..."+bool);
    }
    else
    {
      System.out.println("this is just a string..."+testString);
    }
  }
}
