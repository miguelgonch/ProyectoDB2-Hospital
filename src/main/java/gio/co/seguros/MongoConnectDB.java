/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 *
 * @author C.V
 */
public class MongoConnectDB {
    
    public static MongoClient connectMongo() {
		MongoClient conn = null;
                int port_no = 27017;
                String host_name = "25.74.104.162", db_name = "SegurosGio", db_col_name = "Usuarios";
                String client_url = "mongodb://" + host_name + ":" + port_no + "/" + db_name;
                
		try {
                        MongoClientURI uri = new MongoClientURI(client_url);
                        conn = new MongoClient(uri);
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@25.74.104.162:1521:XE","c##hospital1","adminm");
		}catch(Exception e){
			System.err.println(e);
		}
		return conn;
	}
    
    
    
}



