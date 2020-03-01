package Model;

import java.util.ArrayList;

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
	
	
}
