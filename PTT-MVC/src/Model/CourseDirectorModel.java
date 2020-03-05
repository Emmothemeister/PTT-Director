package Model;

import java.util.ArrayList;

public class CourseDirectorModel {
	private ArrayList<TeachingRequest> pendingTeachingRequests = new ArrayList<>();
	private ArrayList<TeachingRequest> ongoingClassesArray = new ArrayList<>();
	
	
	public CourseDirectorModel() {
		
	}
	
	public ArrayList<TeachingRequest> getPendingTeachingRequests() {
		return pendingTeachingRequests;
	}
	public ArrayList<TeachingRequest> getOngoingClassesArray() {
		return ongoingClassesArray;
	}

}
