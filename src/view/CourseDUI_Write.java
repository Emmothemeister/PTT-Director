package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import Control.CourseDCon_Main;
import Control.CourseDCon_Write;
import Model.CourseD;
import Model.School;

public class CourseDUI_Write extends JFrame{
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private JPanel mainPanel = new JPanel();
	private JPanel centralPanel = new JPanel();
	private String cont;
	private String cos;
	public CourseDCon_Write controller;
	public JButton submit;
	public JButton back;
	public JTextField content, cost;
	
	public CourseDUI_Write(School s, CourseD d, CourseDCon_Main mainControl) {
		controller = new CourseDCon_Write(s, d,mainControl);
		this.setTitle("< PTT System > Wrtting Teaching Request");
		this.setSize(40*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		Border emptyBorder = BorderFactory.createEmptyBorder(3*UNIT,3*UNIT,3*UNIT,3*UNIT);
		mainPanel.setBorder(emptyBorder);
		
		mainPanel.add(centralPanel);
		centralPanel.setLayout(new GridLayout(4,1));
		content = new JTextField(16*UNIT);
		content.setText("Please enter contents here");

		cost = new JTextField(4*UNIT);
		cost.setText("Please enter the [number] of cost here");
		submit = new JButton("Submit Request");
		submit.setSize(4*UNIT, 34*UNIT);
		submit.addActionListener(controller);
		back = new JButton("Return Back");
		back.setSize(4*UNIT,34*UNIT);
		back.addActionListener(controller);
		centralPanel.add(content);
		centralPanel.add(cost);
		centralPanel.add(submit);
		centralPanel.add(back);
		
		cont = content.getText();
		cos = cost.getText();
		
	}
	
	public String getContent() {
		return content.getText();
	}
	
	public String getCost() {
		return cost.getText();
	}
	
	public void clearCost() {
		cost.setText("");
	}
	
	public void clearContent() {
		content.setText("");
	}
	
}
