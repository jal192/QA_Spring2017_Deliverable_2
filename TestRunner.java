import java.util.ArrayList;

import org.junit.runner.*;
import org.junit.runner.notification.*;

public class TestRunner {
    public static void main(String[] args) {

		ArrayList<Class> classesToTest = new ArrayList<Class>();
		boolean anyFailures = false;

		// ADD ANY MORE CLASSES YOU WISH TO TEST HERE
		
		classesToTest.add(DriverTest.class);
		classesToTest.add(LocationNodeTest.class);
		classesToTest.add(CitySim9004Test.class);
		classesToTest.add(LocationNodeListTest.class);
		
		// For all test classes added, loop through and use JUnit
		// to run them.
		
		for (Class c: classesToTest) {
			
			String classname = c.getSimpleName();
			
			System.out.println("\nStarting tests for " + classname);
			
			Result r = JUnitCore.runClasses(c);

			// Print out any failures for this class.
		  
			for (Failure f : r.getFailures()) {
				System.out.println(f.toString());
			}

			// If r is not successful, there was at least one
			// failure.  Thus, set anyFailures to true - this
			// can never be set back to false (no amount of
			// successes will ever eclipse the fact that there
			// was at least one failure.
			
			if (!r.wasSuccessful()) {
				anyFailures = true;
			}
			else {
				System.out.println("\n" + classname + " > Tests were successful!");
			}
			
		}
		
		// After completion, notify user if all tests passed or any failed.
		
		if (anyFailures) {
			System.out.println("\n!!! - At least one failure, see above.");
		} 
		else {
			System.out.println("\nALL TESTS PASSED");
		} 
    }
} 