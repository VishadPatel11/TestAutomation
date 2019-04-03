package com.vishadstool.autoprogram;
/*
  * WmvcModel - An MVC model superclass for the Wmvc Framework
  * 
  */
  
 import java.util.*;
  
 public class WmvcModel
     extends     Observable
 {
     // not a huge class, but provides implementation of
     // Observer pattern using MVC naming
  
     public WmvcModel()
     {
         super();
     }
     
     public void addView(WmvcView view)
     {
         addObserver((Observer) view);
     }
     
     public void deleteView(WmvcView view)
     {
         deleteObserver((Observer) view);
     }
     
     public void notifyViews()
     {
         setChanged();
         notifyObservers();
     }
 }