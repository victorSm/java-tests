package com.vitek.apies.json;

import java.util.*;

public class JsModel
{
  Map mapList = new HashMap();
 
 /* 
  public static JsonArray makeEnum(JsonValue val)
  {
    JsonArray jsonArray = val.asArray();
    return jsonArray;
  }

  public static String makeString(JsonValue val)
  {
    String string = val.asString();
    return string;
  }
  
  public static Boolean makeBoolean(JsonValue val)
  {
    boolean bool = val.asBoolean();
    return bool;
  }
  
  public static double makeNumeric(JsonValue val)
  {
    double numeric = val.asDouble();
    return numeric;
  }
  
  public static JsonObject makeObj(JsonValue val)
  {
    JsonObject jsObj = val.asObject();
    return jsObj;
  }
    
  public static Object getJavaType(JsonValue val)
  {
    Object o = null;
    if(val.isArray())
    {
      o = makeEnum(val);
    }
    else if(val.isString())
    {
      o = makeString(val);
    }
    else if(val.isBoolean())
    {
      o = makeBoolean(val);
    }
    else if(val.isNumber())
    {
      o = makeNumeric(val);
    }
    else if(val.isObject())
    {
      o = makeObj(val);
    }
    else
    { 
      System.out.println("Can't recognize type..."); 
      return null; 
    }
    return o;
  }

*/  
  
  public boolean isDouble(Object o)
  {  
    boolean isDouble = false;
    if(o.getClass().equals(Double.class))
    {
      System.out.println("is Double...");
      isDouble = true;
    }
    return isDouble;
  }
  
  public boolean isInteger(Object o)
  {
    boolean isInt = false;
    if(o.getClass().equals(Integer.class))
    {
      System.out.println("is Integer...");
      isInt = true;
    }
    return isInt;
  }
  
  public boolean isBoolean(Object o)
  {
    boolean isBool = false;
    if(o.getClass().equals(Boolean.class))
    {
      System.out.println("is boolean...");
      isBool = true;
    }
    return isBool;
  }
  
  public boolean isString(Object o)
  {
    boolean isString = false;
    if(o.getClass().equals(String.class))
    {
      System.out.println("is String...");
      isString = true;
    }
    return isString;
  }
  
  public void addData(String s, Object o)
  {
    mapList.put(s, o);
  }

  public void removeData(String key)
  {
    mapList.remove(key);
  }
  
  public String jsonWrap()
  {
    ArrayList valueList = new ArrayList();
    StringBuffer jbuff = new StringBuffer("{");
    
    if(!mapList.isEmpty())
    {      
      for(Iterator iter = mapList.entrySet().iterator(); iter.hasNext();)
      {
        Map.Entry e = (Map.Entry)iter.next();
        String jsonVal = "";
        
        if(isString(e.getValue()))
        {
          jsonVal = "\""+e.getKey().toString()+"\""+":"+"\""+e.getValue().toString()+"\"";
          System.out.println(e.getValue().toString()+"_is a String...");
        }
        else
        {
          jsonVal = "\""+e.getKey().toString()+"\""+":"+e.getValue().toString();
        }       
        valueList.add(jsonVal);
      }
      
      for(ListIterator it = valueList.listIterator(); it.hasNext();)
      {
        jbuff.append(it.next());

        
        if(!it.hasNext())
        {
          jbuff.append("}");
        }
        else
        {
          jbuff.append(",");
        }
      }
      
      String jsonObject = jbuff.toString();
      System.out.println(jsonObject);
      return jsonObject;
    }
    return "{}";
  }
}  
  
