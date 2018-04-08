/*
	Jason Ly
	2/20/17
	Deliverable 2
	
	List of tests that use stubbing of methods (for ease of searching):
		- testTraversalByAvenuePresbyToUnion
		- testTraversalByAvenueUnionToPhil
		- testTraversalByAvenueHillmanToSennott
		- testTraversalByAvenueSennottToClev
		- testTraversalByStreetSennottToPresby
		- testTraversalByStreetPresbyToSennott
		- testTraversalByStreetUnionToHillman
		- testTraversalByStreetHillmanToUnion
		- testCheckStartPosSennott
		- testCheckStartPosNotSennott
		- testCheckOutsideCityDriverOutsideCity
		- testCheckOutsideCityDriverInsideCity
		
	Number of Tests: 17
*/

import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*; 
import java.util.*;
import java.io.*;

public class LocationNodeListTest {
	
	
	//	############################################################
	//	########### 	TEST INTIALIZED LOCATION NAMES	 ###########
	//	############################################################
	

	//	Ensure that the first four intialized locations are the ones required: Presby, Union, Sennott, Hillman.
	//	The four locations inside the city should match the ones stated in the requirements.
	//	This test satisfies the FUN-CITY-LOCS requirement
	
	//	Create a locations list, intialize all locations.
	//	Retrieve the map.
	//	Check that the first four locations are the ones specified in the requirements.
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
	
	
	//	Ensure that the last intialized city is the outside city. 
	//	The last locations on the map should be represented by an outside city as stated in the requirements.
	//	This test satisfies the FUN-OUTSIDE-CITY requirement.
	
	//	Create a location list, initialize all locations.
	//	Retrieve the city map.
	//	Check the last or 5th element in the arraylist that it's the outside city.
	@Test
	public void testLocNameOutsideCityExists() {
		
		LocationNodeList cityMap = new LocationNodeList();
		cityMap.initializeLocations();
		
		ArrayList<LocationNode> locList = new ArrayList<LocationNode>();
		
		locList = cityMap.getCityMap();
		
		assertEquals("Outside City", locList.get(4).getLocationName());
	}
	
	
	//	################################################################
	//	########### 	TEST NUMBER OF LOCATIONS CREATED	 ###########
	//	################################################################
	
	
	//	Ensure that there are a total of 5 locations initialized.
	//	There should always be 5 locations in total that are intialized and set up.
	//	Based on the requirements there are four city locations and one location representing the outside city.
	//	Therefore there should be 5 in total.
	
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
	
	
	//	#######################################################
	//	########### 	TEST CITY MAP RETRIEVAL		###########
	//	#######################################################
	
	
	//	Ensure that setting a new list overwrites the previous list.
	//	If a new list replaces the old list, then when the list is retrieved it should always be the new one.
	
	//	Create a locations list object, which by default has an empty list.
	//	Create an arraylist and add mock location node objects because it doesn't matter.
	//	what information is contained in the location nodes, this test focuses on consistency.
	//	Add all mock objects to the temporary list.
	//	Set the new list .
	//	Retrieve the list.
	//	Ensure that the retrieve list matches the one that set to it.
	
	//	Test uses test doubles/mocks
	@Test
	public void testSetCityMapMockNodes() {
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
	
	
	//	Ensure that getting the list of location nodes is empty when a new list is initialized.
	//	When a new location list is created, the default list should always be empty.
	
	//	Create a new locations list.
	//	Retrieve the city map.
	//	Check that the number of locations in the list is 0.
	@Test
	public void testGetListEmpty() {
		
		LocationNodeList cityMap = new LocationNodeList();
		
		ArrayList<LocationNode> getLocList = new ArrayList<LocationNode>();
		getLocList = cityMap.getCityMap();
		
		assertEquals(0, getLocList.size());
	}
	
	
	//	###########################################################################
	//	########### 	TEST ALL POSSIBLE DRIVER ROUTES VIA AVENUE		###########
	//	###########################################################################
	
	
	//	This test checks the print display for each driver's step through the simulation.
	//	The information that is displayed to the user should match to where the driver
	//	has actually travelled.
	
	//	Test traversal from Presby to Union via Fourth Ave.
	//	Created a mock driver and mock locations.
	//	When information about the driver and locations are retrieved return specific values.
	//	Set the mock driver and locations as the parameter to the method.
	//	Ensure that the output of the method matches what is expected.
	
	//	Test requirement FUN-AVENUES.
	
	//	Test uses stubbing of methods.
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
	
	
	//	This test checks the print display for each driver's step through the simulation.
	//	The information that is displayed to the user should match to where the driver
	//	has actually travelled.
	
	//	Test traversal from Union to Outside City via Fourth Ave.
	//	Created a mock driver and mock locations.
	//	When information about the driver and locations are retrieved return specific values.
	//	Set the mock driver and locations as the parameter to the method.
	//	Ensure that the output of the method matches what is expected.
	
	//	Test requirement FUN-OTHER-CITIES
	
	//	Test uses stubbing of methods.
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
	
	
	//	This test checks the print display for each driver's step through the simulation.
	//	The information that is displayed to the user should match to where the driver
	//	has actually travelled.
	
	//	Test traversal from Hillman to Sennott via Fifth Ave.
	//	Created a mock driver and mock locations.
	//	When information about the driver and locations are retrieved return specific values.
	//	Set the mock driver and locations as the parameter to the method.
	//	Ensure that the output of the method matches what is expected.
	
	//	Test requirement FUN-AVENUES
	
	//	Test uses stubbing of methods.
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
	
	
	//	This test checks the print display for each driver's step through the simulation.
	//	The information that is displayed to the user should match to where the driver
	//	has actually travelled.
	
	//	Test traversal from Sennott to Outside City via Fifth Ave.
	//	Created a mock driver and mock locations.
	//	When information about the driver and locations are retrieved return specific values.
	//	Set the mock driver and locations as the parameter to the method.
	//	Ensure that the output of the method matches what is expected.
	
	//	Test requirement FUN-OTHER-CITIES
	
	//	Test uses stubbing of methods.
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
	
	
	//	###########################################################################
	//	########### 	TEST ALL POSSIBLE DRIVER ROUTES VIA STREETS		###########
	//	###########################################################################
	
	
	//	This test checks the print display for each driver's step through the simulation.
	//	The information that is displayed to the user should match to where the driver
	//	has actually travelled.
	
	//	Test traversal from Sennott to Presby via Bill St.
	//	Created a mock driver and mock locations.
	//	When information about the driver and locations are retrieved return specific values.
	//	Set the mock driver and locations as the parameter to the method.
	//	Ensure that the output of the method matches what is expected.
	
	//	Test requirement FUN-STREETS
	
	//	Test uses stubbing of methods.
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
	
	
	//	This test checks the print display for each driver's step through the simulation.
	//	The information that is displayed to the user should match to where the driver
	//	has actually travelled.
	
	//	Test traversal from Presby to Sennott via Bill St.
	//	Created a mock driver and mock locations.
	//	When information about the driver and locations are retrieved return specific values.
	//	Set the mock driver and locations as the parameter to the method.
	//	Ensure that the output of the method matches what is expected.
	
	//	Test requirement FUN-STREETS
	
	//	Test uses stubbing of methods.
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
	
	
	//	This test checks the print display for each driver's step through the simulation.
	//	The information that is displayed to the user should match to where the driver
	//	has actually travelled.
	
	//	Test traversal from Presby to Sennott via Bill St.
	//	Created a mock driver and mock locations.
	//	When information about the driver and locations are retrieved return specific values.
	//	Set the mock driver and locations as the parameter to the method.
	//	Ensure that the output of the method matches what is expected.
	
	//	Test requirement FUN-STREETS
	
	//	Test uses stubbing of methods.
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
	
	
	//	This test checks the print display for each driver's step through the simulation.
	//	The information that is displayed to the user should match to where the driver
	//	has actually travelled.
	
	//	Test traversal from Presby to Sennott via Bill St.
	//	Created a mock driver and mock locations.
	//	When information about the driver and locations are retrieved return specific values.
	//	Set the mock driver and locations as the parameter to the method.
	//	Ensure that the output of the method matches what is expected.
	
	//	Test requirement FUN-STREETS
	
	//	Test uses stubbing of methods.
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
	
	
	//	###################################################################
	//	########### 	TEST CHECK DRIVER STARTING POSITION 	###########
	//	###################################################################
	
	
	//	Ensure that if the driver starts at Sennott, that the number of times the driver
	//	has visited Laboon is incremented by 1 as stated in FUN-SENNOTT-COUNT.
	//	The number of times the driver visited Laboon should never exceed one if the 
	//	driver starts there.
	
	//	Create a driver and mock location, setting the starting location for the driver
	//	at the mock location when the driver is created.
	//	When the location ID of the location is retrieved, return 3 which represents Sennott.
	//	Then run the method that checks the starting position of the driver to determine 
	//	whether or not to update the number of visits.
	
	//	Tests part of FUN-SENNOTT-COUNT
	
	//	Test uses stubbing of methods.
	@Test
	public void testCheckStartPosSennott() {
		LocationNodeList cityMap = new LocationNodeList();
		
		LocationNode mockLoc = Mockito.mock(LocationNode.class);
		Driver testDriver = new Driver(1, mockLoc);
		
		Mockito.when(mockLoc.getLocationID()).thenReturn(3);
		
		Driver returnDriver = cityMap.checkStartPos(testDriver);
		
		assertEquals(1, returnDriver.getNumberSennottVisits());
	}
	
	
	//	Ensure that if the driver doesn't start at Sennott, that the number of times the driver
	//	has visited Laboon is not incremented by 1.
	//	Since the driver hasn't visited Laboon or started their traversal through the city at Sennott,
	//	the number of visits shouldn't change.
	
	//	Create a driver and mock location, setting the starting location for the driver
	//	at the mock location when the driver is created.
	//	When the location ID of the location is retrieved, return 1 which represents a location out of Sennott,
	//	more specifically 1 represents Prebsy.
	//	Then run the method that checks the starting position of the driver to determine 
	//	whether or not to update the number of visits.
	
	//	Tests part of FUN-SENNOTT-COUNT
	
	//	Test uses stubbing of methods.
	@Test
	public void testCheckStartPosNotSennott() {
		LocationNodeList cityMap = new LocationNodeList();
		
		Driver mockDriver = Mockito.mock(Driver.class);
		LocationNode mockLoc = Mockito.mock(LocationNode.class);
		
		Mockito.when(mockLoc.getLocationID()).thenReturn(1);
		
		Mockito.when(mockDriver.getLocation()).thenReturn(mockLoc);
		
		Driver returnDriver = cityMap.checkStartPos(mockDriver);
		
		assertEquals(0, returnDriver.getNumberSennottVisits());
	}
	
	
	//	###########################################################################
	//	########### 	TEST CHECK DRIVER LEFT OR STILL IN THE CITY 	###########
	//	###########################################################################
	
	
	//	Check if driver is outside of the city. If the driver is outside of the city then
	//	return true indicating that the simulation for that driver is complete.

	//	Create a city map, create a mock driver mock location.
	//	When the driver tries to return it's current position return the mock location.
	//	When the location ID of the mock location is being retrieved, return 5.
	//	5 represents the location ID of outside city.
	//	Since 5 represents the outside city, the return boolean of the method should always
	//	return true.
	
	//	Tests part of requirement FUN-END
	
	//	Test uses stubbing of methods.
	@Test
	public void testCheckOutsideCityDriverOutsideCity() {
		LocationNodeList cityMap = new LocationNodeList();
		
		Driver mockDriver = Mockito.mock(Driver.class);
		LocationNode mockLoc = Mockito.mock(LocationNode.class);
		
		Mockito.when(mockDriver.getLocation()).thenReturn(mockLoc);
		Mockito.when(mockLoc.getLocationID()).thenReturn(5);
		
		boolean returnVal = cityMap.checkDriverExitCity(mockDriver);
		
		assertTrue(returnVal);
	}
	
	
	//	Check if driver is outside of the city. If the driver is inside of the city then
	//	return false indicating that the simulation for that driver is not complete.

	//	Create a city map, create a mock driver mock location.
	//	When the driver tries to return it's current position return the mock location.
	//	When the location ID of the mock location is being retrieved, return 2.
	//	2 represents the location ID of location in the city, more specifically Union.
	//	Since 2 represents a location in the city, the return boolean of the method should always
	//	return false.
	
	//	Test uses stubbing of methods.
	@Test
	public void testCheckOutsideCityDriverInsideCity() {		
		LocationNodeList cityMap = new LocationNodeList();
		
		Driver mockDriver = Mockito.mock(Driver.class);
		LocationNode mockLoc = Mockito.mock(LocationNode.class);
		
		Mockito.when(mockDriver.getLocation()).thenReturn(mockLoc);
		Mockito.when(mockLoc.getLocationID()).thenReturn(2);
		
		boolean returnVal = cityMap.checkDriverExitCity(mockDriver);
		
		assertFalse(returnVal);
	}
}



