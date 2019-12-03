package factroy.system;

public class Address {

    private int blockNumber;
    private String streetName;
    private String region;
    private int houseNumber;
    private int flateNumber;

    public Address () {
    }

    public Address (int blockNumber, String streetName, String region, int houseNumber, int flateNumber) {
        this.houseNumber = houseNumber;
        this.flateNumber = flateNumber;
        this.blockNumber = blockNumber;
        this.streetName = streetName;
        this.region = region;
    }

    @Override
    public String toString() {
        return  + blockNumber + streetName + region + " (houseNumber) " + houseNumber + " (flateNumber) " + flateNumber;
    }

}

