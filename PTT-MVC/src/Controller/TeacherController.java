package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Writer;
import View.TeacherUI;
import Model.TeachingFinished;
import Model.TeachingRequest;

public class TeacherController implements ActionListener{
	private JButton applyForLeave, fillInClaimForm, sendToFinanceDepartment, backToLogin, exit;
	private TeacherUI Teacher;
	private String inputContent;
	
	public TeacherController(){
		Teacher = new TeacherUI();
		
		applyForLeave = new JButton("Apply For Leave");
		fillInClaimForm = new JButton("Fill in Claim Form");
		sendToFinanceDepartment = new JButton("Send to Finance Department");
		backToLogin = new JButton("Back to Login");
		exit = new JButton("Exit System");
		
		applyForLeave.addActionListener(this);
		fillInClaimForm.addActionListener(this);
		sendToFinanceDepartment.addActionListener(this);
		backToLogin.addActionListener(this);
		exit.addActionListener(this);
		
		Teacher.getPendingCourseButtons().add(applyForLeave);
		Teacher.getNewClaimsButtons().add(fillInClaimForm);
		Teacher.getNewClaimsButtons().add(sendToFinanceDepartment);
		Teacher.getTopInstruction().add(backToLogin);
		Teacher.getTopInstruction().add(exit);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == applyForLeave) {
			int row = Teacher.getTTT().getSelectedRow();
			new Writer("TypeD "
					+ Teacher.getTeacherM().getT1().get(row).getClassDate().toString() + " "
					+ Teacher.getTeacherM().getT1().get(row).getCourseTitle() + " "
					+ Teacher.getTeacherM().getT1().get(row).getTeacher() + "\n");
			Teacher.getTableModel().removeRow(row);
			Teacher.getTeacherM().getT1().remove(row);
		}else if(e.getSource() == backToLogin) {
			Teacher.dispose();
			new LoginController();
		}else if(e.getSource() == exit) {
			System.exit(0);
		}else if(e.getSource() == fillInClaimForm) {
			inputContent = JOptionPane.showInputDialog(
					"Claim Amount:",
					"Fill in amount here"
			);
			
			int row = Teacher.getNC().getSelectedRow();
			Teacher.getTableModel2().setValueAt(inputContent, row, 3);

		}else if(e.getSource() == sendToFinanceDepartment) {
			int row = Teacher.getNC().getSelectedRow();
			new Writer("TypeG "
					+ Teacher.getTeacherM().getNewClaimsArray().get(row).getTeachingRequest().getClassDate().toString() + " "
					+ Teacher.getTeacherM().getNewClaimsArray().get(row).getTeachingRequest().getCourseTitle() + " "
					+ Teacher.getTeacherM().getNewClaimsArray().get(row).getTeachingRequest().getTeacher() + " "
					+ inputContent + "\n");
			Teacher.getTableModel2().removeRow(row);
			Teacher.getTeacherM().getNewClaimsArray().remove(row);
			
		}

	}

}
