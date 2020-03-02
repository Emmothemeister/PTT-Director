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
	private int budget;
	
	public School() {
		staffList = new ArrayList<Staff>();
		applyingRequests = new ArrayList<Request>();
		approvedRequests = new ArrayList<Request>();
		rejectedRequests = new ArrayList<Request>();
		claimFormList = new ArrayList<ClaimForm>();
		requirementList = new ArrayList<Requirement>();
		logginHistory = new ArrayList<LogginHistory>();
		budget = 0;
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
	
	
}
