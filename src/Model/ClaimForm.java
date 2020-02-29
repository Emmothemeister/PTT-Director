package Model;

public class ClaimForm {
	private int claimID;
	private int newID = 0;
	private String content;
	private boolean status;
	private double cost;
	private Time submitTime;
	
	public ClaimForm(String cont, double c) {
		newID++;
		claimID = newID;
		status = false;
		content = cont;
		cost = c;
		submitTime = new Time();
		
	}
}
