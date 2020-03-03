package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.Border;

import Control.PTTDCon_Main;
import Control.PTTDCon_Req;
import Model.PTTD;
import Model.Request;

public class PTTDUI_Req extends JFrame {
	private PTTD pModel;
	public Request model;
	public PTTDCon_Req controller;
	public PTTDCon_Main mainCon;
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private Border blackline = BorderFactory.createLineBorder(Color.gray, 2);
	private Timer tmr;
	private JLabel welcome, timeLabel;
	private JPanel Budget, Clock, SouthPanel, ButtonPanel, p1, p2, p3, p4, p5, p6;
	public JButton approval, back;
	
	public PTTDUI_Req(PTTD pm, Request r, PTTDCon_Req cr, PTTDCon_Main cm) {
		pModel = pm;
		model = r;
		mainCon = cm;
		controller = new PTTDCon_Req(pModel, model, mainCon);
		this.setSize(40*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("< PTT System > PTT Director");
		this.setLayout(new BorderLayout());
		this.add(Budget = new JPanel(new BorderLayout()), BorderLayout.CENTER);
		this.add(Clock = new JPanel(), BorderLayout.NORTH);
		this.add(p1 = new JPanel(), BorderLayout.EAST);
		this.add(p2 = new JPanel(), BorderLayout.WEST);
		this.add(SouthPanel = new JPanel(), BorderLayout.SOUTH);
		
		SouthPanel.setLayout(new BorderLayout());
		SouthPanel.add(ButtonPanel = new JPanel(), BorderLayout.CENTER);
		SouthPanel.add(p3 = new JPanel(), BorderLayout.NORTH);
		SouthPanel.add(p4 = new JPanel(), BorderLayout.SOUTH);
		SouthPanel.add(p5 = new JPanel(), BorderLayout.WEST);
		SouthPanel.add(p6 = new JPanel(), BorderLayout.EAST);
		
		ButtonPanel.setLayout(new GridLayout(1,2));
		approval = new JButton("Approval");
		back = new JButton("back");
		approval.addActionListener(controller);
		back.addActionListener(controller);
		ButtonPanel.add(approval);
		ButtonPanel.add(back);
		
		
		//Teaching Request
		String[] columnTitle = {"ID", "Content", "Cost", "submitTime", "comment"};
		Object[][] rowData = {
				{"1", "Need a bunch of chalk", "100", "03/03/2020", "must"},
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
