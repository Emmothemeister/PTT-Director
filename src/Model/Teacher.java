package Model;

import java.util.ArrayList;

public class Teacher extends Staff{
	
	private ArrayList<Skill> skills;
	private ArrayList<Mail> mailBox;
	private boolean absent;
	
	public Teacher(String s,String u, String p, int c, School sch) {
		super(s,u,p,c, sch);
		skills = new ArrayList<Skill>();
		mailBox = new ArrayList<Mail>();
		authority = 0;
		absent = false;
	}
	
	public String[] getSkills(){
		String[] skillList = new String[skills.size()];
		for(int i = 0; i < skills.size(); i++) {
			skillList[i] = skills.get(i).toString();
		}
		return skillList;
	}
	
	public boolean getAbsent() {
		return absent;
	}
		
	
	public String toString(){
		return "SID: " + getSID() + ", Teacher Name: " + getSName() + ", Skills: " + getSkills();
	}
	
	

}
