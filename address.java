
public class Address {

    private int apartmentNumber;
    private int floorNumber;
    private int buldingNumber;
    private String streetName;
    private String block;
    private String city;

    public Address(int apartmentNumber, int floorNumber, int buldingNumber, String streetName, String block, String city) {
        this.apartmentNumber = apartmentNumber;
        this.floorNumber = floorNumber;
        this.buldingNumber = buldingNumber;
        this.streetName = streetName;
        this.block = block;
        this.city = city;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getBuldingNumber() {
        return buldingNumber;
    }

    public void setBuldingNumber(int buldingNumber) {
        this.buldingNumber = buldingNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String Display_Address() {
        return buldingNumber + " " + streetName + " " + block + " " + city + "[ Floor Number:" + floorNumber + " / House Number:" + apartmentNumber + "]";
    }

    public String toString() {
        return apartmentNumber + "#" + floorNumber + "#" + buldingNumber + "#" + streetName + "#" + block + "#" + city;
    }

}
