public class Address {

    private int blockNumber;
    private String streetName;
    private String region;
    private int houseNumber;
    private int floorNumber;

    public Address (int houseNumber, int floorNumber,int blockNumber, String streetName, String region ) {
        this.houseNumber = houseNumber;
        this.floorNumber = floorNumber;
        this.blockNumber = blockNumber;
        this.streetName = streetName;
        this.region = region;
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getRegion() {
        return region;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
    
    public String toString() {
        return  blockNumber +" "+ streetName+" " + region + " Floor Number:" + floorNumber + " / House Number:" + houseNumber +"]";
    }

}

