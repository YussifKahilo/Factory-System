
public class Address {

    private int apartmentNumber;
    private int floorNumber;
    private int buildingNumber;
    private String streetName;
    private String block;
    private String city;

    public Address(int apartmentNumber, int floorNumber, int buildingNumber, String streetName, String block, String city) {
        this.apartmentNumber = apartmentNumber;
        this.floorNumber = floorNumber;
        this.buildingNumber = buildingNumber;
        this.streetName = streetName;
        this.block = block;
        this.city = city;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getBlock() {
        return block;
    }

    public String getCity() {
        return city;
    }

    public String Display_Address() {
        return buildingNumber + " " + streetName + " " + block + " " + city + "[ Floor Number:" + floorNumber + " / Apartment Number:" + apartmentNumber + "]";
    }

    public String toString() {
        return apartmentNumber + "#" + floorNumber + "#" + buildingNumber + "#" + streetName + "#" + block + "#" + city;
    }

}
