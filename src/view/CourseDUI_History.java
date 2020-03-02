package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import Control.CourseDCon_History;
import Control.CourseDCon_Main;
import Model.CourseD;
import Model.Request;
import Model.School;

public class CourseDUI_History extends JFrame{
	private final int UNIT = 20;
	public CourseDCon_History controller;
	private CourseD model;
	public JPanel mainPanel, centralPanel, c1, g1, g2;
	public JLabel introduction;
	public JButton back;
	public JList<String> list1, list2, list3;
	private Font f = new Font("TimesRoman", Font.PLAIN, 36);
	
	public CourseDUI_History(School s, CourseD d, CourseDCon_Main mainControl) {
		controller = new CourseDCon_History(s, d, mainControl);
		model = d;
		this.setTitle("< PTT System > Request History");
		this.setSize(60*UNIT,25*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel = new JPanel());
		mainPanel.setLayout(new BorderLayout());
		Border emptyBorder = BorderFactory.createEmptyBorder(3*UNIT,3*UNIT,3*UNIT,3*UNIT);
		mainPanel.setBorder(emptyBorder);
		mainPanel.add(centralPanel = new JPanel());
		centralPanel.setLayout(new GridLayout(5,1));
		
		
		//top
		introduction = new JLabel("Request      History");
		introduction.setSize(24*UNIT,3*UNIT);
		introduction.setFont(f);
		
		//central part: lists
		g1 = new JPanel();
		g1.setSize(24*UNIT,1*UNIT);
		g2 = new JPanel();
		g2.setSize(24*UNIT,1*UNIT);
		c1 = new JPanel();
		c1.setSize(24*UNIT, 32*UNIT);
		c1.setLayout(new GridLayout(1,3));
		
		String[] applyings = model.getApplyings();
		String[] approveds = model.getApproveds();
		String[] rejecteds = model.getRejecteds();
		list1 = new JList<String>(applyings);
		list2 = new JList<String>(approveds);
		list3 = new JList<String>(rejecteds);
		list1.setBorder(BorderFactory.createTitledBorder("Applying Requests"));
		list2.setBorder(BorderFactory.createTitledBorder("Approved Requests"));
		list3.setBorder(BorderFactory.createTitledBorder("Rejected Requests"));
		c1.add(list1);
		c1.add(list2);
		c1.add(list3);
		c1.add(new JScrollPane(this.list1));
		c1.add(new JScrollPane(this.list2));
		c1.add(new JScrollPane(this.list3));
		
		//bottom
		back = new JButton("Return Back");
		back.setSize(24*UNIT,3*UNIT);
		back.addActionListener(controller);
		
		//composition
		centralPanel.add(introduction);
		centralPanel.add(g1);
		centralPanel.add(c1);
		centralPanel.add(g2);
		centralPanel.add(back);
		}
	
}
