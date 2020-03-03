package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.Border;

import Control.PTTDCon_Req;
import Model.Request;

public class PTTDUI_Req extends JFrame {
	private Request model;
	private PTTDCon_Req controller;
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private Border blackline = BorderFactory.createLineBorder(Color.gray, 2);
	private Timer tmr;
	private JLabel welcome, timeLabel;
	private JPanel Budget, Clock, gap1, gap2;
	public JButton approval;
	
	public PTTDUI_Req(Request r, PTTDCon_Req cr) {
		model = r;
		controller = cr;
		this.setSize(40*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("< PTT System > PTT Director");
		this.setLayout(new BorderLayout());
		this.add(Budget = new JPanel(new BorderLayout()), BorderLayout.CENTER);
		this.add(Clock = new JPanel(), BorderLayout.NORTH);
		this.add(gap1 = new JPanel(), BorderLayout.EAST);
		this.add(gap2 = new JPanel(), BorderLayout.WEST);
		approval = new JButton("Approval");
		approval.addActionListener(controller);
		this.add(approval, BorderLayout.SOUTH);
		
		
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
