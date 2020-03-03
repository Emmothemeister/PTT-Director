package Control;

import Model.*;
import Control.*;
import view.*;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class AdminCon_Replace_inner implements MouseListener, ActionListener{

	private AdminUI_Replace_inner viewObject;
	private Administrator model;
	private Course selectedCourse;
	private Teacher selectedTeacher;
	private School school;
	private Course course;
	private Teacher visiter;
	private int index1, index2;
	
	public AdminCon_Replace_inner(School s, Administrator a, Teacher t) {
		
		visiter = t;
		selectedTeacher = null;
		model = a;
		school = s;
	}
	
	public void setView(AdminUI_Replace_inner view) {
		viewObject = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewObject.confirm) {
			if(selectedTeacher.getPendingCourse().contains(selectedCourse)) {
				JOptionPane.showMessageDialog(null, "Error, this teacher already have the course, please select another teacher");
			}else {
				JOptionPane.showMessageDialog(null, "The Course has been added into the teacher's timetable");	
				selectedTeacher.getPendingCourse().add(selectedCourse);
			}
			
		}
	}
	
	public void mousePressed (MouseEvent e) {
		index1 = viewObject.list1.getSelectedIndex();
		selectedCourse = model.getTBRC().get(index1);
		index2 = viewObject.list2.getSelectedIndex();
		selectedTeacher = model.getReplacement().get(index2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
