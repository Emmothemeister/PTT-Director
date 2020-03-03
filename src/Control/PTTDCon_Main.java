package Control;

import Model.*;
import view.*;
import java.awt.event.*;

public class PTTDCon_Main implements ActionListener{
	private PTTD model;
	private PTTDUI_Main view;
	private Budget bModel;
	private Request rModel;
	private PTTDCon_Budget bCon;
	private PTTDCon_Req rCon;
	
	public PTTDCon_Main(PTTD m) {
		model = m;
	}
	
	public void setView(PTTDUI_Main v) {
		view = v;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.checkBudget) {
			view.setVisible(false);
			PTTDUI_Budget Budget = new PTTDUI_Budget(model,bModel, bCon, this);
			Budget.controller.setView(Budget);
			Budget.setVisible(true);
		}else if(e.getSource() == view.approvalReq) {
			view.setVisible(false);
			PTTDUI_Req approval = new PTTDUI_Req(model,rModel, rCon, this);
			approval.controller.setView(approval);
			approval.setVisible(true);
		}
	}
}
