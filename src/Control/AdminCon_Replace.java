package Control;

import Model.*;
import view.*;
import Control.*;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class AdminCon_Replace implements ActionListener, MouseListener{
	
	private AdminUI_Replace viewObject;
	private Administrator model;
	private School school;
	private AdminCon_Main mainControl;
	private Teacher selectedTeacher;
	private int index;
	
	public AdminCon_Replace(School s, Administrator a, AdminCon_Main c) {
		mainControl = c;
		model = a;
		school = s;
		selectedTeacher = null;
	}
	
	public void setView(AdminUI_Replace view) {
		viewObject = view;
	}
	
	//mouse events
	public void mousePressed(MouseEvent e) {
		index = viewObject.list.getSelectedIndex();
		selectedTeacher = model.getToBeReplacedList().get(index);
	}
	
	//button events
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewObject.confirm) {
			
			if(selectedTeacher == null) {
				JOptionPane.showMessageDialog(null, "Please select a teacher to find replacement");	
			}else {
				//create a new window here
				AdminUI_Replace_inner newWindow = new AdminUI_Replace_inner(school, model, selectedTeacher);
				newWindow.controller.setView(newWindow);
				newWindow.setVisible(true);
			}
			
			
		}else if(e.getSource() == viewObject.back) {
			viewObject.setVisible(false);
			AdminUI_Main mainView = new AdminUI_Main(school, model, mainControl);
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
