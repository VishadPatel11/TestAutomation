package com.vishadstool.autoprogram;

import java.awt.event.ActionEvent;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JList;

public class Runner  {
	ToolContent action= new ToolContent();
	VariableModel list = new VariableModel();
	VariableListView lis=new VariableListView();
	Variable var= new Variable(); 
	String text;
	String name;
	String xpath;
	
	Variable a;
	
	public void actionPerformed()
    {
        		//action.chromeBrowser();
		int b=lis.jlist.getSelectedIndex();
      //text=(String)list.theList.elementAt(b);
		
		
      text= (String)lis.variableList.getElementAt(b);
      name=(String)lis.variableName.getElementAt(b);
      xpath=(String)lis.variableXpath.getElementAt(b);
     
   
   
   
    System.out.println(text+name+xpath);
    
       
        
    }
}
