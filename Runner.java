package com.vishadstool.autoprogram;

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
	
	
	public void actionPerformed(String browser)
    {
    		
			b=list.jlist.getSelectedIndex();
			listSize= list.variableName.getSize();
			//start the browser
			if(browser.equalsIgnoreCase("chrome"))
			{
					run.chromeBrowser();
					//System.out.println("i started Chrome");
			}else if (browser.equalsIgnoreCase("firefox"))
			{
					run.firefoxBrowser();
			}else if (browser.equalsIgnoreCase("IE"))
			{
					run.ieBrowser();
			}else if (browser.equalsIgnoreCase("desktopApp"))
			{
				run.desktopApplication();
			}
		
			
		//Run the Script step by step	
			for(int i=0; i < listSize; i++)
	{
		
			//assign the parameters the proper value
		action=(String)list.action.getElementAt(b);
				//action= (String)VariableAction.stringAt(b);
		name=(String)list.variableName.getElementAt(b);
		xpath=(String)list.variableXpath.getElementAt(b);
		
		
		
			if(action.equalsIgnoreCase("Click"))
			{
				
				//Pass the values to the parameters in the actions
				boolean flag=false; 
				
				run.clickAction(xpath);
				
				//System.out.println("this is a click");
				//System.out.println(action+name+xpath+b);
				
			}else if(action.equalsIgnoreCase("Validate Text")){
				 boolean passFail= run.validateText(name, xpath);
				 if (passFail==true)
				 {
					
					//not working 
					 Variable m= new Variable();
					 m.setVariablePassFail(1);
					
				 }else
				 {
					 Variable m= new Variable();
					 m.setVariablePassFail(2);
					 //VariableItemView.fldPassFail.setText(VariablePassFail.stringAt(2));
				 }
				//System.out.println("this is a validate text");
				//System.out.println(action+name+xpath+b);
				
			}else if(action.equalsIgnoreCase("Wait")) 
			{
				run.waitAction(xpath);
				//System.out.println(" this is a wait");
				//System.out.println(action+name+xpath+b);
				
			}else if(action.equalsIgnoreCase("close"))
				{
				run.close();
				restore();
				//System.out.println(action+name+xpath+b);
				
				}
			this.b=b+1;
		}
		
	}
	
	
	public void restore()
	{
		VariableItemView.fldPassFail.setText(VariablePassFail.stringAt(0));
		run= new ToolContent();
		list=new VariableListView();
		action= new String("");
		name=new String("");
		xpath=new String("");
		b= new Integer(0);
		listSize= new Integer(0);
		
	}
	
		
	 
       
}
