package Model;
import java.util.Calendar;


public class Time extends Date{
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	
	public Time() {
		super();
		Calendar calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		minute = calendar.get(Calendar.MINUTE);
		second = calendar.get(Calendar.SECOND);
		
	}
	
	public String toString() {
		return day + "/" + month + "/" + "/" + year + " " + hour + ":" + minute + ":" + second;
	}
	
}
