package Modelo;

public class Regions{

    private int regionId;
    private String regionName;

    public Regions() {}

    public Regions(int regionId,String regionName){
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    @Override
    public String toString() {
        return "Regions {regionId:"+regionId+", regionName:"+regionName+", }";
    }
}