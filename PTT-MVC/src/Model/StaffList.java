package Model;

import java.util.ArrayList;

public class StaffList {
	private ArrayList<Staff> staffList = new ArrayList<>();
	private ArrayList<Staff> teacherList = new ArrayList<>();
	
	public StaffList() {
		Staff CD = new Staff("CD", 1001, "1", 1);
		Staff AD = new Staff("AD", 2001, "1", 2);
		Staff PD = new Staff("PD", 3001, "1", 3);
		Staff RE = new Staff("RE", 4001, "1", 4);
		Staff FI = new Staff("FI", 5001, "1", 5);
		Staff T1 = new Staff("T1", 6001, "1", 6);
		Staff T2 = new Staff("T2", 6002, "1", 6);
		Staff T3 = new Staff("T3", 6003, "1", 6);
		
		staffList.add(CD);
		staffList.add(AD);
		staffList.add(PD);
		staffList.add(RE);
		staffList.add(FI);
		staffList.add(T1);
		staffList.add(T2);
		staffList.add(T3);
		
		teacherList.add(T1);
		teacherList.add(T2);
		teacherList.add(T3);
	}
	
	public ArrayList<Staff> getStaffList(){
		return staffList;
	}
	public ArrayList<Staff> getTeacherList(){
		return teacherList;
	}

}
