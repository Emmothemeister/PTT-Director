package Model;

import java.util.ArrayList;

public class Applicants {
	private String name;
	private int contact;
	private ArrayList<Skill> skills;
	private String selfIntro;
	private boolean status;
	
	public Applicants(String n, int cont, ArrayList<Skill> apskills, String intro) {
		name = n;
		contact = cont;
		skills = apskills;
		selfIntro = intro;
		status = false; // false means not approved, but true means approved
	}
}
