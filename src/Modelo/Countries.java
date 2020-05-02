package Modelo;

public class Countries{

    private char countryId;
    private String countryName;
    private int regionId;

    public Countries() {}

    public Countries(char countryId,String countryName,int regionId){
        this.countryId = countryId;
        this.countryName = countryName;
        this.regionId = regionId;
    }

    public void setCountryId(char countryId) {
        this.countryId = countryId;
    }

    public char getCountryId() {
        return countryId;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getRegionId() {
        return regionId;
    }

    @Override
    public String toString() {
        return "Countries {countryId:"+countryId+", countryName:"+countryName+", regionId:"+regionId+", }";
    }
}