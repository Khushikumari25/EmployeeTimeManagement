package Employee.Time.Management;

import java.util.Date;

public class Employee {
    private int employeeId;
    private String name;
    private String email;
    private String position;
    private Date clockInTime;
    private Date clockOutTime;

    // Constructor
    public Employee(int employeeId, String name, String email, String position) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.position = position;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getClockInTime() {
        return clockInTime;
    }

    public void setClockInTime(Date clockInTime) {
        this.clockInTime = clockInTime;
    }

    public Date getClockOutTime() {
        return clockOutTime;
    }

    public void setClockOutTime(Date clockOutTime) {
        this.clockOutTime = clockOutTime;
    }

    // Calculate total worked hours (just as an example, may need improvements)
    public long getWorkedHours() {
        if (clockInTime != null && clockOutTime != null) {
            long diffInMillis = clockOutTime.getTime() - clockInTime.getTime();
            return diffInMillis / (1000 * 60 * 60); // Convert milliseconds to hours
        }
        return 0;
    }
}
