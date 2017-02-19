/*
	Jason Ly
	2/20/17
	cs1632
	Deliverable 2
	
*/

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class CitySim9004Test {
	
	
	//	Check if checkNumbArgs method performs the intended behavior
	//	Simulation continues when user enters one argument 
	//	This doesn't test if the actual input values are correct
	//	Only tests the quantity of arguments
	
	//	Ensure that if the user tries to submit/enter a non integer seed values
	//	that the checkNumbArgs() method will always return false
	//	The simulation shouldn't be allowed to continue unless it's a single value integer 
	//	for the seed

	//	Intialize a string array to simulate the arguments that would be inputted
	//	Run the method with the arguments as the parameter
	//	Results should always be false
	@Test
	public void testCheckNumbArgsOneArgWrongType() {
		
		String[] args = {"temp"};
		boolean returnVal = CitySim9004.checkNumbArgs(args);
		assertTrue(returnVal);
		
	}
	
	
	//	User shouldn't be allowed to continue the simulation execution if they enter 0 arguments
	//	Testing edge case
	
	//	Initialize and empty string array
	//	Input the array as the parameter for the method
	//	Results should always be false
	@Test
	public void testCheckNumbArgsZeroArg() {
		
		String[] args = new String[0];
		boolean returnVal = CitySim9004.checkNumbArgs(args);
		assertFalse(returnVal);
		
	}
	
	
	//	User shouldn't be allowed to continue the simulation execution if they enter more than one argument
	//	Testing boundary cases - number of arguments are beyond what's accepted
	
	//	Intialize a string array that contains 3 elements
	//	Input the array as the parameter for the method
	//	Results should always be false
	@Test
	public void testCheckNumbArgsManyArg() {
		
		String[] args = {"1", "Rickroll", "NyanLaboonCat"};
		boolean returnVal = CitySim9004.checkNumbArgs(args);
		assertFalse(returnVal);
		
	}
	
	
	//	Check if checkValidInt method performs the intended behavior
	//	I am assuming that the number of arguments is correct
	//	Only testing the handling of seed values
	//	If user enters a valid integer for seed then it should always pass
	
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
	
	
	//	Check if checkValidInt method performs the intended behavior
	//	I am assuming that the number of arguments is correct
	//	Only testing the handling of seed values
	//	If user enters an invalid input such as a string it should always fail
	
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
	
	
	//	Check if checkValidInt method performs the intended behavior
	//	I am assuming that the number of arguments is correct
	//	Only testing the handling of seed values
	//	If user enters an invalid input such as a floating point number it should always fail
	
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
	
	
	//	Ensure that 5 drivers are simulated through each simulation
	
	//	Run a test simulation with seed 10
	//	After the test is finsihed, get the count of the number of drivers
	
	//	Tests FUN-FIVE-DRIVERS
	@Test
	public void test5Drivers() {
		String[] args = {"10"};
		CitySim9004.main(args);
		int numbDrivers = CitySim9004.getNumberOfDrivers();
		assertEquals(5, numbDrivers);
	}
	
	
	//	Ensure that the number of times a driver has visited Laboon is printed out to the user
	
	//	Tests part of FUN-SENNOTT-COUNT
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