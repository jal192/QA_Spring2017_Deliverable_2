/*
	Jason Ly
	2/20/17
	Deliverable 2
	
	List of tests that use stubbing of methods (for ease of searching):
		- testPrintNumbVists 
	
	Number of Tests: 8
	
*/

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class CitySim9004Test {
	
	//	########################################################
	//	########### 	TEST NUMBER OF ARGUMENTS	 ###########
	//	########################################################
	
	
	//	Test checks if checkNumbArgs() method performs the intended behavior.
	//	Simulation should only accept one argument. 
	//	This doesn't test if the actual input values are correct,
	//	only tests the quantity of arguments
	
	//	Ensure that if the user tries to submit/enter a non integer seed values
	//	that the checkNumbArgs() method will always return false.
	//	The simulation shouldn't be allowed to continue unless it's a single value integer 
	//	for the seed.

	//	Intialize a string array to simulate the arguments that would be inputted
	//	Run the method with the arguments as the parameter
	//	Results should always be false
	@Test
	public void testCheckNumbArgsOneArgWrongType() {
		
		String[] args = {"temp"};
		boolean returnVal = CitySim9004.checkNumbArgs(args);
		assertTrue(returnVal);
		
	}
	
	
	//	Users shouldn't be allowed to continue the simulation if they enter 0 arguments.
	//	FUN-ARGS states that the program must accept an argument which represents the seed
	//	value for the random number generator.
	
	//	Testing edge case
	//	This test checks that if the user enters no arguments then the method will return false.
	//	Which indicates that the program shouldn't execute.
	
	//	Initialize and empty string array
	//	Input the array as the parameter for the method
	//	Results should always be false
	@Test
	public void testCheckNumbArgsZeroArg() {
		
		String[] args = new String[0];
		boolean returnVal = CitySim9004.checkNumbArgs(args);
		assertFalse(returnVal);
		
	}
	
	
	//	Users shouldn't be allowed to continue the simulation execution if they enter more than one argument.
	//	FUN-ARGS states that the program must accept an argument which represents the seed
	//	value for the random number generator.
	
	//	Testing boundary cases - number of arguments are beyond what's accepted
	//	Tests that if the user tries to enter more than one argument that the program will not continue.
	//	The method should always return false, indicating that the simulation shouldn't continue.
	
	//	Intialize a string array that contains 3 elements
	//	Input the array as the parameter for the method
	//	Results should always be false
	@Test
	public void testCheckNumbArgsManyArg() {
		
		String[] args = {"Can'tFitAllTheseMemes", "Rickroll", "NyanLaboonCat"};
		boolean returnVal = CitySim9004.checkNumbArgs(args);
		assertFalse(returnVal);
		
	}
	
	
	//	####################################################
	//	########### 	TEST TYPE OF ARGUMENTS	 ###########
	//	####################################################
	
	
	//	Test checks that if the user enters a valid seed for the argument then the simulation
	//	should be allowed to continue which is represented by the return value.
	
	//	I am assuming that the number of arguments is correct and that this test is
	//	only testing the handling of seed values.
	//	If user enters a valid integer for seed then it should always pass.
	
	//	Intialize a string array that contains a single element that is an integer
	//	Input the array as the parameter for the method
	//	Results should always be true because only a valid integer seed should be accepted
	//	in order to run the simulation
	@Test
	public void testCheckValidIntGood() {
		
		String[] args = {"10"};
		Integer returnVal = CitySim9004.checkValidInt(args);
		assertNotNull(returnVal);
		
	}
	
	
	//	Test checks that if the user enters an invalid seed for the argument then the simulation
	//	shouldn't be allowed to continue which is represented by the return value.
	
	//	I am assuming that the number of arguments is correct and that this test is
	//	only testing the handling of seed values.
	//	If user enters an invalid input such as a string it should always fail.
	
	//	Ensure that non-integer values for seed input is never accepted
	
	//	Intialize a string array that contains a single element that is not an integer
	//	Input the array as the parameter for the method
	//	Results should always be false because only a valid integer seed should be accepted
	//	in order to run the simulation
	@Test
	public void testCheckValidIntBadString() {
		
		String[] args = {"NyanLaboonCat"};
		Integer returnVal = CitySim9004.checkValidInt(args);
		assertNull(returnVal);
		
	}
	
	
	//	Test checks that if the user enters an invalid seed for the argument then the simulation
	//	shouldn't be allowed to continue which is represented by the return value.
	
	//	I am assuming that the number of arguments is correct and that this test is
	//	only testing the handling of seed values.
	//	If user enters an invalid input such as a floating point number it should always fail.
	
	//	Ensure that non-integer values for seed input is never accepted
	
	//	Intialize a string array that contains a single element that is not an integer
	//	Input the array as the parameter for the method
	//	Results should always be false because only a valid integer seed should be accepted
	//	in order to run the simulation
	@Test
	public void testCheckValidIntBadFloat() {
		
		String[] args = {"3.1415926535897"};
		Integer returnVal = CitySim9004.checkValidInt(args);
		assertNull(returnVal);
		
	}
	
	
	//	############################################################################
	//	########### 	TEST NUMBER OF DRIVERS AFTER EACH SIMULATION	 ###########
	//	############################################################################
	
	
	//	Ensure that 5 drivers are simulated through each simulation.
	//	FUN-FIVE-DRIVERS requirement states that five driver should traverse through the city.
	
	//	Tests FUN-FIVE-DRIVERS
	
	//	Run a test simulation with seed 10.
	//	After the test is finsihed, get the count of the number of drivers which should always be 5.
	@Test
	public void test5Drivers() {
		String[] args = {"10"};
		CitySim9004.main(args);
		int numbDrivers = CitySim9004.getNumberOfDrivers();
		assertEquals(5, numbDrivers);
	}
	
	
	//	############################################################
	//	########### 	TEST NUMBER OF VISITS DISPLAYED	 ###########
	//	############################################################
	
	
	//	Ensure that the number of times a driver has visited Laboon is printed out to the user.
	
	//	Tests part of FUN-SENNOTT-COUNT
	//	This test uses stubbing of methods
	
	//	Create a mock driver, when it tries to return it's driver ID, return 5.
	//	When the mock driver tries to retrieve the number of times they visited Sennott, return 10.
	
	//	Check that the outputted string matches what is expected.
	@Test
	public void testPrintNumbVists() {
		Driver mockDriver = Mockito.mock(Driver.class);
		Mockito.when(mockDriver.getDriverID()).thenReturn(5);
		Mockito.when(mockDriver.getNumberSennottVisits()).thenReturn(10);
		
		String returnVal = CitySim9004.printNumbVists(mockDriver);
		String expectedOutput = "Driver 5 met with Professor Laboon 10 time(s).";
		assertEquals(expectedOutput, returnVal);
	}
	
}
