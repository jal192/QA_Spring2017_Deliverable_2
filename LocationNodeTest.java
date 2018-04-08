/*
	Jason Ly
	2/20/17
	Deliverable 2

	Number of Tests: 14
	
*/

import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*; 
import java.util.*;
import java.io.*;

public class LocationNodeTest {


	// "B" at the end of the test name represents tests are conducted on a location node object 
	//		that emulates the information needed for a building.
	
	// "O" at the end of the test name represents tests are conducted on a location node object 
	//		that emulates the information needed for an outside location.
	
	//	Separate tests are conducted on both constructors, one constructor for buildings and other 
	//		for outside locations.

	
	//#########################################################################
	//###########	TESTS FOR CONSTRUCTOR THAT EMULATES BUILDING	###########
	//#########################################################################
	
	//	Test the accuracy of the location name that is retrieved.
	
	//	The location name that is set should always be the same as the one inputted.
	//	The getLocationName() should always retrieve the name of the location node and 
	//	not any other information related to the location.
	
	//	Create a test location node, then retrieve the name of the node.
	//	Ensure that it's the same/matches the one inputted.
	@Test
	public void testGetLocationName_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals("Union", testLoc.getLocationName());
	}
	
	
	//	Test the accuracy of the location ID that is retrieved.
	
	//	The location ID that is set should always be the same as the one inputted.
	//	The getLocationID() should always retrieve the ID of the location node and 
	//	not any other information related to the location.
	
	//	Create a test location node, then retrieve the ID of the node.
	//	Ensure that it's the same/matches the one inputted.
	@Test
	public void testGetLocationID_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals(1, testLoc.getLocationID());
	}
	
	
	//	Test the accuracy of the avenue name that is retrieved.
	
	//	The avenue name that the location is connected to should always be the same as 
	//	the one that is inputted. 
	//	The getAvenueName() should always retrieve the avenue of the location node and 
	//	not any other information related to the location.
	
	//	Create a test location node, then retrieve the avenue name of the node.
	//	Ensure that it's the same/matches the one inputted.
	@Test
	public void testGetAvenueName_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals("Fourth Avenue.", testLoc.getAvenueName());
	}
	
	
	//	Test the accuracy of the street name that is retrieved.
	
	//	The street name that the location is connected to should always be the same as 
	//	the one that is inputted. 
	//	The getStreetName() should always retrieve the street of the location node and 
	//	not any other information related to the location.
	
	//	Create a test location node, then retrieve the street name of the node.
	//	Ensure that it's the same/matches the one inputted.
	@Test
	public void testGetStreetName_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals("Phil St.", testLoc.getStreetName());
	}
	
	
	//	Test the accuracy of the location node that is retrieved.
	
	//	A newly created location node object doesn't have another location connected to it by
	//	using the avenue route. Therefore it should always be the default value of null.
	
	//	Create a test location node, then retrieve the location node if the driver was to travel using
	//	the avenue route. 
	//	Check that the retrieved location node is null.
	@Test
	public void testGetLocByAvenueNull_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertNull(testLoc.getLocByAvenue());
	}
	
	
	//	Test the accuracy of the location node that is retrieved.
	
	//	A newly created location node object doesn't have another location connected to it by
	//	using the street route. Therefore it should always be the default value of null.
	
	//	Create a test location node, then retrieve the location node if the driver was to travel using
	//	the street route. 
	//	Check that the retrieved location node is null.
	@Test
	public void testGetLocByStreetNull_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertNull(testLoc.getLocByStreet());
	}
	
	
	//	Test the accuracy of the location node that is retrieved.
	
	//	When making a connection from the intial location to another, the location node that is set should 
	//	match the location node of the destiniation.
	//	Test ensures that the set node matches the one that is retrieved.
	
	//	Create a start location node and a end location node.
	//	When the node tries to return it's location node just return end location.
	//	Set the location node when traveling by avenue with the end location node.
	//	Then try to retrive the location node of the start location when traveling by avenue and 
	//	see if it matches the end location node.
	@Test
	public void testSetLocByAvenue_B() {
		
		LocationNode StartLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		LocationNode EndLoc = new LocationNode("Hillman", 4, "Fifth Avenue.", "Phil St.");
		
		StartLoc.setLocByAvenue(EndLoc);
		
		LocationNode returnVal = StartLoc.getLocByAvenue();
		
		assertEquals(returnVal, EndLoc);
	}
	
	
	//	Test the accuracy of the location node that is retrieved.
	
	//	When making a connection from the intial location to another, the location node that is set should 
	//	match the location node of the destiniation.
	//	Test ensures that the set node matches the one that is retrieved.
	
	//	Create a start location node and a end location node.
	//	When the node tries to return it's location node just return end location.
	//	Set the location node when traveling by street with the the end location node.
	//	Then try to retrive the location node of the start location when traveling by street and 
	//	see if it matches the end location node.
	@Test
	public void testSetLocByStreet_B() {
		
		LocationNode StartLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		LocationNode EndLoc = new LocationNode("Hillman", 4, "Fifth Avenue.", "Phil St.");
		
		StartLoc.setLocByStreet(EndLoc);
		
		LocationNode returnVal = StartLoc.getLocByStreet();
		
		assertEquals(returnVal, EndLoc);
	}
	
	
	
	//#############################################################################
	//###########	TESTS FOR CONSTRUCTOR THAT EMULATES OUTSIDE CITY	###########
	//#############################################################################
	
	
	//	Test the accuracy of the location name that is retrieved.
	
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
	
	
	//	Test the accuracy of the location ID that is retrieved.
	
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
	
	
	//	Test the accuracy of the avenue name that is retrieved.
	
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
	
	
	//	Test the accuracy of the street name that is retrieved.
	
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
	
	
	//	Test the accuracy of the location node that is retrieved.
	
	//	The outside city shouldn't be connected to anywhere else, 
	//	therefore there should be no destination location node.
	
	//	Create a test location node, then retrieve the location null of the 
	//	destination when traveling by avenue.
	//	Ensure that the location null is null, which indicates that there is no location
	//	when traveling by avenue.
	@Test
	public void testGetLocByAvenueNull_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertNull(outsideCity.getLocByAvenue());
	}
	
	
	//	Test the accuracy of the location node that is retrieved.
	
	//	The outside city shouldn't be connected to anywhere else, 
	//	therefore there should be no destination location node.
	
	//	Create a test location node, then retrieve the location null of the 
	//	destination when traveling by street.
	//	Ensure that the location null is null, which indicates that there is no location
	//	when traveling by street.
	@Test
	public void testGetLocByStreetNull_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertNull(outsideCity.getLocByStreet());
	}
	

}
	
	
	
	
	
