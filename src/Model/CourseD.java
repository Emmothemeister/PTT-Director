package Model;

import java.util.ArrayList;

public class CourseD extends Staff{

	private int courseID;
	private ArrayList<Mail> mailBox;
	private int contact;
	private ArrayList<LogginHistory> logginHistory;
	private ArrayList<Request> applyingRequest;
	private ArrayList<Request> rejectedRequest;
	private ArrayList<Request> approvedRequest;
	private ArrayList<Teacher> supervisedTeachers;
	
	public CourseD(String s, String u, String p, int c, int o) {
		super(s,u,p);
		courseID = c;
		contact = o;
		logginHistory = new ArrayList<LogginHistory>();
		applyingRequest = new ArrayList<Request>();
		rejectedRequest = new ArrayList<Request>();
		approvedRequest = new ArrayList<Request>();
		supervisedTeachers = new ArrayList<Teacher>();
	}
	
}
