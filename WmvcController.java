package com.vishadstool.autoprogram;
/*
  * WmvcController - implements a general purpose Swing based
  *     Controller using the Command pattern - for Wmvc framework
  * Used to simplify Swing controls
  *
  * (c) 2001, Bruce E. Wampler
  */
  
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import javax.swing.event.*;
  
 public class WmvcController
         implements      ActionListener,
                         ItemListener
 {
     protected JComponent myComponent;
     private WmvcExecutor wmvcExecutor;  // The Executor object
  
     // This constructor is use by the subobjects
     public WmvcController(JComponent comp,    // the component
                           String tip,
                           WmvcExecutor wExec)
     {
         myComponent = comp;
         wmvcExecutor = wExec;
         if (tip != null)
             myComponent.setToolTipText(tip);
     }
  
     public WmvcExecutor getWmvcExecutor()
         { return wmvcExecutor; }
  
     /* ------------------------------------------------------
      * Implement the Listeners for components.
      * Each listener will send a message to the appropriate
      * execute method from the associated WmvcExecutor. Type
      * of event determines the signature of the execute method.
      */
  
     // implment the ActionListener
     public void actionPerformed(ActionEvent event)
     {
         if (wmvcExecutor != null)
             wmvcExecutor.execute(event);
     }
  
     // implement ItemLisetener
     public void itemStateChanged(ItemEvent event)
     {
         if (wmvcExecutor != null)
             wmvcExecutor.execute(event);
     }
 }