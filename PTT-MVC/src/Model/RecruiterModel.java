package Model;

import java.util.ArrayList;

import Model.TeachingRequest;

public class RecruiterModel {
	private ArrayList<TeachingRequest> pendingReplacementArray = new ArrayList<>();
	
	public RecruiterModel() {
		
	}
	
	public ArrayList<TeachingRequest> getPendingReplacementArray(){
		return pendingReplacementArray;
	}

}
