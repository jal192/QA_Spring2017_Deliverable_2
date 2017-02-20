/*
	Jason Ly
	2/20/17
	cs1632
	Deliverable 2
	
	This class is used to create the entire city layout and prepare it for use in the 
	simulation. All locations are initialized and all connections are set.
*/

import java.util.*;
import java.io.*;

public class LocationNodeList {

	private ArrayList<LocationNode> cityMap;				//	Represents the map of the city, will contain all information pertaining to the city
	private String outsideCityPhil = "Philadelphia";		//	Name of one of the outside cities
	private String outsideCityClev = "Cleveland";			//	Name of one of the outside cities

	public LocationNodeList() {
		
		cityMap = new ArrayList<LocationNode>();
	}
	
	
	//	Initialize all 5 locations and set up the corresponding routes
	public void initializeLocations() {
		//	Create locations for the 4 buildings in the city and 2 locations outside the city
		LocationNode presby = new LocationNode("Presby", 1, "Fourth Ave.", "Bill St.");
		LocationNode union = new LocationNode("Union", 2, "Fourth Ave.", "Phil St.");
		LocationNode sennott = new LocationNode("Sennott", 3, "Fifth Ave.", "Bill St.");
		LocationNode hillman = new LocationNode("Hillman", 4, "Fifth Ave.", "Phil St.");
		
		LocationNode outsideCity = new LocationNode("Outside City", 5);
		
		//	Set up conections for Presby
		presby.setLocByAvenue(union);
		presby.setLocByStreet(sennott);
		
		
		//	Set up conections for Union
		union.setLocByAvenue(outsideCity);
		union.setLocByStreet(hillman);
		
		
		//	Set up conections for Sennott
		sennott.setLocByAvenue(outsideCity);
		sennott.setLocByStreet(presby);
		
		
		//	Set up conections for Hillman
		hillman.setLocByAvenue(sennott);
		hillman.setLocByStreet(union);
		
		
		//	Add all locations to list
		this.cityMap.add(presby);
		this.cityMap.add(union);
		this.cityMap.add(sennott);
		this.cityMap.add(hillman);
		this.cityMap.add(outsideCity);
	}
	
	
	//	Set a new city list, primarily used in testing the getCityMap() method
	public void setCityMap(ArrayList<LocationNode> newList) {
		this.cityMap = newList;
	}
	
	
	//	Retrieve the current or initialized city map
	public ArrayList<LocationNode> getCityMap() {
		return this.cityMap;
	}
	
	
	//	Print route details when traveling by avenue
	public String printDriverTravelByAvenue(Driver d, LocationNode start, LocationNode end) {
		//	If the location ID of the driver is not 5 it means that the driver is still in the city
		//	Else the location ID is 5, means that the driver has left the city
		//	return the print information about the route taken by the driver and the intial and end destinations
		
		String displayMessage = "";
		
		if(end.getLocationID() != 5) {
			displayMessage = "Driver " + d.getDriverID() + " heading from " + start.getLocationName() + " to " + 
								end.getLocationName() + " via " + start.getAvenueName();
		}
		else if(end.getLocationID() == 5) {
			displayMessage = "Driver " + d.getDriverID() + " heading from " + start.getLocationName() + " to " + 
								end.getLocationName() + " via " + start.getAvenueName();
			
			if(start.getLocationID() == 2) {
				displayMessage = displayMessage + "\nDriver " + d.getDriverID() + " has gone to " + outsideCityPhil + "!";
			}
			else if(start.getLocationID() == 3) {
				displayMessage = displayMessage + "\nDriver " + d.getDriverID() + " has gone to " + outsideCityClev + "!";
			}
		}
		
		return displayMessage;
	}
	
	
	//	Print route details when traveling by street
	public String printDriverTravelByStreet(Driver d, LocationNode start, LocationNode end) {
		String displayMessage =  "Driver " + d.getDriverID() + " heading from " + start.getLocationName() + " to " + end.getLocationName() + " via " + start.getStreetName();
												
		return displayMessage;
	}
	
	
	//	Check the current starting position of the driver, if they are at sennott then increment the visits counter
	//	Return the updated driver
	public Driver checkStartPos(Driver d) {
		//	Check if the user is currently at Sennott, also takes care of case where user starts at Sennott
		int driverLoc = d.getLocation().getLocationID();
		
		if(driverLoc == 3) {
			d.incrementVisitCounter();
		}
		
		return d;
	}
	
	
	//	Check if the driver has left the city
	//	If so return true
	//	Else return false
	public boolean checkDriverExitCity(Driver d) {
		boolean driverLeavesCity = false;
		
		LocationNode driverLoc = d.getLocation();
		
		if(driverLoc.getLocationID() == 5) {
			driverLeavesCity = true;
		}
		
		return driverLeavesCity;
	}
	
}
