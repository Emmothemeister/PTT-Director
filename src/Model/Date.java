package Model;

import java.util.Calendar;

public class Date{
	
	private int year;
	private int month;
	private int day;
	
	public Date() {
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
		day = calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public Date(int d, int m, int y) {
		year = y;
		month = m;
		day = d;
	}
	
	public String toString() {
		return day + "/" + month + "/" + "/" + year;
	}

}
