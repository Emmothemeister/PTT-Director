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
		authority = 2;
	}
	
	public ArrayList<Request> getApplyingArrayList(){
		return applyings;
	}
	
	public String[] getApplyings(){
		String[] applyingList = new String[applyings.size()];
		for(int i =0; i < applyings.size(); i++) {
			Request r = applyings.get(i);
			applyingList[i] = "RequestID =" + r.getID() + ", Request Content: " + r.getContt() + ", Comment: " + r.getComm() + "/n"
					+ "Cost: " + r.getCost() + "Approved: " + r.getStatus();
		}
		return applyingList;
	}
	
	public String[] getApproveds(){
		String[] approvedsList = new String[approveds.size()];
		for(int i =0; i < approveds.size(); i++) {
			Request r = approveds.get(i);
			approvedsList[i] = "RequestID =" + r.getID() + ", Request Content: " + r.getContt() + ", Comment: " + r.getComm() + "/n"
					+ "Cost: " + r.getCost() + "Approved: " + r.getStatus();
		}
		return approvedsList;
	}
		
	public String[] getRejecteds(){
		String[] rejectedList = new String[rejecteds.size()];
		for(int i =0; i < rejecteds.size(); i++) {
			Request r = rejecteds.get(i);
			rejectedList[i] = "RequestID =" + r.getID() + ", Request Content: " + r.getContt() + ", Comment: " + r.getComm() + "/n"
					+ "Cost: " + r.getCost() + "Approved: " + r.getStatus();
		}
		return rejectedList;
	}
	
	public ArrayList<Teacher> getSupervisedList(){
		return supervisedTeachers;
	}
	
}
