package com.vitek.dbtests;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SqlUtility
{

//Field variables 
  private Connection sqlConnection = null;
  private Statement stmt = null;
  private ResultSet rs = null;
  
  private String SQLErrorMesg = "";
  private int SQLErrorCode = -1;
  
  private String connectionString = "";
  private String tableName = "";
  private int numOfRows = 0;

//Field Accessors  
  public String getConnectionString(){ return connectionString; }
  public void setConnectionString(String conString) { conString = connectionString;  }
  
  public String getSQLErrorMesg(){return SQLErrorMesg;}
  public void setSQLErrorMesg(String sqlemsg){SQLErrorMesg = sqlemsg;}
  
  public int getSQLErrorCode(){return SQLErrorCode;}
  public void setSQLErrorCode(int sqlecode){SQLErrorCode = sqlecode;}
  
  public String getTableName() { return tableName; }
  public void setTableName( String tName) { tableName = tName; }

   
//Class Methods 
  public ArrayList makeTable()
  {
    ArrayList TableList = new ArrayList();
    int tableHash = TableList.hashCode();
    System.out.println("New table: "+tableHash);
    
    return TableList;
  }
  
  public void Connect2SQLDB()
  {
    if(connectionString != null || connectionString != "")
    {
      try
      {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        sqlConnection = DriverManager.getConnection(getConnectionString());
        
      }catch(Exception e){ System.out.println("SQL connection error: "+e.getMessage()); e.printStackTrace();}
    }
    else{System.out.println("Sql connectionString is null or blank...provide a valid value...!!");}
  }
  
  public int getNumOfRows()
  {
    String queryTable = "SELECT * FROM"+tableName;
    
    try
    {
      if(sqlConnection.isValid(5))
      {
        try
        {
          stmt = sqlConnection.createStatement();
          rs = stmt.executeQuery(queryTable);
          
          while(rs.next())
          {
            numOfRows = rs.getRow();           
          }
        }catch(Exception e){System.out.println("Sql error: "+e.getMessage()); e.printStackTrace();}   
      }
      else
      {
        System.out.println("Sql Connection is not valid...");
      }
    }
    catch (SQLException sqle)
    {
      setSQLErrorMesg(sqle.getMessage());
      setSQLErrorCode(sqle.getErrorCode());
      System.out.println("Sql Connection Validation Error: "+sqle.getMessage()+"\n"+"SQL Error Code"+sqle.getErrorCode());
      sqle.printStackTrace();
    }
    finally
    {
      if(rs != null) try{ rs.close(); }catch(Exception e){}
      if(stmt != null) try{ stmt.close(); }catch(Exception e){}
    }    
    return numOfRows;
  }
  
  public ArrayList GenerateTable()
  {
    String queryTable = "SELECT * FROM"+tableName;
    String tableRow = "";
    ArrayList Table = makeTable();
    
    try
    {
      if(sqlConnection.isValid(5))
      {
        try
        {
          stmt = sqlConnection.createStatement();
          rs = stmt.executeQuery(queryTable);
          
          while(rs.next())
          {
            System.out.println(rs.getString(1)+" "+rs.getString(2)+"  "+rs.getString(3));
            
            tableRow = rs.getString(1)+" "+rs.getString(2)+"  "+rs.getString(3);
            Table.add(tableRow);
          }
        }catch(Exception e){System.out.println("Sql error: "+e.getMessage()); e.printStackTrace();}   
      }
      else
      {
        System.out.println("Sql Connection is not valid...");
      }
    }
    catch (SQLException sqle)
    {
      setSQLErrorMesg(sqle.getMessage());
      setSQLErrorCode(sqle.getErrorCode());
      System.out.println("Sql Connection Validation Error: "+sqle.getMessage()+"\n"+"SQL Error Code"+sqle.getErrorCode());
      sqle.printStackTrace();
    }
    finally
    {
      if(rs != null) try{ rs.close(); }catch(Exception e){}
      if(stmt != null) try{ stmt.close(); }catch(Exception e){}
    }    
    return Table;
  }
  
  public String QueryTable()
  {
    String queryResult = "";
    //TODO
    return queryResult;
  }
  
  public void InsertRow(String... rowFields)
  {
    String fieldString = "";
    String valueString = "VALUES( "+fieldString+")";
    String stmtString = "INSERT INTO "+ tableName+" "+valueString;
    
    try
    {
      if(sqlConnection.isValid(5))
      {
        try
        {
          for(int v = 0; v < rowFields.length; v++)
          {
            fieldString += rowFields[v]+" ";
                
          }
          stmt = sqlConnection.createStatement();
          stmt.executeUpdate(stmtString);
          
        }catch(Exception e){System.out.println("Sql error: "+e.getMessage()); e.printStackTrace();}   
      }
      else
      {
        System.out.println("Sql Connection is not valid...");
      }
    }
    catch (SQLException sqle)
    {
      setSQLErrorMesg(sqle.getMessage());
      setSQLErrorCode(sqle.getErrorCode());
      System.out.println("Sql Connection Validation Error: "+sqle.getMessage()+"\n"+"SQL Error Code"+sqle.getErrorCode());
      sqle.printStackTrace();
    }
    finally
    {
      if(stmt != null) try{ stmt.close(); }catch(Exception e){}
    }
  }
  
  public void UpdateRow() 
  {
    //TODO
  }

  public void DeleteRow()
  {
    //TODO
  }
  
  public void DeleteTable()
  {
    //TODO
  }

}

