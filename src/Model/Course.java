package Model;

import java.util.ArrayList;

public class Course {
	private int courseID = 1;
	private String courseName;
	private CourseD director;
	private String introduction;
	private ArrayList<Classes> classes;
	private ArrayList<Teacher> teachers;
	private ArrayList<Request> requests;
	
	public Course(String n, CourseD d, String intro) {
		courseID = courseID++;
		courseName = n;
		director = d;
		introduction = intro;
		classes = new ArrayList<Classes>();
		teachers = new ArrayList<Teacher>();
		requests = new ArrayList<Request>();
	}
}
