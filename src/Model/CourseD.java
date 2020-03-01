package Model;

import java.util.ArrayList;

public class CourseD extends Staff{

	private Course course;
	private ArrayList<Mail> mailBox;
	private int contact;
	
	private ArrayList<Request> applyings;
	private ArrayList<Request> rejecteds;
	private ArrayList<Request> approveds;
	private ArrayList<Teacher> supervisedTeachers;
	
	public CourseD(String s, String u, String p, int o, Course c) {
		super(s,u,p,o);
		course = c;
		applyings = new ArrayList<Request>();
		rejecteds = new ArrayList<Request>();
		approveds = new ArrayList<Request>();
		supervisedTeachers = new ArrayList<Teacher>();
	}
	
	public ArrayList<Request> getApplyings(){
		return applyings;
	}
	public ArrayList<Request> getRejecteds(){
		return applyings;
	}
	public ArrayList<Request> getApproveds(){
		return applyings;
	}
	public ArrayList<Teacher> getSupervisedList(){
		return supervisedTeachers;
	}
	
}
