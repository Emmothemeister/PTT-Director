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
	private School school;
	
	public Course(String n, String intro, School sch) {
		school = sch;
		courseID = school.getCourseNewID();
		school.increaseCourseNewID();
		courseName = n;
		director = null;
		introduction = intro;
		classes = new ArrayList<Classes>();
		teachers = new ArrayList<Teacher>();
		requests = new ArrayList<Request>();
	}
	
	public void setDirector(CourseD d) {
		director = d;
	}
}
