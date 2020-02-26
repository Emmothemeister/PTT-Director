package Model;

import java.util.ArrayList;

public class PTTD extends Staff{
	private String SName;
	private	String UName;
	private String password;
	private MailBox mailbox;
	private String contact;
	private ArrayList<Request> requestBox;
	private ArrayList<LogginHistory> logginHistory;
	
	
	public PTTD(String n, String u, String p, String c){
		super(); // get a automatically increment SID
		SName = n;
		UName = u;
		password = p;
		contact = c;
		mailbox = new MailBox();
		requestBox = new ArrayList<Request>();
		logginHistory = new ArrayList<LogginHistory>();
		
		
	}
}
