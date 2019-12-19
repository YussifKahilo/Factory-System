//**
//* this class contains the address for every employee.
//* 
//* @author Mostafa Hassan
//* @ID 220180071
//*/
public class Address {
	// the attributes of the class which the information of the employee in the
	// factory.
	private int apartmentNumber;// his apartment number.
	private int floorNumber;// the floor number of his apartment.
	private int buildingNumber;// the number of the building where he lives and his apartment is.
	private String streetName;// the street name of the apartment where the employee lives.
	private String neighborhood;// the neighborhood where the employee lives.
	private String city;// his city of livig.

	// **
	// * Address Constructor.
	// *
	// * @param apartmentNumber of an Employee apartment.
	// * @param floorNumber of an Employee's apartment.
	// * @param buildingNumber of an Employee's living place.
	// * @param streetName of an Employee's street which his apartment in it.
	// * @param neighborhood of an Employee's address.
	// * @param city of an Employee's address.
	// *
	public Address(int apartmentNumber, int floorNumber, int buildingNumber, String streetName, String neighborhood,
			String city) {
		this.apartmentNumber = apartmentNumber;
		this.floorNumber = floorNumber;
		this.buildingNumber = buildingNumber;
		this.streetName = streetName;
		this.neighborhood = neighborhood;
		this.city = city;
	}

	/// **
	// *
	// * @return apartment number of an employee.
	// */
	public int getApartmentNumber() {
		return apartmentNumber;
	}

	/// **
	// *
	// * @return floor number of an employee's apartment.
	// */
	public int getFloorNumber() {
		return floorNumber;
	}

	/// **
	// *
	// * @return building number of an employee's apartment.
	// */
	public int getBuildingNumber() {
		return buildingNumber;
	}

	/// **
	// *
	// * @return street name of an employee's apartment.
	// */
	public String getStreetName() {
		return streetName;
	}

	/// **
	// *
	// * @return neighborhood of an employee place.
	// */
	public String getNeighborhood() {
		return neighborhood;
	}

	// /**
	// *
	// * @return city of an employee where he lives.
	// */
	public String getCity() {
		return city;
	}

	/// **
	// * Displays address information of the employee.
	// */
	public String Display_Address() {
		return buildingNumber + " " + streetName + " " + neighborhood + " " + city + "[ Floor Number:" + floorNumber
				+ " / Apartment Number:" + apartmentNumber + "]";
	}

	/// **
	// * to set the address information in the file.
	// */
	public String toString() {
		return apartmentNumber + "#" + floorNumber + "#" + buildingNumber + "#" + streetName + "#" + neighborhood + "#"
				+ city;
	}

}
