package Control;

import java.awt.event.*;
import javax.swing.JOptionPane;
import Model.*;
import view.*;

public class PTTDCon_Req implements ActionListener {
	private Request model;
	private PTTDUI_Req view;
	private PTTD pModel;
	private PTTDCon_Main mainCon;
	
	public PTTDCon_Req(PTTD pm, Request m, PTTDCon_Main cm) {
		pModel = pm;
		model = m;
		mainCon = cm;
	}
	
	public void setView(PTTDUI_Req v) {
		view = v;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.approval) {
			JOptionPane.showMessageDialog(null, "Successfully approved!");
		}else if(e.getSource() == view.back) {
			view.setVisible(false);
			PTTDUI_Main main = new PTTDUI_Main(pModel, mainCon);
			main.controller.setView(main);
			main.setVisible(true);
		}
	}
}
