package Model;

import java.util.ArrayList;

public class Teacher extends Staff{
	

	private ArrayList<Mail> mailBox;
	private ArrayList<Course> pendingCourse;
	private ArrayList<Classes> taughtClasses;
	private String courses = "";
	private boolean absent;
	
	public Teacher(String s,String u, String p, int c, School sch) {
		super(s,u,p,c, sch);
		mailBox = new ArrayList<Mail>();
		authority = 0;
		absent = false;
		pendingCourse = new ArrayList<Course>();
	}
	
	public String getPendingCourseString() {
		courses = "";
		for(int i=0; i<pendingCourse.size();i++){
			courses += getPendingCourseList()[i] +", ";
		}
		return courses;
	}
	
	
	public String[] getPendingCourseList() {
		int pendingSize = 0;
		for(int n = 0; n<pendingCourse.size();n++) {
			pendingSize += pendingCourse.get(n).getSchedule().size();	
		}
		
		String[] pendingList = new String[pendingSize];
		int insert = 0;
		
		for(int i=0; i<pendingCourse.size();i++) {
			
			Course c = pendingCourse.get(i);
			//create a temporal String array to store the list of a course's schedule
			String[] courseSchedule = new String[c.getSchedule().size()];
			for(int m =0; m<c.getSchedule().size();m++) {
				courseSchedule[m] = "  Date: " + c.getSchedule().get(m).toString() + "  Course Title: " + c.getCourseName();
				pendingList[insert + m] = courseSchedule[m];
			}
			insert += courseSchedule.length;
		}
		return pendingList;
	}
	
	public ArrayList<Course> getPendingCourse(){
		return pendingCourse;
	}
	
	public boolean getAbsent() {
		return absent;
	}
	
	public void setAbsent(boolean a) {
		if(a)absent = true;
		if(!a)absent = false;
	}
	
	public void addCourse(Course c) {
		pendingCourse.add(c);
	}
	
	public String toString(){
		return "SID: " + getSID() + ", Teacher Name: " + getSName() + ", Skills: " + getSkills();
	}
	
	

}
