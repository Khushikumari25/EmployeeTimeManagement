package modal;

import java.util.Date;

public class TimeRecord {
    private int recordId;
    private int employeeId;
    private Date clockInTime;
    private Date clockOutTime;
    private long workedHours;

    // Constructor
    public TimeRecord(int recordId, int employeeId, Date clockInTime, Date clockOutTime) {
        this.recordId = recordId;
        this.employeeId = employeeId;
        this.clockInTime = clockInTime;
        this.clockOutTime = clockOutTime;
        this.workedHours = calculateWorkedHours();
    }

    // Getters and Setters
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getClockInTime() {
        return clockInTime;
    }

    public void setClockInTime(Date clockInTime) {
        this.clockInTime = clockInTime;
        this.workedHours = calculateWorkedHours(); // Recalculate worked hours
    }

    public Date getClockOutTime() {
        return clockOutTime;
    }

    public void setClockOutTime(Date clockOutTime) {
        this.clockOutTime = clockOutTime;
        this.workedHours = calculateWorkedHours(); // Recalculate worked hours
    }

    public long getWorkedHours() {
        return workedHours;
    }

    // Calculate worked hours based on clock-in and clock-out times
    private long calculateWorkedHours() {
        if (clockInTime != null && clockOutTime != null) {
            long diffInMillis = clockOutTime.getTime() - clockInTime.getTime();
            return diffInMillis / (1000 * 60 * 60); // Convert milliseconds to hours
        }
        return 0;
    }
}


