package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import View.FinanceUI;

public class FinanceController implements ActionListener{
	private JButton approve, reject, backToLogin, exit;
	private FinanceUI Finance;
	
	
	public FinanceController() {
		Finance = new FinanceUI();
		
		backToLogin = new JButton("Back to Login");
		exit = new JButton("Exit System");
		approve = new JButton("Approve");
		reject = new JButton("Reject ");
		
		Finance.getDecisionButtons().add(approve);
		Finance.getDecisionButtons().add(reject);
		Finance.getTopInstruction().add(backToLogin);
		Finance.getTopInstruction().add(exit);
		
		approve.addActionListener(this);
		reject.addActionListener(this);
		backToLogin.addActionListener(this);
		exit.addActionListener(this);

	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == approve) {
			int row = Finance.getNC().getSelectedRow();
			String cellValue1 = (String) Finance.getTableModel1().getValueAt(row, 0);
			String cellValue2 = (String) Finance.getTableModel1().getValueAt(row, 1);
			String cellValue3 = (String) Finance.getTableModel1().getValueAt(row, 2);
			double cellValue4 = (double) Finance.getTableModel1().getValueAt(row, 3);
			
			Object[] addToHistoricalApprovedClaims = {cellValue1,cellValue2,cellValue3,cellValue4};
			Finance.getTableModel2().addRow(addToHistoricalApprovedClaims);
			Finance.getTableModel1().removeRow(row);
				
		}else if(e.getSource() == reject) {
			int row = Finance.getNC().getSelectedRow();
			Finance.getTableModel1().removeRow(row);

		}else if(e.getSource() == backToLogin) {
			Finance.dispose();
			new LoginController();
		}else if(e.getSource() == exit) {
			System.exit(0);
		}	
	}
}
