import java.time.LocalDate;

public class Date {
	private int day;
	private int month;
	private int year;
	private LocalDate date = LocalDate.now();
	
	public int getDay() {return this.day;}
	public void setDay(int day) {this.day=day;}
	public int getMonth() {return this.month;}
	public void setMonth(int month) {this.month=month;}
	public int getYear() {return this.year;}
	public void setYear(int year) {this.year=year;}
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public Date() {
	}
	//<>
	public boolean isAfterThan(Date other) {
		if(this.year>other.year)
			return true;
		else if(this.year==other.year && this.month>other.month)
			return true;
		else if(this.month==other.month && this.day>other.day)
			return true;
		return false;
	}
	public boolean isBeforeThan(Date other) {
		if(!this.isAfterThan(other))
			return true;
		return false;
	}
	public boolean isEqualsWith(Date other) {
		if(this.year==other.year&&this.month==other.month&&this.day==other.day)
				return true;
		return false;
	}
	public Date getToday() {
		this.day = date.getDayOfMonth();
		this.month = date.getMonthValue();
		this.year = date.getYear();
		return this;
	}
}
