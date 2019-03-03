package gio.co.proyectodb;

import java.sql.Connection;
import java.sql.DriverManager;

public class JavaConnectDb {
	public static Connection connectDb() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##hospital1","adminm");
		}catch(Exception e){
			System.err.println(e);
		}
		return conn;
	}
}
