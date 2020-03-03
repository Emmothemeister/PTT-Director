package Control;

import Model.*;
import view.*;
import Control.*;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class AdminCon_Org implements ActionListener, MouseListener{
	
	private AdminUI_Org viewObject;
	private Administrator model;
	private School school;
	private AdminCon_Main mainControl;
	private Staff selectedStaff;
	private int index;

	public AdminCon_Org(School s, Administrator a, AdminCon_Main c) {
		mainControl = c;
		model = a;
		school = s;
		selectedStaff = null;
	}
	
	public void setView(AdminUI_Org view) {
		viewObject = view;
	}
	
	//mouse events
	public void mousePressed(MouseEvent e) {
		index = viewObject.list.getSelectedIndex();
		selectedStaff = model.getTrainees().get(index);
	}
	
	//button events
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewObject.select) {
			viewObject.setVisible(false);
			AdminUI_Org_inner newWindow = new AdminUI_Org_inner(school,model,selectedStaff);
			newWindow.controller.setView(newWindow);
			newWindow.setVisible(true);
			
			
		}else if(e.getSource() == viewObject.back) {
			viewObject.setVisible(false);
			AdminUI_Main mainView = new AdminUI_Main(school, model, mainControl);
			mainView.controller.setView(mainView);
			mainView.setVisible(true);	
		}
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
