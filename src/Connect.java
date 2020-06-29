import java.sql.*;
public class Connect {
	Connection c;
	Statement s;
	public Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:6005/project1","root","2511");
			s = c.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
