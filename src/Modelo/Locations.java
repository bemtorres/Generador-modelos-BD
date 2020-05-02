package Modelo;

public class Locations{

    private int locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private char countryId;

    public Locations() {}

    public Locations(int locationId,String streetAddress,String postalCode,String city,String stateProvince,char countryId){
        this.locationId = locationId;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countryId = countryId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setCountryId(char countryId) {
        this.countryId = countryId;
    }

    public char getCountryId() {
        return countryId;
    }

    @Override
    public String toString() {
        return "Locations {locationId:"+locationId+", streetAddress:"+streetAddress+", postalCode:"+postalCode+", city:"+city+", stateProvince:"+stateProvince+", countryId:"+countryId+", }";
    }
}