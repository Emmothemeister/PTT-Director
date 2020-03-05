package Controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextField;

import View.CourseDirectorUI;
import Model.CourseDirectorModel;
import Model.ClassDate;
import Model.TeachingRequest;
import Model.Writer;

public class CourseDirectorController implements ActionListener{
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private JButton addNewTeachingRequest, deleteTeachingRequest, sendToAdministrator;
	private JButton attended, absented, backToLogin, exit;
	private JTextField td,ct;
	private CourseDirectorUI CourseDirector;
	
	
	public CourseDirectorController(){
		CourseDirector = new CourseDirectorUI(); //new CourseDirectorUI object
		
		td = new JTextField();// Teaching Date JTextField
		ct = new JTextField();// Course Title JTextField
		td.setFont(f);
		ct.setFont(f);
		
		backToLogin = new JButton("Back to Login");
		exit = new JButton("Exit System");
		
		deleteTeachingRequest = new JButton("Delete Teaching Request");
		sendToAdministrator = new JButton("Send To Administrator");
		addNewTeachingRequest = new JButton("Add New Teaching Request");
		
		CourseDirector.getUpperForm().add(td);
		CourseDirector.getLowerForm().add(ct);
		CourseDirector.getTeachingRequestButtons1().add(deleteTeachingRequest);
		CourseDirector.getTeachingRequestButtons1().add(sendToAdministrator);
		CourseDirector.getTeachingRequestButtons2().add(addNewTeachingRequest);
		CourseDirector.getTopInstruction().add(backToLogin);
		CourseDirector.getTopInstruction().add(exit);

		deleteTeachingRequest.addActionListener(this);
		sendToAdministrator.addActionListener(this);
		addNewTeachingRequest.addActionListener(this);
		backToLogin.addActionListener(this);
		exit.addActionListener(this);
		
		attended = new JButton("Teacher Attended");
		absented = new JButton("Teacher Absented");
		
		CourseDirector.getOngoingClassesButtons().add(attended);
		CourseDirector.getOngoingClassesButtons().add(absented);
		
		attended.addActionListener(this);
		absented.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addNewTeachingRequest) {
			String teachingDate = td.getText();
			String courseTitle = ct.getText();
			Scanner s = new Scanner(teachingDate);
			String[] tokens = teachingDate.split("/");
			int d = Integer.parseInt(tokens[0]);
			int m = Integer.parseInt(tokens[1]);
			int y = Integer.parseInt(tokens[2]);
			
			TeachingRequest tr = new TeachingRequest(new ClassDate(d,m,y), courseTitle, "");
			CourseDirector.getCourseDirectorM().getPendingTeachingRequests().add(tr);
			Object[] adding = {tr.getClassDate().toString(),tr.getCourseTitle()};
			CourseDirector.getTableModel1().addRow(adding);
			CourseDirector.getPTR().setModel(CourseDirector.getTableModel1());

		}else if(e.getSource() == deleteTeachingRequest) {
			int row = CourseDirector.getPTR().getSelectedRow();
			CourseDirector.getTableModel1().removeRow(row);
			CourseDirector.getCourseDirectorM().getPendingTeachingRequests().remove(row);
			
		}else if(e.getSource() == sendToAdministrator) {
			int row = CourseDirector.getPTR().getSelectedRow();
			if(CourseDirector.getCourseDirectorM().getPendingTeachingRequests().get(row) != null) {
				new Writer("TypeA " 
			+ CourseDirector.getCourseDirectorM().getPendingTeachingRequests().get(row).getClassDate().toString() + " " 
			+ CourseDirector.getCourseDirectorM().getPendingTeachingRequests().get(row).getCourseTitle() + "\n");
			}
			CourseDirector.getTableModel1().removeRow(row);
			CourseDirector.getCourseDirectorM().getPendingTeachingRequests().remove(row);
			
		}else if(e.getSource() == backToLogin) {
			CourseDirector.dispose();
			new LoginController();
		}else if(e.getSource() == exit) {
			System.exit(0);
		}else if(e.getSource() == attended) {
			int row = CourseDirector.getOc().getSelectedRow();
			new Writer("TypeE " 
			+ CourseDirector.getCourseDirectorM().getOngoingClassesArray().get(row).getClassDate().toString() + " "
			+ CourseDirector.getCourseDirectorM().getOngoingClassesArray().get(row).getCourseTitle() + " "
			+ CourseDirector.getCourseDirectorM().getOngoingClassesArray().get(row).getTeacher() + " "
			+ 0.0 + "\n");
			CourseDirector.getTableModel2().removeRow(row);
			CourseDirector.getCourseDirectorM().getOngoingClassesArray().remove(row);
			////////ongoing remove update database(delete)
		}else if(e.getSource() == absented) {
			int row = CourseDirector.getOc().getSelectedRow();
			new Writer("TypeF " 
			+ CourseDirector.getCourseDirectorM().getOngoingClassesArray().get(row).getClassDate().toString() + " "
			+ CourseDirector.getCourseDirectorM().getOngoingClassesArray().get(row).getCourseTitle() + " "
			+ CourseDirector.getCourseDirectorM().getOngoingClassesArray().get(row).getTeacher() + " "
			+ "Absented" + "\n");
			CourseDirector.getTableModel2().removeRow(row);
			CourseDirector.getCourseDirectorM().getOngoingClassesArray().remove(row);
			////////ongoing remove update database(delete)
		}	
	}

}
