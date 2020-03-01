package Model;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import view.TUI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPasswordField;
import javax.swing.Timer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Login extends JFrame implements ActionListener{
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private Border blackline = BorderFactory.createLineBorder(Color.gray, 2);
	private JButton button1, button2;
	private Timer tmr;
	private JLabel timeLabel;
	private JRadioButton option1,option2,option3,option4,option5;

	
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
//			timelabel.setBounds(5, 65, 200, 20);
	}
	
	public Login() {
		this.setSize(26*UNIT,20*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("PTT System");
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		JPanel eastPanel = new JPanel(new BorderLayout());
		JPanel centerPanel = new JPanel(new BorderLayout());
		
		eastPanel.setBorder(blackline);
		centerPanel.setBorder(blackline);
		
		JPanel leftBorder1 = new JPanel();
		JPanel leftBorder2 = new JPanel();
		JPanel leftBorder3 = new JPanel();
		JPanel leftBorder4 = new JPanel();
		JPanel rightBorder1 = new JPanel();
		JPanel rightBorder2 = new JPanel();
		JPanel leftCenter = new JPanel(new GridLayout(0,1));
		JPanel rightCenter = new JPanel(new GridLayout(0,1));
		
//		leftBorder1.setPreferredSize(new Dimension(0,UNIT));
		leftBorder2.setPreferredSize(new Dimension(0,UNIT));
		leftBorder3.setPreferredSize(new Dimension(UNIT,0));
		leftBorder4.setPreferredSize(new Dimension(UNIT,0));
		rightBorder1.setPreferredSize(new Dimension(UNIT,0));
		rightBorder2.setPreferredSize(new Dimension(UNIT,0));
		
//		leftBorder1.setBorder(blackline);
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
		
		JLabel instruction1 = new JLabel("Hello! This is PTT System!");
		JLabel instruction2 = new JLabel("Please login here:");

		JLabel id = new JLabel("Staff ID   :");
		JLabel pd = new JLabel("Password :");
		instruction1.setFont(f);
		instruction2.setFont(f);
		id.setFont(f);
		pd.setFont(f);
		JTextField ID = new JTextField(10);
		JPasswordField password = new JPasswordField(10);
		ID.setFont(f);
		password.setFont(f);
		
		JPanel boxes = new JPanel(new GridLayout(2,1));
		JPanel box1 = new JPanel();
		JPanel box2 = new JPanel();
		box1.add(id);
		box1.add(ID);
		box2.add(pd);
		box2.add(password);
		boxes.add(box1);
		boxes.add(box2);
		
		JPanel buttonPanel = new JPanel(new GridLayout(0,1));
		JPanel buttons = new JPanel(new GridLayout(1,2));
		JPanel buttonBorder1 = new JPanel();
//		JPanel buttonBorder2 = new JPanel();
		button1 = new JButton("Login");
		button2 = new JButton("Quit");
		button1.setFont(f);
		button2.setFont(f);
		button1.addActionListener(this);
		button2.addActionListener(this);
		buttons.add(button1);
		buttons.add(button2);
		buttonPanel.add(buttonBorder1);
		buttonPanel.add(buttons);
//		buttonPanel.add(buttonBorder2);		
		
		leftCenter.add(instruction1);
		timeLabel = new JLabel();
		leftCenter.add(timeLabel);
		this.setTimer(timeLabel);
		leftCenter.add(instruction2);
		leftCenter.add(boxes);
		leftCenter.add(buttonPanel);
		
		ButtonGroup bg = new ButtonGroup();	
		option1 = new JRadioButton("Course Director");
		option2 = new JRadioButton("Administrator");
		option3 = new JRadioButton("PTT Director");
		option4 = new JRadioButton("Recruiter");
		option5 = new JRadioButton("Teacher",true);
		option1.setFont(f);
		option2.setFont(f);
		option3.setFont(f);
		option4.setFont(f);
		option5.setFont(f);
		bg.add(option1);
		bg.add(option2);
		bg.add(option3);
		bg.add(option4);
		bg.add(option5);
		
		JLabel staffType = new JLabel("Your role:");
		staffType.setFont(f);
		staffType.setHorizontalAlignment(SwingConstants.CENTER);

		rightCenter.add(staffType);
		rightCenter.add(option1);
		rightCenter.add(option2);
		rightCenter.add(option3);
		rightCenter.add(option4);
		rightCenter.add(option5);
		
		
		this.add(eastPanel,BorderLayout.EAST);
		this.add(centerPanel,BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			if(option5.isSelected()) {
				this.dispose();
				new TUI();
			} else if (option4.isSelected()) {
				this.dispose();
				new TUI();
			}else if (option3.isSelected()) {
				this.dispose();
				new TUI();
			}else if (option2.isSelected()) {
				this.dispose();
				new TUI();
			}else if (option1.isSelected()) {
				this.dispose();
				new TUI();
			}
			
			
		} else if (e.getSource() == button2) {
			System.exit(0);				
		}
	}
	
}
