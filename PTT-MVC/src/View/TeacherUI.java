package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.ClassDate;
import Model.Reader;
import Model.TeacherModel;
import Model.TeachingFinished;
import Model.TeachingRequest;;

public class TeacherUI extends JFrame{
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	
	private JTable ttt, nc;
	private DefaultTableModel tableModel,tableModel2;
	private JPanel pendingCourseButtons,newClaimsButtons,topInstruction;
	
	private Reader fileReader;
	private TeacherModel TeacherM;
	
	public TeacherUI()  {
		fileReader = new Reader();
		TeacherM = new TeacherModel();
		this.setSize(40*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("< PTT System > Teacher");
		this.setLayout(new BorderLayout());
		
		final JTabbedPane tabbedPane = new JTabbedPane();
		
		//pending course column
		JPanel pendingCourse = new JPanel(new BorderLayout());
		
		//Pending class table
		String[] colNames = {"Teaching Date", "Course Title", "Teacher"};
		Object[][] rowData = {};
				
		tableModel = new DefaultTableModel(rowData,colNames);
		ttt = new JTable(tableModel);
				
		for(int i = 0; i < fileReader.getPtoCDT().size(); i++) {
			if(fileReader.getPtoCDT().get(i).getTeacher().equals("T1")) {
				String a = fileReader.getPtoCDT().get(i).getClassDate().toString();
				String b = fileReader.getPtoCDT().get(i).getCourseTitle();
				ClassDate c = fileReader.getPtoCDT().get(i).getClassDate();
				String d = fileReader.getPtoCDT().get(i).getTeacher();
						
				Object[] bb = {a,b,d};
				tableModel.addRow(bb);
				TeacherM.getT1().add(new TeachingRequest(c,b,d));
			}
					
		}
		ttt.setModel(tableModel);
						
		JScrollPane scrollPane = new JScrollPane();				
		scrollPane.setViewportView(ttt);
		pendingCourse.add(scrollPane,BorderLayout.CENTER);
		pendingCourseButtons = new JPanel(new FlowLayout());
		pendingCourse.add(pendingCourseButtons,BorderLayout.SOUTH);
		
		//New Claims
		JPanel newClaims = new JPanel(new BorderLayout());
				
		//Show courses in table needed to be claimed
		String[] colNames2 = {"Teaching Date", "Course Title", "Teacher", "Claim Amount"};
		Object[][] claimDetails = {};
				
		tableModel2 = new DefaultTableModel(claimDetails,colNames2);
				
		nc = new JTable(tableModel2);
				
		for(int i = 0; i < fileReader.getCDtoT().size(); i++) {
			String a = fileReader.getCDtoT().get(i).getTeachingRequest().getClassDate().toString();
			String b = fileReader.getCDtoT().get(i).getTeachingRequest().getCourseTitle();
			ClassDate c = fileReader.getCDtoT().get(i).getTeachingRequest().getClassDate();
			String d = fileReader.getCDtoT().get(i).getTeachingRequest().getTeacher();
					
			Object[] bb = {a,b,d,0.0};
			tableModel2.addRow(bb);
			TeacherM.getNewClaimsArray().add(new TeachingFinished(new TeachingRequest(c,b,d),0.0));
		}
		nc.setModel(tableModel2);
				
		JScrollPane scrollPane2 = new JScrollPane();			
		scrollPane2.setViewportView(nc);
		newClaims.add(scrollPane2,BorderLayout.CENTER);		
		newClaimsButtons = new JPanel(new FlowLayout());
		newClaims.add(newClaimsButtons,BorderLayout.SOUTH);
				
		//JTable for Historical claims
		String[] c = {"Claim Date", "Claim Title", "Claim Amount"};
		Object[][] r = {
				{"01/01/2020", "Advanced Programming", 300},
				{"05/01/2020", "Internet Technology", 299},
				{"10/01/2020", "Advanced Programming", 300},
				{"15/01/2020", "Internet Technology", 299},
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
			
		topInstruction = new JPanel(new FlowLayout());
		JLabel instruction = new JLabel("Hello Teacher! Today is: ");
		instruction.setFont(f);
		topInstruction.add(instruction);
		JLabel timeLabel = new JLabel();
		Time t = new Time(timeLabel);
		topInstruction.add(timeLabel);
				
		tabbedPane.addTab(" Pending Course  ", pendingCourse);
		tabbedPane.addTab(" New Claim Form  ", newClaims);
		tabbedPane.addTab("Historical Claims", panel);
		tabbedPane.addTab(" Absence Record  ", absenceScrollPane);

		centerBoard.add(topInstruction, BorderLayout.NORTH);
		centerBoard.add(tabbedPane, BorderLayout.CENTER);
				
		this.setVisible(true);
		
		
	}
	
	public JPanel getPendingCourseButtons() {
		return pendingCourseButtons;
	}
	public JPanel getNewClaimsButtons() {
		return newClaimsButtons;
	}
	public JPanel getTopInstruction() {
		return topInstruction;
	}
	
	public JTable getTTT() {
		return ttt;
	}
	public JTable getNC() {
		return nc;
	}
	public TeacherModel getTeacherM() {
		return TeacherM;
	}
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	public DefaultTableModel getTableModel2() {
		return tableModel2;
	}
}
