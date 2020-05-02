package Modelo;

public class JobHistory{

    private int employeeId;
    private String startDate;
    private String endDate;
    private String jobId;
    private int departmentId;

    public JobHistory() {}

    public JobHistory(int employeeId,String startDate,String endDate,String jobId,int departmentId){
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobId = jobId;
        this.departmentId = departmentId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return "JobHistory {employeeId:"+employeeId+", startDate:"+startDate+", endDate:"+endDate+", jobId:"+jobId+", departmentId:"+departmentId+", }";
    }
}