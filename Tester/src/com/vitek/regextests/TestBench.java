package com.vitek.regextests;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TestBench {

    public static void main(String[] args){

      String text2search ="SA_temp";
      String regexp = "temp|tmp|tp";
      
//////////////////REGEX MATCHING////////////////////////////////////////////////////////////////////////////      
      Pattern pattern =  Pattern.compile(regexp, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
      
      Matcher matcher = pattern.matcher(text2search);

      boolean found = false;
      if(matcher.find()) {
        System.out.println("I found the text " +matcher.group()+" starting at " +"index "+matcher.start()+ " and ending at index "+matcher.end());
        found = true;
      }
      if(!found){
        System.out.println("No match found.");
      }

//////////////////STRING MATCHING///////////////////////////////////////////////
      if(text2search.contains("temp"))
      {
        System.out.println("String match resolved 'temp'...");
      }
      else{ System.out.println("String match resolved..."); }
   
    }
    
    /*
     * import all the facet definitions into an array of BFacets, create an array of regex strings.
     * For every numeric loop over the facet definitions testing every BFacets array element's string by running a test loop over the regex array.
     * for(every bfacet){
     *  for(every regex)
     *    test bfacet with regexjava.
     * }
     */
    
}