package modal;

import java.util.Date;

public class Attendance {
    private int employeeId;
    private Date date;
    private boolean isPresent;

    // Constructor
    public Attendance(int employeeId, Date date, boolean isPresent) {
        this.employeeId = employeeId;
        this.date = date;
        this.isPresent = isPresent;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }
}
{
}
