package Model;

import java.util.ArrayList;

public class FND extends Staff{
	
	private ArrayList<ClaimForm> formBox;
	
	/*
	 * This class represent the type of Financial Department staff, and each of them
	 * has their basic staff information, beside, they have a formBox which stores the 
	 * received ClaimForm objects send from Teachers.
	 */
	
	public FND(String s, String u, String p, int c, School sch) {
		super(s,u,p,c,sch);
		formBox = new ArrayList<ClaimForm>();
		authority = 3;
	}

}
