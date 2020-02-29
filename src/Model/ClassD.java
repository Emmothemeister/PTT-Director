package Model;

import java.util.ArrayList;

public class ClassD extends Staff{
	private Class itsClass;
	private Course course;
	private ArrayList<Skill> skills;
	private ArrayList<Requirement> requirements;
	private ArrayList<ClaimForm> applyings;
	private ArrayList<ClaimForm> rejecteds;
	private ArrayList<ClaimForm> approveds;
	
	public ClassD(String s, String u, String p, int c, Class cla, Course Cour) {
		super(s,u,p,c);
		itsClass = cla;
		course = Cour;
		skills = new ArrayList<Skill>();
		requirements = new ArrayList<Requirement>();
		applyings = new ArrayList<ClaimForm>();
		rejecteds = new ArrayList<ClaimForm>();
		approveds = new ArrayList<ClaimForm>();
	}
}
