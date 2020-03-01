package Control;

import Model.CourseD;
import view.CourseDUI_Main;
import view.CourseDUI_Write;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class CourseDCon_Main implements ActionListener{

	private CourseDUI_Main viewObject;
	private CourseD model;
	
	public CourseDCon_Main(CourseD d){
		model = d;
	}
	
	public void setView(CourseDUI_Main view) {
		viewObject = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewObject.write) {
			JOptionPane.showMessageDialog(null, "Jumping");
			CourseDUI_Write writeView = new CourseDUI_Write(model);
			viewObject.setVisible(false);
			writeView.setVisible(true);
		}
	}
	
}
