/*
	Jason Ly
	2/20/17
	cs1632
	Deliverable 2

	#########################################
	####### TODO Need to add comments #######
	#########################################	
	
	Using seed number 3 displays driver needing help message
*/

import java.util.*;
import java.io.*;

public class CitySim9004 {


	private static boolean valid;
	private static Integer seed;
	private static ArrayList<LocationNode> locationList;
	private static String outsideCityPhil;
	private static String outsideCityClev;
	private static int numbDrivers;
	private static boolean driverLeavesCity;
	private static int startPos;
	private static LocationNode nextLocation;
	private static int selectPath;
	
	public static void main(String[] args) {
		
		outsideCityPhil = "Philadelphia";
		outsideCityClev = "Cleveland";
		
		//	Set up random number generator
		Random rng = new Random();
		
		//	Check if the user entered the correct number of arguments
		valid = checkNumbArgs(args);
		
		if(valid == true) {
			
			//	Check if the argument the user entered is an integer
			seed = checkValidInt(args);
			
			if(seed != null) {
				
				//	Set seed for random number generator
				rng.setSeed(seed);
				
				//	Initialize all possible locations
				LocationNodeList cityMap = new LocationNodeList();
				cityMap.initializeLocations();
				
				//	Retrieve the city map
				locationList = new ArrayList<LocationNode>();
				locationList = cityMap.getCityMap();
				
				//	Intialize counter that keeps track of the number of drivers
				numbDrivers = 0;
				
				for(int i = 1; i < 6; i++) {
					
					//	Intialize boolean variable that keeps track of whether or not the driver has left the city
					driverLeavesCity = false;
					
					//	Retrieve the starting position from the random number generator
					startPos = rng.nextInt(4) + 1;
					
					LocationNode startPosNode = locationList.get(startPos-1);
					
					//	Set the random starting location as the current location of the driver
					Driver driver = new Driver(i, startPosNode);
					
					//	Keep looping through simulation steps until the driver has left the city
					do {
						//	Check if the starting position of the driver is at Sennott
						//	If so then increment the counter that keeps track of the number of visits
						driver = cityMap.checkStartPos(driver);
						
						//	Get the current location node of the driver
						int index = locationList.indexOf(driver.getLocation());
						LocationNode current = locationList.get(index);
						
						//	1 represents avenue
						//	2 represents street
						selectPath = rng.nextInt(2) + 1;
						
						//	If the random value obtained is 1, means that the driver follows the avenue route
						if(selectPath == 1) {
							//	Get the location ID corresponding to the next destination when traveling by avenue
							nextLocation = current.getLocByAvenue();
							
							//	Update the driver's location with the next location ID
							driver.setNewLocation(nextLocation);
							
							//	Retrieve the location node of the destination that the driver is currently at/travelled to
							index = locationList.indexOf(driver.getLocation());
							LocationNode endDestination = locationList.get(index);
							
							//	Print out the details related to travel
							System.out.println(cityMap.printDriverTravelByAvenue(driver, current, endDestination));
							
							//	Check if the driver has left the city, if so print the corresponding information
							driverLeavesCity = cityMap.checkDriverExitCity(driver);
						}
						//	If the random value obtained is 2, means that the driver follows the street route
						else if(selectPath == 2) {
							//	Get the location ID corresponding to the next destination when traveling by street
							nextLocation = current.getLocByStreet();
							
							//	Update the driver's location with the next location ID
							driver.setNewLocation(nextLocation);
							
							//	Retrieve the location node of the destination that the driver is currently at/travelled to
							index = locationList.indexOf(driver.getLocation());
							LocationNode endDestination = locationList.get(index);
							
							//	Print out the details related to travel
							System.out.println(cityMap.printDriverTravelByStreet(driver, current, endDestination));
						}
						
					} while(driverLeavesCity == false);
					
					//	Print out the number of times the driver has met with Laboon
					System.out.println(printNumbVists(driver));
					
					//	Check if the number of times the driver has visited Laboon is 3 or more
					//	If so then print the statement indicating that the driver needed a lot of help
					if(driver.checkNumbVisitsGreaterEqualThree() == true) {
						System.out.println("Wow, that driver needed lots of CS help!");
					}
					
					//	Display the 5 dashes after each run as stated in the FUN-DASHES requirement
					System.out.println("-----");
					
					//	Since the current driver has finished his traversal through the city, increment the counter by 1
					numbDrivers++;
				}
			}
			//	If the inputted seed was not a valid integer display corresponding message
			else {
				System.out.println("Error: Seed input is not a valid integer.");
			}
		}
		//	If the user entered too few or many arguments display the corresponding messages to the user
		else {
			System.out.println("Too Many or Zero Arguments Found!");
			System.out.println("Proper Usage is: java CitySim9004 <Seed Integer>");
		}
	}
	
	
	//	Checks if the number of arguments is 1
	public static boolean checkNumbArgs(String[] a) {
		
		boolean check = false;
		
		//	Check if the user entered a seed integer
		if(a.length == 1) {
			check = true;
		}
		
		return check;
	}
	
	
	//	Check if the argument/seed value that the user entered is an integer
	public static Integer checkValidInt(String[] a) {
		String seedString = a[0];
		
		Integer val = null;
		
		try {
			val = Integer.parseInt(seedString);
		} catch(Exception e) {
			val = null;
		}
		
		return val;
	}
	
	//	Return the number of drivers
	//	Primarily used for testing to determine number of simulations that are done
	public static int getNumberOfDrivers() {
		return numbDrivers;
	}
	
	
	//	Prints out the number of times the driver has visited Laboon
	public static String printNumbVists(Driver d) {
		return "Driver " + d.getDriverID() + " met with Professor Laboon " + d.getNumberSennottVisits() + " time(s).";
	}
}