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
	
	//
	@Test
	public void testGetLocationName_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals("Union", testLoc.getLocationName());
	}
	
	
	//
	@Test
	public void testGetLocationID_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals(1, testLoc.getLocationID());
	}
	
	
	//
	@Test
	public void testGetAvenueName_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals("Fourth Avenue.", testLoc.getAvenueName());
	}
	
	
	//
	@Test
	public void testGetStreetName_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals("Phil St.", testLoc.getStreetName());
	}
	
	
	//
	@Test
	public void testGetLocByAvenueZero_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals(0, testLoc.getLocByAvenue());
	}
	
	
	//
	@Test
	public void testGetLocByStreetZero_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertEquals(0, testLoc.getLocByStreet());
	}
	
	
	// 
	//	
	@Test
	public void testSetLocByAvenue_B() {
		
		LocationNode StartLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		LocationNode mockLocNodeAve = Mockito.mock(LocationNode.class);
		
		Mockito.when(mockLocNodeAve.getLocByAvenue()).thenReturn(2);
		
		StartLoc.setLocByAvenue(mockLocNodeAve.getLocByAvenue());
		
		int returnVal = StartLoc.getLocByAvenue();
		
		assertEquals(returnVal, 2);
	}
	
	
	//	
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
	
	
	//
	@Test
	public void testGetLocationName_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertEquals("Philadelphia", outsideCity.getLocationName());
	}
	
	
	//
	@Test
	public void testGetLocationID_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertEquals(5, outsideCity.getLocationID());
	}
	
	
	//
	@Test
	public void testGetAvenueName_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertNull(outsideCity.getAvenueName());
	}
	
	
	//
	@Test
	public void testGetStreetName_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertNull(outsideCity.getStreetName());
	}
	
	
	//
	@Test
	public void testGetLocByAvenue_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertEquals(0, outsideCity.getLocByAvenue());
	}
	
	
	//
	@Test
	public void testGetLocByStreet_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertEquals(0, outsideCity.getLocByStreet());
	}
	

}
	
	
	
	
	
