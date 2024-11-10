package Employee.Time.Management;

import java.sql.*;

public class conn {

    Connection c;
    Statement s;

    public conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "codeforinterview");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
