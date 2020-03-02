package Control;

import Model.*;
import view.*;
import Control.*;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class CourseDCon_Absence implements ActionListener, MouseListener{
	
	private CourseDUI_Absence viewObject;
	private CourseD model;
	private School school;
	private CourseDCon_Main mainControl;
	private Teacher selectedTeacher;
	private int index;
	
	public CourseDCon_Absence(School s, CourseD d, CourseDCon_Main c) {
		mainControl = c;
		model = d;
		school = s;
		selectedTeacher = null;
		
	}
	
	public void setView(CourseDUI_Absence view) {
		viewObject = view;
	}
	
	
	//mouse events
	public void mousePressed(MouseEvent e) {
		index = viewObject.list.getSelectedIndex();
		selectedTeacher = school.getTeacherList().get(index);
	}
	
	//button events
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewObject.confirm) {
			
			if(selectedTeacher == null) {
				JOptionPane.showMessageDialog(null, "Please select a teacher to check");	
			}else {
				CourseDUI_Absence_inner innerView = new CourseDUI_Absence_inner(school, model, selectedTeacher);
				innerView.controller.setView(innerView);
				innerView.setVisible(true);
			}
			
			
		} else if(e.getSource() == viewObject.back) {
			JOptionPane.showMessageDialog(null, "Jumping");	
			viewObject.setVisible(false);
			CourseDUI_Main mainView = new CourseDUI_Main(school, model, mainControl);
			mainView.controller.setView(mainView);
			mainView.setVisible(true);	
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
