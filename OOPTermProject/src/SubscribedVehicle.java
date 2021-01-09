public class SubscribedVehicle implements Vehicle {
	private String plate;
	private Subscription subscription;
	
	public String getPlate(){return this.plate;}
	public Subscription getSubscription() {return this.subscription;}
	public SubscribedVehicle(String plate, Subscription subscription) {
		this.plate = plate;
		this.subscription = subscription;
	}
	
	public SubscribedVehicle(String string, Date begin1, Date end1) {
		// TODO Auto-generated constructor stub
	}
	public boolean isSpecial() {return false;}
}
