public class RegularVehicle implements Vehicle {
	private String plate;
	private Subscription subscription;
	
	public String getPlate(){return this.plate;}
	public Subscription getSubscription() {return this.subscription;}
	public RegularVehicle(String plate) {
		this.plate = plate;
		this.subscription = null;
	}
	
	public boolean isSpecial() {return false;}
}