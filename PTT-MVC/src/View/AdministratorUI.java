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

import Model.Reader;
import Model.ClassDate;
import Model.AdministratorModel;
import Model.TeachingRequest;

public class AdministratorUI extends JFrame{
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private JPanel addTeacherButtons, topInstruction;
	private DefaultTableModel tableModel1;
	private JTable at; //at = Add Teacher
	private Reader fileReader;
	private AdministratorModel AdministratorM;
	
	public AdministratorUI(){
		fileReader = new Reader();
		AdministratorM = new AdministratorModel();
		this.setSize(40*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("< PTT System > Administrator");
		this.setLayout(new BorderLayout());
		
		final JTabbedPane tabbedPane = new JTabbedPane();
		
		//Add Teachers
		JPanel addTeachers = new JPanel(new BorderLayout());
		
		String[] colNames1 = {"Teaching Date", "Course Title", "Teacher"};
		Object[][] rowData1 = {};
		
		tableModel1 = new DefaultTableModel(rowData1,colNames1);
		at = new JTable(tableModel1);
		
		for(int i = 0; i < fileReader.getCDtoA().size(); i++) {
			String a = fileReader.getCDtoA().get(i).getClassDate().toString();
			String b = fileReader.getCDtoA().get(i).getCourseTitle();
			ClassDate c = fileReader.getCDtoA().get(i).getClassDate();
			
			Object[] read = {a,b};
			tableModel1.addRow(read);
			AdministratorM.getAddTeacherArray().add(new TeachingRequest(c,b,""));
		}
		at.setModel(tableModel1);
		
		JScrollPane scrollPane1 = new JScrollPane();		
		
		scrollPane1.setViewportView(at);
		addTeachers.add(scrollPane1,BorderLayout.CENTER);
		
		addTeacherButtons = new JPanel(new FlowLayout());

		addTeachers.add(addTeacherButtons,BorderLayout.SOUTH);
		
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
		JLabel instruction = new JLabel("Hello Administrator! Today is: ");
		instruction.setFont(f);
		topInstruction.add(instruction);
		JLabel timeLabel = new JLabel();
		Time t = new Time(timeLabel);
		topInstruction.add(timeLabel);
				
		tabbedPane.addTab("  Add Teachers   ", addTeachers);

		centerBoard.add(topInstruction, BorderLayout.NORTH);
		centerBoard.add(tabbedPane, BorderLayout.CENTER);
				
		this.setVisible(true);			
		
	}
	
	public JPanel getAddTeacherButtons() {
		return addTeacherButtons;
	}
	public JPanel getTopInstruction() {
		return topInstruction;
	}
	public DefaultTableModel getTableModel1() {
		return tableModel1;
	}
	public JTable getAt() {
		return at;
	}
	public AdministratorModel getAdministratorM() {
		return AdministratorM;
	}

}
