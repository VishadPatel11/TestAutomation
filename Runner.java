package com.vishadstool.autoprogram;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.winium.WiniumDriver;

public class Runner  {
	ToolContent run;
	VariableListView list;
	String action;
	String name;
	String xpath;	
	int b;
	int listSize;
	
	
	public Runner()
	{
		run= new ToolContent();
		list=new VariableListView();
		action= new String("");
		name=new String("");
		xpath=new String("");
		b= new Integer(0);
		listSize= new Integer(0);
		
	}
	
	public void actionPerformed()
    {
    		
			b=list.jlist.getSelectedIndex();
			listSize= list.variableAction.getSize();
			//start the browser
			run.chromeBrowser();
			
			
			for(int i=0; i < listSize; i++)
	{
		
			//assign the parameters the proper value
		action= (String)list.variableAction.getElementAt(b);
		name=(String)list.variableName.getElementAt(b);
		xpath=(String)list.variableXpath.getElementAt(b);
		System.out.println(action+name+xpath+ "..."+b);
		
		
			if(action.equalsIgnoreCase("click"))
			{
				
				//Pass the values to the parameters in the actions
				run.clickAction(xpath);
				System.out.println(action+name+xpath+ "..."+b);
				
			}else if(action.equalsIgnoreCase("validate")){
				 run.validateText(name, xpath);
				System.out.println(action+name+xpath+ "..."+b);
				
			}else 
			{
				run.waitAction(5);
				System.out.println(action+name+xpath+ "..."+b);
			}
		
		this.b=b+1;
	
	}
	
		
	 
       
    }
}