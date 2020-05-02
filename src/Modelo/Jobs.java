package Modelo;

public class Jobs{

    private String jobId;
    private String jobTitle;
    private int minSalary;
    private int maxSalary;

    public Jobs() {}

    public Jobs(String jobId,String jobTitle,int minSalary,int maxSalary){
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    @Override
    public String toString() {
        return "Jobs {jobId:"+jobId+", jobTitle:"+jobTitle+", minSalary:"+minSalary+", maxSalary:"+maxSalary+", }";
    }
}