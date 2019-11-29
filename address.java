
package FactorySystem;
public class Address {
    
    private  int houseNumber ;
    private  int flateNumber ;
    private  String  streetName ;
    private String place ;

    public Address() {
    }

    public Address(int houseNumber, int flateNumber, String streetName,
            String place) {
        this.houseNumber = houseNumber;
        this.flateNumber = flateNumber;
        this.streetName = streetName;
        this.place = place;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setFlateNumber(int flateNumber) {
        this.flateNumber = flateNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getFlateNumber() {
        return flateNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getPlace() {
        return place;
    }

    public String toString() {
        return  + houseNumber + " " + flateNumber + " " + streetName + " " 
                + place ;
    }
        
}
