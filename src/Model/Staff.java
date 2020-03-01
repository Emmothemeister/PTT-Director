package Model;

import java.util.ArrayList;

public class Staff {
	private int SID = 0;
	private int newID;
	private String SName;
	private String UName;
	private String password;
	private ArrayList<Mail> mailBox;
	private int contact;
	private ArrayList<LogginHistory> logginHistory;
	
	public Staff(String s, String u, String p, int c) {
		SName = s;
		UName = u;
		password = p;
		newID = SID++;
		mailBox = new ArrayList<Mail>();
		contact = c;
		logginHistory = new ArrayList<LogginHistory>();
	}
	
	public int getSID() {
		return newID;
	}
	
	public String getSName() {
		return SName;
	}
}
