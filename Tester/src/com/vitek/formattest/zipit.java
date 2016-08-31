package com.vitek.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class zipit
{
  
  public static void main(String[] args)
  {
    
    String zipFile = "C:\\Users\\vsmolins\\Desktop\\TestFile.zip";//it should be arg[0]
    
    String srcDir = "C:\\Users\\vsmolins\\Desktop\\TestFolder";//it should be arg[1]
    
    
    try
    {
      FileOutputStream fos = new FileOutputStream(zipFile);
      ZipOutputStream zos = new ZipOutputStream(fos);
      
      File srcFile = new File(srcDir);
      addDir2Archive(zos, srcFile);
      
      zos.close();
    }
    catch(IOException ioe)
    {
      System.out.println("Error creating zip file:"+ ioe+"\r\n"); 
      ioe.printStackTrace();
    }
  }
  
  private static void addDir2Archive(ZipOutputStream zos, File srcFile)
  {
    File[] files = srcFile.listFiles();
    System.out.println("Adding directory: "+srcFile.getName());
    
    for(int i = 0; i < files.length; i++)
    {
      if(files[i].isDirectory())
      {
        addDir2Archive(zos, files[i]);
        continue;
      }
      
      try
      {
        System.out.println("Adding file: "+ files[i].getName());
        
        int length;
        byte[] buffer = new byte[1024];
        FileInputStream fis = new FileInputStream(files[i]);
        
        zos.putNextEntry(new ZipEntry(files[i].getName()));
        while((length = fis.read(buffer)) > 0 )
        {
          zos.write(buffer, 0, length);
        }
        zos.closeEntry();
        fis.close();
      }
      catch(IOException ioe)
      {
        System.out.println("Error: "+ioe);
        ioe.printStackTrace();
      }
    }
  }
}
