package Model;

import java.util.ArrayList;

import Model.TeachingRequest;
import Model.TeachingFinished;

public class TeacherModel {
	public static ArrayList<TeachingRequest> T1 = new ArrayList<>();
	public static ArrayList<TeachingFinished> newClaimsArray = new ArrayList<>();
	
	public TeacherModel() {
		
	}
	public void checkWarning() {
	
	}
	public ArrayList<TeachingRequest> getT1(){
		return T1;
	}
	public ArrayList<TeachingFinished> getNewClaimsArray(){
		return newClaimsArray;
	}

}
