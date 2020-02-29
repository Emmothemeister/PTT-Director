package Model;

public class Mail {
	private Time sendTime;
	private int senderID;
	private int receiverID;
	private String title;
	private String content;
	private boolean status;
	
	
	public Mail(Time t, int s, int r,String tl, String c) {
		sendTime = t;
		senderID = s;
		receiverID = r;
		title = tl;
		content = c;
		status = false; //status is always false before the mail has been read
	}
}
