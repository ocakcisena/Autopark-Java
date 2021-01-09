import java.util.Scanner;

public class Menu {

	    boolean exit;

	    public static void main(String[] args) {
	        Menu menu = new Menu();
	        menu.runMenu();
	    }

	    public void runMenu() {
	        printHeader();
	        while (!exit) {
	            printMenu();
	            int choice = getMenuChoice();
	            performAction(choice);
	        }
	    }

	    private void printHeader() {
	        System.out.println("+-----------------------------------+");
	        System.out.println("|        	 Welcome to             |");
	        System.out.println("|        	Autopark App            |");
	        System.out.println("+-----------------------------------+");
	    }

	    private void printMenu() {
	    	System.out.println("Please make a selection");
	        System.out.println("1) a new Subscription");
	        System.out.println("2) Park Records ");
	        System.out.println("3) For Vehicle exit");
	        System.out.println("4) List Vehicles in the Autopark ");
	        System.out.println("0) Exit");
	    }

	    private int getMenuChoice() {
	        @SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);
	        int choice = -1;
	        do {
	            System.out.print("Enter your choice: ");
	            try {
	                choice = Integer.parseInt(keyboard.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid selection. Numbers only please.");
	            }
	            if (choice < 0 || choice > 4) {
	                System.out.println("Choice outside of range. Please chose again.");
	            }
	        } while (choice < 0 || choice > 4);
	        return choice;
	    }

	    private void performAction(int choice) {
	        switch (choice) {
	            case 0:
	                System.out.println("Thank you for using our app.");
	                System.exit(0);
	                break;
	            case 1: {
	            	@SuppressWarnings({ "unused", "resource" })
					Scanner keyboard = new Scanner(System.in);
	            	@SuppressWarnings("unused")
					String response = keyboard.nextLine();
	            	          
	            }
	            break;
	            case 2:
	            	Autopark park1=new Autopark(5,30);
	            	
	            	Scanner input= new Scanner(System.in);
	            	String newplate=input.nextLine();
	            	
	        
	            	park1.searchVehicle(newplate);
	           
	                break;
	            case 3:
	            	
	                break;
	            case 4:
	            	Autopark park4=new Autopark(5,30);
	            	park4.toString();
	                
	                break;
	            default:
	                System.out.println("Unknown error has occured.");
	        }
	  
	    }

}
