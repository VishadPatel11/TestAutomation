package com.vishadstool.autoprogram;
/*
  * WmvcChkMenuItemCtl - implements JCheckBoxMenuItem controller
  * (c) 2001, Bruce E. Wampler
  */
  
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import javax.swing.event.*;
  
 public class WmvcChkMenuItemCtl extends WmvcController
 {
     private JMenu myMenu;
     private JCheckBoxMenuItem checkBoxItem;
  
     
     // Constructor for JMenu item:  JCheckBoxMenuItem
     public WmvcChkMenuItemCtl(JMenu menu,       // JMenu I go with
                         String text,        // Button's text
                         String icon,        // the icon's name
                         char mnemonic,      // Button's mnemonic
                         String accel,       // accelerator
                         boolean checked,    // initial state
                         WmvcExecutor wExec)
     {
         super((JComponent)new JCheckBoxMenuItem(), null, wExec);
         
         myMenu = menu;
         JCheckBoxMenuItem checkBoxMenuItem = (JCheckBoxMenuItem) myComponent;
         if (text != null)
             checkBoxItem.setText(text);
         if (mnemonic != ' ' && mnemonic != 0)
             checkBoxItem.setMnemonic(mnemonic);
         if (accel != null)
           {
             KeyStroke ks = KeyStroke.getKeyStroke(accel);
             checkBoxItem.setAccelerator(ks);
           }
         if (icon != null)
           {
             Icon theIcon = new ImageIcon(icon);
             checkBoxItem.setIcon(theIcon);
           }
  
         checkBoxItem.setState(checked);
  
         checkBoxItem.addActionListener(this);   // Add listeners
         checkBoxItem.addItemListener(this);
         myMenu.add(checkBoxItem);        // Finally, add to menu
     }
  
     public boolean getState()
     {   return checkBoxItem.getState();
     }
     public void setState(boolean checked)
     {   checkBoxItem.setState(checked);
     }
     public void setEnabled(boolean enable)
     {   checkBoxItem.setEnabled(enable);
     }
     public JMenu getJMenu() { return myMenu; }
     public JCheckBoxMenuItem getJCheckBoxMenuItem()
     {   return checkBoxItem;
     }
 }
