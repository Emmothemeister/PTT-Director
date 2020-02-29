package Model;

public class Request {
	private int requestID;
	private int newID = 0;
	private String content;
	private boolean status;
	private double cost;
	private Time submitTime;
	private String comment;

	public Request(String cont, double n, String comm, Time t) {
		newID++;
		requestID = newID;
		content = cont;
		comment = comm;
		submitTime = t;
		status = false;
	}
}
