package view;
//This class is the UI design for teachers

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;

import Model.ClaimForm;


public class TUI extends JFrame implements ActionListener{
	
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private Border blackline = BorderFactory.createLineBorder(Color.gray, 2);
//	private JButton button1, button2;
	private Timer tmr;
	private JLabel timeLabel;
	private ArrayList<ClaimForm> mail = new ArrayList<>();
	
	public TUI() {
		this.setSize(40*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("< PTT System > Teacher");
		this.setLayout(new BorderLayout());
		
		final JTabbedPane tabbedPane = new JTabbedPane();
		
		JTabbedPane mailBox = new JTabbedPane(JTabbedPane.LEFT);
		JPanel inbox = new JPanel();
		JPanel sent = new JPanel();
		JPanel bin = new JPanel();
		mailBox.addTab("Inbox", inbox);
		mailBox.addTab("Sent", sent);
		mailBox.addTab("Bin", bin);
		
		
		
		JPanel tab1 = new JPanel();
		JPanel tab2 = new JPanel(new GridLayout(1, 1));
		JPanel tab3 = new JPanel(new GridLayout(1, 1));
		
		
		JLabel inbox1 = new JLabel("Please fill in a claim form for dd/mm/yyyy");
		inbox1.setFont(f);
		JLabel inbox2 = new JLabel("Please fill in a claim form for dd/mm/yyyy");
		inbox2.setFont(f);
		JLabel sent1 = new JLabel("Sent Mail");
		JLabel bin1 = new JLabel("This is the bin");
		inbox.add(inbox1);
		inbox.add(inbox2);
		sent.add(sent1);
		bin.add(bin1);

		
		//JTable for Historical
		Object[] columnNames = {"Claim Date", "Claim Title", "Claim Amount"};
		Object[][] rowData = {
				{"01/01/2020", "Advanced Programming", 300},
				{"05/01/2020", "Internet Technology", 200},
				{"10/01/2020", "Advanced Programming", 300},
				{"15/01/2020", "Internet Technology", 200},
		};
		JTable table = new JTable(rowData, columnNames);
		JPanel panel = new JPanel(new BorderLayout());
		
//		JScrollPane scrollPane = new JScrollPane();
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		panel.add(table, BorderLayout.CENTER);
//		scrollPane.add(table);
		
		

		
		timeLabel = new JLabel();
//		leftCenter.add(timeLabel);
		this.setTimer(timeLabel);
		
		
		JPanel eastPanel = new JPanel(new FlowLayout());
		JPanel centerPanel = new JPanel(new BorderLayout());
		
		eastPanel.setBorder(blackline);
		centerPanel.setBorder(blackline);
		
		JPanel topBoard = new JPanel(new FlowLayout());
		JPanel leftBorder1 = new JPanel();
		JPanel leftBorder2 = new JPanel();
		JPanel leftBorder3 = new JPanel();
		JPanel leftBorder4 = new JPanel();
		JPanel rightBorder1 = new JPanel();
		JPanel rightBorder2 = new JPanel();
		JPanel leftCenter = new JPanel(new BorderLayout());
		JPanel rightCenter = new JPanel(new GridLayout(0,1));
		
		leftBorder1.setPreferredSize(new Dimension(0,UNIT));
		leftBorder2.setPreferredSize(new Dimension(0,UNIT));
		leftBorder3.setPreferredSize(new Dimension(UNIT,0));
		leftBorder4.setPreferredSize(new Dimension(UNIT,0));
		rightBorder1.setPreferredSize(new Dimension(UNIT,0));
		rightBorder2.setPreferredSize(new Dimension(UNIT,0));
		
//		topBoard.setBorder(blackline);
//		leftBorder2.setBorder(blackline);
//		leftBorder3.setBorder(blackline);
//		leftBorder4.setBorder(blackline);
		
		centerPanel.add(leftBorder1, BorderLayout.NORTH);
		centerPanel.add(leftBorder2, BorderLayout.SOUTH);
		centerPanel.add(leftBorder3, BorderLayout.WEST);
		centerPanel.add(leftBorder4, BorderLayout.EAST);
		centerPanel.add(leftCenter, BorderLayout.CENTER);
		eastPanel.add(rightBorder1, BorderLayout.WEST);
		eastPanel.add(rightBorder2, BorderLayout.EAST);
		eastPanel.add(rightCenter, BorderLayout.CENTER);
		leftCenter.add(topBoard, BorderLayout.NORTH);
		
		JPanel TopInstruction = new JPanel(new FlowLayout());
		
		JLabel instruction = new JLabel("Hello Teacher! Today is: ");
		instruction.setFont(f);
		
		TopInstruction.add(instruction);
		
		JLabel title = new JLabel("Please fill in the claim form here:");
		JLabel claimDate = new JLabel("Claim Date     :");
		JLabel claimTitle = new JLabel("Claim Title     :");
		JLabel claimAmount = new JLabel("Claim Amount:");
		
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		title.setFont(f);
		claimDate.setFont(f);
		claimTitle.setFont(f);
		claimAmount.setFont(f);
		
		JTextField cd = new JTextField(10);
		JTextField ct = new JTextField(10);
		JTextField ca = new JTextField(10);
		cd.setFont(f);
		ct.setFont(f);
		ca.setFont(f);
		
		JPanel TextFields = new JPanel(new GridLayout(5,1));
		JPanel box1 = new JPanel();
		JPanel box2 = new JPanel();
		JPanel box3 = new JPanel();
		JPanel submit = new JPanel();
		box1.add(claimDate);
		box1.add(cd);
		box2.add(claimTitle);
		box2.add(ct);
		box3.add(claimAmount);
		box3.add(ca);
		
		JButton s = new JButton("Submit");
		JButton c = new JButton("Clear");
		submit.add(c);
		submit.add(s);
		TextFields.add(title);
		TextFields.add(box1);
		TextFields.add(box2);
		TextFields.add(box3);
		TextFields.add(submit);
		
		//Ask for leave
//		JPanel AFK = new JPanel();
		JLabel leavingTitle = new JLabel("Please inform recruiter your leaving here:");
		JLabel leavingDate = new JLabel("Leaving Date     :");
		JLabel leavingCourseTitle = new JLabel("Leaving Coure Name:");
		JLabel leavingReason = new JLabel("Leaving Reason   :");
		
		leavingTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		leavingTitle.setFont(f);
		leavingDate.setFont(f);
		leavingCourseTitle.setFont(f);
		leavingReason.setFont(f);
		
		JTextField ld = new JTextField(10);
		JTextField lc = new JTextField(10);
		JTextField lr = new JTextField(10);
		ld.setFont(f);
		lc.setFont(f);
		lr.setFont(f);
		
		JPanel awayForm = new JPanel(new GridLayout(6,1));
		JPanel box4 = new JPanel();
		JPanel box5 = new JPanel();
		
		JPanel buttons = new JPanel();
		box4.add(leavingDate);
		box4.add(ld);
		box5.add(leavingCourseTitle);
		box5.add(lc);
		
		
		JButton ss = new JButton("Submit");
		JButton cc = new JButton("Clear");
		buttons.add(cc);
		buttons.add(ss);
		awayForm.add(leavingTitle);
		awayForm.add(box4);
		awayForm.add(box5);
		awayForm.add(leavingReason);
		awayForm.add(lr);
		awayForm.add(buttons);
		
//		AFK.add(awayForm);
		
		
		tabbedPane.addTab("  Your Mail Box  ", mailBox);
		tabbedPane.addTab(" New Claim Form  ", TextFields);
		tabbedPane.addTab("Historical Claims", panel);
		tabbedPane.addTab("  Ask For Leave  ", awayForm);
			
		
		topBoard.add(instruction);
		topBoard.add(timeLabel);
		leftCenter.add(tabbedPane);
			
		
		JLabel taskTitle = new JLabel("Your tasks:");
		taskTitle.setFont(f);
		taskTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel task1 = new JLabel(" 0 new mail!");
		task1.setFont(f);
		JLabel task2 = new JLabel(" 0 claim form to fill!");
		task2.setFont(f);
		
		rightCenter.add(taskTitle);
		rightCenter.add(task1);
		rightCenter.add(task2);

		
		
//		this.add(eastPanel,BorderLayout.EAST);
		this.add(centerPanel,BorderLayout.CENTER);
		
		this.setVisible(true);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
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
