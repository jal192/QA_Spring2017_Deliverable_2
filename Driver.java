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
	
	public Driver(int dID, int loc) {
		this.driverID = dID;
		this.location = loc;
	}
	
	// Return the driver number
	public int getDriverID() {
		return this.driverID;
	}
	
	//Return the current location id of the driver
	public int getLocation() {
		return this.location;
	}
	
	//Set the new location of the driver
	public void setNewLocation(int newLoc) {
		this.location = newLoc;
	}
}