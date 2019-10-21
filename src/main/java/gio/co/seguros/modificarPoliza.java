
package gio.co.seguros;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

@WebServlet("/modificarPoliza")

/**
 *
 * @author C.V
 */
public class modificarPoliza extends HttpServlet {
    
    public modificarPoliza() {
        super();
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
                //String db_name = "SegurosGio", db_col_name = "Usuarios";
		String tPoliza, nPoliza, cobertura;
                tPoliza = request.getParameter("nPoliza").toString();
		nPoliza = request.getParameter("nPoliza").toString();
                cobertura = request.getParameter("cobertura").toString();
		/*try {*/
			//MongoClient conn = gio.co.seguros.MongoConnectDB.connectMongo();
                        //MongoDatabase db = conn.getDatabase(db_name);
                        //MongoCollection<Document> coll = db.getCollection(db_col_name);
                        MongoCollection<Document> coll = gio.co.seguros.collPoliza.collpoliza();
                        try {
                        
                            BasicDBObject updateFields = new BasicDBObject();
                            updateFields.append("tipo_poliza", nPoliza);
                            updateFields.append("cobertura", cobertura);
                            BasicDBObject searchQuery = new BasicDBObject().append("tipo_poliza", nPoliza);

                           //coll.replaceOne(searchQuery, updateFields);
                            
                           BasicDBObject setQuery = new BasicDBObject();
                           setQuery.append("$set", updateFields);
                           coll.updateMany(searchQuery, setQuery);
                            //coll.upda
                                                        
                            RequestDispatcher rd = request.getRequestDispatcher("exitoAdmin.jsp");
                            rd.forward(request, response);
                        //puesto = "Admin";
                        } catch(MongoException | ClassCastException e){
                            e.printStackTrace();
                            //log.error("Exception occurred while insert Value using **BasicDBObject** : " + e, e);
                        }
                        
                        //FindIterable<Document> fi = coll.find(eq ("nombre", "Mateo"));
                        //MongoCursor<Document> cursor = fi.iterator();
                        
                        
                        
			/*if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("page2_h1.jsp");
				rd.forward(request, response);
			}else {
				response.sendRedirect("index.jsp?val=0");
			}
		} /*catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

    
}



