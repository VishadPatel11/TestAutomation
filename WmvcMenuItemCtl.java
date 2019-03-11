package com.vishadstool.autoprogram;
 /*
  * WmvcMenuItemCtl - implements JMenuItem controller
  * (c) 2001, Bruce E. Wampler
  */
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import javax.swing.event.*;
  
 public class WmvcMenuItemCtl extends WmvcController
 {
  
     private JMenu myMenu;
     private JMenuItem menuItem;
     
         // Constructor for JMenu item: Standard JMenuItem
     public WmvcMenuItemCtl(JMenu menu,       // JMenu I go with
                         String text,        // Button's text
                         String icon,        // the icon's name
                         char mnemonic,      // Button's mnemonic
                         String accel,       // accelerator
                         WmvcExecutor wExec)
     {
         super((JComponent)new JMenuItem(), null, wExec);
         
         myMenu = menu;
         menuItem = (JMenuItem) myComponent;
  
         if (text != null)
             menuItem.setText(text);
         if (mnemonic != ' ' && mnemonic != 0)
             menuItem.setMnemonic(mnemonic);
         if (accel != null)
           {
             KeyStroke ks = KeyStroke.getKeyStroke(accel);
             menuItem.setAccelerator(ks);
           }
         if (icon != null)
           {
             Icon theIcon = new ImageIcon(icon);
             menuItem.setIcon(theIcon);
           }
         menuItem.addActionListener(this);  // Add listeners
         menuItem.addItemListener(this);
         menu.add(menuItem);              // Finally, add to menu
     }
   
     public void setEnabled(boolean enable)
     {
         menuItem.setEnabled(enable);
     }
  
     public JMenu getJMenu() { return myMenu; }
     public JMenuItem getJMenuItem() { return menuItem; }
 }
