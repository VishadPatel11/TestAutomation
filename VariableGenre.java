package com.vishadstool.autoprogram;
/* MovieGenre -  very simple helper class
  * Copyright 2001, Bruce E. Wampler
  */
 public class VariableGenre
 {
     private static String[] values = 
       {
        "Drama", "Comedy", "Children", "Family", "Action",
        "Sci-Fi", "Documentary", "Other"
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