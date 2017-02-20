/*
	Jason Ly
	2/20/17
	cs1632
	Deliverable 2
	
	Class Description:
		LocationNode object used to simulate the potential routes the driver can go to
		Each object represents a possible location the driver can go to
		This class stores all the information pertaining to one of the locations on the map/city
*/


public class LocationNode {
	
	private String locationName;			//	Name of the location
	private LocationNode nextLocByAvenue;	//	End destination when traveling by avenue
	private LocationNode nextLocByStreet;	//	End destination when traveling by street
	private String avenueName;				//	Name of the avenue to get to the next location
	private String streetName;				//	Name of the street to get to the next location
	private int locationID;					//	Simple identifier for the location
	
	
	//	Location that represents an outside city
	public LocationNode(String name, int id) {
		this.locationName = name;
		this.locationID = id;
		
		this.nextLocByAvenue = null;
		this.nextLocByStreet = null;
		this.avenueName = null;
		this.streetName = null;
	}
	
	//	Location that represents a building/location in the city
	public LocationNode(String name, int id, String aveName, String stName) {
		this.locationName = name;
		this.locationID = id;
		
		this.avenueName = aveName;
		this.streetName = stName;
		
		this.nextLocByAvenue = null;
		this.nextLocByStreet = null;
	}
	
	//	Retrieve location name
	public String getLocationName() {
		return this.locationName;
	}
	
	//	Retrieve location id, used to distinguish locations
	public int getLocationID() {
		return this.locationID;
	}
	
	//	Retrieve the avenue name that connects the current location to the one traversed by an avenue
	public String getAvenueName() {
		return this.avenueName;
	}
	
	//	Retrieve the street name that connects the current location to the one traversed by a street
	public String getStreetName() {
		return this.streetName;
	}
	
	//	Set location node travelled by avenue
	public void setLocByAvenue(LocationNode nextLoc) {
		this.nextLocByAvenue = nextLoc;
	}
	
	//	Set location node travelled by street
	public void setLocByStreet(LocationNode nextLoc) {
		this.nextLocByStreet = nextLoc;
	}
	
	//	Retrieve location node travelled by avenue
	public LocationNode getLocByAvenue() {
		return this.nextLocByAvenue;
	}
	
	//	Retrieve location node travelled by street
	public LocationNode getLocByStreet() {
		return this.nextLocByStreet;
	}

}


