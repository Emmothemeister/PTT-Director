package Control;

import java.awt.event.*;
import javax.swing.JOptionPane;
import Model.Request;
import view.PTTDUI_Req;

public class PTTDCon_Req implements ActionListener {
	private Request model;
	private PTTDUI_Req view;
	public PTTDCon_Req(Request r) {
		model = r;
		view = new PTTDUI_Req(model, this);
		view.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.approval) {
			JOptionPane.showMessageDialog(null, "Successful approved!");
		}
	}
}
