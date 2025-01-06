package Employee.Time.Management.dao;
import com.example.TimeRecord;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TimeRecordDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Add a new time record
    public void addTimeRecord(TimeRecord timeRecord) {
        String query = "INSERT INTO time_records (employee_id, clock_in_time, clock_out_time) VALUES (?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, timeRecord.getEmployeeId());
            stmt.setTimestamp(2, new Timestamp(timeRecord.getClockInTime().getTime()));
            stmt.setTimestamp(3, new Timestamp(timeRecord.getClockOutTime().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all time records for an employee
    public List<TimeRecord> getTimeRecordsForEmployee(int employeeId) {
        List<TimeRecord> timeRecords = new ArrayList<>();
        String query = "SELECT * FROM time_records WHERE employee_id = ?";
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TimeRecord timeRecord = new TimeRecord(
                        rs.getInt("record_id"),
                        rs.getInt("employee_id"),
                        rs.getTimestamp("clock_in_time"),
                        rs.getTimestamp("clock_out_time")
                );
                timeRecords.add(timeRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timeRecords;
    }

    // Update an existing time record
    public void updateTimeRecord(TimeRecord timeRecord) {
        String query = "UPDATE time_records SET clock_in_time = ?, clock_out_time = ? WHERE record_id = ?";
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setTimestamp(1, new Timestamp(timeRecord.getClockInTime().getTime()));
            stmt.setTimestamp(2, new Timestamp(timeRecord.getClockOutTime().getTime()));
            stmt.setInt(3, timeRecord.getRecordId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a time record
    public void deleteTimeRecord(int recordId) {
        String query = "DELETE FROM time_records WHERE record_id = ?";
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, recordId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

