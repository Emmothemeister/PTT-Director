package Control;

import javax.swing.*;

import Model.CourseD;
import Model.Request;
import view.CourseDUI_Write;

import java.awt.event.*;

public class CourseDCon_Write implements ActionListener {
	
	private CourseD model;
	private CourseDUI_Write view;
	private int cost;
	
	public CourseDCon_Write(CourseD d) {
		model = d;
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
			
			if(isNumeric(view.getCost())) {
				cost = Integer.valueOf(view.getCost().toString());
				model.getApplyings().add(new Request(view.getContent(), cost, "This is the comment."));
				view.clearCost();
				view.clearContent();
			}
			else {
				JOptionPane.showMessageDialog(null, "Please enter an integer as the cost");
				view.clearCost();
			}
			
			
	}
		}
}
