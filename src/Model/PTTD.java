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
	
	public void setRequestBox() {
		for(int i=0; i<school.getApplyingRequests().size();i++) {
			requestBox.add(school.getApplyingRequests().get(i));
		}
	}
	
	public ArrayList<Request> getRequestBoxList(){
		return requestBox;
	}
	
	public String[][] getRequestBoxStringArray() {
		ArrayList<Request>t = requestBox;
		String appRequestStringArray[][] = new String[requestBox.size()][6];
		for(int i=0; i<requestBox.size();i++) {
			appRequestStringArray[i][0] = ""+t.get(i).getID();
			appRequestStringArray[i][1] = t.get(i).getContt();
			appRequestStringArray[i][2] = ""+t.get(i).getCost();
			appRequestStringArray[i][3] = t.get(i).getSubmitTime().toString();
			appRequestStringArray[i][4] = t.get(i).getComm();
			appRequestStringArray[i][5] = ""+t.get(i).getStatus();
		}
		return appRequestStringArray;
	}
	
	
}
