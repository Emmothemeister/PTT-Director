package view;

import Model.*;
import Control.*;
import view.*;

public class AdminTestView {

	public static void main(String[] args) {
		
	
		School s = new School();
		Administrator a = new Administrator("Emmo", "goloku", "123456", 123456, s);
		Course c1 = new Course("PE", "duanlianshenti", s);
		c1.setSchedule(3, 3, 2020);
		c1.setSchedule(7, 3, 2020);
		c1.setSchedule(13, 3, 2020);
		Course c2 = new Course("Math", "suanshu", s);
		c1.setSchedule(3, 4, 2020);
		c1.setSchedule(5, 4, 2020);
		c1.setSchedule(20, 4, 2020);
		Course c3 = new Course("Physic", "wuli", s);
		c1.setSchedule(15, 5, 2020);
		c1.setSchedule(22, 5, 2020);
		c1.setSchedule(17, 5, 2020);
		Teacher t1 = new Teacher("Teacher 1", "teacher1", "123456", 123456, s);
		Teacher t2 = new Teacher("Teacher 2", "teacher2", "123456", 123456, s);
		Teacher t3 = new Teacher("Teacher 3", "teacher3", "123456", 123456, s);
		Skill s1 = new Skill("Boxing");
		Skill s2 = new Skill("Chuibi");
		Skill s3 = new Skill("Luguan");
		Skill s4 = new Skill("ShouChong");
		t1.addCourse(c1);
		t1.addCourse(c2);
		t1.addCourse(c3);
		t2.addCourse(c2);
		t3.addCourse(c3);
		t1.addSkill(s1);
		t1.addSkill(s2);
		t2.addSkill(s2);
		t3.addSkill(s1);
		t1.setAbsent(true);
		s.addSkill(s1);
		s.addSkill(s2);
		s.addSkill(s3);
		s.addSkill(s4);
		s.addStaff(t1);
		s.addStaff(t2);
		s.addStaff(t3);
		s.addStaff(a);
		
		
		
		
		AdminCon_Main controller = new AdminCon_Main(s,a);
		AdminUI_Main GUI = new AdminUI_Main(s, a, controller);
		controller.setView(GUI);
		GUI.setVisible(true);
		
	}
}
