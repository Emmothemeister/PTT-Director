package Model;

public class AbsenceRequest {
	private boolean read;
	private boolean approved;
	private Time sendTime;
	private int indicatedID;
	private Teacher sender;
	
	/*
	 * AbsenceRequest will be create when a teacher want to request a absence
	 */
	public AbsenceRequest(Teacher t, int i) {
		sender = t;
		read = false; //false = unread, true = read
		approved = false; // false = rejected or not approved, true = approved
		sendTime = new Time();
		indicatedID = i;
		
	}
	
	public boolean getRead() {
		return read;
	}
	
	public boolean getApproved() {
		return approved;
	}
	
	public int getIndictaed() {
		return indicatedID;
	}
	
	public Teacher getSender() {
		return sender;
	}
	
}
