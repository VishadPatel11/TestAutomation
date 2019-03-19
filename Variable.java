package com.vishadstool.autoprogram;
/* Variable - Defines and manipulates a Variable object for VariableCat
  * Copyright (c) 2001, Bruce E. Wampler
  */
  
 import java.io.*;
  
 public class Variable implements  Cloneable
 {
     
	 protected String action;
     protected String variableName;
     protected String variableXpath;
     protected String comments;
  
     
     
     public void setAction(String action) { this.action = action; }
     public String getAction() { return action; }
     public void setVariableName(String variableName) { this.variableName = variableName; }
     public String getVariableName() { return variableName; }
     public void setVariableXpath(String variableXpath) { this.variableXpath = variableXpath; }
     public String getVariableXpath() { return variableXpath; }
     public void setComments(String c) { this.comments = c; }
     public String getComments() { return comments; }
  
     public Variable()
     {
    	
         action = new String(""); 
         variableName = new String("");
         variableXpath = new String("");   
         comments = new String("");
     }
  
     // override Object.clone()
     public Object clone() 
     {
         Variable c = null;
         try
         {
             c = (Variable)super.clone();          		// copy ints
             c.action = new String(action);       				// String doesn't
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
        	 
             action = new String(in.readUTF());
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
         out.writeUTF(action);
         out.writeUTF(variableName);
         out.writeUTF(variableXpath);
         out.writeUTF(comments);
         
     }    
 }