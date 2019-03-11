package com.vishadstool.autoprogram;

import java.util.Scanner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.List;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.border.BevelBorder;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.SwingConstants;
import java.awt.Point;
import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

public class TAC {

	private JFrame frame;
	private final Action action = new SwingAction();
	ToolContent test= new ToolContent();
	DefaultListModel<VariableTest> model = new DefaultListModel<VariableTest>();
	//LinkedHashMap<String, String> demoList= new LinkedHashMap<String, String>();
	Scanner inputText = new Scanner (System.in);
	
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TAC window = new TAC();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TAC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 727, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JInternalFrame internalFrame = new JInternalFrame("Actions ");
		internalFrame.setVisible(true);
		
		JInternalFrame internalFrame_1 = new JInternalFrame("TestCase");
		internalFrame_1.setVisible(true);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(internalFrame_1, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(internalFrame, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(internalFrame_1, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
				.addComponent(internalFrame, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
		);
		
		JMenuBar menuBar_2 = new JMenuBar();
		internalFrame_1.setJMenuBar(menuBar_2);
		
		JMenu mnTools = new JMenu("Tools");
		mnTools.setToolTipText("list of tools");
		mnTools.setHorizontalTextPosition(SwingConstants.LEADING);
		mnTools.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		
		JMenuItem mntmNewScript = new JMenuItem("New Script");
		menuBar_2.add(mntmNewScript);
		menuBar_2.add(mnTools);
		
		JMenuItem mntmVariable = new JMenuItem("Variable");
		mntmVariable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id=textField_3.getText();
				String name=textField.getText();
				String field=textField_2.getText();
				//demoList.put(id, name, field);
				VariableTest var1= new VariableTest(id,name,field);
				model.addElement(var1);
			
			}
		});
		mnTools.add(mntmVariable);
		
		
		JMenuItem mntmAction = new JMenuItem("Action");
		mntmAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		mnTools.add(mntmAction);
		
		JMenuItem mntmWait = new JMenuItem("Wait");
		mntmWait.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//demoList.add(0, "Wait Added");
			}
		});
		mnTools.add(mntmWait);
		
		JMenuItem mntmComment = new JMenuItem("Comment");
		mntmComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//demoList.add(0, "Comment Added");
			}
		});
		mnTools.add(mntmComment);
		internalFrame_1.getContentPane().setLayout(null);
		
		JList list = new JList(model);
		list.setAlignmentX(Component.RIGHT_ALIGNMENT);
		list.setBorder(new TitledBorder(null, "Write Your Script ", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		list.setBounds(0, 0, 416, 521);
		internalFrame_1.getContentPane().add(list);
		
		JMenuBar menuBar_1 = new JMenuBar();
		internalFrame.setJMenuBar(menuBar_1);
		internalFrame.getContentPane().setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Xpath:");
		lblNewLabel.setBounds(12, 87, 56, 16);
		internalFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Expected:");
		lblNewLabel_1.setBounds(12, 58, 56, 16);
		internalFrame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(94, 26, 116, 22);
		internalFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 55, 116, 22);
		internalFrame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(94, 84, 148, 22);
		internalFrame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblVaribleName = new JLabel("Varible Name:");
		lblVaribleName.setBounds(12, 29, 86, 16);
		internalFrame.getContentPane().add(lblVaribleName);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(94, 128, 97, 25);
		internalFrame.getContentPane().add(btnSave);
		
		JLabel lblVariableId = new JLabel("Variable ID:");
		lblVariableId.setBounds(12, 0, 77, 16);
		internalFrame.getContentPane().add(lblVariableId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(94, -3, 116, 22);
		internalFrame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnOpenBrowser = new JMenu("Open Browser");
		mnFile.add(mnOpenBrowser);
		
		JMenuItem mntmChrome = new JMenuItem("Chrome");
		mntmChrome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					test.chromeBrowser();
			}
		});
		mnOpenBrowser.add(mntmChrome);
		
		JMenuItem mntmFirefox = new JMenuItem("FireFox");
		mntmFirefox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
					test.firefoxBrowser();
			}
		});
		mnOpenBrowser.add(mntmFirefox);
		
		JMenuItem mntmInternetExplorer = new JMenuItem("Internet Explorer");
		mntmInternetExplorer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
					test.ieBrowser();
			}
		});
		mnOpenBrowser.add(mntmInternetExplorer);
		
		JMenuItem mntmSafari = new JMenuItem("Safari");
		mnOpenBrowser.add(mntmSafari);
		
		JMenuItem mntmEdge = new JMenuItem("Edge");
		mnOpenBrowser.add(mntmEdge);
		
		JMenu mnOpenApplication = new JMenu("Open application");
		mnFile.add(mnOpenApplication);
		
		JMenuItem mntmWindowsApplication = new JMenuItem("Windows application");
		mntmWindowsApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				test.windowApplication();
				
			}
		});
		mnOpenApplication.add(mntmWindowsApplication);
		
		JMenu mnSave = new JMenu("Save");
		mnFile.add(mnSave);
		
		JMenuItem mntmImport = new JMenuItem("Import");
		mnFile.add(mntmImport);
		
		JMenuItem mntmExport = new JMenuItem("Export");
		mnFile.add(mntmExport);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
		
		
		
	}
}
