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
	private ArrayList<Date> schedule;
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
		schedule = new ArrayList<Date>();
	}
	
	public void setDirector(CourseD d) {
		director = d;
	}
	
	public ArrayList<Date> getSchedule(){
		return schedule;
	}
	
	public String getCourseName() {
		return courseName;
	}
}
