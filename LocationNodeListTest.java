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
	//	
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
	
	//	Ensure that the last intialized city is outside city exists
	//	
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
	@Test
	public void testInitializeLocations() {
		
		LocationNodeList lList = new LocationNodeList();
		lList.initializeLocations();
		
		ArrayList<LocationNode> locList = new ArrayList<LocationNode>();
		
		locList = lList.getCityMap();
		
		assertEquals(5, locList.size());
	}
}



