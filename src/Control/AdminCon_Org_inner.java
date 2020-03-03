package Control;

import Model.*;
import Control.*;
import view.*;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class AdminCon_Org_inner implements MouseListener, ActionListener{
	
	private AdminUI_Org_inner viewObject;
	private Administrator model;
	private Skill selectedSkill;
	private Staff staff;
	private School school;
	private int index;
	
	public AdminCon_Org_inner(School s, Administrator a, Staff stf) {
		school = s;
		model = a;
		staff = stf;
		selectedSkill = null;
	}
	
	public void setView(AdminUI_Org_inner view) {
		viewObject = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewObject.confirm) {
			if(staff.getStaffSkillList().contains(selectedSkill)) {
				JOptionPane.showMessageDialog(null, "Error, this staff already learnt this skill");
			}else {
				JOptionPane.showMessageDialog(null, "The training of the skill has been organized for the staff");
				staff.addSkill(selectedSkill);
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
		index = viewObject.list.getSelectedIndex();
		selectedSkill = school.getSkillList().get(index);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
