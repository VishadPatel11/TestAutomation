package com.vishadstool.autoprogram;
 /*
  * VariableListView - the list View of the VariableCat model.
  *  This view implements the view of the variable list
  * Copyright (c) 2001, Bruce E. Wampler
  */
  
 import java.util.*;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import javax.swing.event.*;
  
 public class VariableListView 
     extends WmvcView
     implements  ListSelectionListener   // for JList
 {
     // need updating to avoid interaction between update and
     // valueChanged listener
     private static boolean updating = false;
     private JPanel listPanel;
     public JList jlist;
  
     private VariableModel myModel;
     public DefaultListModel variableList;	  //this contains the attributes(id,name,xpath) for specific variables.
     public DefaultListModel variableName;    //this contains the attributes(id,name,xpath) for specific variables.
     public DefaultListModel variableXpath;   //this contains the attributes(id,name,xpath) for specific variables.
     
     public JPanel getPanel() { return listPanel; }
  
     public VariableListView()
     {
         // Build list view which is simply a JList in a JPanel
         myModel = (VariableModel)WmvcApp.getModel();
         myModel.addView(this);  // add view to model list
  
         variableList = new DefaultListModel(); // first allocation
         variableList.addElement("No Variable List Opened");
  
         variableName = new DefaultListModel();
         variableXpath = new DefaultListModel();
         
         listPanel = new JPanel();
         listPanel.setLayout(new BorderLayout());
  
         jlist = new JList(variableList);
         jlist.setSelectionMode(
                         ListSelectionModel.SINGLE_SELECTION);       
         jlist.setSelectedIndex(0);
         jlist.addListSelectionListener(this); // valueChanged
  
         listPanel.add(jlist,BorderLayout.CENTER);
     }
  
     public void updateView()
     {
         // Called when model changes
         updating = true;
         // if list changed, don't need to refresh here
         if (myModel.getListChanged())
         {
             variableList.ensureCapacity(
                               myModel.getNumberOfVariables() + 8);
             variableList.clear();
             variableName.ensureCapacity(
                     myModel.getNumberOfVariables() + 8);
             variableName.clear();
             variableXpath.ensureCapacity(
                     myModel.getNumberOfVariables() + 8);
             variableXpath.clear();
  
             // See if just the selection changed
             // copy titles from variable list to view list
             ListIterator it = myModel.getVariableListIterator();
             while (it.hasNext())
               {
                 Variable m = (Variable) it.next();
                 variableList.addElement(m.getId());
                 variableName.addElement(m.getVariableName());
                 variableXpath.addElement(m.getVariableXpath());
               }
         }
         // Always update selected item
         // Note that by using the DefaultListModel, these will
         // trigger valueChanged, so we need the updating value
         jlist.setSelectedIndex(myModel.getCurrentVariableIndex());
         jlist.ensureIndexIsVisible(
                                myModel.getCurrentVariableIndex());
         updating = false;
     }
  
     // Implement ListSelectionListener
     public void valueChanged(ListSelectionEvent e)
     {
         if (e.getValueIsAdjusting()) // Still adjusting?
             return;
  
         JList theList = (JList)e.getSource();
         if (! theList.isSelectionEmpty()) 
         {
             int index = theList.getSelectedIndex();
             // now set the model to use the selected variable name
             if (!updating)
                 myModel.setCurrentVariableIndex(index);
         }
     }
     
     
 }