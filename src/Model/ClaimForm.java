package Model;

public class ClaimForm {
	private int claimID;
	private int newID = 0;
	private String content;
	private boolean approved;
	private boolean read;
	private double cost;
	private Time submitTime;
	
	public ClaimForm(String cont, double c) {
		claimID = claimID++;
		approved = false;
		read = false;
		content = cont;
		cost = c;
		submitTime = new Time();
	}
	
	public String getContt() {
		return content;
	}
	
	public double getCost() {
		return cost;
	}
}
