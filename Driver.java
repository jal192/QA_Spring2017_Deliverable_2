/*
	Jason Ly
	2/20/17
	Deliverable 2
	
	Class Description:
		Driver object used to simulate a driver, keeping track of it's ID, location and number of visits to Sennott.
*/


public class Driver {
	
	private int driverID;				//	Driver's ID
	private LocationNode location;		//	Driver's current location
	private int numberVisitsSennott;	//	Counter keeping track of the number of times the driver has visited Sennott
	
	//	Constructor for creating a driver
	public Driver(int dID, LocationNode loc) {
		this.driverID = dID;
		this.location = loc;
		this.numberVisitsSennott = 0;
	}
	
	//	Return the driver's ID
	public int getDriverID() {
		return this.driverID;
	}
	
	//	Return the current location of the driver
	public LocationNode getLocation() {
		return this.location;
	}
	
	//	Set the new location of the driver
	public void setNewLocation(LocationNode newLoc) {
		this.location = newLoc;
	}
	
	//	Get the current number of times the driver has visited Sennott
	public int getNumberSennottVisits() {
		return this.numberVisitsSennott;
	}
	
	//	Increment the number of times the driver has visited Sennott by 1
	public void incrementVisitCounter() {
		this.numberVisitsSennott++;
	}
	
	//	Check if the number of times the driver has visited equals three or more times
	//	If so then the message displaying that the driver needs a lot of help should be displayed
	//	Else do nothing
	public boolean checkNumbVisitsGreaterEqualThree() {
		
		boolean printCSHelpMessage = false;
		
		int numberVists = this.getNumberSennottVisits();
		
		if(numberVists >= 3) {
			printCSHelpMessage = true;
		}
		
		return printCSHelpMessage;
	}
}
