package Control;

import java.awt.event.*;

import javax.swing.JOptionPane;

import Model.Budget;
import Model.PTTD;
import view.PTTDUI_Budget;
import view.PTTDUI_Main;


public class PTTDCon_Budget implements ActionListener {
	private Budget model;
	private PTTD pModel;
	private PTTDUI_Budget view;
	private PTTDCon_Main mainCon;
	
	public PTTDCon_Budget(PTTD pm,Budget m, PTTDCon_Main cm) {
		pModel = pm;
		model = m;
		mainCon = cm;
	}
	
	public void setView(PTTDUI_Budget v) {
		view = v;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.back) {
			view.setVisible(false);
			PTTDUI_Main main = new PTTDUI_Main(pModel, mainCon);
			main.setVisible(true);
		}
	}
}
