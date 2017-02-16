/*
	Jason Ly
	2/20/17
	cs1632
	Deliverable 2
	
*/

import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*;

public class DriverTest {
	
	//	Test that checks if the getLocation() returns the current location of the driver
	//	The initialized driver location should be the same when retrieving it
	
	//	Create a driver object with driver ID 1 and at location 3
	//	Then check if the retrieved value is the same as the one it was initialized with
	@Test
	public void testGetDriverLocation() {
		Driver d = new Driver(1, 3);
		assertEquals(3, d.getLocation());
	}
	
	
	//	Test that checks if the driver's location changes after setting a new location 
	
	//	Create a driver object that has a driver ID 1 and at location 3
	//	Modify the current location of the driver using setNewLocation()
	//	Test if the new location of the driver matches the intended new location which in this case is 10
	@Test
	public void testSetDriverLocation() {
		Driver d = new Driver(1, 3);
		d.setNewLocation(10);
		assertEquals(10, d.getLocation());
	}
	
	
	//	Test to check if the initialized driver id matches the return id of the driver
	//	The method should always return the driver's id value
	
	//	Create a driver with a driver ID 1 and starting location at 3
	//	Test if the current driver id matches the one initialized which in this case is 1
	@Test
	public void testGetDriverID() {
		Driver d = new Driver(1, 3);
		assertEquals(1, d.getDriverID());
	}
	
	
	//	Test to check if the initial default number of times the driver has visited Sennott is 0
	//	The method should always return 0, since when the object is created the user has not visited Sennott
	//	Assume that a check hasn't been done to test if the starting position of the driver is Sennott
	
	//	Create driver object
	//	Retrieve the current number of times the driver has visited Sennott which should always be 0
	@Test
	public void testGetCurrentNumberSennottVisits() {
		Driver d = new Driver(5, 2);
		assertEquals(0, d.getNumberSennottVisits());
	}
	

	//	Test to check if the number of times the driver has visited Sennott is incremented by 1
	//	Ensure that counter is only incremented by 1
	
	//	Create driver object
	//	Simulate the driver visiting Sennott once
	//	Resulting total number of visits should always be 1
	@Test
	public void testIncrementNumberSennottVisits() {
		Driver d = new Driver(1, 3);
		d.incrementVisitCounter();
		assertEquals(1, d.getNumberSennottVisits());
	}
	
	
	//	Test to check if the number of times the driver has visited Sennott is incremented by 1 multiple times
	//	Ensure that number of visits is properly updated when calling the method
	
	//	Create driver object
	//	Simulate the driver visiting Sennott 5 times
	//	Resulting total number of visits should alwaus be 5
	@Test
	public void testMultipleVisits() {
		Driver d = new Driver(1, 3);
		for(int i = 0; i < 5; i++) {
			d.incrementVisitCounter();
		}
		assertEquals(5, d.getNumberSennottVisits());
	}
	
	
	//	Check that Driver equals itself
	@Test
	public void testDriverEqualsSelf() {
		Driver d = new Driver(2,3);
		assertEquals(d,d);
	}
}