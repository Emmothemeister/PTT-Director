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
		
		JLabel sent1 = new JLabel("Sent Mail");
		JLabel bin1 = new JLabel("This is the bin");
		inbox.add(inbox1);
		sent.add(sent1);
		bin.add(bin1);
		
		
		
		tabbedPane.addTab("  Your Mail Box  ", mailBox);
		tabbedPane.addTab(" New Claim Form  ", tab2);
		tabbedPane.addTab("Historical Claims", tab3);
		
		timeLabel = new JLabel();
//		leftCenter.add(timeLabel);
		this.setTimer(timeLabel);
		
		
		JPanel eastPanel = new JPanel(new BorderLayout());
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
		
		
//		JLabel id = new JLabel("Staff ID   :");
//		JLabel pd = new JLabel("Password :");
//		
//		id.setFont(f);
//		pd.setFont(f);
//		JTextField ID = new JTextField(10);
//		JPasswordField password = new JPasswordField(10);
//		ID.setFont(f);
//		password.setFont(f);
//		
//		JPanel boxes = new JPanel(new GridLayout(2,1));
//		JPanel box1 = new JPanel();
//		JPanel box2 = new JPanel();
//		box1.add(id);
//		box1.add(ID);
//		box2.add(pd);
//		box2.add(password);
//		boxes.add(box1);
//		boxes.add(box2);
		
//		JPanel buttonPanel = new JPanel(new GridLayout(3,1));
//		JPanel buttons = new JPanel(new GridLayout(1,2));
//		JPanel buttonBorder1 = new JPanel();
//		JPanel buttonBorder2 = new JPanel();
//		button1 = new JButton("Login");
//		button2 = new JButton("Quit");
//		button1.setFont(f);
//		button2.setFont(f);
//		button1.addActionListener(this);
//		button2.addActionListener(this);
//		buttons.add(button1);
//		buttons.add(button2);
//		buttonPanel.add(buttonBorder1);
//		buttonPanel.add(buttons);
//		buttonPanel.add(buttonBorder2);		
		
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

		
		
		this.add(eastPanel,BorderLayout.EAST);
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
