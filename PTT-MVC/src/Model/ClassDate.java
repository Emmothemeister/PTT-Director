package Model;


public class ClassDate {
	private int day;
	private int month;
	private int year;
	
	public ClassDate(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public String toString() {
		return String.format("%02d/%02d/%04d", day, month, year);
	}

}
