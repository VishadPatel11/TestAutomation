package com.vishadstool.autoprogram;
/*
  * WmvcTBButtonCtl - implements JButton controller for tool bar
  * (c) 2001, Bruce E. Wampler
  */
  
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import javax.swing.event.*;
  
 public class WmvcTBButtonCtl extends WmvcController
 {
     private JButton myButton;
     
     // Constructor for JToolBar item:  JButton
     public WmvcTBButtonCtl( String text,        // Button's text
                             String icon,        // the icon's name
                             String tip,         // tool tip
                             WmvcExecutor wExec)
     {
         super((JComponent)new JButton(), tip, wExec);
         
         myButton = (JButton) myComponent;
     
         if (text != null)
             myButton.setText(text);
         if (icon != null)
           {
             Icon theIcon = new ImageIcon(icon);
             myButton.setIcon(theIcon);
           }
  
         myButton.addActionListener(this);       // add listener
         WmvcApp.getToolBar().add(myButton);     // add to bar
     }    
  
     public void setEnabled(boolean enable)
     {   myButton.setEnabled(enable);
     }
     public JButton getJButton() { return myButton; }
 }
