package utilities;

public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	@Override
	public String toString() {
		return Integer.toString(this.day) + Integer.toString(this.month) + Integer.toString(this.year);
	}
	
	public int getDay() { return day; }
	public int getMonth() { return month; }
	public int getYear() { return year; }
	
}
