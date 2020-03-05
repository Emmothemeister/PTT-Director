package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.Writer;
import View.PTTDirectorUI;

public class PTTDirectorController implements ActionListener{
	
	private JButton approve,reject,backToLogin,exit;
	private PTTDirectorUI PTTDirector;
	
	public PTTDirectorController() {
		PTTDirector = new PTTDirectorUI();
		
		approve = new JButton("Approve");
		reject = new JButton("Reject ");
		backToLogin = new JButton("Back to Login");
		exit = new JButton("Exit System");
		
		PTTDirector.getDecisionButtons().add(approve);
		PTTDirector.getDecisionButtons().add(reject);
		PTTDirector.getTopInstruction().add(backToLogin);
		PTTDirector.getTopInstruction().add(exit);
		
		approve.addActionListener(this);
		reject.addActionListener(this);
		backToLogin.addActionListener(this);
		exit.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == approve) {
			int row = PTTDirector.getAr().getSelectedRow();
			new Writer("TypeC " 
            + PTTDirector.getPTTDirectorM().getTeachingRequestArray().get(row).getClassDate().toString() + " " 
			+ PTTDirector.getPTTDirectorM().getTeachingRequestArray().get(row).getCourseTitle() + " " 
            + PTTDirector.getPTTDirectorM().getTeachingRequestArray().get(row).getTeacher() + "\n");
			PTTDirector.getTableModel1().removeRow(row);
			PTTDirector.getPTTDirectorM().getTeachingRequestArray().remove(row);
			
		}else if(e.getSource() == reject) {
			int row = PTTDirector.getAr().getSelectedRow();
			PTTDirector.getTableModel1().removeRow(row);
			PTTDirector.getPTTDirectorM().getTeachingRequestArray().remove(row);
			
		}else if(e.getSource() == backToLogin) {
			PTTDirector.dispose();
			new LoginController();
		}else if(e.getSource() == exit) {
			System.exit(0);
		}
		
	}

}
