package view;

import Model.*;
import view.*;
import Control.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class AdminUI_Replace extends JFrame{
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private JPanel mainPanel = new JPanel();
	private JPanel centralPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private Administrator model;
	public AdminCon_Replace controller;
	public JList<String> list;
	public JButton back, confirm;
	
	public AdminUI_Replace(School s, Administrator a, AdminCon_Main mainControl) {
		model = a;
		controller = new AdminCon_Replace(s,a,mainControl);
		this.setTitle("< PTT System > Requireing Replacement");
		this.setSize(40*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		Border emptyBorder = BorderFactory.createEmptyBorder(2*UNIT,2*UNIT,2*UNIT,2*UNIT);
		mainPanel.setBorder(emptyBorder);
		
		mainPanel.add(centralPanel);
		centralPanel.setLayout(new BorderLayout());
		
		//top
		model.setToBeReplaced();
		list = new JList<String>(model.getToBeReplacedStringArray());
		list.addMouseListener(controller);
		list.setBorder(BorderFactory.createTitledBorder("Replacement Required"));
		
		//bottom
		bottomPanel.setLayout(new GridLayout(1,2));
		back = new JButton("Return");
		back.addActionListener(controller);
		confirm = new JButton("Find Replacement");
		confirm.addActionListener(controller);
		bottomPanel.add(back);
		bottomPanel.add(confirm);
		
		//composition
		centralPanel.add(list,BorderLayout.CENTER);
		centralPanel.add(bottomPanel,BorderLayout.SOUTH);
		centralPanel.add(new JScrollPane(list));
		
		
	}
}
