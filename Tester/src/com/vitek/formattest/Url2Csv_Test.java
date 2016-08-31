package com.vitek.formattest;

import com.vitek.nettests.UrlStringifier;

public class Url2Csv_Test
{
  public static void main(String[] args)
  {
    UrlStringifier UrlStringer = new UrlStringifier();
    CsvStringReader CsvStringer = new CsvStringReader();
    
    UrlStringer.setUrl("http://spauserlist.texaspowertrain.com");
    
    CsvStringer.setUrlString(UrlStringer.urlStringify());
    CsvStringer.doRead();
    CsvStringer.setExitThread(false);
    
  }
}
