
public class Address {

	private int apartmentNumber;
	private int floorNumber;
	private int buildingNumber;
	private String streetName;
	private String neighborhood;
	private String city;

	/**
	 * Address Constructor.
	 * 
	 * @param apartmentNumber of an Employee apartment.
	 * @param floorNumber     of an Employee's apartment.
	 * @param buildingNumber  of an Employee's living place.
	 * @param streetName      of an Employee's street which his apartment in it.
	 * @param neighborhood    of an Employee's address.
	 * @param city            of an Employee's address.
	 */
	public Address(int apartmentNumber, int floorNumber, int buildingNumber, String streetName, String neighborhood,
			String city) {
		this.apartmentNumber = apartmentNumber;
		this.floorNumber = floorNumber;
		this.buildingNumber = buildingNumber;
		this.streetName = streetName;
		this.neighborhood = neighborhood;
		this.city = city;
	}

	/**
	 * 
	 * @return apartment number of an employee.
	 */
	public int getApartmentNumber() {
		return apartmentNumber;
	}

	/**
	 * 
	 * @return floor number of an employee's apartment.
	 */
	public int getFloorNumber() {
		return floorNumber;
	}

	/**
	 * 
	 * @return building number of an employee's apartment.
	 */
	public int getBuildingNumber() {
		return buildingNumber;
	}

	/**
	 * 
	 * @return street name of an employee's apartment.
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * 
	 * @return neighborhood of an employee place.
	 */
	public String getNeighborhood() {
		return neighborhood;
	}

	/**
	 * 
	 * @return city of an employee where he lives.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Displays the address information.
	 */
	public String Display_Address() {
		return buildingNumber + " " + streetName + " " + neighborhood + " " + city + "[ Floor Number:" + floorNumber
				+ " / Apartment Number:" + apartmentNumber + "]";
	}

	/**
	 * to set the address information in the file.
	 */
	public String toString() {
		return apartmentNumber + "#" + floorNumber + "#" + buildingNumber + "#" + streetName + "#" + neighborhood + "#"
				+ city;
	}

}
