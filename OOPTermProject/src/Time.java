import java.time.LocalTime;

public class Time {
	private int hour;
	private int minute;
	private LocalTime time = LocalTime.now();
	
	public int getHour() {return this.hour;}
	public int getMinute() {return this.minute;}
	
	public Time() {
		this.hour = time.getHour();
		this.minute = time.getMinute();
	}
	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}
	
	public int getDifference(Time other) {
		if(this.hour <= other.hour && this.minute <= other.minute)
			return (other.hour - this.hour + 1);
		else if(this.hour <= other.hour && this.minute > other.minute)
			return (other.hour - this.hour);
		else if(this.hour > other.hour && this.minute <= other.minute)
			return (other.hour +25 - this.hour + 1);
		else 
			return (other.hour + 25 - this.hour);
	}
	public String toString() {
		String intro = getHour() + ":" + getMinute();
		return intro;
	}
}
