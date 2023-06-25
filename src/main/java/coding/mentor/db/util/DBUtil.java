package coding.mentor.db.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
	public static Connection makeConnection() {
		try {
			// connect to b_k4
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/be_k4?user=admin&password=0000&useLegacyDatetimeCode=false&serverTimezone=UTC"
					
				);
			return conn;
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return null;	
	}
}
