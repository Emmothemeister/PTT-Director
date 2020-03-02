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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TUI extends JFrame implements ActionListener{
	
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private Border blackline = BorderFactory.createLineBorder(Color.gray, 2);
//	private JButton button1, button2;
	private Timer tmr;
	private JLabel timeLabel;
	
	public TUI() {
		this.setSize(40*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("< PTT System > Teacher");
		this.setLayout(new BorderLayout());
		
		final JTabbedPane tabbedPane = new JTabbedPane();
		
		//pending course column
		JPanel pendingCourse = new JPanel(new BorderLayout());
		
		//Pending class table
		String[] columnNames = {"Course Date", "Course Title", "Course Location"};
		Object[][] rowData = {
				{"01/01/2020", "Software Engineering", "Boyd Orr Building:222"},
				{"02/01/2020", "Advanced Programming", "Gregory Building:109"},
				{"03/01/2020", "Internet Technology", "Kelvin Building:222"},
				{"04/01/2020", "Algorithms & Data Structures", "Gregory Building:109"},
				{"05/01/2020", "Cyber Security Fundamentals", "Boyd Orr Building:203"},
				{"06/01/2020", "Software Engineering", "Boyd Orr Building:222"},
				{"07/01/2020", "Advanced Programming", "Gregory Building:109"},
				{"08/01/2020", "Internet Technology", "Kelvin Building:222"},
				{"09/01/2020", "Algorithms & Data Structures", "Gregory Building:109"},
				{"10/01/2020", "Cyber Security Fundamentals", "Boyd Orr Building:203"},
				{"01/01/2020", "Software Engineering", "Boyd Orr Building:222"},
				{"02/01/2020", "Advanced Programming", "Gregory Building:109"},
				{"03/01/2020", "Internet Technology", "Kelvin Building:222"},
				{"04/01/2020", "Algorithms & Data Structures", "Gregory Building:109"},
				{"05/01/2020", "Cyber Security Fundamentals", "Boyd Orr Building:203"},
				{"06/01/2020", "Software Engineering", "Boyd Orr Building:222"},
				{"07/01/2020", "Advanced Programming", "Gregory Building:109"},
				{"08/01/2020", "Internet Technology", "Kelvin Building:222"},
				{"09/01/2020", "Algorithms & Data Structures", "Gregory Building:109"},
				{"10/01/2020", "Cyber Security Fundamentals", "Boyd Orr Building:203"},
				{"01/01/2020", "Software Engineering", "Boyd Orr Building:222"},
				{"02/01/2020", "Advanced Programming", "Gregory Building:109"},
				{"03/01/2020", "Internet Technology", "Kelvin Building:222"},
				{"04/01/2020", "Algorithms & Data Structures", "Gregory Building:109"},
				{"05/01/2020", "Cyber Security Fundamentals", "Boyd Orr Building:203"},
				{"06/01/2020", "Software Engineering", "Boyd Orr Building:222"},
				{"07/01/2020", "Advanced Programming", "Gregory Building:109"},
				{"08/01/2020", "Internet Technology", "Kelvin Building:222"},
				{"09/01/2020", "Algorithms & Data Structures", "Gregory Building:109"},
				{"10/01/2020", "Cyber Security Fundamentals", "Boyd Orr Building:203"},
		};
		JTable pc = new JTable(rowData,columnNames);
		JScrollPane scrollPane = new JScrollPane();		
		
		scrollPane.setViewportView(pc);
		pendingCourse.add(scrollPane,BorderLayout.CENTER);
		
		JPanel pendingCourseButtons = new JPanel(new FlowLayout());
		JButton applyForLeave = new JButton("Apply For Leave");
		pendingCourseButtons.add(applyForLeave);
		pendingCourse.add(pendingCourseButtons,BorderLayout.SOUTH);
		
//		//InputDialog
//		applyForLeave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				public void actionPerformed(ActionEvent e) {
//					String inputContent = JOptionPane.showInputDialog(
//							"Leaving Reason:",
//							"Fill in your leaving reason here"
//					);
//				}
//			}
//		});		
		
		//New Claims
		JPanel newClaims = new JPanel(new BorderLayout());
		
		//Show courses in table needed to be claimed
		String[] title = {"Course Date", "Course Title", "Course Location"};
		Object[][] claimDetails = {
				{"01/01/2020", "Software Engineering", "Boyd Orr Building:222"},
				{"02/01/2020", "Advanced Programming", "Gregory Building:109"},
				{"03/01/2020", "Internet Technology", "Kelvin Building:222"},
				{"04/01/2020", "Algorithms & Data Structures", "Gregory Building:109"},
				{"05/01/2020", "Cyber Security Fundamentals", "Boyd Orr Building:203"},
		};
		JTable nc = new JTable(claimDetails,title);
		JScrollPane scrollPane2 = new JScrollPane();		
		
		scrollPane2.setViewportView(nc);
		newClaims.add(scrollPane2,BorderLayout.CENTER);
		
		JPanel newClaimsButtons = new JPanel(new FlowLayout());
		JButton fillInClaimForm = new JButton("Fill in Claim Form");
		newClaimsButtons.add(fillInClaimForm);
		newClaims.add(newClaimsButtons,BorderLayout.SOUTH);
		
		//InputDialog
		fillInClaimForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputContent = JOptionPane.showInputDialog(
						"Claim Amount:",
						"Fill in amount here"
				);
				System.out.println(inputContent);
			}
		});
		
		//JTable for Historical claims
		String[] c = {"Claim Date", "Claim Title", "Claim Amount"};
		Object[][] r = {
				{"01/01/2020", "Advanced Programming", 300},
				{"05/01/2020", "Internet Technology", 200},
				{"10/01/2020", "Advanced Programming", 300},
				{"15/01/2020", "Internet Technology", 200},
		};
		JTable table = new JTable(r, c);
		JPanel panel = new JPanel(new BorderLayout());		
		
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		panel.add(table, BorderLayout.CENTER);
		
		
		//Absence Record
		JScrollPane absenceScrollPane = new JScrollPane();
		String[] absenceTitle = {"Course Date", "Course Title", "Course Location"};
		Object[][] absenceDetails = {
				{"01/01/2020", "Software Engineering", "Boyd Orr Building:222"},
				
		};
		JTable ar = new JTable(absenceDetails,absenceTitle);				
		absenceScrollPane.setViewportView(ar);	
		
		//Outer border
		JPanel Border1 = new JPanel();
		JPanel Border2 = new JPanel();
		JPanel Border3 = new JPanel();
		JPanel Border4 = new JPanel();
		JPanel centerBoard = new JPanel(new BorderLayout());
		
		//border size
		Border1.setPreferredSize(new Dimension(0,UNIT));
		Border2.setPreferredSize(new Dimension(0,UNIT));
		Border3.setPreferredSize(new Dimension(UNIT,0));
		Border4.setPreferredSize(new Dimension(UNIT,0));
		
		this.add(Border1, BorderLayout.NORTH);
		this.add(Border2, BorderLayout.SOUTH);
		this.add(Border3, BorderLayout.WEST);
		this.add(Border4, BorderLayout.EAST);
		this.add(centerBoard, BorderLayout.CENTER);
		
		JPanel topInstruction = new JPanel(new FlowLayout());
		
		JLabel instruction = new JLabel("Hello Teacher! Today is: ");
		instruction.setFont(f);
		
		topInstruction.add(instruction);
		timeLabel = new JLabel();	
		topInstruction.add(timeLabel);
				
//		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		tabbedPane.addTab(" Pending Course  ", pendingCourse);
		tabbedPane.addTab(" New Claim Form  ", newClaims);
		tabbedPane.addTab("Historical Claims", panel);
		tabbedPane.addTab(" Absence Record  ", absenceScrollPane);
			
		
		centerBoard.add(topInstruction, BorderLayout.NORTH);
		centerBoard.add(tabbedPane, BorderLayout.CENTER);

		this.setTimer(timeLabel);
		this.setVisible(true);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
