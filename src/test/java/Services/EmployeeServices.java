package Services;

// Assuming this is a Maven project with a typical structure.
// Below is a basic implementation for the Employee Time Management service in Java.

import com.example.employeemanagement.models.Employee;
import com.example.employeemanagement.models.TimeLog;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTimeService {

    private List<TimeLog> timeLogs = new ArrayList<>();

    // Method to clock in an employee
    public TimeLog clockIn(Employee employee) {
        TimeLog timeLog = new TimeLog();
        timeLog.setEmployeeId(employee.getId());
        timeLog.setClockInTime(LocalDateTime.now());
        timeLogs.add(timeLog);
        System.out.println("Employee " + employee.getName() + " clocked in at " + timeLog.getClockInTime());
        return timeLog;
    }

    // Method to clock out an employee
    public TimeLog clockOut(Employee employee) {
        for (TimeLog timeLog : timeLogs) {
            if (timeLog.getEmployeeId().equals(employee.getId()) && timeLog.getClockOutTime() == null) {
                timeLog.setClockOutTime(LocalDateTime.now());
                System.out.println("Employee " + employee.getName() + " clocked out at " + timeLog.getClockOutTime());
                return timeLog;
            }
        }
        throw new IllegalStateException("Employee has not clocked in or already clocked out.");
    }

    // Method to get total worked hours
    public double getTotalWorkedHours(Employee employee) {
        double totalHours = 0;
        for (TimeLog timeLog : timeLogs) {
            if (timeLog.getEmployeeId().equals(employee.getId()) && timeLog.getClockOutTime() != null) {
                totalHours += java.time.Duration.between(timeLog.getClockInTime(), timeLog.getClockOutTime()).toHours();
            }
        }
        return totalHours;
    }

    // Method to display time logs
    public void displayTimeLogs() {
        for (TimeLog timeLog : timeLogs) {
            System.out.println(timeLog);
        }
    }
}

