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
	public void testGetLocByAvenueNull_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertNull(testLoc.getLocByAvenue());
	}
	
	
	//
	@Test
	public void testGetLocByStreetNull_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		assertNull(testLoc.getLocByStreet());
	}
	
	
	//	Test using Mockito
	@Test
	public void testSetLocByAvenue_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		LocationNode mockLocNodeAve = Mockito.mock(LocationNode.class);
		testLoc.setLocByAvenue(mockLocNodeAve);
		assertSame(mockLocNodeAve, testLoc.getLocByAvenue());
	}
	
	
	//	Test using Mockito
	@Test
	public void testSetLocByStreet_B() {
		LocationNode testLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		LocationNode mockLocNodeStreet = Mockito.mock(LocationNode.class);
		testLoc.setLocByStreet(mockLocNodeStreet);
		assertSame(mockLocNodeStreet, testLoc.getLocByStreet());
	}
	
	
	//	Test using Mockito
	
	@Test
	public void testGetLocByAvenueAfter2Traversals() {
		LocationNode startLoc = new LocationNode("Presby", 1, "Fourth Avenue.", "Bill St.");
		LocationNode firstAveTravel = new LocationNode("Union", 2, "Fourth Avenue.", "Phil St.");
		startLoc.setLocByAvenue(firstAveTravel);
		LocationNode secondAveTravel = Mockito.mock(LocationNode.class);
		firstAveTravel.setLocByAvenue(secondAveTravel);
		assertSame(secondAveTravel, startLoc.getLocByAvenue().getLocByAvenue());
	}
	
	
	//	Simulates a two way street
	
	@Test
	public void testGetLocByStreetAfter2Traversals() {
		LocationNode startLoc = new LocationNode("Union", 1, "Fourth Avenue.", "Phil St.");
		LocationNode firstStreetTravel = new LocationNode("Hillman", 2, "Fifth Avenue.", "Phil St.");
		startLoc.setLocByStreet(firstStreetTravel);
		firstStreetTravel.setLocByStreet(startLoc);
		assertSame(startLoc, startLoc.getLocByStreet().getLocByStreet());
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
		assertNull(outsideCity.getLocByAvenue());
	}
	
	
	//
	@Test
	public void testGetLocByStreet_O() {
		LocationNode outsideCity = new LocationNode("Philadelphia", 5);
		assertNull(outsideCity.getLocByStreet());
	}
	
	
	
	

}
	
	
	
	
	
