package Model;

public class Request {
	private int requestID;

	private String content;
	private boolean approved;
	private double cost;
	private Time submitTime;
	private String comment;

	public Request(String cont, double c, String comm, School s) {
		requestID = s.getRequestNewID();
		s.increaseRequestNewID();
		content = cont;
		comment = comm;
		cost = c;
		submitTime = new Time();
		approved = false;
	}
	
	public String getContt() {
		return content;
	}
	
	public double getCost() {
		return cost;
	}
	
	public String getComm() {
		return comment;
	}
	
	public int getID() {
		return requestID;
	}
	
	public boolean getStatus() {
		return approved;
	}
	
	public void setStatus(boolean bl) {
		if(bl==true) approved = true;
		if(bl==false) approved = false;
	}
	
	public Time getSubmitTime(){
		return submitTime;
	}
	
	public String toString() {
		return "Request ID: " + requestID + " Cost: " + cost + " Approved: " + approved;
	}
}
