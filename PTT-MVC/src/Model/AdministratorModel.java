package Model;

import java.util.ArrayList;

import Model.TeachingRequest;

public class AdministratorModel {
	private ArrayList<TeachingRequest> addTeacherArray = new ArrayList<>();
	private ArrayList<TeachingRequest> AdminSent = new ArrayList<>();
	
	public AdministratorModel() {
		
	}
	
	public ArrayList<TeachingRequest> getAddTeacherArray(){
		return addTeacherArray;
	}
	public ArrayList<TeachingRequest> getAdminSent(){
		return AdminSent;
	}

}
