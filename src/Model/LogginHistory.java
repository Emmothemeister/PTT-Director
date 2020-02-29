package Model;

public class LogginHistory {

	private boolean sucess;
	private Time time;
	
	/*
	 * Each time when someone try to log in, the system will catch the status
	 * of whether this logging in has succeed and store the time.
	 */
	
	public LogginHistory(boolean s) {
		time = new Time();
		sucess = s;
	}
	
	public String toString() {
		return "On the time of" + time.toString() + ", the loggin was " + sucess;
	}
}
