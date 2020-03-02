package view;

import Control.CourseDCon_Absence;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import Model.*;
import Control.*;

public class CourseDUI_Absence extends JFrame{
	private final int UNIT = 20;
	public CourseDCon_Absence controller;
	private CourseD model;
	public JPanel mainPanel, centralPanel, bottomPanel;
	public JLabel introduction;
	public JList<String> list;
	public String[] teacherList;
	private School school;
	public JButton confirm, back;
	private Font f = new Font("TimesRoman", Font.PLAIN, 36);
	
	public CourseDUI_Absence(School s, CourseD d, CourseDCon_Main mainControl) {
		school = s;
		controller = new CourseDCon_Absence(s,d,mainControl);
		model = d;
		this.setTitle("< PTT System > Mark a Teacher as Absent");
		this.setSize(60*UNIT,25*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel = new JPanel());
		mainPanel.setLayout(new BorderLayout());
		Border emptyBorder = BorderFactory.createEmptyBorder(1*UNIT,1*UNIT,1*UNIT,1*UNIT);
		mainPanel.setBorder(emptyBorder);
		mainPanel.add(centralPanel = new JPanel());
		centralPanel.setLayout(new BorderLayout());
		
		//top
		introduction = new JLabel("Mark a Teacher as Absent");
		introduction.setFont(f);
		introduction.setSize(6*UNIT,22*UNIT);

		//central part
		school.setTeacherList();
		teacherList = school.getTeacherStringArray();
		list = new JList<String>(teacherList);
		list.addMouseListener(controller);
		
		//bottom
		confirm = new JButton("Check and Mark the selected teacher");
		confirm.setSize(3*UNIT,22*UNIT);
		confirm.addActionListener(controller);
		
		back = new JButton("Return");
		back.setSize(3*UNIT,22*UNIT);
		back.addActionListener(controller);
		
		//composition
		centralPanel.add(introduction, BorderLayout.NORTH);
		centralPanel.add(list, BorderLayout.CENTER);
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(2,1));
		centralPanel.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.add(confirm);
		bottomPanel.add(back);
		
	}
	
	//test
//	public static void main(String[] args) {
//		School s = new School();
//		Course c = new Course("PE", "train", s);
//		CourseD d = new CourseD("Emmo", "goloku", "123456", 123456, c, s);
//		Teacher t1 = new Teacher("Teacher 1", "teacher1", "123456", 123456, s);
//		Teacher t2 = new Teacher("Teacher 2", "teacher2", "123456", 123456, s);
//		Teacher t3 = new Teacher("Teacher 3", "teacher3", "123456", 123456, s);
//		d.addTeacher(t1);
//		d.addTeacher(t2);
//		d.addTeacher(t3);
//		CourseDUI_Absence GUI = new CourseDUI_Absence(s,d,new CourseDCon_Main(s,d));
//		
//		System.out.print(GUI.teacherList[0]);
//	}
	
}
