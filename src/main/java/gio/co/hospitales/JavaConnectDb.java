package gio.co.hospitales;

import java.sql.Connection;
import java.sql.DriverManager;

public class JavaConnectDb {
	public static Connection connectDb() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@25.66.75.32:1521:XE","c##hospital1","adminm");
		}catch(Exception e){
			System.err.println(e);
		}
		return conn;
	}
}
