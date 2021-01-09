import java.time.LocalDate;

public class Subscription {
	private Date begin;
	private Date end; 
	private SubscribedVehicle vehicle;
	private LocalDate date = LocalDate.now();
	private Date today;
	
	public Date getBegin() {return this.begin;}
	public void setBegin(Date begin) {this.begin=begin;}
	public Date getEnd() {return this.end;}
	public void setEnd(Date end) {this.end=end;}
	public SubscribedVehicle getvehicle() {return this.vehicle;}
	public void setVehicle(SubscribedVehicle vehicle) {this.vehicle=vehicle;}
	
	public Subscription(Date begin, Date end, String plate) {
		this.begin = begin;
		this.end = end;
		vehicle = new SubscribedVehicle(plate,this);
		today = new Date(date.getDayOfMonth(),date.getMonthValue(),date.getYear());
	}
	public boolean isValid() {
		if(end.isAfterThan(today.getToday()) || end.isEqualsWith(today.getToday()))
			return true;
		return false;
	}
}
