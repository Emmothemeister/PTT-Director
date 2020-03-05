package Model;

import java.util.ArrayList;

import Model.TeachingRequest;

public class PTTDirectorModel {
	
	private ArrayList<TeachingRequest> PTTDSent = new ArrayList<>();
	private ArrayList<TeachingRequest> teachingRequestArray = new ArrayList<>();
	
	public PTTDirectorModel() {
		
	}
	
	public ArrayList<TeachingRequest> getTeachingRequestArray(){
		return teachingRequestArray;
	}

}
