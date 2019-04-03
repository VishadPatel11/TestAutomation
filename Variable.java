package com.vishadstool.autoprogram;
/* Variable - Defines and manipulates a Variable object for VariableCat
  * Copyright (c) 2001, Bruce E. Wampler
  */
  
 import java.io.*;
  
 public class Variable implements  Cloneable
 {
     
	 protected int variablePassFail;
     protected String variableName;
     protected String variableXpath;
     protected String comments;
     protected int Action;
     
     public void setVariablePassFail(int variablePassFail) { this.variablePassFail = variablePassFail; }
     public int getVariablePassFail() { return variablePassFail; }
     public void setAction(int g) { Action = g; }
     public int getAction() { return Action; }
     public void setVariableName(String variableName) { this.variableName = variableName; }
     public String getVariableName() { return variableName; }
     public void setVariableXpath(String variableXpath) { this.variableXpath = variableXpath; }
     public String getVariableXpath() { return variableXpath; }
     public void setComments(String c) { this.comments = c; }
     public String getComments() { return comments; }
  
     public Variable()
     {
    	
    	 //variablePassFail=0;
         variableName = new String("");
         variableXpath = new String("");   
         comments = new String("");
         Action = 0;
     }
  
     // override Object.clone()
     public Object clone() 
     {
         Variable c = null;
         try
         {
             c = (Variable)super.clone();          		// copy ints
                    									// String doesn't
             c.variableName = new String(variableName); // have clone so
                 										// make copy of
             c.comments = new String(comments);			 // each String
         }
         catch (CloneNotSupportedException e)
         {
             System.out.println(
                     "Should never happen: Variable clone failed.");
         }
         return c;
     }
  
     public boolean readVariable(DataInputStream in)
         throws IOException
     {
         try             // read one VariableCat record
         {
        	 
        	 Action = in.readInt();
             variableName = new String(in.readUTF());
             variableXpath = new String(in.readUTF());     
             comments = new String(in.readUTF());
             return true;
         }
         catch (EOFException e)  // all records read
         {
             in.close();
             return false;
         }      
     }
  
     public void writeVariable(DataOutputStream out)
         throws IOException
     {
         out.writeInt(variablePassFail);
         out.writeInt(Action);
         out.writeUTF(variableName);
         out.writeUTF(variableXpath);
         out.writeUTF(comments);
         
     }    
     
 }