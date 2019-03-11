package com.vishadstool.autoprogram;

public class VariableTest {
	String id;
	String variableName;
	String variableXpath;
	
 public  VariableTest(String id, String variableName, String variableXpath)
 {
	 this.id=id;
	 this.variableName=variableName;
	 this.variableXpath=variableXpath;	 
	 
 }

/*
public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
	
}

public String getVariableId() {
	return variableName;
}

public void setVariableId(String variableName) {
	this.variableName = variableName;
}

public String getVariableXpath() {
	return variableXpath;
}

public void setVariableXpath(String variableXpath) {
	this.variableXpath = variableXpath;
}
*/
@Override
public String toString(){
	return id+variableName+variableXpath;

}


}
