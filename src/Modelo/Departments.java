package Modelo;

public class Departments{

    private int departmentId;
    private String departmentName;
    private int managerId;
    private int locationId;

    public Departments() {}

    public Departments(int departmentId,String departmentName,int managerId,int locationId){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.locationId = locationId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getLocationId() {
        return locationId;
    }

    @Override
    public String toString() {
        return "Departments {departmentId:"+departmentId+", departmentName:"+departmentName+", managerId:"+managerId+", locationId:"+locationId+", }";
    }
}