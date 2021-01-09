public class Test {

	public static void main(String[] args) {
		Autopark park = new Autopark(5, 30);
		Menu menu = new Menu();
		
		Subscription s1 = new Subscription(new Date(19,01,2019), new Date(27,11,2021), "34 SNO 96");
		park.addVehicle(s1.getvehicle());
		
		Subscription s2 = new Subscription(new Date(04,07,2018), new Date(19,06,2022), "34 BS 95");
		park.addVehicle(s2.getvehicle());
		
		Subscription s3 = new Subscription(new Date(27,03,2019), new Date(04,07,2022), "34 ABC 25");
		park.addVehicle(s3.getvehicle());
		
		Subscription s4 = new Subscription(new Date(19,06,2018), new Date(27,03,2019), "34 TUV 49");
		park.addVehicle(s4.getvehicle());
		
		Subscription s5 = new Subscription(new Date(19,04,2019), new Date(27,11,2020), "34 KLM 36");
		park.addVehicle(s5.getvehicle());
		
		RegularVehicle regular = new RegularVehicle("34 VT 20");
		OfficialVehicle official = new OfficialVehicle("34 OFC 01");
		
		
		park.vehicleExits(s1.getvehicle().getPlate(), new Time(21,30));
		park.vehicleEnters(s1.getvehicle().getPlate(), new Time(18,00), s1.getvehicle().isSpecial());
		park.vehicleEnters(s1.getvehicle().getPlate(), new Time(18,00), s1.getvehicle().isSpecial());
		park.vehicleExits(s1.getvehicle().getPlate(), new Time(21,30));
		park.vehicleEnters(s2.getvehicle().getPlate(), new Time(18,30), s2.getvehicle().isSpecial());
		park.vehicleExits(s2.getvehicle().getPlate(), new Time(21,00));
		park.vehicleEnters(s3.getvehicle().getPlate(), new Time(21,00), s3.getvehicle().isSpecial());
		park.vehicleExits(s3.getvehicle().getPlate(), new Time(03,30));
		park.vehicleEnters(s4.getvehicle().getPlate(), new Time(21,30), s4.getvehicle().isSpecial());
		park.vehicleExits(s4.getvehicle().getPlate(), new Time(03,00));
		park.vehicleEnters(s5.getvehicle().getPlate(), new Time(18,00), s5.getvehicle().isSpecial());
		park.vehicleExits(s5.getvehicle().getPlate(), new Time(23,00));
		park.vehicleEnters(regular.getPlate(), new Time(18,00), regular.isSpecial());
		park.vehicleExits(regular.getPlate(), new Time(23,00));
		park.vehicleEnters(official.getPlate(), new Time(18,00), official.isSpecial());
		park.vehicleExits(official.getPlate(), new Time(23,00));
		System.out.printf(park.toString());	
		menu.runMenu();
		
		
		
		
		
	}
}
