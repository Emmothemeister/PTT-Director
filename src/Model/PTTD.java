package Model;

import java.util.ArrayList;

public class PTTD extends Staff{
	private String SName;
	private	String UName;
	private String password;

	private ArrayList<Request> requestBox;
	
	
	
	public PTTD(String n, String u, String p, int c, School sch){
		super(n,u,p,c,sch); // get a automatically increment SID
		authority = 5;
		requestBox = new ArrayList<Request>();
		
		
		
	}
	
	
}
