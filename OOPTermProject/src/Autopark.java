import java.util.ArrayList;

public class Autopark {
	private ArrayList<SubscribedVehicle> subscribedVehicles;
	private ArrayList<ParkRecord> parkRecords;
	private ArrayList<RegularVehicle> regularVehicles;
	private double hourlyFee;
	private double incomeDaily;
	private int vehicleCount;
	private int capacity;
	
	public Autopark(double hourlyFee, int capacity) {
		this.hourlyFee=hourlyFee;
		vehicleCount = 0;
		subscribedVehicles = new ArrayList<SubscribedVehicle>();
		incomeDaily = 0;
		parkRecords = new ArrayList<ParkRecord>();
		this.capacity = capacity;
		regularVehicles = new ArrayList<RegularVehicle>();
	}

	public Autopark(String string) {
	}

	public SubscribedVehicle searchVehicle(String plate) {
		for(SubscribedVehicle sv : subscribedVehicles)
			if (sv.getPlate().compareTo(plate) == 0)
				return sv;
		return null;
	}
	public RegularVehicle searchRegularVehicle(String plate) {
		for(RegularVehicle rv : regularVehicles)
			if (rv.getPlate().compareTo(plate) == 0)
				return rv;
		RegularVehicle rv = new RegularVehicle(plate);
		return rv;
	}
	
	public boolean isParked(String plate) {
		for(ParkRecord pr : parkRecords)
			if (pr.getVehicle().getPlate()==plate && pr.getExitTime()==null)
				return true;
		return false;
	}
	private void enlargeVehicleArray() {
		capacity = capacity + 10;
		System.out.println("Capacity of the autopark has enlarged (+10 vehicles)");
	}
	public boolean addVehicle(SubscribedVehicle vehicle) {
		if(subscribedVehicles.size()==capacity || searchVehicle(vehicle.getPlate()) != null)
			enlargeVehicleArray();
		subscribedVehicles.add(vehicle);
		vehicleCount++;
		System.out.println("A car its plate " + vehicle.getPlate() + " has added to subscribed vehicles list.");
		return true;
	}
	public boolean vehicleEnters(String plate, Time enter, boolean isOfficial) {
		if(isParked(plate)) {
			System.out.println("Enter is failed.");
			return false;
		}
		else if(searchVehicle(plate) != null && searchVehicle(plate).getSubscription().isValid()) {
			parkRecords.add(new ParkRecord(enter, searchVehicle(plate)));
			System.out.println("At " + enter.toString() + ", a vehicle which its subscription is valid and its plate " + plate  + " has entered." );
			return true;
		}
		else if(searchVehicle(plate) != null && !searchVehicle(plate).getSubscription().isValid()) {
			parkRecords.add(new ParkRecord(enter, searchVehicle(plate)));
			System.out.println("At " + enter.toString() + ", a vehicle its subscription is invalid and which its plate " + plate  + " has entered." );
			return true;
		}
		else if(isOfficial==false) {
			parkRecords.add(new ParkRecord(enter, searchRegularVehicle(plate)));
			System.out.println("At " + enter.toString() + ", a regular vehicle which its plate " + plate  + " has entered." );
			return true;
		}
		System.out.println("An official vehicle which its plate " + plate + " has entered.");
		return false;
	}
	public boolean vehicleExits(String plate, Time exit) {
		for(ParkRecord pr : parkRecords) {
			if (isParked(pr.getVehicle().getPlate())) {
				pr.setExitTime(exit);
				System.out.println("At " + exit.toString() + ", a vehicle which its plate " + plate  + " has exited." );
				if (pr.getVehicle().getSubscription()==null || pr.getVehicle().getSubscription().isValid()==false) {
					incomeDaily = incomeDaily + (pr.getParkingDuration()*hourlyFee);
					System.out.println("Income : " + pr.getEnterTime().getDifference(pr.getExitTime())*hourlyFee);
					System.out.println("Current daily income : " + incomeDaily);
				}
				return true;
			}
		}
		System.out.println("An official vehicle which its plate " + plate + " has exited.");
		return false;
	}
	@Override
	public String toString() {
		String intro = "This is an autopark that has " + vehicleCount + " subscribed vehicles. \n";
		intro += "For Parking hourly fee is -->" +hourlyFee;
	
			for(SubscribedVehicle sv : subscribedVehicles)
				intro+=System.out.printf("Subscribed Vehicles:" +sv.getPlate() + "\n");
			for(RegularVehicle rv : regularVehicles)
				intro+=System.out.printf("Plate is: " +rv.getPlate() + "\n");
		return intro;
	}
	
}
