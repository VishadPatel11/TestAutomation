package com.vishadstool.autoprogram;
 /* MovieFormat -  very simple helper class
  * Copyright 2001, Bruce E. Wampler
  */
 public class VariableFormat
 {
     private static String[] values = 
       {
         "VHS", "DVD", "VCD", "SVCD", "Hi8", "DV", "Other"
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