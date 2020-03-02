package Model;

import java.util.ArrayList;

public class Recruiter extends Staff{
	
	private ArrayList<Applicants> applicants;
	
	public Recruiter(String s, String u, String p, int c, School sch) {
		super(s,u,p,c,sch);
		applicants = new ArrayList<Applicants>();
		authority = 4;
	}

	public ArrayList<Applicants> getApplicantsList(){
		return applicants;
	}
}
