package Model;

import java.util.ArrayList;

/*
 * This class represents the database model of the school, and it
 * stores the list of staffs, requests, requirements and loggin histories
 */

public class School {
	
	private ArrayList<Staff> staffList;
	private ArrayList<Request> applyingRequests;
	private ArrayList<Request> approvedRequests;
	private ArrayList<Request> rejectedRequests;
	private ArrayList<ClaimForm> claimFormList;
	private ArrayList<Requirement> requirementList; 
	private ArrayList<LogginHistory> logginHistory;
	private ArrayList<Teacher> teacherList;
	private ArrayList<Skill> skillList;
	private int budget;
	private int requestID_new;
	private int staffID_new;
	private int courseID_new;
	private int classID_new;
	private int claimFormID_new;
	
	public School() {
		staffID_new = 0;
		requestID_new = 0;
		courseID_new = 0;
		classID_new = 0;
		claimFormID_new = 0;
		staffList = new ArrayList<Staff>();
		teacherList = new ArrayList<Teacher>();
		applyingRequests = new ArrayList<Request>();
		approvedRequests = new ArrayList<Request>();
		rejectedRequests = new ArrayList<Request>();
		claimFormList = new ArrayList<ClaimForm>();
		requirementList = new ArrayList<Requirement>();
		logginHistory = new ArrayList<LogginHistory>();
		skillList = new ArrayList<Skill>();
		budget = 0;
	}
	
	//this method will initial and create an ArrayList of Teachers
	
	public void addStaff(Staff t) {
		staffList.add(t);
	}
	
	public void setTeacherList() {
		teacherList.clear();
		for(int i=0; i < staffList.size(); i++) {
			if(staffList.get(i) instanceof Teacher) {
				teacherList.add((Teacher) staffList.get(i));
			}
		}
	}
	
	public String[] getTeacherStringArray() {
		String[] teacherListStringArray = new String[teacherList.size()];
		for(int i=0; i<teacherList.size();i++) {
			teacherListStringArray[i] = "SID: " + teacherList.get(i).getSID() + "  , Teacher Name: " + teacherList.get(i).getSName() + "  Absent: " + teacherList.get(i).getAbsent();
		}
		return teacherListStringArray;
	}
	
	public ArrayList<Teacher> getTeacherList(){
		return teacherList;
	}
	
	public int getClaimFormNewID() {
		return claimFormID_new;
	}
	
	public void increaseClaimFormNewID() {
		claimFormID_new++;
	}
	
	public int getClassNewID() {
		return classID_new;
	}
	
	public void increaseClassNewID() {
		classID_new++;
	}
	
	public int getCourseNewID() {
		return courseID_new;
	}
	
	public void increaseCourseNewID() {
		courseID_new++;
	}
	
	public int getStaffNewID() {
		return staffID_new;
	}
	
	public void increaseStaffNewID() {
		staffID_new++;
	}
	
	public int getRequestNewID() {
		return requestID_new;
	}
	
	public void increaseRequestNewID() {
		requestID_new++;
	}
	
	public ArrayList<Staff> getStaffList(){
		return staffList;
	}
	
	public ArrayList<Request> getApplyingRequests(){
		return applyingRequests;
	}
	public ArrayList<Request> getApprovedRequests(){
		return approvedRequests;
	}
	public ArrayList<Request> getRejectedRequests(){
		return rejectedRequests;
	}
	
	public ArrayList<ClaimForm> claimFormList(){
		return claimFormList;
	}
	
	public ArrayList<LogginHistory> getLogginHistory(){
		return logginHistory;
	}
	
	public int getBudget() {
		return budget;
	}
	
	public void addSkill(Skill skl) {
		skillList.add(skl);
	}
	
	public String[] getSkillListStringArray() {
		String[] skillListStringArray = new String[skillList.size()];
		for(int i = 0; i<skillList.size();i++) {
			skillListStringArray[i] = "Skill Name: " + skillList.get(i).getSkillName();
		}
		return skillListStringArray;
	}
	
	public ArrayList<Skill> getSkillList(){
		return skillList;
	}
	
	public void addApplyingRequest(Request r) {
		applyingRequests.add(r);
	}
	
}
