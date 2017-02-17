/*
	Jason Ly
	2/20/17
	cs1632
	Deliverable 2
	
*/

import java.util.*;
import java.io.*;

public class CitySim9004 {


	private boolean valid;
	private Integer seed;

	public static void main(String[] args) {
		
		CitySim9004 sim = new CitySim9004(args);
		
	}
	
	public CitySim9004(String[] args) {
		
		//	Set up random number generator
		Random rng = new Random();
		
		//	Check if the user entered the correct number of arguments
		valid = checkNumbArgs(args);
		
		if(valid == true) {
			
			//	Check if the argument the user entered is an integer
			seed = checkValidInt(args);
			
			if(seed != null) {
				
				//	Set seed for random number generator
				rng.setSeed(seed);
			}
		}
	}
	
	public boolean checkNumbArgs(String[] a) {
		
		boolean check = false;
		
		//	Check if the user entered a seed integer
		if(a.length == 0)
		{
			System.out.println("No Arguments found!");
			System.out.println("Proper Usage is: java CitySim9004 <Seed Integer>");
		}
		else if(a.length > 1) {
			System.out.println("Too Many Arguments Found!");
			System.out.println("Proper Usage is: java CitySim9004 <Seed Integer>");
		}
		else if(a.length == 1) {
			check = true;
		}
		
		return check;
	}
	
	public Integer checkValidInt(String[] a) {
		String seedString = a[0];
		
		Integer val = null;
		
		try {
			val = Integer.parseInt(seedString);
		} catch(NumberFormatException numbFormError) {
			System.out.println("Error: Seed input is not a valid integer.");
		}
		
		return val;
	}

}