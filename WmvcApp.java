package com.vishadstool.autoprogram;
/*
  * WmvcApp - The main Application Class for Wmvc
  * 
  */
  
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
  
 public abstract class WmvcApp
 {
     private static WmvcApp theApp = null;       // Singleton
  
     // Model
     
     protected static WmvcModel theModel = null;
     
     // GUI interface parts
     private static JFrame theFrame = null;  // The topmost frame
     private static JMenuBar theMenuBar = null;
     private static JToolBar theToolBar = null;
     private static JPanel theContentPanel = null;
     
    
     public static JFrame getFrame() { return theFrame; }
     public static JMenuBar getMenuBar() { return theMenuBar; }
     public static JToolBar getToolBar() { return theToolBar; }
     public static JPanel getContentPanel()
         { return theContentPanel; }
     public static WmvcModel getModel() { return theModel; }
     public static void setModel(WmvcModel m) { theModel = m; }
     
     public static WmvcApp getApp()
     {
         return theApp;
     }
     
     // Only one constructor. Could have alternates:
     //        public WmvcApp()
     //        public WmvcApp(String aName)
     public WmvcApp(String aName, boolean cMenu, boolean cTool)
     {
         if (theApp != null)
             return;
         theApp = this;
         initializeWmvc(aName,cMenu,cTool);
     }
     
     private void initializeWmvc(String aName, boolean cMenu,
                                 boolean cTool)
     {
         // Step 1 - set up the main JFrame
         theFrame = new JFrame(aName);
  
         // handle closing cleanly
         theFrame.setDefaultCloseOperation(
                                     JFrame.DO_NOTHING_ON_CLOSE);
         theFrame.addWindowListener(new WindowAdapter()
           {
               public void windowClosing(WindowEvent e)
               { 
                   if (theApp.appClosing())
                       System.exit(0);
               } 
           });
  
         // Step 2 - the menu bar
         if (cMenu)              // add a MenuBar?
         {
             theMenuBar = new JMenuBar();
             theFrame.setJMenuBar(theMenuBar);
         }
  
         // Step 3 - the JPanel (may or may not have a tool bar)
 
         theContentPanel = new JPanel();             // A JPanel
         theContentPanel.setLayout(new BorderLayout());
         theContentPanel.setPreferredSize(
                 new Dimension(400, 300));
  
         if (cTool)              // add a Tool Bar?
         {
             theToolBar = new JToolBar();
             theContentPanel.add(theToolBar,BorderLayout.NORTH);
         }
  
         // Note: we could add a status bar (another ToolBar) at
         // the bottom by using BorderLayout.SOUTH
  
         theFrame.setContentPane(theContentPanel);
     }
     
     public static void addMainPane(JComponent pane)
     {
         // This will add the "user" pane to the content pane
         theContentPanel.add(pane,BorderLayout.CENTER);
     }
     
     public static void addMenu(JMenu menu)
     {
         if (theMenuBar == null)
             return;
         theMenuBar.add(menu);
     }
     
     public static void showApp()
     {
         theFrame.pack();
         theFrame.setVisible(true);
     }
     
     public boolean appClosing()
     {
         return true;  // Default behavior - close automatically
     }
 }
