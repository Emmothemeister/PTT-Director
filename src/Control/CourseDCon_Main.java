package Control;

import Model.CourseD;
import Model.School;
import view.CourseDUI_History;
import view.CourseDUI_Main;
import view.CourseDUI_Write;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class CourseDCon_Main implements ActionListener{

	private CourseDUI_Main viewObject;
	private CourseD model;
	private School school;
	
	public CourseDCon_Main(School s, CourseD d){
		model = d;
		school = s;
	}
	
	public void setView(CourseDUI_Main view) {
		viewObject = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewObject.write) {
			JOptionPane.showMessageDialog(null, "Jumping");
			CourseDUI_Write writeView = new CourseDUI_Write(school, model, this);
			viewObject.setVisible(false);
			writeView.controller.setView(writeView);
			writeView.setVisible(true);
			
		}else if (e.getSource() == viewObject.enquiry) {
			JOptionPane.showMessageDialog(null, "Jumping");
			CourseDUI_History historyView = new CourseDUI_History(school, model, this);
			viewObject.setVisible(false);
			historyView.controller.setView(historyView);
			historyView.setVisible(true);
		}
	}
	
}
