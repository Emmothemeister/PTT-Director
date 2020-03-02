package Model;

import java.util.ArrayList;

public class Staff {
	private int SID;
	private String SName;
	private String UName;
	private String password;
	private ArrayList<Mail> mailBox;
	private int contact;
	private School school;
	private ArrayList<LogginHistory> logginHistory;
	protected int authority;
	
	//Authority: 0=teacher, 1=classD, 2=courseD, 3=FND, 4=Recruiter, 5=PTTD
	public Staff(String s, String u, String p, int c, School sch) {
		school = sch;
		SName = s;
		UName = u;
		password = p;
		SID = school.getStaffNewID();
		school.increaseStaffNewID();
		mailBox = new ArrayList<Mail>();
		contact = c;
		logginHistory = new ArrayList<LogginHistory>();
		authority = 0;
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
