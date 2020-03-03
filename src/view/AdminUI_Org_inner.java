package view;

import Model.*;
import Control.*;
import view.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class AdminUI_Org_inner extends JFrame{
	
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.BOLD, 20);
	public AdminCon_Org_inner controller;
	private Administrator model;
	private School school;
	private Staff staff;
	public JList<String> list;
	public JLabel info;
	public JButton confirm;
	
	public JPanel mainPanel, centralPanel;
	
	public AdminUI_Org_inner(School s, Administrator a, Staff stf) {
		staff = stf;
		controller = new AdminCon_Org_inner(s,a,stf);
		model = a;
		school = s;
		this.setTitle("< PTT System > Finding Replacement for Teacher:" + staff.getSName());
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
		info = new JLabel("Organizing Training for: " + staff.getSName());
		info.setSize(3*UNIT,26*UNIT);
		info.setFont(f);
		
		//list init
		list = new JList<String>(school.getSkillListStringArray());
		list.setBorder(BorderFactory.createTitledBorder("Skill List:"));
		list.addMouseListener(controller);
		
		//button init
		confirm = new JButton("Confirm");
		confirm.addActionListener(controller);
		
		//composition
		centralPanel.add(info,BorderLayout.NORTH);
		centralPanel.add(list,BorderLayout.CENTER);
		centralPanel.add(confirm,BorderLayout.SOUTH);
		
	}

}
