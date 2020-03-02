package Model;

import java.util.ArrayList;

public class Recruiter extends Staff{
	
	private ArrayList<Applicants> applicants;
	
	public Recruiter(String s, String u, String p, int c) {
		super(s,u,p,c);
		applicants = new ArrayList<Applicants>();
		authority = 4;
	}

	public ArrayList<Applicants> getApplicantsList(){
		return applicants;
	}
}
