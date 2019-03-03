/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospitales;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 *
 * @author C.V
 */
public class MongoConnectDB {
    
    int port_no = 27017;
    String host_name = "25.66.75.32", db_name = "SegurosGio", db_col_name = "Usuarios";
    String client_url = "mongodb://" + host_name + ":" + port_no + "/" + db_name;
    MongoClientURI uri = new MongoClientURI(client_url);
    MongoClient mongo_client = new MongoClient(uri);
    
    
    
}


