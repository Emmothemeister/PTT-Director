package Model;

public class Staff {
	private int SID = 0;
	private int newID;
	
	public Staff() {
		newID = SID++;
	}
	
	public int getSID() {
		return newID;
	}
}
