package Control;

import Model.*;
import view.*;
import Control.*;

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
			
		}else if (e.getSource() == viewObject.absence) {
			JOptionPane.showMessageDialog(null, "Jumping");
			CourseDUI_Absence absenceView = new CourseDUI_Absence(school, model, this);
			viewObject.setVisible(false);
			absenceView.controller.setView(absenceView);
			absenceView.setVisible(true);
		}
	}
	
}
