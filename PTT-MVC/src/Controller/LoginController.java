package Controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import View.LoginUI;
import Model.Reader;
import Model.StaffList;

public class LoginController implements ActionListener{
	private Font f = new Font("TimesRoman", Font.PLAIN, 20);
	private JButton button1, button2;
	private JRadioButton option1,option2,option3,option4,option5,option6;
	private JTextField staffID;
	private JPasswordField code;
	private LoginUI login;
	private StaffList sl;
	private Reader fileReader;
	
	public LoginController () {
		sl = new StaffList();
		login = new LoginUI();
//		fileReader = new Reader();
		
		staffID = new JTextField(10);
		code = new JPasswordField(10);
		staffID.setFont(f);
		code.setFont(f);
		
		button1 = new JButton("Login");
		button2 = new JButton("Quit");
		button1.setFont(f);
		button2.setFont(f);
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		option1 = new JRadioButton("Course Director");
		option2 = new JRadioButton("Administrator");
		option3 = new JRadioButton("PTT Director");
		option4 = new JRadioButton("Recruiter");
		option5 = new JRadioButton("Finance");
		option6 = new JRadioButton("Teacher",true);
		
		option1.setFont(f);
		option2.setFont(f);
		option3.setFont(f);
		option4.setFont(f);
		option5.setFont(f);
		option6.setFont(f);
		
		login.getBox1().add(staffID);
		login.getBox2().add(code);
		login.getButtons().add(button1);
		login.getButtons().add(button2);
		login.getBg().add(option1);
		login.getBg().add(option2);
		login.getBg().add(option3);
		login.getBg().add(option4);
		login.getBg().add(option5);
		login.getBg().add(option6);
		login.getRightCenter().add(option1);
		login.getRightCenter().add(option2);
		login.getRightCenter().add(option3);
		login.getRightCenter().add(option4);
		login.getRightCenter().add(option5);
		login.getRightCenter().add(option6);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			if(option1.isSelected()) {
				login.dispose();
				new CourseDirectorController();
			} else if (option2.isSelected()) {
				login.dispose();
				new AdministratorController();
			}else if (option3.isSelected()) {
				login.dispose();
				new PTTDirectorController();
			}else if (option4.isSelected()) {
				login.dispose();
				new RecruiterController();
			}else if (option5.isSelected()) {
				login.dispose();
				new FinanceController();
			}else if (option6.isSelected()) {
				Reader fr = new Reader();
				if (fr.getCDtoT().size() > 0) {
					JOptionPane.showMessageDialog(
							login,
							"Please submit your next claim!",
							"Warning",
							JOptionPane.WARNING_MESSAGE
					);
				}
				
				login.dispose();
				new TeacherController();
			}
			
			
		} else if (e.getSource() == button2) {
			System.exit(0);				
		}
		
	}
	
	//Getters
	public JTextField getStaffID() {
		return staffID;
	}
	
	public JPasswordField getCode() {
		return code;
	}

}
