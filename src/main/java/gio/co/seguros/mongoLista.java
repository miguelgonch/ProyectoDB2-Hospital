
package gio.co.seguros;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

@WebServlet("/mongoLista")

/**
 *
 * @author C.V
 */
public class mongoLista extends HttpServlet {
    
    
    private static final long serialVersionUID = 1L;
    public mongoLista() {
        super();
        
    }
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
                String db_name = "SegurosGio", db_col_name = "Usuarios";
		/*try {*/
			MongoClient conn = gio.co.seguros.MongoConnectDB.connectMongo();
                        MongoDatabase db = conn.getDatabase(db_name);
                        MongoCollection<Document> coll = db.getCollection(db_col_name);
                        try {
                            List<Document> employees = (List<Document>) coll.find().into(
				new ArrayList<Document>());
                            
                        
                        } catch(MongoException | ClassCastException e){
                            e.printStackTrace();
                        }
	}
    
}


