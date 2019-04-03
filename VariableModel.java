package com.vishadstool.autoprogram;
/* VariableModel - implements the variable model. Handles changes.
  * 
  */
  
 import java.io.*;
 import java.util.*;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
  
 public class VariableModel extends     WmvcModel
 {
     private int currentVariableIndex;
     public Vector theList;
     private final int FILE_ID = 48879;  // 0xBEEF
  
     // need two changed flags - one if a new entry has been
     // added that is true only until the views update, and a
     // global one that remains true if anything has changed
     // until the list is saved
     private boolean listChanged;   // true until views updated
     private boolean editsMade;          // true until saved
     private File myFile;
  
     public ListIterator getVariableListIterator()
        { return theList.listIterator();}
     public boolean getListChanged() { return listChanged; }
     public boolean getEditsMade() { return editsMade; }
     public int getCurrentVariableIndex()
        { return currentVariableIndex; }
     public int getNumberOfVariables() { return theList.size(); }
     public File getFile() { return myFile; }
     
     public VariableModel()
     {
         editsMade = false;
         listChanged = false;
         theList = new Vector();
         myFile = null;
     }
  
     public void setCurrentVariableIndex(int variableNumber)
     {
         if (theList == null || theList.size() == 0) // valid?
             return;
         // Validate number passed in, wrap appropriately
         if (variableNumber < 0)
             variableNumber = theList.size() - 1;
         if (variableNumber >= theList.size())
             variableNumber = 0;
  
         currentVariableIndex = variableNumber;  // change the variable
         notifyViews();                    // update
     }
     
     public void addVariable(Variable variable)
     {
         if (variable == null)              // some validation
             return;
         editsMade = true;          // we've made some changes
         listChanged = true;
  
         ListIterator it = getVariableListIterator();
         int nextI = 0;
  
         while (it.hasNext())
         {
             // Assume list is sorted, so as soon as we find the
             // first entry that is > than this one, we insert
             // it before that one.
  
             nextI = it.nextIndex();     // index of next entry
             Variable m = (Variable) it.next();
             String adding = variable.getVariableName();
             String curName = m.getVariableName();
         
             /* uncomment the below if you want the list to always be sorted
             if (adding.compareToIgnoreCase(curName) <= 0)
                 //break;                  // curName > adding
             */
         
         }
  
         if (!it.hasNext())      // add at end (also if 1st time)
         {
             theList.add(variable);
             // make it current variable
             setCurrentVariableIndex(theList.size() - 1);
         }
         else                    // add it before nextI
         {
             theList.add(nextI,variable);
             setCurrentVariableIndex(nextI);
         }
     }
     
     public void deleteCurrentVariable()
     {
         if (theList.size() <= 0)
             return;
  
         editsMade = true;       // we've made some changes
         listChanged = true;
  
         theList.removeElementAt(currentVariableIndex);
         setCurrentVariableIndex(currentVariableIndex);
     }
     
     public void replaceCurrentVariable(Variable variable)
     {
         if (variable == null)
             return;
  
         theList.setElementAt(variable,currentVariableIndex);
         editsMade = true;       // we've made some changes
         listChanged = true;
         notifyViews();
     }
     
     public boolean saveVariables()
     {
         return saveVariablesAs(myFile);
     }
     
     public boolean saveVariablesAs(File file)
     {
         if (file != null)
         {
             try
             {
                 DataOutputStream out = new DataOutputStream(
                         new BufferedOutputStream(
                           new FileOutputStream(file)));
                 out.writeInt(FILE_ID);
                 ListIterator it = getVariableListIterator();
                 while (it.hasNext())
                 {
                	
                     Variable m = (Variable) it.next();
                     m.writeVariable(out);
                 }
                 out.flush(); out.close();
                 myFile = file;          // remember name
             }
             catch (IOException e)
             {
                 JOptionPane.showMessageDialog(
                     WmvcApp.getFrame(),
                     "Error opening file: " + e,
                          "VariableCat Error",
                     JOptionPane.ERROR_MESSAGE);
                 return false;
             }
         }
         else
             return false;
         
         editsMade = false;              // no edits now!
         return true;
     }
  
     public boolean openVariables(File file)
     {
         if (file != null)
         {
             myFile = file;              // remember the name
             try
             {
                 DataInputStream in = new DataInputStream(
                         new BufferedInputStream(
                           new FileInputStream(file)));
                 // check if file was made by us
                 if (in.readInt() != FILE_ID)
                 {
                     in.close();
                     myFile = null;
                     JOptionPane.showMessageDialog(
                         WmvcApp.getFrame(),
                         file.getName() +
                          " is not a valid VariableCat file.",
                          "VariableCat Error",
                         JOptionPane.ERROR_MESSAGE);
                     return false;
                 }
                 for ( ; ; )     // do until catch EOF Exception
                 {
                     Variable m = new Variable();
                     if (!m.readVariable(in))
                         break;
                     theList.add(m);
                 }
             }
             catch (IOException e)
             {
                 JOptionPane.showMessageDialog(
                     WmvcApp.getFrame(),
                     "Error reading file: " + e,
                          "VariableCat Error",
                     JOptionPane.ERROR_MESSAGE);
                 myFile = null;
                 return false;
             }
  
             editsMade = false;          // no edits to start
             listChanged = true;
             notifyViews();
             return true;
         }
         else
             return false;
     }
     
     public boolean closeVariables()
     {
         // Just close - Views responsible to save before closing
         myFile = null;                  // reset to empty values
         theList.clear();
         editsMade = false;              // no edits now!
         listChanged = true;
         notifyViews();
         return true;
     }
     
     public Variable getCurrentVariable()
     {
         if (currentVariableIndex < 0 
                      && currentVariableIndex >= theList.size())
             return null;
         else if (theList.size() == 0)
             return null;
         else
             return (Variable)theList.elementAt(currentVariableIndex);
     }

     public VariableAction getCurrentVariableAction()
     {
         if (currentVariableIndex < 0 
                      && currentVariableIndex >= theList.size())
             return null;
         else if (theList.size() == 0)
             return null;
         else
             return (VariableAction)theList.elementAt(currentVariableIndex);
     }
     
     public void notifyViews()
     {
         super.notifyViews();
         // updating views makes list correct
         listChanged = false;
     }
     
     
     
 }