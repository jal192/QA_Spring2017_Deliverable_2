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
		
		LocationNodeList cityMap = new LocationNodeList();
		cityMap.initializeLocations();
		
		ArrayList<LocationNode> locList = new ArrayList<LocationNode>();
		
		locList = cityMap.getCityMap();
		
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
		
		LocationNodeList cityMap = new LocationNodeList();
		cityMap.initializeLocations();
		
		ArrayList<LocationNode> locList = new ArrayList<LocationNode>();
		
		locList = cityMap.getCityMap();
		
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
		
		LocationNodeList cityMap = new LocationNodeList();
		cityMap.initializeLocations();
		
		ArrayList<LocationNode> locList = new ArrayList<LocationNode>();
		
		locList = cityMap.getCityMap();
		
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
		LocationNodeList cityMap = new LocationNodeList();
		
		ArrayList<LocationNode> tempList = new ArrayList<LocationNode>();
		
		LocationNode mockLoc1 = Mockito.mock(LocationNode.class);
		LocationNode mockLoc2 = Mockito.mock(LocationNode.class);
		LocationNode mockLoc3 = Mockito.mock(LocationNode.class);
		
		tempList.add(mockLoc1);
		tempList.add(mockLoc2);
		tempList.add(mockLoc3);
		
		cityMap.setCityMap(tempList);
		
		ArrayList<LocationNode> getLocList = new ArrayList<LocationNode>();
		getLocList = cityMap.getCityMap();
		
		assertSame(tempList, getLocList);
	}
	
	//	Ensure that getting the list of location nodes is empty when a new list is initialized
	//	When a new location list is created, the default list should always be empty
	
	//	Create a new locations list
	//	Retrieve the city map
	//	Check that the number of locations in the list is 0
	@Test
	public void testGetListEmpty() {
		
		LocationNodeList cityMap = new LocationNodeList();
		
		ArrayList<LocationNode> getLocList = new ArrayList<LocationNode>();
		getLocList = cityMap.getCityMap();
		
		assertEquals(0, getLocList.size());
	}
	
	
	//	Test print traversal by ave
	//	Test traversal from Presby to Union via Fourth Ave.
	//	Test requirement FUN-AVENUES
	@Test
	public void testTraversalByAvenuePresbyToUnion() {
		Driver mockDriver1 = Mockito.mock(Driver.class);
		LocationNode mockLoc1 = Mockito.mock(LocationNode.class);
		LocationNode mockLoc2 = Mockito.mock(LocationNode.class);
		
		Mockito.when(mockDriver1.getDriverID()).thenReturn(3);
		Mockito.when(mockLoc1.getLocationName()).thenReturn("Presby");
		Mockito.when(mockLoc1.getAvenueName()).thenReturn("Fourth Ave.");
		Mockito.when(mockLoc2.getLocationName()).thenReturn("Union");
		Mockito.when(mockLoc2.getLocationID()).thenReturn(2);
		
		LocationNodeList cityMap = new LocationNodeList();
		
		String returnString = cityMap.printDriverTravelByAvenue(mockDriver1, mockLoc1, mockLoc2);
		String expectedOutput = "Driver 3 heading from Presby to Union via Fourth Ave.";
		assertEquals(expectedOutput, returnString);
	}
	
	
	//	Test print traversal by ave
	//	Test traversal from Union to Outside City via Fourth Ave.
	//	Test requirement FUN-AVENUES
	@Test
	public void testTraversalByAvenueUnionToPhil() {
		Driver mockDriver1 = Mockito.mock(Driver.class);
		LocationNode mockLoc1 = Mockito.mock(LocationNode.class);
		LocationNode mockLoc2 = Mockito.mock(LocationNode.class);
		
		Mockito.when(mockDriver1.getDriverID()).thenReturn(3);
		Mockito.when(mockLoc1.getLocationName()).thenReturn("Union");
		Mockito.when(mockLoc1.getAvenueName()).thenReturn("Fourth Ave.");
		Mockito.when(mockLoc1.getLocationID()).thenReturn(2);
		Mockito.when(mockLoc2.getLocationName()).thenReturn("Outside City");
		Mockito.when(mockLoc2.getLocationID()).thenReturn(5);
		
		LocationNodeList cityMap = new LocationNodeList();
		
		String returnString = cityMap.printDriverTravelByAvenue(mockDriver1, mockLoc1, mockLoc2);
		String expectedOutput = "Driver 3 heading from Union to Outside City via Fourth Ave.\nDriver 3 has gone to Philadelphia!";
		assertEquals(expectedOutput, returnString);
	}
	
	
	//	Test print traversal by ave
	//	Test traversal from Hillman to Sennott via Fifth Ave.
	//	Test requirement FUN-AVENUES
	@Test
	public void testTraversalByAvenueHillmanToSennott() {
		Driver mockDriver1 = Mockito.mock(Driver.class);
		LocationNode mockLoc1 = Mockito.mock(LocationNode.class);
		LocationNode mockLoc2 = Mockito.mock(LocationNode.class);
		
		Mockito.when(mockDriver1.getDriverID()).thenReturn(3);
		Mockito.when(mockLoc1.getLocationName()).thenReturn("Hillman");
		Mockito.when(mockLoc1.getAvenueName()).thenReturn("Fifth Ave.");
		Mockito.when(mockLoc2.getLocationName()).thenReturn("Sennott");
		Mockito.when(mockLoc2.getLocationID()).thenReturn(3);
		
		LocationNodeList cityMap = new LocationNodeList();
		
		String returnString = cityMap.printDriverTravelByAvenue(mockDriver1, mockLoc1, mockLoc2);
		String expectedOutput = "Driver 3 heading from Hillman to Sennott via Fifth Ave.";
		assertEquals(expectedOutput, returnString);
	}
	
	
	//	Test print traversal by ave
	//	Test traversal from Sennott to Outside City via Fifth Ave.
	//	Test requirement FUN-AVENUES
	@Test
	public void testTraversalByAvenueSennottToClev() {
		Driver mockDriver1 = Mockito.mock(Driver.class);
		LocationNode mockLoc1 = Mockito.mock(LocationNode.class);
		LocationNode mockLoc2 = Mockito.mock(LocationNode.class);
		
		Mockito.when(mockDriver1.getDriverID()).thenReturn(3);
		Mockito.when(mockLoc1.getLocationName()).thenReturn("Sennott");
		Mockito.when(mockLoc1.getAvenueName()).thenReturn("Fifth Ave.");
		Mockito.when(mockLoc1.getLocationID()).thenReturn(3);
		Mockito.when(mockLoc2.getLocationName()).thenReturn("Outside City");
		Mockito.when(mockLoc2.getLocationID()).thenReturn(5);
		
		LocationNodeList cityMap = new LocationNodeList();
		
		String returnString = cityMap.printDriverTravelByAvenue(mockDriver1, mockLoc1, mockLoc2);
		String expectedOutput = "Driver 3 heading from Sennott to Outside City via Fifth Ave.\nDriver 3 has gone to Cleveland!";
		assertEquals(expectedOutput, returnString);
	}
	
	//	Test print traversal by street
	//	Test traversal from Sennott to Presby via Bill St.
	//	Test requirement FUN-STREETS
	@Test
	public void testTraversalByStreetSennottToPresby() {
		Driver mockDriver1 = Mockito.mock(Driver.class);
		LocationNode mockLoc1 = Mockito.mock(LocationNode.class);
		LocationNode mockLoc2 = Mockito.mock(LocationNode.class);
		
		Mockito.when(mockDriver1.getDriverID()).thenReturn(1);
		Mockito.when(mockLoc1.getLocationName()).thenReturn("Sennott");
		Mockito.when(mockLoc2.getLocationName()).thenReturn("Presby");
		Mockito.when(mockLoc1.getStreetName()).thenReturn("Bill St.");
		
		LocationNodeList cityMap = new LocationNodeList();
		
		String returnString = cityMap.printDriverTravelByStreet(mockDriver1, mockLoc1, mockLoc2);
		String expectedOutput = "Driver 1 heading from Sennott to Presby via Bill St.";
		assertEquals(expectedOutput, returnString);
	}
	
	
	//	Test print traversal by street
	//	Test traversal from Presby to Sennott via Bill St.
	//	Test requirement FUN-STREETS
	@Test
	public void testTraversalByStreetPresbyToSennott() {
		Driver mockDriver1 = Mockito.mock(Driver.class);
		LocationNode mockLoc1 = Mockito.mock(LocationNode.class);
		LocationNode mockLoc2 = Mockito.mock(LocationNode.class);
		
		Mockito.when(mockDriver1.getDriverID()).thenReturn(1);
		Mockito.when(mockLoc1.getLocationName()).thenReturn("Presby");
		Mockito.when(mockLoc2.getLocationName()).thenReturn("Sennott");
		Mockito.when(mockLoc1.getStreetName()).thenReturn("Bill St.");
		
		LocationNodeList cityMap = new LocationNodeList();
		
		String returnString = cityMap.printDriverTravelByStreet(mockDriver1, mockLoc1, mockLoc2);
		String expectedOutput = "Driver 1 heading from Presby to Sennott via Bill St.";
		assertEquals(expectedOutput, returnString);
	}
	
	
	//	Test print traversal by street
	//	Test traversal from Presby to Sennott via Bill St.
	//	Test requirement FUN-STREETS
	@Test
	public void testTraversalByStreetUnionToHillman() {
		Driver mockDriver1 = Mockito.mock(Driver.class);
		LocationNode mockLoc1 = Mockito.mock(LocationNode.class);
		LocationNode mockLoc2 = Mockito.mock(LocationNode.class);
		
		Mockito.when(mockDriver1.getDriverID()).thenReturn(1);
		Mockito.when(mockLoc1.getLocationName()).thenReturn("Union");
		Mockito.when(mockLoc2.getLocationName()).thenReturn("Hillman");
		Mockito.when(mockLoc1.getStreetName()).thenReturn("Phil St.");
		
		LocationNodeList cityMap = new LocationNodeList();
		
		String returnString = cityMap.printDriverTravelByStreet(mockDriver1, mockLoc1, mockLoc2);
		String expectedOutput = "Driver 1 heading from Union to Hillman via Phil St.";
		assertEquals(expectedOutput, returnString);
	}
	
	
	//	Test print traversal by street
	//	Test traversal from Presby to Sennott via Bill St.
	//	Test requirement FUN-STREETS
	@Test
	public void testTraversalByStreetHillmanToUnion() {
		Driver mockDriver1 = Mockito.mock(Driver.class);
		LocationNode mockLoc1 = Mockito.mock(LocationNode.class);
		LocationNode mockLoc2 = Mockito.mock(LocationNode.class);
		
		Mockito.when(mockDriver1.getDriverID()).thenReturn(1);
		Mockito.when(mockLoc1.getLocationName()).thenReturn("Hillman");
		Mockito.when(mockLoc2.getLocationName()).thenReturn("Union");
		Mockito.when(mockLoc1.getStreetName()).thenReturn("Phil St.");
		
		LocationNodeList cityMap = new LocationNodeList();
		
		String returnString = cityMap.printDriverTravelByStreet(mockDriver1, mockLoc1, mockLoc2);
		String expectedOutput = "Driver 1 heading from Hillman to Union via Phil St.";
		assertEquals(expectedOutput, returnString);
	}
	
	
	//	Check driver start pos if the starting position is Sennott which is recognized by location ID 3
	@Test
	public void testCheckStartPosSennott() {
		LocationNodeList cityMap = new LocationNodeList();
		
		Driver testDriver = new Driver(1, 3);
		testDriver.setNewLocation(3);
		
		Driver returnDriver = cityMap.checkStartPos(testDriver);
		
		assertEquals(1, returnDriver.getNumberSennottVisits());
	}
	
	
	//	Check driver start pos if the starting position is Sennott
	@Test
	public void testCheckStartPosNotSennott() {
		LocationNodeList cityMap = new LocationNodeList();
		
		Driver mockDriver = Mockito.mock(Driver.class);
		
		Mockito.when(mockDriver.getLocation()).thenReturn(1);
		
		Driver returnDriver = cityMap.checkStartPos(mockDriver);
		
		assertEquals(0, returnDriver.getNumberSennottVisits());
	}
	
	
	//	Check if driver is at the end of the city
	//	This test checks the condition that the driver is outside of the city
	@Test
	public void testCheckOutsideCityDriverOutsideCity() {
		LocationNodeList cityMap = new LocationNodeList();
		
		Driver mockDriver = Mockito.mock(Driver.class);
		
		Mockito.when(mockDriver.getLocation()).thenReturn(5);
		
		boolean returnVal = cityMap.checkDriverExitCity(mockDriver);
		
		assertTrue(returnVal);
	}
	
	
	//	Check if driver is at the end of the city
	//	This test checks the condition that the driver is still in the city
	@Test
	public void testCheckOutsideCityDriverInsideCity() {
		LocationNodeList cityMap = new LocationNodeList();
		
		Driver mockDriver = Mockito.mock(Driver.class);
		
		Mockito.when(mockDriver.getLocation()).thenReturn(2);
		
		boolean returnVal = cityMap.checkDriverExitCity(mockDriver);
		
		assertFalse(returnVal);
	}
}



