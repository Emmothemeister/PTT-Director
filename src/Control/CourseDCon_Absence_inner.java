package Control;

import Model.*;
import Control.*;
import view.*;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class CourseDCon_Absence_inner implements ActionListener{
	
	private CourseDUI_Absence_inner viewObject;
	private CourseD model;
	private Teacher teacher;
	private School school;
	
	public CourseDCon_Absence_inner(School s, CourseD d, Teacher t) {
		teacher = t;
		model = d;
		school = s;
	}
	
	public void setView(CourseDUI_Absence_inner view) {
		viewObject = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewObject.confirm) {
			JOptionPane.showMessageDialog(null, "This teacher has been marked as Absent!");	
			teacher.setAbsent(true);
		} else if(e.getSource() == viewObject.cancel) {
			JOptionPane.showMessageDialog(null, "This teacher has been marked as In Position!");
			teacher.setAbsent(false);
		}
	}
}
