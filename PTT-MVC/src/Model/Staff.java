package Model;

public class Staff {
	private String staffName;
	private int staffID;
	private String password;
	private int staffType;
	
	public Staff(String staffName, int staffID, String password, int staffType) {
		this.staffName = staffName;
		this.staffID = staffID;
		this.password = password;
		this.staffType = staffType;
	}
/*
 *  1 = Course Director
 *  2 = Administrator
 *  3 = PTT Director
 *  4 = Recruiter
 *  5 = Finance
 *  6 = Teacher
 */
	
	public String getStaffName() {
		return staffName;
	}
	
	public int getStaffID() {
		return staffID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getStaffType() {
		return staffType;
	}

}
