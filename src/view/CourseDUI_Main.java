package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import Control.CourseDCon_Main;
import Model.CourseD;
public class CourseDUI_Main extends JFrame{
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private JPanel mainPanel, centralPanel, g1,g2,g3;
	public JButton write;
	public JButton enquiry, absence;
	public CourseDCon_Main controller;
	private CourseD model;
	
	public CourseDUI_Main(CourseD d, CourseDCon_Main control) {
		controller = control;
		model = d;
		this.setTitle("< PTT System > Course Director");
		this.setSize(40*UNIT, 30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel = new JPanel());
		mainPanel.setLayout(new BorderLayout());
		Border emptyBorder = BorderFactory.createEmptyBorder(3*UNIT,3*UNIT,3*UNIT,3*UNIT);
		mainPanel.setBorder(emptyBorder);
		mainPanel.add(centralPanel = new JPanel());
		centralPanel.setLayout(new GridLayout(7,1));
		JLabel welcome = new JLabel("Welcome! Dear Course Director " + d.getSName());
		centralPanel.add(welcome);
		centralPanel.add(g1 = new JPanel());
		write = new JButton("Write a new Teaching Request");
		write.addActionListener(controller);
		centralPanel.add(write);
		centralPanel.add(g2 = new JPanel());
		enquiry = new JButton("Enquiry previous Teaching Request status");
		centralPanel.add(enquiry);
		//enquiry.addActionListener();
		centralPanel.add(g3 = new JPanel());
		absence = new JButton("Mark a teacher as absence from some lectures");
		centralPanel.add(absence);
		//absence.addActionListener();
		
	}
	
	
	
	
}
