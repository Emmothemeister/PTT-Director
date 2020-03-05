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
import Model.FinanceModel;
import Model.Reader;
import Model.TeachingFinished;
import Model.TeachingRequest;

public class FinanceUI extends JFrame{
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private JTable nc,hac;
	private DefaultTableModel tableModel1, tableModel2;
	
	private JPanel decisionButtons,topInstruction;
	private Reader fileReader;
	private FinanceModel FinanceM;
	
	public FinanceUI() {
		fileReader = new Reader();
		FinanceM = new FinanceModel();
		this.setSize(40*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("< PTT System > Finance Department");
		this.setLayout(new BorderLayout());
		
		final JTabbedPane tabbedPane = new JTabbedPane();	
		
		//Approve claims
		JPanel approveClaims = new JPanel(new BorderLayout());
		
		
		String[] colNames = {"Teaching Date", "Course Title", "Teacher", "Claim Amount"};
		Object[][] claims = {};
		
		tableModel1 = new DefaultTableModel(claims,colNames);
		nc = new JTable(tableModel1);
				
		for(int i = 0; i < fileReader.getTtoF().size(); i++) {
			String a = fileReader.getTtoF().get(i).getTeachingRequest().getClassDate().toString();
			String b = fileReader.getTtoF().get(i).getTeachingRequest().getCourseTitle();
			ClassDate c = fileReader.getTtoF().get(i).getTeachingRequest().getClassDate();
			String d = fileReader.getTtoF().get(i).getTeachingRequest().getTeacher();
			double ca = fileReader.getTtoF().get(i).getClaimAmount();
			
			Object[] bb = {a,b,d,ca};
			tableModel1.addRow(bb);
			FinanceM.getListOfClaims().add(new TeachingFinished(new TeachingRequest(c,b,d), ca));	
		}
		nc.setModel(tableModel1);
		
		
		JScrollPane scrollPane2 = new JScrollPane();		
		
		scrollPane2.setViewportView(nc);
		approveClaims.add(scrollPane2,BorderLayout.CENTER);
		
		decisionButtons = new JPanel(new FlowLayout());
		approveClaims.add(decisionButtons,BorderLayout.SOUTH);
		
		//JTable for Historical approved claims
		
		String[] colNames2 = {"Teaching Date", "Course Title", "Teacher", "Claim Amount"};
		Object[][] approvedClaims = {};
		tableModel2 = new DefaultTableModel(approvedClaims,colNames2);
		hac = new JTable(tableModel2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(hac);
		
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
		JLabel instruction = new JLabel("Hello Financier! Today is: ");
		instruction.setFont(f);
		topInstruction.add(instruction);
		JLabel timeLabel = new JLabel();
		Time t = new Time(timeLabel);
		topInstruction.add(timeLabel);
				
		tabbedPane.addTab(" List of Claims  ", approveClaims);
		tabbedPane.addTab("Historical Approved Claims", scrollPane);

		centerBoard.add(topInstruction, BorderLayout.NORTH);
		centerBoard.add(tabbedPane, BorderLayout.CENTER);
				
		this.setVisible(true);
	}
	
	public JPanel getDecisionButtons() {
		return decisionButtons;
	}
	public JPanel getTopInstruction() {
		return topInstruction;
	}
	public JTable getNC() {
		return nc;
	}
	public DefaultTableModel getTableModel1() {
		return tableModel1;
	}
	public DefaultTableModel getTableModel2() {
		return tableModel2;
	}
	

}
