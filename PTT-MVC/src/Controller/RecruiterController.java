package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.StaffList;

import Model.Writer;
import View.RecruiterUI;

public class RecruiterController implements ActionListener{
	private JButton editTeacher, finish, backToLogin, exit;
	private RecruiterUI Recruiter;
	private StaffList sl;
	private Object inputContent;
	
	public RecruiterController(){
		sl = new StaffList();
		Recruiter = new RecruiterUI();
		editTeacher = new JButton("Edit Teacher");
		finish = new JButton("Finish");
		backToLogin = new JButton("Back to Login");
		exit = new JButton("Exit System");
		
		Recruiter.getPendingReplacementButtons().add(editTeacher);
		Recruiter.getPendingReplacementButtons().add(finish);
		Recruiter.getTopInstruction().add(backToLogin);
		Recruiter.getTopInstruction().add(exit);
		
		editTeacher.addActionListener(this);
		finish.addActionListener(this);
		backToLogin.addActionListener(this);
		exit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == editTeacher) {
			Object[] selectionValues = new Object[sl.getTeacherList().size()];
			for(int i = 0; i < sl.getTeacherList().size(); i++) {
				selectionValues[i] = sl.getTeacherList().get(i).getStaffName();
			}
			inputContent = JOptionPane.showInputDialog(
					Recruiter,
					"Replace a teacher for this class :",
					"Changing Teacher",
					JOptionPane.PLAIN_MESSAGE,
					null,
					selectionValues,
					selectionValues[0]
			);
			int row = Recruiter.getTTT().getSelectedRow();
			Recruiter.getTableModel().setValueAt(inputContent, row, 2);
		}else if(e.getSource() == finish) {
			int row = Recruiter.getTTT().getSelectedRow();
			new Writer("");
			Recruiter.getTableModel().removeRow(row);
			//send to another Teacher haven't done here
		}
	}

}
