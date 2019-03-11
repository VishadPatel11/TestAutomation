package com.vishadstool.autoprogram;
 import java.io.*;
 import java.util.*;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import javax.swing.filechooser.*;
  
 public class MainView extends WmvcView
 {
     private JFileChooser fc;    // instance of a file chooser
     private VariableEditor theVariableEditor; // instance of editor
     private VariableModel myModel; // local copy of model reference
     private Runner run= new Runner();   //Start of the Script
  
     public MainView()
     {
         myModel = (VariableModel) WmvcApp.getModel();
         myModel.addView(this);
  
         // Create file chooser dialog. We will tell it to open
         // in the "user.dir" directory, which will usually be
         // the "current directory" when the program was started.
         // This will let the user use the "Start In" setting 
         // on Windows, for example.
  
         fc = new JFileChooser(  // file chooser in current dir.
                    new File(System.getProperty("user.dir")));
  
         createControls(); // Create controls - menus,toolbar
  
         theVariableEditor = VariableEditor.getInstance();  // editor
         theVariableEditor.initialize();
     }
  
     public boolean closingCurrentVariable(boolean ask)
     {
         // Check if current Variable has changed, ask if want to
         // save. Returns true if saved or didn't want to save,
         // false if save fails or user cancels.
         if (myModel.getEditsMade())
         {
             if (ask)            // interactive closing
             {
                 switch (JOptionPane.showConfirmDialog(
                         WmvcApp.getFrame(),
                         "The variable list has changed since you "
                         + "last saved it.\n"
                         + "Save the current variable list?",
                         "Variable List Has Changed",
                     JOptionPane.YES_NO_CANCEL_OPTION))
                 {
                     case JOptionPane.NO_OPTION:
                         return true;   // don't save, but done
                     case JOptionPane.CANCEL_OPTION:
                     case JOptionPane.CLOSED_OPTION:
                         return false;
                     default:
                         break;          // YES
                 }
                 if (myModel.getFile() == null)
                 {
                     int retV = 
                          fc.showSaveDialog(WmvcApp.getFrame());
                     if (retV == JFileChooser.APPROVE_OPTION)
                     {
                         File file = fc.getSelectedFile();
                         if (!myModel.saveVariablesAs(file))
                             return false;
                         else
                         {
                             myModel.closeVariables();
                             return true;
                         }
                     }
                     else
                         return false;
                 }
             }
             myModel.saveVariables();
             myModel.closeVariables();
         }
         return true;
     }
  
     private void createControls()
     {
         // This is the Controller for this view. It creates the
         // menu & toolbar, and implements all the control code, 
         // mostly in anonymous WmvcExecutor classes.
  
         // MenuBar: File
         JMenu fileMenu = new JMenu("File");
  
         // File->Open Variable List
         WmvcMenuItemCtl fileOpen = new WmvcMenuItemCtl(fileMenu,
             "Open Variable List","images/open-16.gif", 'O',
             null /* no accel */, new WmvcExecutor()
             {
                 public void execute(ActionEvent event)
                 {
                     if (!closingCurrentVariable(true))
                         return;
  
                     int retV = 
                           fc.showOpenDialog(WmvcApp.getFrame());
                     if (retV == JFileChooser.APPROVE_OPTION)
                     {
                         File file = fc.getSelectedFile();
                         myModel.openVariables(file);
                     }
                 }
             });
  
         // File->Save Variable List
         WmvcMenuItemCtl fileSave = new WmvcMenuItemCtl(fileMenu,
             "Save Variable List","images/save-16.gif", 'S',
             null /* no accel */, new WmvcExecutor()
             {
                 public void execute(ActionEvent event)
                 {
                     if (myModel.getFile() == null)
                     {
                         JOptionPane.showMessageDialog(
                          WmvcApp.getFrame(),
                          "No variable file name specified.\n"
                          + "Use \"Save VariableList As\" instead.",
                         "No file name specified",
                         JOptionPane.ERROR_MESSAGE);
                     }
                     else
                         myModel.saveVariables();
                 }
             });
  
         // File->Save Variable List
         WmvcMenuItemCtl fileSaveAs = new WmvcMenuItemCtl(
             fileMenu,
             "Save Variable List As","images/gray.gif",
             'A', null /* no accel */, new WmvcExecutor()
             {
                 public void execute(ActionEvent event)
                 {
                     int retV = 
                           fc.showSaveDialog(WmvcApp.getFrame());
                     if (retV == JFileChooser.APPROVE_OPTION)
                     {
                         File file = fc.getSelectedFile();
                         myModel.saveVariablesAs(file);
                     }
                 }
             });
  
         WmvcApp.addMenu(fileMenu);      // Add to app menu
  
         // MenuBar: Edit
         JMenu editMenu = new JMenu("Edit");
  
         // Edit->Edit Current Variable
         WmvcMenuItemCtl editEdit = new WmvcMenuItemCtl(editMenu,
             "Edit Current Variable","images/gray.gif", 'E',
             null /* no accel */,  new WmvcExecutor()
             {
                 public void execute(ActionEvent event)
                 {
                     Variable edited = theVariableEditor.showDialog(
                        WmvcApp.getFrame(), 
                        myModel.getCurrentVariable());
                     myModel.replaceCurrentVariable(edited);
                 }
             });
  
         // Edit->Add New Variable
         WmvcMenuItemCtl editNew = new WmvcMenuItemCtl(editMenu,
             "Add New Variable","images/addvariable-16.gif", 'A',
             null /* no accel */, new WmvcExecutor()
             {
                 public void execute(ActionEvent event)
                 {
                     Variable blank = new Variable();
                     Variable newVariable = theVariableEditor.showDialog(
                        WmvcApp.getFrame(), blank);
                     myModel.addVariable(newVariable);
                 }
             });
  
         // Edit->Remove Current Variable
         WmvcMenuItemCtl editRemove = new WmvcMenuItemCtl(
             editMenu,
             "Remove Current Variable","images/delx.gif", 'R',
              null /* no accel */, new WmvcExecutor()
             {
                 public void execute(ActionEvent event)
                 {
                     myModel.deleteCurrentVariable();
                 }
             });
         
         WmvcMenuItemCtl runn = new WmvcMenuItemCtl(
                 editMenu,
                 "Run Program","images/delx.gif", 'N',
                  null /* no accel */, new WmvcExecutor()
                  {
                	 public void execute(ActionEvent event)
                     {
                         run.actionPerformed();
                     }
                  }
                       
                 );
  
         WmvcApp.addMenu(editMenu);      // Add to app menu
  
         // ToolBar: Open
         WmvcTBButtonCtl toolOpen = new WmvcTBButtonCtl(
             "Open","images/open-16.gif",
             "Open an Existing Variable List",
             fileOpen.getWmvcExecutor()); // reuse fileopen exec
  
         // ToolBar: Add
         WmvcTBButtonCtl toolAdd = new WmvcTBButtonCtl(
             "Add Variable", "images/addvariable-16.gif",
             "Add a new variable",
             editNew.getWmvcExecutor()); // reuse editNew exec
     }
 }