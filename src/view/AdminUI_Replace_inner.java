package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import Model.*;
import Control.*;

public class AdminUI_Replace_inner extends JFrame{
	
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.BOLD, 20);
	public AdminCon_Replace_inner controller;
	private Administrator model;
	private School school;
	private Teacher teacher;
	public JPanel mainPanel, centralPanel,c1;
	public JList<String> list1, list2;
	public JButton confirm;
	public JLabel info;
	
	public AdminUI_Replace_inner(School s, Administrator a, Teacher t) {
		teacher = t;
		controller = new AdminCon_Replace_inner(s,a,t);
		model = a;
		school = s;
		this.setTitle("< PTT System > Finding Replacement for Teacher:" + teacher.getSName());
		this.setSize(30*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.add(mainPanel = new JPanel());
		mainPanel.setLayout(new BorderLayout());
		Border emptyBorder = BorderFactory.createEmptyBorder(1*UNIT,1*UNIT,1*UNIT,1*UNIT);
		mainPanel.setBorder(emptyBorder);
		centralPanel = new JPanel();
		centralPanel.setLayout(new BorderLayout());
		mainPanel.add(centralPanel);
		
		//JLabel
		info = new JLabel("Finding Replacement for Teacher: " + teacher.getSName());
		info.setSize(3*UNIT,26*UNIT);
		
		//list init
		model.setReplacement(teacher);
		c1 = new JPanel();
		c1.setLayout(new GridLayout(1,2));
		model.setToBeReplacedCourses(teacher);
		list1 = new JList<String>(model.getToBeReplacedCoursesStringArray());
		list1.setBorder(BorderFactory.createTitledBorder("Courses Requiring New Teachers:"));
		list1.addMouseListener(controller);
		list2 = new JList<String>(model.getReplacementStringArray());
		list2.setBorder(BorderFactory.createTitledBorder("Able to be Replaced:"));
		list2.addMouseListener(controller);
		c1.add(list1);
		c1.add(list2);
		c1.add(new JScrollPane(list1));
		c1.add(new JScrollPane(list2));
		
		//the button
		confirm = new JButton("Confirm Replacement");
		confirm.addActionListener(controller);
		
		//composition
		centralPanel.add(info,BorderLayout.NORTH);
		centralPanel.add(c1,BorderLayout.CENTER);
		centralPanel.add(confirm,BorderLayout.SOUTH);
	}

}
