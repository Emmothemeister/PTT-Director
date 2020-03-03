package Control;

import Model.*;
import view.*;
import Control.*;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class AdminCon_Main implements ActionListener{
	
	private AdminUI_Main viewObject;
	private Administrator model;
	private School school;
	
	public AdminCon_Main(School s, Administrator a) {
		model = a;
		school = s;
	}
	
	public void setView(AdminUI_Main view) {
		viewObject = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewObject.find) {
			AdminUI_Replace replaceView = new AdminUI_Replace(school,model,this);
			viewObject.setVisible(false);
			replaceView.controller.setView(replaceView);
			replaceView.setVisible(true);
			
		}else if(e.getSource() == viewObject.organize) {
			AdminUI_Org orgView = new AdminUI_Org(school,model,this);
			viewObject.setVisible(false);
			orgView.controller.setView(orgView);
			orgView.setVisible(true);
		}
	}
	
}
