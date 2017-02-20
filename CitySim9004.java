/*
	Jason Ly
	2/20/17
	cs1632
	Deliverable 2
	
	Main program that runs the simulation. Program accepts a single integer argument 
	that will be used for the seed value, allowing for consistency and reproduction
	of runs through the simulation to ensure that everything is still working as intended.
	
	Note: I found that using seed number 3 displays most of the features of the program.
	
*/

import java.util.*;
import java.io.*;

public class CitySim9004 {


	private static boolean valid;								//	Used to check if the number of arguments is correct
	private static Integer seed;								//	Seed used for simulation runs
	private static ArrayList<LocationNode> locationList;		//	Representation of the city map
	private static String outsideCityPhil;						//	Name of one of the outside cities
	private static String outsideCityClev;						//	Name of the other outside city
	private static int numbDrivers;								//	Counter that keeps track of the number of drivers that run through the simulation
	private static boolean driverLeavesCity;					//	Checks if the user has exited the city
	private static int startPos;								//	Used to present the starting location of the driver
	private static LocationNode nextLocation;					//	Variable that stores the next location the driver is heading
	private static int selectPath;								//	Variable that stores the path the driver will take
	
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
					
					//	Retrieve the location that will be where the driver starts
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
							//	Get the location node corresponding to the next destination when traveling by avenue
							nextLocation = current.getLocByAvenue();
							
							//	Update the driver's location with the next location node
							driver.setNewLocation(nextLocation);
							
							//	Retrieve the location node of the destination that the driver is currently at/travelled to
							index = locationList.indexOf(driver.getLocation());
							LocationNode endDestination = locationList.get(index);
							
							//	Print out the details related to travel
							System.out.println(cityMap.printDriverTravelByAvenue(driver, current, endDestination));
							
							//	Check if the driver has left the city, if so print the corresponding information
							//	Return an updated boolean variable if the driver has indeed left
							driverLeavesCity = cityMap.checkDriverExitCity(driver);
						}
						//	If the random value obtained is 2, means that the driver follows the street route
						else if(selectPath == 2) {
							//	Get the location node corresponding to the next destination when traveling by street
							nextLocation = current.getLocByStreet();
							
							//	Update the driver's location with the next location node
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
					//	Not going to test this requirement explicitly through a test since it can be seen through trial runs
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