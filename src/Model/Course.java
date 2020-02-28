package Model;

public class Course {
	private int courseID = 1;
	private String courseName;
	private int directorID;
	private String introduction;
	
	public Course(String n, int d, String intro) {
		courseID = courseID++;
		courseName = n;
		directorID = d;
		introduction = intro;
	}
}
