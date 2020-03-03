package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.Border;

import Control.PTTDCon_Budget;
import Control.PTTDCon_Main;
import Model.Budget;
import Model.PTTD;

public class PTTDUI_Budget extends JFrame {
	private PTTD pModel;
	public Budget model;
	public PTTDCon_Budget controller;
	public PTTDCon_Main mainCon;
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private Border blackline = BorderFactory.createLineBorder(Color.gray, 2);
	private Timer tmr;
	private JLabel welcome, timeLabel;
	private JPanel Budget, Clock, ButtonPanel, p1, p2, p3, p4, p5, p6;
	public JButton back;;
	
	public PTTDUI_Budget(PTTD pm, Budget b, PTTDCon_Budget cb, PTTDCon_Main m) {
		pModel = pm;
		model = b;
		mainCon = m;
		controller = new PTTDCon_Budget(pModel, model, mainCon);
		this.setSize(40*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("< PTT System > PTT Director");
		this.setLayout(new BorderLayout());
		this.add(Budget = new JPanel(new BorderLayout()), BorderLayout.CENTER);
		this.add(Clock = new JPanel(), BorderLayout.NORTH);
		this.add(p1 = new JPanel(), BorderLayout.EAST);
		this.add(p2 = new JPanel(), BorderLayout.WEST);
		this.add(ButtonPanel = new JPanel(), BorderLayout.SOUTH);
		
		ButtonPanel.setLayout(new BorderLayout());
		back = new JButton("back");
		back.addActionListener(controller);
		ButtonPanel.add(back, BorderLayout.CENTER);
		ButtonPanel.add(p3 = new JPanel(), BorderLayout.NORTH);
		ButtonPanel.add(p4 = new JPanel(), BorderLayout.EAST);
		ButtonPanel.add(p5 = new JPanel(), BorderLayout.SOUTH);
		ButtonPanel.add(p6 = new JPanel(), BorderLayout.WEST);
		
		
		// Budget table
		String[] columnTitle = {"Item", "Number", "Cost"};
		Object[][] rowData = {
				{"Projectors", "2", "3,000"},
				{"Computers", "10", "10,000"},
				{"Desks", "60", "3,000"},
		};
		JTable BT = new JTable(rowData,columnTitle);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(BT);
		Budget.add(scrollPane, BorderLayout.CENTER);

		welcome = new JLabel("Hello Director! Today is: ");
		welcome.setFont(f);
		timeLabel = new JLabel();
	
		Clock.add(welcome);	
		Clock.add(timeLabel);
		this.setTimer(timeLabel);
	}
	
	//Show current time
	private void setTimer(JLabel time) {
		timeLabel = time;
		timeLabel.setFont(new Font("TimesRoman", Font.BOLD, 20));
		timeLabel.setForeground(new Color(30, 144, 255));
		tmr = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long timemillis = System.currentTimeMillis();
				SimpleDateFormat df = new SimpleDateFormat(" dd/MM/yyyy  HH:mm:ss");
				timeLabel.setText(df.format(new Date(timemillis)));
				
			}
		});
		tmr.start();	
	}
}
