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
		Request r1 = new Request("c1", 10, "cmt1", s);
		Request r2 = new Request("c2", 20, "cmt2", s);
		Request r3 = new Request("c3", 30, "cmt3", s);
		Request r4 = new Request("c4", 40, "cmt4", s);
		s.addApplyingRequest(r1);
		s.addApplyingRequest(r2);
		s.addApplyingRequest(r3);
		s.addApplyingRequest(r4);
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
