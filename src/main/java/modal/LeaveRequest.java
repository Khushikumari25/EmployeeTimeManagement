package modal;

import java.util.Date;

public class LeaveRequest {
    private int requestId;
    private int employeeId;
    private Date startDate;
    private Date endDate;
    private String leaveType; // e.g., "Sick", "Vacation"
    private String status; // e.g., "Approved", "Pending", "Rejected"

    // Constructor
    public LeaveRequest(int requestId, int employeeId, Date startDate, Date endDate, String leaveType, String status) {
        this.requestId = requestId;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.status = status;
    }

    // Getters and Setters
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
