package com.vishadstool.autoprogram;
/* MovieRating -  very simple helper class
  * Copyright 2001, Bruce E. Wampler
  */
 public class VariableRating
 {
     private static String[] values = 
       {
         "G", "PG", "PG-13", "R", "NC-17", "X", "NR", "Unknown"
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
             return "Unknown";
         return values[at];
     }
     public static String[] getNames()
     {
         return values;
     }
 }