/*
	Jason Ly
	2/20/17
	cs1632
	Deliverable 2
	
	#########################################
	####### TODO Need to add comments #######
	#########################################
	
*/

import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*; 
import java.util.*;
import java.io.*;

public class LocationNodeListTest {

	//	Ensure that the first four intialized locations are the ones required: Presby, Union, Sennott, Hillman
	//	This test satisfies the FUN-CITY-LOCS requirement
	
	//	Create a locations list, intialize all locations
	//	Retrieve the map
	//	Check that the first four locations are the ones specified in the requirements
	@Test
	public void testLocNamePresbyUnionSennottHillmanExists() {
		
		LocationNodeList lList = new LocationNodeList();
		lList.initializeLocations();
		
		ArrayList<LocationNode> locList = new ArrayList<LocationNode>();
		
		locList = lList.getCityMap();
		
		assertEquals("Presby", locList.get(0).getLocationName());
		assertEquals("Union", locList.get(1).getLocationName());
		assertEquals("Sennott", locList.get(2).getLocationName());
		assertEquals("Hillman", locList.get(3).getLocationName());
	}
	
	//	Ensure that the last intialized city is outside city 
	//	This test satisfies the FUN-OUTSIDE-CITY requirement
	
	//	Create a location list, initialize all locations
	//	Retrieve the city map
	//	Check the last or 5th element in the arraylist that it's the outside city.
	@Test
	public void testLocNameOutsideCityExists() {
		
		LocationNodeList lList = new LocationNodeList();
		lList.initializeLocations();
		
		ArrayList<LocationNode> locList = new ArrayList<LocationNode>();
		
		locList = lList.getCityMap();
		
		assertEquals("Outside City", locList.get(4).getLocationName());
	}
	
	//	Ensure that there are a total of 5 locations initialized
	//	There should always be 5 locations in total that are intialized and set up
	//	Based on the requirements there are four city locations and one location representing the outside city
	//	Therefore there should be 5 in total
	
	//	Create a locations list, intialize all locations
	//	Retrieve the map into an arraylist
	//	Check that the size of the arraylist or number of locations initialized is 5
	@Test
	public void testInitializeLocations() {
		
		LocationNodeList lList = new LocationNodeList();
		lList.initializeLocations();
		
		ArrayList<LocationNode> locList = new ArrayList<LocationNode>();
		
		locList = lList.getCityMap();
		
		assertEquals(5, locList.size());
	}
	
	
	//	Ensure that setting a new list overwrites the previous list
	//	If a new list overs the old list, then when the list is retrieved it should be the new one
	
	//	Create a locations list object, which by default has an empty list
	//	Create an arraylist and add mock location node objects because it doesn't matter
	//	what information is contained in the location nodes, this test focuses on consistency
	//	Add all mock objects to the temporary list
	//	Set the new list 
	//	Retrieve the list
	//	Ensure that the retrieve list matches the one that set to it
	@Test
	public void testSetCityMap() {
		LocationNodeList lList = new LocationNodeList();
		
		ArrayList<LocationNode> tempList = new ArrayList<LocationNode>();
		
		LocationNode mockLoc1 = Mockito.mock(LocationNode.class);
		LocationNode mockLoc2 = Mockito.mock(LocationNode.class);
		LocationNode mockLoc3 = Mockito.mock(LocationNode.class);
		
		tempList.add(mockLoc1);
		tempList.add(mockLoc2);
		tempList.add(mockLoc3);
		
		lList.setCityMap(tempList);
		
		ArrayList<LocationNode> getLocList = new ArrayList<LocationNode>();
		getLocList = lList.getCityMap();
		
		assertSame(tempList, getLocList);
	}
	
	//	Ensure that getting the list of location nodes is empty when a new list is initialized
	//	When a new location list is created, the default list should always be empty
	
	//	Create a new locations list
	//	Retrieve the city map
	//	Check that the number of locations in the list is 0
	@Test
	public void testGetListEmpty() {
		
		LocationNodeList lList = new LocationNodeList();
		
		ArrayList<LocationNode> getLocList = new ArrayList<LocationNode>();
		getLocList = lList.getCityMap();
		
		assertEquals(0, getLocList.size());
	}
	
	
	//	Test print traversal by ave
	
	
	//	Test print traversal by street
	
	
	
	//	Check driver start pos
	
	
	
	//	Check if driver is at the end of the city
}



