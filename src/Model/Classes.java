package Model;

import java.util.ArrayList;

public class Classes {
	private int classID;
	private int newID = 0;
	private ArrayList<Teacher> teachers;
	private ArrayList<Course> courses;
	private School school;
	
	public Classes(School sch) {
		//automatic increment ID for classes
		school = sch;
		classID = school.getClassNewID();
		school.increaseClassNewID();
		teachers = new ArrayList<Teacher>();
		courses = new ArrayList<Course>();
	}
}
