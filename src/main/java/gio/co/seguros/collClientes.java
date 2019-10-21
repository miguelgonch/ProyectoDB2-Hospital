
package gio.co.seguros;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author C.V
 */
public class collClientes {
    public static MongoCollection collclientes(){
        String db_name = "SegurosGio", db_col_name = "Clientes";
        MongoClient conn = gio.co.seguros.MongoConnectDB.connectMongo();
        MongoDatabase db = conn.getDatabase(db_name);
        MongoCollection<Document> coll = db.getCollection(db_col_name);
        return coll;
    }
}


