package view;

import Control.CourseDCon_Main;
import Model.Course;
import Model.CourseD;

public class testView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course c = new Course("PE", "train");
		CourseD d = new CourseD("Emmo", "goloku", "123456", 123456, c);
		CourseDCon_Main controller = new CourseDCon_Main(d);
		CourseDUI_Main GUI = new CourseDUI_Main(d, controller);
		controller.setView(GUI);
		GUI.setVisible(true);
	}

}
