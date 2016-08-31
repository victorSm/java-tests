package com.vitek.dbtests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

public class SqlTest_Query
{

  public static void main(String[] args)
  {
    
    String connectionURL = "jdbc:sqlserver://localhost:53279;"+"databaseName=Employees;user=Tridium;password=Seguin2016";
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try
    {
      
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      conn = DriverManager.getConnection(connectionURL);
      
      String qnameCol = "name LIKE ";
      String qnameVal = "'Vi%'";
      
      String qbadgeCol = "badge_number LIKE ";
      String qbadgeVal = "'1%'";
      
      String qaccessCol = "access_level LIKE ";
      String qaccessVal = "Admin";
      
      String queryStr = "SELECT * FROM piston_ringer WHERE "+qnameCol+qnameVal;
      
      stmt = conn.createStatement();
      rs = stmt.executeQuery(queryStr);
      
      while(rs.next())
      {
        System.out.println(rs.getString(1)+"\n"+rs.getInt(2)+"\n"+rs.getString(3));
      }
      
    }catch(Exception e){System.out.println("Sql error: "+e.getMessage()); e.printStackTrace();}
    
    finally
    {
      if(rs !=null) try{rs.close();}catch(Exception e){System.out.println("ResultSet Obj closing error...");}
      if(stmt !=null) try{ stmt.close(); }catch(Exception e){System.out.println("Statement Obj closing error...");}
    }
  }
}
