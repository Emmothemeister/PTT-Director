package Model;

import java.util.ArrayList;

public class Teacher extends Staff{
	
	private ArrayList<Skill> skills;
	private ArrayList<Mail> mailBox;
	private ArrayList<Course> pendingCourse;
	private boolean absent;
	
	public Teacher(String s,String u, String p, int c, School sch) {
		super(s,u,p,c, sch);
		skills = new ArrayList<Skill>();
		mailBox = new ArrayList<Mail>();
		authority = 0;
		absent = false;
		pendingCourse = new ArrayList<Course>();
	}
	
	public String[] getSkills(){
		String[] skillList = new String[skills.size()];
		for(int i = 0; i < skills.size(); i++) {
			skillList[i] = skills.get(i).toString();
		}
		return skillList;
	}
	
	public String[] getPendingClassList() {
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
				courseSchedule[m] = "Date: " + c.getSchedule().get(m).toString() + "Course Title: " + c.getCourseName();
				pendingList[insert + m] = courseSchedule[m];
			}
			insert += courseSchedule.length;
		}
		return pendingList;
	}
	
	public ArrayList<Course> getPendingClass(){
		return pendingCourse;
	}
	
	public boolean getAbsent() {
		return absent;
	}
		
	
	public String toString(){
		return "SID: " + getSID() + ", Teacher Name: " + getSName() + ", Skills: " + getSkills();
	}
	
	

}
