package Model;

import java.util.ArrayList;

public class PTTD extends Staff{
	private String SName;
	private	String UName;
	private String password;

	private ArrayList<Request> requestBox;
	
	
	
	public PTTD(String n, String u, String p, int c){
		super(n,u,p,c); // get a automatically increment SID

		requestBox = new ArrayList<Request>();
		
		
		
	}
	
	
}
