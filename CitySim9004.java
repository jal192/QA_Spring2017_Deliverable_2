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


	private boolean valid;
	private Integer seed;
	private ArrayList<Driver> driverList;
	private ArrayList<LocationNode> locationList;
	private String outsideCityPhil;
	private String outsideCityClev;
	private int numbDrivers;
	
	public static void main(String[] args) {
		
		CitySim9004 sim = new CitySim9004(args);
		
	}
	
	
	//
	public CitySim9004(String[] args) {
		
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
				
				numbDrivers = 0;
				
				for(int i = 1; i < 6; i++) {
					
					boolean driverLeavesCity = false;
					
					int startPos = rng.nextInt(4) + 1;
					Driver driver = new Driver(i, startPos);
					
					do {
						driver = cityMap.checkStartPos(driver);
						
						//	Get the current location node of the driver
						LocationNode current = locationList.get(driver.getLocation()-1);
						
						int nextLocation = 0;
						
						//	1 represents avenue
						//	2 represents street
						int selectPath = rng.nextInt(2) + 1;
						
						//System.out.println(selectPath);
						
						if(selectPath == 1) {
							int nextLocationID = current.getLocByAvenue();
							driver.setNewLocation(nextLocationID);
							
							LocationNode endDestination = locationList.get(driver.getLocation()-1);
							
							cityMap.printDriverTravelByAvenue(driver, current, endDestination);
							
							driverLeavesCity = cityMap.checkDriverExitCity(driver);
						}
						else if(selectPath == 2) {
							int nextLocationID = current.getLocByStreet();
							driver.setNewLocation(nextLocationID);
							
							LocationNode endDestination = locationList.get(driver.getLocation()-1);
							
							cityMap.printDriverTravelByStreet(driver, current, endDestination);
						}
						
					} while(driverLeavesCity == false);
					
					System.out.println("Driver " + driver.getDriverID() + " met with Professor Laboon " + driver.getNumberSennottVisits() + " time(s).");

					if(driver.checkNumbVisitsGreaterEqualThree() == true) {
						System.out.println("Wow, that driver needed lots of CS help!");
					}
					
					printDashes();
					
					numbDrivers++;
				}
			}
			else {
				System.out.println("Error: Seed input is not a valid integer.");
			}
		}
		else {
			System.out.println("Too Many or Zero Arguments Found!");
			System.out.println("Proper Usage is: java CitySim9004 <Seed Integer>");
		}
	}
	
	
	//
	public boolean checkNumbArgs(String[] a) {
		
		boolean check = false;
		
		//	Check if the user entered a seed integer
		if(a.length == 1) {
			check = true;
		}
		
		return check;
	}
	
	
	//
	public Integer checkValidInt(String[] a) {
		String seedString = a[0];
		
		Integer val = null;
		
		try {
			val = Integer.parseInt(seedString);
		} catch(Exception e) {
			val = null;
		}
		
		return val;
	}
	
	//	Print out the 5 dashes as stated in the FUN-DASHES requirement
	public void printDashes() {
		System.out.println("-----");
	}
	
	
	public int getNumberOfDrivers() {
		return this.numbDrivers;
	}
	
	
}