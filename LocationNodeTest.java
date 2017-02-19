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

public class LocationNodeTest {


	// "B" at the end of the test name represents tests are conducted on a location node object 
	//		that emulates the information needed for a building
	
	// "O" at the end of the test name represents tests are conducted on a location node object 
	//		that emulates the information needed for an outside location
	
	//	Separate tests are conducted on both constructors, one constructor for buildings and other 
	//		for outside locations

	
	//#########################################################################
	//###########	TESTS FOR CONSTRUCTOR THAT EMULATES BUILDING	###########
	//#########################################################################
	
	//	The location name that is set should always be the same as the one inputted
	//	The getLocationName() should always retrieve the name of the location node and 
	//	not any other information related to the location
	
	//	Create a test location node, then retrieve the name of the node
	//	Ensure that it's the same/matches the one inputted
	@Test
	public void testGetLocationName_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals("Union", testLoc.getLocationName());
	}
	
	
	//	The location ID that is set should always be the same as the one inputted
	//	The getLocationID() should always retrieve the ID of the location node and 
	//	not any other information related to the location
	
	//	Create a test location node, then retrieve the ID of the node
	//	Ensure that it's the same/matches the one inputted
	@Test
	public void testGetLocationID_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals(1, testLoc.getLocationID());
	}
	
	
	//	The avenue name that the location is connected to should always be the same as 
	//	the one that is inputted. 
	//	The getAvenueName() should always retrieve the avenue of the location node and 
	//	not any other information related to the location
	
	//	Create a test location node, then retrieve the avenue name of the node
	//	Ensure that it's the same/matches the one inputted
	@Test
	public void testGetAvenueName_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals("Fourth Avenue.", testLoc.getAvenueName());
	}
	
	
	//	The street name that the location is connected to should always be the same as 
	//	the one that is inputted. 
	//	The getStreetName() should always retrieve the street of the location node and 
	//	not any other information related to the location
	
	//	Create a test location node, then retrieve the street name of the node
	//	Ensure that it's the same/matches the one inputted
	@Test
	public void testGetStreetName_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals("Phil St.", testLoc.getStreetName());
	}
	
	
	//	A newly created location node object doesn't have another location connected to it by
	//	using the avenue route. Therefore it should always be the default value of 0.
	
	//	Create a test location node, then retrieve the location ID if the driver was to travel using
	//	the avenue route. 
	//	Check that the retrieve location ID is 0.
	@Test
	public void testGetLocByAvenueZero_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals(0, testLoc.getLocByAvenue());
	}
	
	
	//	A newly created location node object doesn't have another location connected to it by
	//	using the street route. Therefore it should always be the default value of 0.
	
	//	Create a test location node, then retrieve the location ID if the driver was to travel using
	//	the street route. 
	//	Check that the retrieve location ID is 0.
	@Test
	public void testGetLocByStreetZero_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals(0, testLoc.getLocByStreet());
	}
	
	
	//	When making a connection from the intial location to another, the location ID that is set should 
	//	match the location ID of the destiniation.
	//	Test ensures that the set ID matches the one that is retrieved.
	
	//	Create a location node and a mock location node.
	//	When the node tries to return it's location ID just return 2.
	//	Set the location ID when traveling by avenue with the location ID of the mock node.
	//	Then try to retrive the location ID of the destiniation when traveling by avenue and 
	//	see if it matches the mock location node's id.
	@Test
	public void testSetLocByAvenue_B() {
		
		LocationNode StartLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		LocationNode mockLocNodeAve = Mockito.mock(LocationNode.class);
		
		Mockito.when(mockLocNodeAve.getLocByAvenue()).thenReturn(2);
		
		StartLoc.setLocByAvenue(mockLocNodeAve.getLocByAvenue());
		
		int returnVal = StartLoc.getLocByAvenue();
		
		assertEquals(returnVal, 2);
	}
	
	
	//	When making a connection from the intial location to another, the location ID that is set should 
	//	match the location ID of the destiniation.
	//	Test ensures that the set ID matches the one that is retrieved.
	
	//	Create a location node and a mock location node.
	//	When the node tries to return it's location ID just return 2.
	//	Set the location ID when traveling by street with the location ID of the mock node.
	//	Then try to retrive the location ID of the destiniation when traveling by street and 
	//	see if it matches the mock location node's id.
	@Test
	public void testSetLocByStreet_B() {

		LocationNode StartLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		LocationNode mockLocNodeStreet = Mockito.mock(LocationNode.class);
		
		Mockito.when(mockLocNodeStreet.getLocByStreet()).thenReturn(4);
		
		StartLoc.setLocByStreet(mockLocNodeStreet.getLocByStreet());
		
		int returnVal = StartLoc.getLocByStreet();
		
		assertEquals(returnVal, 4);
	}
	
	
	
	//#############################################################################
	//###########	TESTS FOR CONSTRUCTOR THAT EMULATES OUTSIDE CITY	###########
	//#############################################################################
	
	//	These tests are similar to the tests done to the constructor that emulates a location in the city
	
	//	The location name that is set should always be the same as the one inputted
	//	The getLocationName() should always retrieve the name of the location node and 
	//	not any other information related to the location
	
	//	Create a test location node, then retrieve the name of the node
	//	Ensure that it's the same/matches the one inputted
	@Test
	public void testGetLocationName_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertEquals("Philadelphia", outsideCity.getLocationName());
	}
	
	
	//	The location ID that is set should always be the same as the one inputted
	//	The getLocationID() should always retrieve the ID of the location node and 
	//	not any other information related to the location
	
	//	Create a test location node, then retrieve the ID of the node
	//	Ensure that it's the same/matches the one inputted
	@Test
	public void testGetLocationID_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertEquals(5, outsideCity.getLocationID());
	}
	
	
	//	The outside city shouldn't be connected to anywhere else, 
	//	therefore there should be no avenues that the driver can take to get to 
	//	another destination.
	
	//	Create a test location node, then retrieve the avenue name of the node
	//	Ensure that the avenue name is null
	@Test
	public void testGetAvenueName_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertNull(outsideCity.getAvenueName());
	}
	
	
	//	The outside city shouldn't be connected to anywhere else, 
	//	therefore there should be no avenues that the driver can take to get to 
	//	another destination.
	
	//	Create a test location node, then retrieve the street name of the node
	//	Ensure that the street name is null
	@Test
	public void testGetStreetName_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertNull(outsideCity.getStreetName());
	}
	
	
	//	The outside city shouldn't be connected to anywhere else, 
	//	therefore there should be no destination location ID.
	
	//	Create a test location node, then retrieve the location ID of the 
	//	destination when traveling by avenue.
	//	Ensure that the location ID is 0, which indicates that there is no location
	//	when traveling by avenue.
	@Test
	public void testGetLocByAvenue_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertEquals(0, outsideCity.getLocByAvenue());
	}
	
	
	//	The outside city shouldn't be connected to anywhere else, 
	//	therefore there should be no destination location ID.
	
	//	Create a test location node, then retrieve the location ID of the 
	//	destination when traveling by street.
	//	Ensure that the location ID is 0, which indicates that there is no location
	//	when traveling by street.
	@Test
	public void testGetLocByStreet_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertEquals(0, outsideCity.getLocByStreet());
	}
	

}
	
	
	
	
	
