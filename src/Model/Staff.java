package Model;

import java.util.ArrayList;

public class Staff {
	protected int SID;
	protected String SName;
	protected String UName;
	protected String password;
	protected ArrayList<Mail> mailBox;
	protected int contact;
	protected School school;
	protected ArrayList<LogginHistory> logginHistory;
	protected int authority;
	protected ArrayList<Skill> skills;
	protected ArrayList<Skill> trainingSkills;
	
	//Authority: 0=teacher, 1=classD, 2=courseD, 3=FND, 4=Recruiter, 5=PTTD
	public Staff(String s, String u, String p, int c, School sch) {
		school = sch;
		SName = s;
		UName = u;
		password = p;
		skills = new ArrayList<Skill>();
		trainingSkills = new ArrayList<Skill>();
		SID = school.getStaffNewID();
		school.increaseStaffNewID();
		mailBox = new ArrayList<Mail>();
		contact = c;
		logginHistory = new ArrayList<LogginHistory>();
		authority = 0;
	}
	
	public String getSkills(){
		String[] skillList = new String[skills.size()];
		String skillString = "";
		for(int i = 0; i < skills.size(); i++) {
			skillList[i] = skills.get(i).toString();
		}
		for(int n=0; n < skillList.length; n++) {
			skillString += skillList[n] + ", ";
		}
		return skillString;
	}
	
	public ArrayList<Skill> getStaffSkillList(){
		return skills;
	}
	
	public void addSkill(Skill skill) {
		skills.add(skill);
	}
	
	public void addTraining(Skill skill) {
		trainingSkills.add(skill);
	}
	
	public int getSID() {
		return SID;
	}
	
	public String getSName() {
		return SName;
	}
	
	public int getAuthority() {
		return authority;
	}
	
	public int getContact() {
		return contact;
	}
}
