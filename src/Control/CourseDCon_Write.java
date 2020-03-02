package Control;

import javax.swing.*;
import java.util.ArrayList;

import Model.CourseD;
import Model.PTTD;
import Model.Request;
import Model.School;
import Model.Staff;
import view.CourseDUI_Main;
import view.CourseDUI_Write;

import java.awt.event.*;

public class CourseDCon_Write implements ActionListener {
	
	private CourseD model;
	private CourseDUI_Write view;
	private CourseDCon_Main mainControl;
	private School school;
	private int cost;
	private boolean isNumeric;
	
	public CourseDCon_Write(School s, CourseD d, CourseDCon_Main c) {
		mainControl = c;
		model = d;
		school = s;
	}
	
	public void setView(CourseDUI_Write GUI) {
		view = GUI;
	}
	
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {   
			   if (!Character.isDigit(str.charAt(i))) {
			    return false;
			   }
		}
		return true;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.submit) {
			/*
			 * if the input content of cost is an Integer, then parse it into int type
			 */
			
			if(view.getCost() == null || "".contentEquals(view.getCost())) {
				JOptionPane.showMessageDialog(null, "Please enter an integer as the cost");
				view.clearCost();
			}else {
				cost = Integer.valueOf(view.getCost().toString());
				Request r = new Request(view.getContent(), cost, "This is the comment.",school);
				model.getApplyingArrayList().add(r);
				school.getApplyingRequests().add(r);
				view.clearCost();
				view.clearContent();
				
			}
			
			
	}	//if the back button is pressed, jump back to the main UI
		else if(e.getSource() == view.back) {
		JOptionPane.showMessageDialog(null, "Jumping");	
		view.setVisible(false);
		CourseDUI_Main mainView = new CourseDUI_Main(school, model, mainControl);
		mainView.controller.setView(mainView);
		mainView.setVisible(true);
	}
		}
	
	//this method can be used to find the corresponding PTTD by his/her ID
	public PTTD findPTTD(int SID) {
		ArrayList<Staff> staffList = school.getStaffList();
		for(int i = 0; i < school.getStaffList().size(); i++) {
			if(staffList.get(i) instanceof PTTD && SID == staffList.get(i).getSID()) {
				return (PTTD) staffList.get(i);
			}
		}
		return null;
		
	}
	
	
}
