package com.vishadstool.autoprogram;

/* VariableCat - A simple Variable Application
  * Copyright (c) 2001, Bruce E. Wampler
  */
  
 import java.awt.*;
 import javax.swing.*;
  
 public class VariableCat extends WmvcApp
 {
     private MainView mainView;
     private VariableListView listView;
     private VariableItemView itemView;
    
     public VariableCat(String name)        // constructor
     {
         super(name, true, true);    // Create with menu, toolbar
  
         // **** First, create the model
         setModel( (WmvcModel) new VariableModel() );
  
         // **** Next, create the view/controllers
         mainView = new MainView();      // won't use any panels
         listView = new VariableListView(); // list view for left
         itemView = new VariableItemView(); // item view for right
  
         // ****  Create a split pane, add list and item views
         JScrollPane listPane = 
             new JScrollPane(listView.getPanel());
         JScrollPane itemPane = 
             new JScrollPane(itemView.getPanel());
         JSplitPane splitPane = 
             new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                 listPane, itemPane);
         splitPane.setOneTouchExpandable(true);  // details
         splitPane.setDividerLocation(200);
         Dimension minimumSize = new Dimension(100, 50);
         listPane.setMinimumSize(minimumSize);
         itemPane.setMinimumSize(minimumSize);
  
         WmvcApp.addMainPane(splitPane); // add splitter
     }
     
     public boolean appClosing()
     {
         return mainView.closingCurrentVariable(true);
     }
     
     public static void main(String[] args)
     {
         final VariableCat variableCat = 
            new VariableCat("AutoMation Application");
  
         WmvcApp.getContentPanel().setPreferredSize(
            new Dimension(640, 300)); // make bigger than default
         variableCat.showApp();          // pop it up
     }
 }