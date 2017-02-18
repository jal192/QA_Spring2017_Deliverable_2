/*
	Jason Ly
	2/20/17
	cs1632
	Deliverable 2
	
	#########################################
	####### TODO Need to add comments #######
	#########################################
*/

import java.util.*;
import java.io.*;

public class LocationNodeList {

	ArrayList<LocationNode> lList;

	public LocationNodeList() {
		
		lList = new ArrayList<LocationNode>();
		
	}

	public void initializeLocations() {
		//	Create locations for the 4 buildings in the city and 2 locations outside the city
		LocationNode presby = new LocationNode("Presby", 1, "Fourth Ave.", "Bill St.");
		LocationNode union = new LocationNode("Union", 2, "Fourth Ave.", "Phil St.");
		LocationNode sennott = new LocationNode("Sennott", 3, "Fifth Ave.", "Bill St.");
		LocationNode hillman = new LocationNode("Hillman", 4, "Fifth Ave.", "Phil St.");
		
		LocationNode outsideCity = new LocationNode("Outside City", 5);
		
		//	Set up conections for Presby
		presby.setLocByAvenue(2);
		presby.setLocByStreet(3);
		
		
		//	Set up conections for Union
		union.setLocByAvenue(5);
		union.setLocByStreet(4);
		
		
		//	Set up conections for Sennott
		sennott.setLocByAvenue(5);
		sennott.setLocByStreet(1);
		
		
		//	Set up conections for Hillman
		hillman.setLocByAvenue(3);
		hillman.setLocByStreet(2);
		
		
		//	Add all locations to list
		this.lList.add(presby);
		this.lList.add(union);
		this.lList.add(sennott);
		this.lList.add(hillman);
		this.lList.add(outsideCity);
	}
	
	public void setCityMap(ArrayList<LocationNode> newList) {
		this.lList = newList;
	}
	
	public ArrayList<LocationNode> getCityMap() {
		return this.lList;
	}
}
