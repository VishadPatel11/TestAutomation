package com.vishadstool.autoprogram;
/* VariableAction -  very simple helper class
  * 
  */
 public class VariableAction
 {
     private static String[] values = 
       {
        "Click", "Validate Text", "Wait", "Close"
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
     public static String[] getNames()
     {
         return values;
     }
     
     
 }