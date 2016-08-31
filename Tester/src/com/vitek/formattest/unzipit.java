package com.vitek.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class unzipit
{
  public static void main(String[] args) throws IOException {
    ZipFile zipFile = new ZipFile("C:\\Users\\vsmolins\\Desktop\\TestFile.zip");//arg[0]
    File unzipDir = new File("C:\\Users\\vsmolins\\Desktop\\TestFolder");//arg[1]
    unzip(zipFile, unzipDir);
  }
   
  public static void unzip(ZipFile zipFile, File unzipDir) {
    Enumeration<? extends ZipEntry> files = zipFile.entries();
    File f = null;
    FileOutputStream fos = null;
     
    while (files.hasMoreElements()) {
      try {
        ZipEntry entry = (ZipEntry) files.nextElement();
        InputStream eis = zipFile.getInputStream(entry);
        byte[] buffer = new byte[1024];
        int bytesRead = 0;
   
        f = new File(unzipDir.getAbsolutePath() + File.separator + entry.getName());
         
        if (entry.isDirectory()) {
          f.mkdirs();
          continue;
        } else {
          f.getParentFile().mkdirs();
          f.createNewFile();
        }
         
        fos = new FileOutputStream(f);
   
        while ((bytesRead = eis.read(buffer)) != -1) {
          fos.write(buffer, 0, bytesRead);
        }
      } catch (IOException e) {
        e.printStackTrace();
        continue;
      } finally {
        if (fos != null) {
          try {
            fos.close();
          } catch (IOException e) {
            // ignore
          }
        }
      }
    }
  }

}
