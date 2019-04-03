package com.vishadstool.autoprogram;
/* VariablePassFail -  very simple helper class
  * 
  */
 public class VariablePassFail
 {
     private static String[] values = 
       {
        "NoRun", "Pass", "Fail"
       };
  
     public static int indexOf(String str)
     {
         for (int ix = 0 ; ix < values.length ; ++ix)
             if (values[ix].equals(str))
                 return ix;
         return 0;
     }
     public static String stringAt(int at)
     {
         if (at < 0 || at >= values.length)
             return "Other";
         return values[at];
     }
     
     
 }