package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Reader;
import Model.TeachingRequest;
import Model.ClassDate;
import Model.CourseDirectorModel;

public class CourseDirectorUI extends JFrame {
	private final int UNIT = 20;
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	
	private JTable PTR,oc;
	private DefaultTableModel tableModel1,tableModel2;
	
	private JPanel teachingRequestButtons1, teachingRequestButtons2, topInstruction;
	private JPanel upperForm, lowerForm, ongoingClassesButtons;
	private Reader fileReader;
	private CourseDirectorModel CourseDirectorM;
	
	public CourseDirectorUI() {
		fileReader = new Reader();
		CourseDirectorM = new CourseDirectorModel();
		this.setSize(40*UNIT,30*UNIT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("< PTT System > Course Director");
		this.setLayout(new BorderLayout());
		
		//first tabbedPane
		final JTabbedPane tabbedPane = new JTabbedPane();
		
		//add new teaching request
		JPanel teachingRequests = new JPanel(new GridLayout(2,1));		
		JPanel pendingTeachingRequests = new JPanel(new BorderLayout());
		
		//Display table
		String[] colNames1 = {"Teaching Date", "Course Title"};
		Object[][] rowData1 = {};
		tableModel1 = new DefaultTableModel(rowData1,colNames1);
		PTR = new JTable(tableModel1);//PTR = Pending Teaching Requests
	
		JScrollPane scrollPane1 = new JScrollPane();		
		scrollPane1.setViewportView(PTR);
		
		teachingRequestButtons1 = new JPanel();
		
		pendingTeachingRequests.add(scrollPane1, BorderLayout.CENTER);
		pendingTeachingRequests.add(teachingRequestButtons1, BorderLayout.SOUTH);
		teachingRequests.add(pendingTeachingRequests);
		
		//Add new teaching request here
		JPanel newRequest = new JPanel(new BorderLayout());
		JPanel newTeachingRequestForm = new JPanel(new GridLayout(2,1));
		upperForm = new JPanel(new GridLayout(2,1));
		lowerForm = new JPanel(new GridLayout(2,1));
		newTeachingRequestForm.add(upperForm);
		newTeachingRequestForm.add(lowerForm);
		JLabel teachingDate = new JLabel("Teaching Date: (dd/mm/yyyy)");
		JLabel courseTitle = new JLabel("Course Title");
		teachingDate.setFont(f);
		courseTitle.setFont(f);
		upperForm.add(teachingDate);
		lowerForm.add(courseTitle);
		
		
		teachingRequestButtons2 = new JPanel();
		
		newRequest.add(newTeachingRequestForm, BorderLayout.CENTER);
		newRequest.add(teachingRequestButtons2, BorderLayout.SOUTH);
		teachingRequests.add(newRequest);
		
		//Ongoing Classes
		JPanel ongoingClasses = new JPanel(new BorderLayout());
				
		//Show courses in table needed to be claimed
		String[] colName = {"Teaching Date", "Course Title", "Teacher"};
		Object[][] classDetail = {};
	
		tableModel2 = new DefaultTableModel(classDetail,colName);
		
		oc = new JTable(tableModel2);
		for(int i = 0; i < fileReader.getPtoCDT().size(); i++) {
			String a = fileReader.getPtoCDT().get(i).getClassDate().toString();
			String b = fileReader.getPtoCDT().get(i).getCourseTitle();
			ClassDate c = fileReader.getPtoCDT().get(i).getClassDate();
			String d = fileReader.getPtoCDT().get(i).getTeacher();
			
			Object[] read = {a,b,d};
			tableModel2.addRow(read);
			CourseDirectorM.getOngoingClassesArray().add(new TeachingRequest(c,b,d));
			
		}
		oc.setModel(tableModel2);
		JScrollPane scrollPane2 = new JScrollPane();		
		
		scrollPane2.setViewportView(oc);
		ongoingClasses.add(scrollPane2,BorderLayout.CENTER);
		
		ongoingClassesButtons = new JPanel(new FlowLayout());
		ongoingClasses.add(ongoingClassesButtons,BorderLayout.SOUTH);
		
		
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
		JLabel instruction = new JLabel("Hello Course Director! Today is: ");
		instruction.setFont(f);
		topInstruction.add(instruction);
		JLabel timeLabel = new JLabel();
		Time t = new Time(timeLabel);
		topInstruction.add(timeLabel);
		
		tabbedPane.addTab("Teaching Requests", teachingRequests);
		tabbedPane.addTab(" Ongoing Classes ", ongoingClasses);

		centerBoard.add(topInstruction, BorderLayout.NORTH);
		centerBoard.add(tabbedPane, BorderLayout.CENTER);
		
		this.setVisible(true);	
	}
	
	public JPanel getTeachingRequestButtons1() {
		return teachingRequestButtons1;
	}
	public JPanel getTeachingRequestButtons2() {
		return teachingRequestButtons2;
	}
	public JPanel getUpperForm() {
		return upperForm;
	}
	public JPanel getLowerForm() {
		return lowerForm;
	}
	public JPanel getTopInstruction() {
		return topInstruction;
	}
	public JTable getPTR() {
		return PTR;
	}
	public DefaultTableModel getTableModel1() {
		return tableModel1;
	}
	public DefaultTableModel getTableModel2() {
		return tableModel2;
	}
	public CourseDirectorModel getCourseDirectorM() {
		return CourseDirectorM;
	}
	public JPanel getOngoingClassesButtons() {
		return ongoingClassesButtons;
	}
	public JTable getOc() {
		return oc;
	}

}
