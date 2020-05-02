package Modelo;

public class Employees{

    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private String jobId;
    private double salary;
    private double commissionPct;
    private int managerId;
    private int departmentId;

    public Employees() {}

    public Employees(int employeeId,String firstName,String lastName,String email,String phoneNumber,String hireDate,String jobId,double salary,double commissionPct,int managerId,int departmentId){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setCommissionPct(double commissionPct) {
        this.commissionPct = commissionPct;
    }

    public double getCommissionPct() {
        return commissionPct;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return "Employees {employeeId:"+employeeId+", firstName:"+firstName+", lastName:"+lastName+", email:"+email+", phoneNumber:"+phoneNumber+", hireDate:"+hireDate+", jobId:"+jobId+", salary:"+salary+", commissionPct:"+commissionPct+", managerId:"+managerId+", departmentId:"+departmentId+", }";
    }
}