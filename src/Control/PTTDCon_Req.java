package Control;

import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.*;
import view.*;

public class PTTDCon_Req implements ActionListener, ListSelectionListener{
	private Request model;
	private PTTDUI_Req view;
	private PTTD pModel;
	private PTTDCon_Main mainCon;
	private int index;
	private Request selectedRequest;
	
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
			
			if(selectedRequest.getStatus() == true) {
				JOptionPane.showMessageDialog(null, "This Request is already approved");
			}else {
			JOptionPane.showMessageDialog(null, "Successfully approved!");
			selectedRequest.setStatus(true);
			view.refreshTable();
			}
		}else if(e.getSource() == view.back) {
			view.setVisible(false);
			PTTDUI_Main main = new PTTDUI_Main(pModel, mainCon);
			main.controller.setView(main);
			main.setVisible(true);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		index = view.selection.getMaxSelectionIndex();
		selectedRequest = pModel.getRequestBoxList().get(index);
	}
}
