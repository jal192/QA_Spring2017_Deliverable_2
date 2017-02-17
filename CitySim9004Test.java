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

public class CitySim9004Test {
	
	
	//	Check if checkNumbArgs method performs the intended behavior
	//	Simulation continues when user enters one argument
	//	This doesn't test if the actual input values are correct
	//	Only tests the quantity of arguments

	@Test
	public void testCheckNumbArgsOneArg() {
		
		String[] args = {"temp"};
		CitySim9004 citySim = new CitySim9004(args);
		boolean returnVal = citySim.checkNumbArgs(args);
		assertTrue(returnVal);
		
	}
	
	
	//	User shouldn't be allowed to continue the simulation execution if they enter 0 arguments
	//	Testing edge case
	@Test
	public void testCheckNumbArgsZeroArg() {
		
		String[] args = new String[0];
		CitySim9004 citySim = new CitySim9004(args);
		boolean returnVal = citySim.checkNumbArgs(args);
		assertFalse(returnVal);
		
	}
	
	
	//	User shouldn't be allowed to continue the simulation execution if they enter more than one argument
	//	Testing edge case
	@Test
	public void testCheckNumbArgsManyArg() {
		
		String[] args = {"1", "2", "NyanLaboonCat"};
		CitySim9004 citySim = new CitySim9004(args);
		boolean returnVal = citySim.checkNumbArgs(args);
		assertFalse(returnVal);
		
	}
	
	
	//	Check if checkValidInt method performs the intended behavior
	//	I am assuming that the number of arguments is correct
	//	Only testing the handling of seed values
	//	If user enters a valid integer for seed then it should always pass

	@Test
	public void testCheckValidIntGood() {
		
		String[] args = {"1"};
		CitySim9004 citySim = new CitySim9004(args);
		Integer returnVal = citySim.checkValidInt(args);
		assertNotNull(returnVal);
		
	}
	
	
	//	Check if checkValidInt method performs the intended behavior
	//	I am assuming that the number of arguments is correct
	//	Only testing the handling of seed values
	//	If user enters an invalid input such as a string it should always fail

	@Test
	public void testCheckValidIntBadString() {
		
		String[] args = {"NyanLaboonCat"};
		CitySim9004 citySim = new CitySim9004(args);
		Integer returnVal = citySim.checkValidInt(args);
		assertNull(returnVal);
		
	}
	
	
	//	Check if checkValidInt method performs the intended behavior
	//	I am assuming that the number of arguments is correct
	//	Only testing the handling of seed values
	//	If user enters an invalid input such as a floating point number it should always fail

	@Test
	public void testCheckValidIntBadFloat() {
		
		String[] args = {"3.1415926535897"};
		CitySim9004 citySim = new CitySim9004(args);
		Integer returnVal = citySim.checkValidInt(args);
		assertNull(returnVal);
		
	}
	
	
	
	
	
}