package com.vishadstool.autoprogram;
/*
  * WmvcView - An MVC view superclass for the Wmvc Framework
  * 
  */
  
 import java.util.*;
  
 public class WmvcView
     implements  Observer
 {
     // implement the single Observer class
     public void update(Observable observed, Object value)
     {
         updateView();
     }
     
     public void updateView()
     {
         // no-op by default
     }
 }
