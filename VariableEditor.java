package com.vishadstool.autoprogram;
/* VariableEditor - edits a Variable object for VariableCat
  * Copyright (c) 2001, Bruce E. Wampler
  */
  
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
  
 public class VariableEditor
     extends     JDialog
     implements  ActionListener
 {
     // Implement VariableEditor with Singleton pattern
     private static VariableEditor theVariableEditor = null;
     private Variable editedVariable = null;
     
     protected GridBagLayout gridbag;
     protected GridBagConstraints c;
  
     private JPanel itemPanel;
  
     // Various components needed for constructing the view
     // We use private statics of each of these since there will
     // be only one instance of the editor
  
     private static JLabel lblId=new JLabel("Variable Id: ");
     private static JTextField fldId = new JTextField(30);
     private static JLabel lblVariableName=new JLabel("VariableName: ");
     private static JTextField fldVariableName = new JTextField(30);
     private static JLabel lblVariableXpath = new JLabel("VariableXpath: ");
     private static JTextField fldVariableXpath = new JTextField(6);
     
     private static JLabel lblComments=new JLabel("Comments: ");
  
     private static JTextArea textArea;
     private static JButton bPrevious;
     private static JButton bNext;
     private static JButton bUpdate;
     private static JButton bRevert;
  
     private Variable variable;        // for a local copy
  
     protected void setAndAdd(JComponent comp,
     int gx, int gy, int gheight, int gwidth)
     {
         // to simplify laying out the gridbag
         c.anchor = c.WEST;
         c.gridx = gx; c.gridy = gy;
         c.gridheight = gheight; c.gridwidth = gwidth;
         gridbag.setConstraints(comp,c);
         itemPanel.add(comp);
     }
  
     static public VariableEditor getInstance()
     {
         if (theVariableEditor == null)
         {
             theVariableEditor = new VariableEditor();
         }
         return theVariableEditor;
     }
     
     public VariableEditor()
     {
         // call JDialog constructor
         super(WmvcApp.getFrame(), "Edit Variable", true);
     }
         
     public void initialize()
     {
         // We will use a GridBag for simple layout of itemView
         itemPanel = new JPanel();       // surrounding Panel
  
         gridbag = new GridBagLayout();
         c = new GridBagConstraints();
         itemPanel.setLayout(gridbag);
  
         itemPanel.setBorder(BorderFactory.createEmptyBorder(
                                                   5, 5, 5, 5));
  
         // Variable Id: ________________________
         setAndAdd(lblId, 0, 0, 1, 1);
         setAndAdd(fldId, 1, 0, 1, c.REMAINDER);
  
         // VariableName: _____________________
         setAndAdd(lblVariableName, 0, 1, 1, 1);
         setAndAdd(fldVariableName, 1, 1, 1, c.REMAINDER);
  
         // VariableXpath: _______      Genre: _________
         setAndAdd(lblVariableXpath,  0, 2, 1, 1);
         setAndAdd(fldVariableXpath,  1, 2, 1, 1);
         
         // Comment box:
         setAndAdd(lblComments,  0,5,1,1);
         textArea = new JTextArea(4,30);
         JScrollPane textScroll = new JScrollPane(textArea);
         setAndAdd(textScroll,  1,5,4,c.REMAINDER);
  
         // Command Buttons
  
         bRevert =   new JButton(" Cancel ");
         bRevert.setActionCommand("revert");
         bRevert.addActionListener(this);
         setAndAdd(bRevert, 2,9,1,1);
  
         bUpdate =   new JButton("   OK   ");
         bUpdate.setActionCommand("update");
         bUpdate.addActionListener(this);
         setAndAdd(bUpdate, 3,9,1,1);
         
         
  
         Container contentPane = getContentPane();
         contentPane.add(itemPanel,BorderLayout.CENTER);
         pack();
     }
     
     public Variable showDialog(Component comp, Variable m)
     {
         if (theVariableEditor == null || m == null)
             return null;
         editedVariable = null;
  
         variable = (Variable)m.clone();// make a copy to work with
         
         // Set box to current fields
         fldId.setText(variable.getId());
         fldVariableName.setText(variable.getVariableName());
         fldVariableXpath.setText(variable.getVariableXpath());
         textArea.setText(variable.getComments());
  
         setLocationRelativeTo(comp);
         setVisible(true);
         
         // will now wait here until actionPerformed
         // calls setVisible(false)
         
         return editedVariable;
     }
  
     // Implement ActionListener
     public void actionPerformed(ActionEvent e)
     {
         if (e.getActionCommand().equals("update"))
         {
             variable.setId(fldId.getText());
             variable.setVariableName(fldVariableName.getText());
             variable.setVariableXpath(fldVariableXpath.getText());
             variable.setComments(textArea.getText());
             editedVariable = variable;
             setVisible(false);
             
         }
         else if (e.getActionCommand().equals("revert"))
         {
             editedVariable = null;
             setVisible(false);
         }
          
     }
     
     
 }