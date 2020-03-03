package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import Model.*;
import Control.*;

public class AdminUI_Main extends JFrame{
	
	private final int UNIT =20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 30);
	private JPanel mainPanel, centralPanel, g1, g2;
	public JButton find, organize;
	public AdminCon_Main controller;
	public JLabel welcome;
	private Administrator model;
	
	public AdminUI_Main(School s, Administrator a, AdminCon_Main control) {
		controller = control;
		model = a;
		this.setTitle("< PTT System > Administrator");
		this.setSize(40*UNIT, 20*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel = new JPanel());
		mainPanel.setLayout(new BorderLayout());
		Border emptyBorder = BorderFactory.createEmptyBorder(2*UNIT,2*UNIT,2*UNIT,2*UNIT);
		mainPanel.setBorder(emptyBorder);
		mainPanel.add(centralPanel = new JPanel());
		centralPanel.setLayout(new GridLayout(5,1));
		welcome = new JLabel("Welcome! Dear Course Director " + a.getSName());
		welcome.setFont(f);
		centralPanel.add(welcome);
		centralPanel.add(g1=new JPanel());
		find = new JButton("Find Replacements");
		find.addActionListener(controller);
		centralPanel.add(find);
		centralPanel.add(g2=new JPanel());
		organize = new JButton("Organize Trainings");
		organize.addActionListener(controller);
		centralPanel.add(organize);
	}

}
