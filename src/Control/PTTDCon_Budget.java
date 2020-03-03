package Control;

import Model.Budget;
import view.PTTDUI_Budget;


public class PTTDCon_Budget {
	private Budget model;
	private PTTDUI_Budget view;
	public PTTDCon_Budget(Budget b) {
		model = b;
		view = new PTTDUI_Budget(model, this);
		view.setVisible(true);
	}
	
}
