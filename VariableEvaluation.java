package com.vishadstool.autoprogram;
/* MovieEvaluation -  very simple helper class
  * Copyright 2001, Bruce E. Wampler
  */
 public class VariableEvaluation
 {
     private static String[] values = 
       {
         "*", "**", "***", "****", "*****"
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
             return "-";
         return values[at];
     }
     public static String[] getNames()
     {
         return values;
     }
 }