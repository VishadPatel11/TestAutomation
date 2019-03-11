package com.vishadstool.autoprogram;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;



public class XMLReaderAndWriter 
{

	
	public static void main(String[] args) throws DocumentException
	{
		

		File inputFile = new File("C:\\Users\\xbbnvfm\\workspace\\WiniumTool\\properties.xml");
        
        
		try {
          	SAXReader reader = new SAXReader();
          	Document document = reader.read( inputFile );
           List<Node> nodes = document.selectNodes("/menu/elements");
            
           for (Node node : nodes) {
               System.out.println("\nCurrent Element :"
                  + node.getName());
               System.out.println("Student roll no : " 
                  + node.valueOf("xpath"));
            
               
           }
         } catch (DocumentException e) {
            e.printStackTrace();
         	}
		
					
	}
	
}
	
