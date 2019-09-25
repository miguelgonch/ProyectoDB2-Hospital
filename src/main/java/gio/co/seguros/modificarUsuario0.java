/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


@WebServlet("/modificarUsuario0")

/**
 *
 * @author C.V
 */
public class modificarUsuario0 extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    public modificarUsuario0() {
        super();
        
    }
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
                //String db_name = "SegurosGio", db_col_name = "Usuarios";
		String usuariow, usuario, nombre, apellido, pass, email, puesto;
		usuariow = request.getParameter("usuariow").toString();
		/*try {*/
			//MongoClient conn = gio.co.seguros.MongoConnectDB.connectMongo();
                        //MongoDatabase db = conn.getDatabase(db_name);
                        //MongoCollection<Document> coll = db.getCollection(db_col_name);
                        MongoCollection<Document> coll = gio.co.seguros.collUsuarios.collUsuarios();
                        try {
                        Document document = coll.find(new BasicDBObject("usuario", usuariow)).projection(Projections.fields(Projections.include("usuario","nombre","apellido","pass","email","puesto"), Projections.excludeId())).first();
                        usuario = document.getString("usuario");
                        nombre = document.getString("nombre");
                        apellido = document.getString("apellido");
                        pass = document.getString("pass");
                        email = document.getString("email");
                        puesto = document.getString("puesto");
                        
                        response.sendRedirect(String.format("modificarUsuario.jsp?usuarioS=%s&nombreS=%s&apellidoS=%s&passS=%s&emailS=%s&puestoS=%s", usuario, nombre, apellido, pass, email, puesto));
                        
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









