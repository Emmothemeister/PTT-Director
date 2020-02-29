package Model;

import java.util.ArrayList;

public class Teacher extends Staff{
	
	private ArrayList<Skill> skills;
	private ArrayList<Mail> mailBox;
	
	public Teacher(String s,String u, String p, int c) {
		super(s,u,p,c);
		skills = new ArrayList<Skill>();
		mailBox = new ArrayList<Mail>();
		
	}

}
