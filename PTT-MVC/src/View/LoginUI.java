package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class LoginUI extends JFrame{
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private Font heading = new Font("TimesRoman", Font.BOLD, 23);
	private Border grayline = BorderFactory.createLineBorder(Color.gray, 2);
	
	private JPanel box1, box2, buttons, rightCenter;
	private ButtonGroup bg;
	
	public LoginUI() {
		this.setSize(26*UNIT,20*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("PTT System");
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		JPanel eastPanel = new JPanel(new BorderLayout());
		JPanel centerPanel = new JPanel(new BorderLayout());
		
		eastPanel.setBorder(grayline);
		centerPanel.setBorder(grayline);
		
		//Add outer borders for UI
		JPanel leftBorder1 = new JPanel();
		JPanel leftBorder2 = new JPanel();
		JPanel leftBorder3 = new JPanel();
		JPanel leftBorder4 = new JPanel();
		JPanel rightBorder1 = new JPanel();
		JPanel rightBorder2 = new JPanel();
		JPanel rightBorder3 = new JPanel();
		JPanel rightBorder4 = new JPanel();
		JPanel leftCenter = new JPanel(new GridLayout(0,1));
		rightCenter = new JPanel(new GridLayout(0,1));
		
		leftBorder2.setPreferredSize(new Dimension(0,UNIT));
		leftBorder3.setPreferredSize(new Dimension(UNIT,0));
		leftBorder4.setPreferredSize(new Dimension(UNIT,0));
		rightBorder1.setPreferredSize(new Dimension(UNIT,0));
		rightBorder2.setPreferredSize(new Dimension(UNIT,0));
		rightBorder3.setPreferredSize(new Dimension(0,UNIT));
		rightBorder4.setPreferredSize(new Dimension(0,UNIT));
		
		centerPanel.add(leftBorder1, BorderLayout.NORTH);
		centerPanel.add(leftBorder2, BorderLayout.SOUTH);
		centerPanel.add(leftBorder3, BorderLayout.WEST);
		centerPanel.add(leftBorder4, BorderLayout.EAST);
		centerPanel.add(leftCenter, BorderLayout.CENTER);
		eastPanel.add(rightBorder1, BorderLayout.WEST);
		eastPanel.add(rightBorder2, BorderLayout.EAST);
		eastPanel.add(rightBorder3, BorderLayout.NORTH);
		eastPanel.add(rightBorder4, BorderLayout.SOUTH);
		eastPanel.add(rightCenter, BorderLayout.CENTER);
		
		//Left-side components
		JLabel instruction1 = new JLabel("Hello! This is PTT System!");
		JLabel instruction2 = new JLabel("Please enter ID and password:");

		JLabel id = new JLabel("Staff ID   :");
		JLabel pd = new JLabel("Password :");
		instruction1.setFont(heading);
		instruction2.setFont(f);
		id.setFont(f);
		pd.setFont(f);
		
		
		JPanel boxes = new JPanel(new GridLayout(2,1));
		box1 = new JPanel();
		box2 = new JPanel();
		box1.add(id);
		box2.add(pd);
		boxes.add(box1);
		boxes.add(box2);
		
		JPanel buttonPanel = new JPanel(new GridLayout(0,1));
		buttons = new JPanel(new GridLayout(1,2));
		JPanel buttonBorder = new JPanel();
		
		buttonPanel.add(buttonBorder);
		buttonPanel.add(buttons);		
		
		JLabel timeLabel = new JLabel();
		Time t = new Time(timeLabel);
		
		//Add left-side components as follows:
		leftCenter.add(instruction1);
		leftCenter.add(timeLabel);
		leftCenter.add(instruction2);
		leftCenter.add(boxes);
		leftCenter.add(buttonPanel);
		
		//right-side components:
		bg = new ButtonGroup();	
		
		JLabel staffType = new JLabel("Your role:");
		staffType.setFont(heading);
		staffType.setHorizontalAlignment(SwingConstants.CENTER);

		rightCenter.add(staffType);
		
		this.add(eastPanel,BorderLayout.EAST);
		this.add(centerPanel,BorderLayout.CENTER);
		
//		sl = new StaffList();
		
		this.setVisible(true);
	}
	
	//Getters
	public JPanel getBox1() {
		return box1;
	}
	public JPanel getBox2() {
		return box2;
	}
	public JPanel getButtons() {
		return buttons;
	}
	public ButtonGroup getBg() {
		return bg;
	}
	public JPanel getRightCenter() {
		return rightCenter;
	}

}
