package Control;

import Model.CourseD;
import Model.School;
import view.CourseDUI_History;
import view.CourseDUI_Main;


import java.awt.event.*;

import javax.swing.JOptionPane;



public class CourseDCon_History implements ActionListener{
	
	private CourseDUI_History viewObject;
	private CourseD model;
	private School school;
	private CourseDCon_Main mainControl;
	
	public CourseDCon_History(School s, CourseD d, CourseDCon_Main c) {
		mainControl = c;
		model = d;
		school = s;
	}
	
	public void setView(CourseDUI_History view) {
		viewObject = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewObject.back) {
			JOptionPane.showMessageDialog(null, "Jumping");	
			viewObject.setVisible(false);
			CourseDUI_Main mainView = new CourseDUI_Main(school, model, mainControl);
			mainView.controller.setView(mainView);
			mainView.setVisible(true);	
		}
	}

}
