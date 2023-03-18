package ai.neuron.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JDBCUtil {
	
	private JDBCUtil() {
		
	}
	
	
// Load and register the Driver
// Autoloading, below code not necessary
	
	static {
		// Step1: loading and register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws IOException,SQLException {
		
		// Establish the connection using hikari connection pool
		
		HikariConfig config = new HikariConfig("src\\ai\\neuron\\properties\\application.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource.getConnection();
	}
	

}