package Model;

import java.util.ArrayList;

public class Classes {
	private int classID;
	private int newID = 0;
	private ArrayList<Teacher> teachers;
	private ArrayList<Course> courses;
	
	public Classes() {
		//automatic increment ID for classes
		newID++;
		classID = newID;
		teachers = new ArrayList<Teacher>();
		courses = new ArrayList<Course>();
	}
}
