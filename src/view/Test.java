package view;

import Control.PTTDCon_Budget;
import Control.PTTDCon_Main;
import Control.PTTDCon_Req;
import Model.Budget;
import Model.Course;
import Model.CourseD;
import Model.PTTD;
import Model.Request;
import Model.School;

public class Test {
	public static void main(String[] args) {
		School s = new School();
		PTTD model = new PTTD("a", "b", "c", 1, s);
		PTTDCon_Main controller = new PTTDCon_Main(model);
		PTTDUI_Main view = new PTTDUI_Main(model, controller);
		view.controller.setView(view);
		view.setVisible(true);
		//Budget model = new Budget("a", 1, 2);
		//PTTDCon_Budget controller = new PTTDCon_Budget(model);
		
		//Request model = new Request("a", 2, "c", s);
		//PTTDCon_Req controller = new PTTDCon_Req(model);
		
	}
}
