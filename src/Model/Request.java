package Model;

public class Request {
	private int requestID;
	private String content;
	private boolean approved;
	private double cost;
	private Time submitTime;
	private String comment;

	public Request(String cont, double c, String comm) {
		requestID = requestID++;
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
}
