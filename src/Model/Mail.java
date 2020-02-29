package Model;

public class Mail {
	private Time sendTime;
	private int senderID;
	private String senderName;
	private int receiverID;
	private String title;
	private String content;
	private boolean status;
	
	
	public Mail(int s, int r, String tl, String c) {
		sendTime = new Time();
		senderID = s;
		receiverID = r;
		title = tl;
		content = c;
		status = false; //status is always false before the mail has been read
	}
	
	public String getSenderName() {
		return senderName;
	}
	
	public int getSenderID() {
		return senderID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getTime() {
		return sendTime.toString();
	}
}
