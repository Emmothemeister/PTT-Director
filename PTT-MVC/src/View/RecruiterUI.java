package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.RecruiterModel;
import Model.TeachingRequest;
import Model.ClassDate;
import Model.Reader;

public class RecruiterUI extends JFrame{
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	
	private JTable ttt;
	private JPanel pendingReplacementButtons,topInstruction;
	private DefaultTableModel tableModel;
	
	private Reader fileReader;
	private RecruiterModel RecruiterM;
	
	public RecruiterUI() {
		fileReader = new Reader();
		RecruiterM = new RecruiterModel();
		this.setSize(40*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("< PTT System > Recruiter");
		this.setLayout(new BorderLayout());
		
		final JTabbedPane tabbedPane = new JTabbedPane();
		
		//pending replacement column
		JPanel pendingReplacement = new JPanel(new BorderLayout());

		String[] colNames = {"Course Date", "Course Title", "Teacher"};
		
		Object[][] rowData = {};
		
		tableModel = new DefaultTableModel(rowData,colNames);
		ttt = new JTable(tableModel);
		
		for(int i = 0; i < fileReader.getTtoR().size(); i++) {
			String a = fileReader.getTtoR().get(i).getClassDate().toString();
			String b = fileReader.getTtoR().get(i).getCourseTitle();
			ClassDate c = fileReader.getTtoR().get(i).getClassDate();
			String d = fileReader.getTtoR().get(i).getTeacher();
			
			Object[] bb = {a,b,d};
			tableModel.addRow(bb);
			RecruiterM.getPendingReplacementArray().add(new TeachingRequest(c,b,d));

		}
		ttt.setModel(tableModel);
		
		JScrollPane scrollPane = new JScrollPane();	
		
		scrollPane.setViewportView(ttt);
		pendingReplacement.add(scrollPane,BorderLayout.CENTER);
		
		pendingReplacementButtons = new JPanel(new FlowLayout());
		
		pendingReplacement.add(pendingReplacementButtons,BorderLayout.SOUTH);
		
		
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
		JLabel instruction = new JLabel("Hello Recruiter! Today is: ");
		instruction.setFont(f);
		topInstruction.add(instruction);
		JLabel timeLabel = new JLabel();
		Time t = new Time(timeLabel);
		topInstruction.add(timeLabel);
				
		tabbedPane.addTab(" Pending Replacement ", pendingReplacement);
		
		centerBoard.add(topInstruction, BorderLayout.NORTH);
		centerBoard.add(tabbedPane, BorderLayout.CENTER);
				
		this.setVisible(true);
	}
	
	public JPanel getPendingReplacementButtons() {
		return pendingReplacementButtons;
	}
	
	public JPanel getTopInstruction() {
		return topInstruction;
	}
	public JTable getTTT() {
		return ttt;
	}
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
}
