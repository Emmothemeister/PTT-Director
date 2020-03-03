package Control;

import Model.PTTD;
import view.PTTDUI_Main;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class PTTDCon_Main implements ActionListener{
	private PTTD model;
	private PTTDUI_Main view;
	public PTTDCon_Main(PTTD pd) {
		model = pd;
		view = new PTTDUI_Main(model, this);
		view.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.checkBudget) {
			JOptionPane.showMessageDialog(null, "OJBK");
		}
	}
}
