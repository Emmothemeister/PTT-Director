package view;

import Control.CourseDCon_Absence;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import Model.*;
import Control.*;

public class CourseDUI_Absence_inner extends JFrame{
	
	private final int UNIT = 20;
	public CourseDCon_Absence_inner controller;
	private CourseD model;
	private School school;
	private Teacher teacher;
	public JPanel mainPanel, topPanel, centralPanel, bottomPanel;
	public JLabel teacherSID, teacherName;
	public JList<String> list;
	public JButton confirm, cancel;
	private Font f = new Font("TimesRoman", Font.BOLD, 20);
	
	
	public CourseDUI_Absence_inner(School s, CourseD d, Teacher t) {
		teacher = t;
		controller = new CourseDCon_Absence_inner(s,d,t);
		model = d;
		school = s;
		this.setTitle("< PTT System > Marking Absence for Teacher:" + teacher.getSName());
		this.setSize(30*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.add(mainPanel = new JPanel());
		mainPanel.setLayout(new BorderLayout());
		Border emptyBorder = BorderFactory.createEmptyBorder(1*UNIT,1*UNIT,1*UNIT,1*UNIT);
		mainPanel.setBorder(emptyBorder);
		topPanel = new JPanel();
		topPanel.setSize(7*UNIT,28*UNIT);
		centralPanel = new JPanel();
		centralPanel.setSize(16*UNIT,28*UNIT);
		bottomPanel = new JPanel();
		bottomPanel.setSize(5*UNIT,28*UNIT);
		
		//top
		topPanel.setLayout(new GridLayout(2,1));
		teacherSID = new JLabel("Teacher ID: " + teacher.getSID());
		teacherSID.setFont(f);
		teacherName = new JLabel("Teacher Name " + teacher.getSName());
		teacherName.setFont(f);
		topPanel.add(teacherSID);
		topPanel.add(teacherName);
		
		//central
		String[] courseList = teacher.getPendingCourseList();
		list = new JList<String>(courseList);
		list.setBorder(BorderFactory.createTitledBorder("Schedule of the teacher"));
		list.setSize(14*UNIT,28*UNIT);
		centralPanel.add(list);
		centralPanel.add(new JScrollPane(this.list));
		
		
		//bottom
		bottomPanel.setLayout(new GridLayout(1,2));
		confirm = new JButton("Absent");
		confirm.addActionListener(controller);
		cancel = new JButton("In Position");
		cancel.addActionListener(controller);
		bottomPanel.add(confirm);
		bottomPanel.add(cancel);
		
		//composition
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(centralPanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
	}
}
