package view;

import Control.CourseDCon_Main;
import Model.*;

public class CourseDTestView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		School s = new School();
		Course c = new Course("PE", "train", s);
		CourseD d = new CourseD("Emmo", "goloku", "123456", 123456, c, s);
		Teacher t1 = new Teacher("Teacher 1", "teacher1", "123456", 123456, s);
		Teacher t2 = new Teacher("Teacher 2", "teacher2", "123456", 123456, s);
		Teacher t3 = new Teacher("Teacher 3", "teacher3", "123456", 123456, s);
		s.addTeacher(t1);
		s.addTeacher(t2);
		s.addTeacher(t3);
		
		CourseDCon_Main controller = new CourseDCon_Main(s, d);
		CourseDUI_Main GUI = new CourseDUI_Main(s, d, controller);
		controller.setView(GUI);
		GUI.setVisible(true);
	}

}
