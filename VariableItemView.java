package com.vishadstool.autoprogram;
/*
  * VariableItemView - the item View for the VariableCat model.
  * This implements a view of a single item - the current variable.
  * 
  */
  
 import java.util.*;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
  
 public class VariableItemView
         extends         WmvcView
         implements      ActionListener  // for buttons
 {
     protected GridBagLayout gridbag;
     protected GridBagConstraints c;
  
     private JPanel itemPanel;
     private VariableModel myModel;         // local copy
     
  
     // Various components needed for constructing the view
     // We use private statics of each of these since there will
     // be only one instance of the itemView
  
     private static JLabel lblAction = new JLabel("Action: ");
     private static JLabel fldAction = new JLabel(" ");
     private static JLabel lblVariableName = new JLabel("VariableName: ");
     private static JLabel fldVariableName = new JLabel(" ");
     private static JLabel lblVariableXpath = new JLabel("VariableXpath: ");
     private static JLabel fldVariableXpath = new JLabel(" ");
     private static JLabel lblComments =new JLabel("Comments: ");
     private static JLabel lblPassFail = new JLabel("Pass/Fail: ");
     public static JLabel fldPassFail = new JLabel();
     
     private static JTextArea textArea;
     private static JButton bPrevious;
     private static JButton bNext;
     private static JButton bEdit;
     
		
  
     public JPanel getPanel() { return itemPanel; }
  
     protected void setAndAdd(JComponent comp,
         int gx, int gy, int gheight, int gwidth, double wx)
     {
         // to simplify laying out the gridbag
         c.anchor = c.WEST;
         c.gridx = gx; c.gridy = gy;
         c.gridheight = gheight; c.gridwidth = gwidth;
         c.weightx = wx;
         gridbag.setConstraints(comp,c);
         itemPanel.add(comp);
     }
  
     public VariableItemView()
     {
         myModel = (VariableModel)WmvcApp.getModel();
         myModel.addView(this);          // adds update
  
         // We will use a GridBag for simple layout of itemView
  
         itemPanel = new JPanel();       // surrounding Panel
         gridbag = new GridBagLayout();
         c = new GridBagConstraints();
         itemPanel.setLayout(gridbag);
         itemPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
  
         // Set data fields to black foreground
         fldPassFail.setBackground(Color.black);
         fldAction.setForeground(Color.black);
         fldVariableName.setForeground(Color.black);
         fldVariableXpath.setForeground(Color.black);
         
         //Pass/Fail:_________________________
         setAndAdd(lblPassFail, 0,0,1,1,1.0);
         setAndAdd(fldPassFail, 1, 0, 1, c.REMAINDER,0.0);
         // Action:________________________
         setAndAdd(lblAction,  0, 2, 1, 1,1.0);
         setAndAdd(fldAction,  1, 2, 1, c.REMAINDER,0.0);
         
  
         // VariableName: _____________________
         setAndAdd(lblVariableName, 0, 3, 1, 1, 1.0);
         setAndAdd(fldVariableName, 1, 3, 1, c.REMAINDER, 0.0);
  
         // VariableXpath: _______      
         setAndAdd(lblVariableXpath,  0, 4, 1, 1, 1.0);
         setAndAdd(fldVariableXpath,  1, 4, 1, c.REMAINDER, 0.0);
      
         // Comment box:
         setAndAdd(lblComments,  0,7,1,1, 1.0);
         textArea = new JTextArea(4,30);
         JScrollPane textScroll = new JScrollPane(textArea);
         setAndAdd(textScroll,  1,7,4,c.REMAINDER, 0.0);
  
         // Command Buttons
         bEdit =   new JButton("  Edit  ");
         bEdit.setActionCommand("edit");
         bEdit.addActionListener(this);
         bEdit.setToolTipText("Edit current variable");
         setAndAdd(bEdit, 2,11,1,1, 0.0);
  
         bPrevious = new JButton("Previous");
         bPrevious.addActionListener(this);
         bPrevious.setActionCommand("previous");
         bPrevious.setIcon(new ImageIcon("images/left-16.gif"));
         bPrevious.setToolTipText("Go to previous variable");
         setAndAdd(bPrevious, 3,11,1,1, 0.0);
  
         bNext =     new JButton("Next");
         bNext.setActionCommand("next");
         bNext.addActionListener(this);
         bNext.setIcon(new ImageIcon("images/right-16.gif"));
         bNext.setToolTipText("Go to next variable");
         setAndAdd(bNext, 4,11,1,1,0.0);
     }
  
     public void updateView()
     {
         // When model changes - update each fld componenet
         Variable m = myModel.getCurrentVariable();
         //
         fldAction.setText(VariableAction.stringAt(m.getAction()));
         fldVariableName.setText(m.getVariableName());
         fldVariableXpath.setText(m.getVariableXpath());
         textArea.setText(m.getComments());
         
     }
  
     
     
     // Implement ActionListener
     public void actionPerformed(ActionEvent e)
     {
         // Since only three buttons, easier to use one listener
         if (e.getActionCommand().equals("edit"))
         {
             Variable edited = 
                 VariableEditor.getInstance().showDialog(
                    WmvcApp.getFrame(),
                    myModel.getCurrentVariable());
             myModel.replaceCurrentVariable(edited);
         }
         else if (e.getActionCommand().equals("previous"))
         {
             myModel.setCurrentVariableIndex(
                  myModel.getCurrentVariableIndex()-1);
         }
         else if (e.getActionCommand().equals("next"))
         {
             myModel.setCurrentVariableIndex(
                  myModel.getCurrentVariableIndex()+1);
         }
     }
     
 }
 