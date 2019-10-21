
package gio.co.seguros;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Projections;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

@WebServlet("/modificarPoliza0")

/**
 *
 * @author C.V
 */
public class modificarPoliza0 extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    public modificarPoliza0() {
        super();
        
    }
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
                //String db_name = "SegurosGio", db_col_name = "Usuarios";
		String nPoliza, coberturaS;
		nPoliza = request.getParameter("nPoliza").toString();
		/*try {*/
			//MongoClient conn = gio.co.seguros.MongoConnectDB.connectMongo();
                        //MongoDatabase db = conn.getDatabase(db_name);
                        //MongoCollection<Document> coll = db.getCollection(db_col_name);
                        MongoCollection<Document> coll = gio.co.seguros.collPoliza.collpoliza();
                        try {
                        Document document = coll.find(new BasicDBObject("tipo_poliza", nPoliza)).projection(Projections.fields(Projections.include("tipo_poliza","cobertura"), Projections.excludeId())).first();
                        coberturaS = document.getString("cobertura");
                        response.sendRedirect(String.format("modificarPoliza.jsp?nPoliza=%s&coberturaS=%s", nPoliza, coberturaS));
                        //response.sendRedirect(String.format("modificarPoliza.jsp?coberturaS=%s",coberturaS));
                        
                        //request.setAttribute("usuarioS", usuario);
                        /*request.setAttribute("nombreS", nombre);
                        request.setAttribute("apellidoS", apellido);
                        request.setAttribute("passS", pass);
                        request.setAttribute("emailS", email);
                        request.setAttribute("puestoS", puesto);*/
                        //request.getRequestDispatcher("modificarUsuario.jsp").forward(request, response);
                        //RequestDispatcher rd = request.getRequestDispatcher("modificarUsuario.jsp");
                        //rd.forward(request, response);
                        
                        } catch(MongoException | ClassCastException e){
                            e.printStackTrace();
                        }
	}
    
}








