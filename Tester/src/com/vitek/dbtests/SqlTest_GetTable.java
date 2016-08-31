package com.vitek.dbtests;

import java.sql.*;

public class SqlTest_GetTable
{
  
  public static void main(String[] args)
  {
    String connURL = "jdbc:sqlserver://localhost:53279;"+"databaseName=Employees;user=Tridium;password=Seguin2016";
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try
    {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      con = DriverManager.getConnection(connURL);
      
      String _TABLE = "SELECT * FROM piston_ringer";
      stmt = con.createStatement();
      rs = stmt.executeQuery(_TABLE);
      
      while(rs.next())
      {
        System.out.println(rs.getString(1)+" "+rs.getString(2)+"  "+rs.getString(3));
      }
    }catch(Exception e){System.out.println("Sql error: "+e.getMessage()); e.printStackTrace();}   
    finally
    {
      if(rs != null) try{ rs.close(); }catch(Exception e){}
      if(stmt != null) try{ stmt.close(); }catch(Exception e){}
    }
  }   
}
