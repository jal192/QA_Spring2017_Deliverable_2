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
				LocationNodeList lList = new LocationNodeList();
				lList.initializeLocations();
				
				//	Retrieve the city map
				locationList = new ArrayList<LocationNode>();
				locationList = lList.getCityMap();
				
				
				for(int i = 1; i < 6; i++) {
					
					boolean driverLeavesCity = false;
					
					int startPos = rng.nextInt(4) + 1;
					Driver driver = new Driver(i, startPos);
					
					//System.out.println("Start: " + startPos);
					
					do {
						
						//	Check if the user is currently at Sennott, also takes care of case where user starts at Sennott
						if(driver.getLocation() == 3) {
							driver.incrementVisitCounter();
						}
						
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
							
							//System.out.println("LocationID " + nextLocationID);
							
							LocationNode endDestination = locationList.get(driver.getLocation()-1);
							
							if(nextLocationID != 5) {
								System.out.println("Driver " + driver.getDriverID() + " heading from " + current.getLocationName() + " to " + 
													endDestination.getLocationName() + " via " + current.getAvenueName());
							}
							else if(nextLocationID == 5) {
								driverLeavesCity = true;
								
								System.out.println("Driver " + driver.getDriverID() + " heading from " + current.getLocationName() + " to " + 
													endDestination.getLocationName() + " via " + current.getAvenueName());
								
								if(current.getLocationID() == 2) {
									System.out.println("Driver " + driver.getDriverID() + " has gone to " + outsideCityPhil + "!");
								}
								else if(current.getLocationID() == 3) {
									System.out.println("Driver " + driver.getDriverID() + " has gone to " + outsideCityClev + "!");
								}
							}
						}
						else if(selectPath == 2) {
							int nextLocationID = current.getLocByStreet();
							driver.setNewLocation(nextLocationID);
							
							//System.out.println("LocationID " + nextLocationID);
							
							LocationNode endDestination = locationList.get(driver.getLocation()-1);
							
							System.out.println("Driver " + driver.getDriverID() + " heading from " + current.getLocationName() + " to " + 
												endDestination.getLocationName() + " via " + endDestination.getStreetName());
						}
						
					} while(driverLeavesCity == false);
					
					System.out.println("Driver " + driver.getDriverID() + " met with Professor Laboon " + driver.getNumberSennottVisits() + " time(s).");
					
					boolean visited3Plus = checkNumbVisitsGreaterEqualThree(driver);
					
					if(visited3Plus == true) {
						System.out.println("Wow, that driver needed lots of CS help!");
					}
					
					System.out.println("-----");
					
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
	
	
	//
	public boolean checkNumbVisitsGreaterEqualThree(Driver d) {
		
		boolean printCSHelpMessage = false;
		
		int numberVists = d.getNumberSennottVisits();
		
		if(numberVists >= 3) {
			printCSHelpMessage = true;
		}
		
		return printCSHelpMessage;
	}
	
	
}