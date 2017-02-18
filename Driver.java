/*
	Jason Ly
	2/20/17
	cs1632
	Deliverable 2
	
	Class Description:
		Driver object used to simulate a driver, keeping track of it's ID and location
*/


public class Driver {
	
	private int driverID;
	private int location;
	private int numberVisitsSennott;
	
	public Driver(int dID, int loc) {
		this.driverID = dID;
		this.location = loc;
		this.numberVisitsSennott = 0;
	}
	
	//	Return the driver number
	public int getDriverID() {
		return this.driverID;
	}
	
	//	Return the current location id of the driver
	public int getLocation() {
		return this.location;
	}
	
	//	Set the new location of the driver
	public void setNewLocation(int newLoc) {
		this.location = newLoc;
	}
	
	//	Get the ccurrent number of times the driver has visited Sennott
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