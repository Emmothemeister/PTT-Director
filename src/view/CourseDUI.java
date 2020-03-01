package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import Model.CourseD;
public class CourseDUI extends JFrame{
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private JPanel mainPanel, centralPanel, g1,g2,g3;
	
	public CourseDUI(CourseD d) {
		this.setTitle("< PTT System > Course Director");
		this.setSize(40*UNIT, 30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		Border emptyBorder = BorderFactory.createEmptyBorder(3*UNIT,3*UNIT,3*UNIT,3*UNIT);
		mainPanel.setBorder(emptyBorder);
		
		mainPanel.add(centralPanel);
		centralPanel.setLayout(new GridLayout(7,1));
		JLabel welcome = new JLabel("Welcome! Dear Course Director " + d.getSName());
		centralPanel.add(welcome);
		centralPanel.add(g1);
		JButton write = new JButton("Write a new Teaching Request");
		centralPanel.add(write);
		write.addActionListener();
		centralPanel.add(g2);
		JButton enquiry = new JButton("Enquiry previous Teaching Request status");
		centralPanel.add(enquiry);
		enquiry.addActionListener();
		centralPanel.add(g3);
		JButton absence = new JButton("Mark a teacher as absence from some lectures");
		centralPanel.add(absence);
		absence.addActionListener();
		
	}
}
