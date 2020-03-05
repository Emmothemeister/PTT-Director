package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.StaffList;
import Model.Writer;
import View.AdministratorUI;

public class AdministratorController implements ActionListener{
	private JButton addTeacher, sendToPTTDirector, backToLogin, exit;
	private Object inputContent;
	
	private AdministratorUI Administrator;
	
	private StaffList sl;
	
	public AdministratorController() {
		sl = new StaffList();
		Administrator = new AdministratorUI();
		
		addTeacher = new JButton("Add Teacher");
		sendToPTTDirector = new JButton("Send To PTT Director");
		backToLogin = new JButton("Back to Login");
		exit = new JButton("Exit System");
		
		Administrator.getAddTeacherButtons().add(addTeacher);
		Administrator.getAddTeacherButtons().add(sendToPTTDirector);
		Administrator.getTopInstruction().add(backToLogin);
		Administrator.getTopInstruction().add(exit);
		
		addTeacher.addActionListener(this);
		sendToPTTDirector.addActionListener(this);
		backToLogin.addActionListener(this);
		exit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addTeacher) {
			Object[] selectionValues = new Object[sl.getTeacherList().size()];
			for(int i = 0; i < sl.getTeacherList().size(); i++) {
				selectionValues[i] = sl.getTeacherList().get(i).getStaffName();
			}
			inputContent = JOptionPane.showInputDialog(
					Administrator,
					"Add a teacher for this class :",
					"Adding Teacher",
					JOptionPane.PLAIN_MESSAGE,
					null,
					selectionValues,
					selectionValues[0]
			);
			int row = Administrator.getAt().getSelectedRow();
			Administrator.getTableModel1().setValueAt(inputContent, row, 2);

		}else if(e.getSource() == sendToPTTDirector) {
			int row = Administrator.getAt().getSelectedRow();
			new Writer("TypeB " 
            + Administrator.getAdministratorM().getAddTeacherArray().get(row).getClassDate().toString() + " " 
			+ Administrator.getAdministratorM().getAddTeacherArray().get(row).getCourseTitle() + " " 
            + inputContent.toString() + "\n");
			Administrator.getTableModel1().removeRow(row);
			Administrator.getAdministratorM().getAddTeacherArray().remove(row);
			
		}else if(e.getSource() == backToLogin) {
			Administrator.dispose();
			new LoginController();
		}else if(e.getSource() == exit) {
			System.exit(0);
		}
		
		
	}

}
