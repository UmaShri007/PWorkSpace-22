package ai.neuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCPhyUtil {
	
	private JDBCPhyUtil() {
		
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
		
		// Establish the connection by taking the data from properties file	
		FileInputStream fis = new FileInputStream("D:\\Uma\\Java\\Telusko_workspace\\JDBCCrudApp\\src\\ai\\neuron\\properties\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		Connection connection = DriverManager.getConnection(properties.getProperty("jdbcUrl"),
								properties.getProperty("user"),
								properties.getProperty("password"));
		
		return connection;
	}
	
// Close the connection
	
	public static void closeResources(Connection con,Statement stmt,ResultSet rs) throws SQLException{

			if(con!=null) {
				con.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(rs!=null) {
				rs.close();
			}
	
	}
}