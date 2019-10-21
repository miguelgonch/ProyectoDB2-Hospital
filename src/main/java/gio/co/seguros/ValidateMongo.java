
package gio.co.seguros;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Projections;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;




@WebServlet("/ValidateMongo")


/**
 *
 * @author C.V
 */
public class ValidateMongo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ValidateMongo() {
        super();
        
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
                String db_name = "SegurosGio", db_col_name = "Usuarios";
		String usuariow, passw, pass, puesto;
		usuariow = request.getParameter("user_id").toString();
		passw = request.getParameter("password").toString();
		try {
			MongoClient conn = gio.co.seguros.MongoConnectDB.connectMongo();
                        MongoDatabase db = conn.getDatabase(db_name);
                        MongoCollection<Document> coll = db.getCollection(db_col_name);
                        try {
                        Document document = coll.find(new BasicDBObject("usuario", usuariow)).projection(Projections.fields(Projections.include("pass"), Projections.excludeId())).first();
                        pass = document.getString("pass");
                        Document document1 = coll.find(new BasicDBObject("usuario", usuariow)).projection(Projections.fields(Projections.include("puesto"), Projections.excludeId())).first();
                        puesto = document1.getString("puesto");
                        //puesto = "Admin";
                        if(passw.equals(pass)){
                            //RequestDispatcher rd = request.getRequestDispatcher("exitoAdmin.jsp");
                            //rd.forward(request, response);
                            //Creando las cookies para usuarios mongo
                            Cookie cookieUsername = new Cookie("user",usuariow);
                            cookieUsername.setMaxAge(5*60);
                            response.addCookie(cookieUsername);
                            
                            if(puesto.equals("Admin")){
                                response.sendRedirect("exitoAdmin.jsp");
                                //RequestDispatcher rd = request.getRequestDispatcher("exitoAdmin.jsp");
				//rd.forward(request, response);
                            } else if(puesto.equals("AdminC")){
                                response.sendRedirect("exitoAdminC.jsp");
                                //RequestDispatcher rd = request.getRequestDispatcher("exitoAdminC.jsp");
				//rd.forward(request, response);
                            } else if(puesto.equals("CallC")){
                                response.sendRedirect("exitoCallCenter.jsp");
                                //RequestDispatcher rd = request.getRequestDispatcher("exitoCallCenter.jsp");
				//rd.forward(request, response);
                            }
                            conn.close();
                                
                        } else {
                                response.sendRedirect("index.jsp?val=0");                        }
                        
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
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    
}























