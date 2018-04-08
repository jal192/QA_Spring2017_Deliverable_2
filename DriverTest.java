/*
	Jason Ly
	2/20/17
	Deliverable 2
	
	All tests use doubles/mocks.
	Note: Constructor is tested implicitly through other tests, therefore it didn't seem
	necessary to write a test dedicated to the constructor.
	
	Number of Tests: 10
*/

import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*;

public class DriverTest {
	
	
	//	################################################################
	//	########### 	TEST DRIVER LOCATION INFORMATION	 ###########
	//	################################################################
	
	
	//	Test that checks if the getLocation() returns the current location of the driver.
	//	The initialized driver location should be the same when retrieving it.
	
	//	This test uses doubles/mocks.
	
	//	Create a driver object with driver ID 1 and at a mock location.
	//	Then check if the retrieved value is the same as the one it was initialized with.
	@Test
	public void testGetDriverLocation() {
		LocationNode mockLoc = Mockito.mock(LocationNode.class);
		Driver d = new Driver(1, mockLoc);
		assertEquals(mockLoc, d.getLocation());
	}
	
	
	//	Test that checks if the driver's location changes after setting a new location.
	//	If a driver's location is changed it should match the one it changed to.
	
	//	This test uses doubles/mocks.
	
	//	Create a driver object that has a driver ID 1 and at a mock location.
	//	Modify the current location of the driver using setNewLocation(), setting a new location.
	//	Test if the new location of the driver matches the intended new location.
	@Test
	public void testSetDriverLocation() {
		LocationNode mockLoc1 = Mockito.mock(LocationNode.class);
		LocationNode mockLoc2 = Mockito.mock(LocationNode.class);
		Driver d = new Driver(1, mockLoc1);
		d.setNewLocation(mockLoc2);
		assertEquals(mockLoc2, d.getLocation());
	}
	
	
	//	########################################################
	//	########### 	TEST DRIVER ID INFORMATION	 ###########
	//	########################################################
	
	
	//	Test to check if the initialized driver id matches the returned id of the driver.
	//	The method should always return the driver's id value.
	
	//	This test uses doubles/mocks.
	
	//	Create a driver with a driver ID 1 and at a mock location.
	//	Test if the current driver id matches the one initialized which in this case is 1
	@Test
	public void testGetDriverID() {
		LocationNode mockLoc = Mockito.mock(LocationNode.class);
		Driver d = new Driver(1, mockLoc);
		assertEquals(1, d.getDriverID());
	}
	
	
	//	####################################################################
	//	########### 	TEST DRIVER NUMBER OF VISITS TO SENNOTT	 ###########
	//	####################################################################
	
	
	//	Test to check if the initial default number of times the driver has visited Sennott is 0.
	//	The method should always return 0, since when the object is created the user has not visited Sennott.
	//	Also assume that the starting position of the driver is not Sennott.
	
	//	This test uses doubles/mocks.
	
	//	Create driver object.
	//	Retrieve the current number of times the driver has visited Sennott which should always be 0.
	@Test
	public void testGetCurrentNumberSennottVisits() {
		LocationNode mockLoc = Mockito.mock(LocationNode.class);
		Driver d = new Driver(1, mockLoc);
		assertEquals(0, d.getNumberSennottVisits());
	}
	

	//	Test to check if the number of times the driver has visited Sennott is incremented by 1.
	//	Ensure that the counter is only incremented by 1.
	
	//	This test uses doubles/mocks.
	
	//	Create driver object.
	//	Simulate the driver visiting Sennott once.
	//	Resulting total number of visits should always be 1.
	@Test
	public void testIncrementNumberSennottVisits() {
		LocationNode mockLoc = Mockito.mock(LocationNode.class);
		Driver d = new Driver(1, mockLoc);
		d.incrementVisitCounter();
		assertEquals(1, d.getNumberSennottVisits());
	}
	
	
	//	Test to check if the number of times the driver has visited Sennott is incremented by 1 multiple times.
	//	Ensure that number of visits is properly updated when calling the method.
	
	//	This test uses doubles/mocks.
	
	//	Create driver object.
	//	Simulate the driver visiting Sennott 5 times.
	//	Resulting total number of visits should alwaus be 5.
	@Test
	public void testMultipleVisits() {
		LocationNode mockLoc = Mockito.mock(LocationNode.class);
		Driver d = new Driver(1, mockLoc);
		for(int i = 0; i < 5; i++) {
			d.incrementVisitCounter();
		}
		assertEquals(5, d.getNumberSennottVisits());
	}
	
	
	//	Ensure that if the driver has visited Laboon more than three times that the method will return the correct
	//	boolean value indicating to print out that the driver needed help.
	//	FUN-SENNOTT-EDGES states that if the driver has visited more than three times then a message should be printed
	//	to the user. This test checks that condition but doesn't print the statement.
	
	//	This test uses doubles/mocks.
	
	//	Create a new driver variable, increment the counter 5 times, since 5 is greater than or equal to 3, the method
	//	should always return true.
	
	//	Tests FUN-SENNOTT-EDGES, checks the condition of whether or not to print the extra statement about needing more help
	@Test
	public void testCheckNumbVisitsGreaterThanThree() {
		LocationNode mockLoc = Mockito.mock(LocationNode.class);
		Driver d = new Driver(1, mockLoc);
		for(int i = 0; i < 5; i++) {
			d.incrementVisitCounter();
		}
		assertTrue(d.checkNumbVisitsGreaterEqualThree());
	}
	
	
	//	Test checks the edge case, ensuring that if the driver visited Laboon exactly three times that the 
	//	method will always return true, indicating to print the message stating that the driver needed a lot of help.
	//	FUN-SENNOTT-EDGES states that if the driver has visited more than three times then a message should be printed
	//	to the user. This test checks that condition but doesn't print the statement.
	
	//	This test uses doubles/mocks.
	
	//	Create a new driver, incrememnt the counter 3 times, simulating that the driver has visited Sennott 3 times..
	//	Check the results of the method call, which should always be true since 3 meets the requirement conditions.
	
	//	Tests FUN-SENNOTT-EDGES, checks the condition of whether or not to print the extra statement about needing more help
	@Test
	public void testCheckNumbVisitsThree() {
		LocationNode mockLoc = Mockito.mock(LocationNode.class);
		Driver d = new Driver(1, mockLoc);
		for(int i = 0; i < 3; i++) {
			d.incrementVisitCounter();
		}
		assertTrue(d.checkNumbVisitsGreaterEqualThree());
	}
	
	
	//	Ensure that if the number of times the driver has visited Sennott is less than three that 
	//	a flag indicating whether or not to print the corresponding message is false.
	//	FUN-SENNOTT-EDGES states that if the driver has visited more than three times then a message should be printed
	//	to the user. This test checks that condition but doesn't print the statement.
	//	Therefore since 0 is less than 3, this test should always fail. 
	
	//	This test uses doubles/mocks.
	
	//	Test a newly created driver that should have their number of visits initialized to 0.
	//	Therefore the method should always return false, the number of visits is less than 3.
	
	//	Tests FUN-SENNOTT-EDGES, checks the condition of whether or not to print the extra statement about needing more help
	@Test
	public void testCheckNumbVisitsLessThanThreeZero() {
		LocationNode mockLoc = Mockito.mock(LocationNode.class);
		Driver d = new Driver(1, mockLoc);
		assertFalse(d.checkNumbVisitsGreaterEqualThree());
	}
	
	//	Ensure that if the number of times the driver has visited Sennott is less than three that 
	//	a flag indicating whether or not to print the corresponding message is false.
	
	//	This test is similar to testCheckNumbVisitsLessThanThreeZero except that it checks 1.
	//	The last test checked the edge value of 0, this test checks one between 0 and 3.
	
	//	This test uses doubles/mocks.
	
	//	Tests a driver that has visited Laboon once. Since the number of visits is less than 3,
	//	the method should always return false.
	@Test
	public void testCheckNumbVisitsLessThanThreeOne() {
		LocationNode mockLoc = Mockito.mock(LocationNode.class);
		Driver d = new Driver(1, mockLoc);
		d.incrementVisitCounter();
		assertFalse(d.checkNumbVisitsGreaterEqualThree());
	}
}
