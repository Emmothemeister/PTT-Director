package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import Control.PTTDCon_Main;
import Model.PTTD;

public class PTTDUI_Main extends JFrame{
	public PTTD model; 
	public PTTDCon_Main controller;
	private final int UNIT  = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private JPanel mainPanel, gap1, gap2;
	public JLabel welcome;
	public JButton checkBudget, approvalReq;
	
	// ptt view
	public PTTDUI_Main(PTTD pd,PTTDCon_Main pc) {
		model = pd;
		controller = pc;
		this.setTitle("< PTT System > PTT Director");
		this.setSize(40*UNIT, 30*UNIT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel = new JPanel());
		Border emptyBorder = BorderFactory.createEmptyBorder(3*UNIT,3*UNIT,3*UNIT,3*UNIT);
		mainPanel.setBorder(emptyBorder);
		mainPanel.setLayout(new GridLayout(5,1));
		
		welcome = new JLabel("Welcome! Dear PTT Director " + model.getSName());
		welcome.setFont(f);
		checkBudget = new JButton("check Budget");
		approvalReq = new JButton("approval teaching request");
		checkBudget.addActionListener(controller);
		approvalReq.addActionListener(controller);
		
		mainPanel.add(welcome);
		mainPanel.add(gap1 = new JPanel());
		mainPanel.add(checkBudget);
		mainPanel.add(gap2 = new JPanel());
		mainPanel.add(approvalReq);
	}
}
