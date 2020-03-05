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
import Model.TeachingRequest;
import Model.PTTDirectorModel;

public class PTTDirectorUI extends JFrame{
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private JTable ar;
	private DefaultTableModel tableModel1;
	private JPanel decisionButtons, topInstruction;
	private Reader fileReader;
	private PTTDirectorModel PTTDirectorM;
	
	public PTTDirectorUI() {
		fileReader = new Reader();
		PTTDirectorM = new PTTDirectorModel();
		this.setSize(40*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("< PTT System > PTT Director");
		this.setLayout(new BorderLayout());
		
		final JTabbedPane tabbedPane = new JTabbedPane();
		
		//Approve requests
		JPanel approveRequests = new JPanel(new BorderLayout());
				
		String[] colNames1 = {"Teaching Date", "Course Title", "Teacher"};
		Object[][] rowData1 = {};
				
		tableModel1 = new DefaultTableModel(rowData1,colNames1);
		ar = new JTable(tableModel1);
				
		for(int i = 0; i < fileReader.getAtoP().size(); i++) {
			String a = fileReader.getAtoP().get(i).getClassDate().toString();
			String b = fileReader.getAtoP().get(i).getCourseTitle();
			ClassDate c = fileReader.getAtoP().get(i).getClassDate();
			String d = fileReader.getAtoP().get(i).getTeacher();
			
			Object[] read = {a,b,d};
			tableModel1.addRow(read);
			PTTDirectorM.getTeachingRequestArray().add(new TeachingRequest(c,b,d));
		}
		ar.setModel(tableModel1);
				
		JScrollPane scrollPane1 = new JScrollPane();		
				
		scrollPane1.setViewportView(ar);
		approveRequests.add(scrollPane1,BorderLayout.CENTER);
				
		decisionButtons = new JPanel(new FlowLayout());

		approveRequests.add(decisionButtons,BorderLayout.SOUTH);
		
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
		JLabel instruction = new JLabel("Hello PTT Director! Today is: ");
		instruction.setFont(f);
		topInstruction.add(instruction);
		JLabel timeLabel = new JLabel();
		Time t = new Time(timeLabel);
		topInstruction.add(timeLabel);
						
		tabbedPane.addTab(" Approve Requests ", approveRequests);

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
	public JTable getAr() {
		return ar;
	}
	public PTTDirectorModel getPTTDirectorM() {
		return PTTDirectorM;
	}
	public DefaultTableModel getTableModel1() {
		return tableModel1;
	}
}
