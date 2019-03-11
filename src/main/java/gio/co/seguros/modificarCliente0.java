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
import org.bson.types.ObjectId;

@WebServlet("/modificarCliente0")

/**
 *
 * @author C.V
 */
public class modificarCliente0 extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    public modificarCliente0() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
                //String db_name = "SegurosGio", db_col_name = "Usuarios";
		String _id, tipo_poliza, nombre, apellido, telefono, email, dpi, contE, telContE;
		_id = request.getParameter("poliza").toString();
		/*try {*/
			//MongoClient conn = gio.co.seguros.MongoConnectDB.connectMongo();
                        //MongoDatabase db = conn.getDatabase(db_name);
                        //MongoCollection<Document> coll = db.getCollection(db_col_name);
                        MongoCollection<Document> coll = gio.co.seguros.collUsuarios.collUsuarios();
                        try {
                        //Document document = coll.find(new BasicDBObject("_id", new ObjectId(_id))).projection(Projections.fields(Projections.include("tipo_poliza", "nombre","apellido","telefono","email","documentoIdentificacion", "contacto_emergencia", "Telefono-contacto_e"), Projections.excludeId())).first();
                        Document document = coll.find(new BasicDBObject("nombre", "matttt")).projection(Projections.fields(Projections.include("tipo_poliza"/*, "nombre","apellido","telefono","email","documentoIdentificacion", "contacto_emergencia", "Telefono-contacto_e"*/), Projections.excludeId())).first();
                        //tipo_poliza = document.getString("tipo_poliza");
                        //nombre = document.getString("nombre");
                        /*apellido = document.getString("apellido");
                        telefono = document.getString("telefono");
                        email = document.getString("email");
                        dpi = document.getString("documentoIdentificacion");
                        contE = document.getString("contacto_emergencia");
                        telContE = document.getString("telefono_contacto_e");*/
                        tipo_poliza ="76";
                        nombre = "a";
                        apellido ="b";
                        telefono ="123";
                        email ="@@";
                        dpi ="987";
                        contE ="pepe";
                        telContE="5647";
                        
                        
                        response.sendRedirect(String.format("modificarCliente.jsp?_id=%s&tipo_poliza=%s&nombre=%s&apellido=%s&telefono=%s&email=%s&dpi=%s&contE=%s&telContE=%s", _id, tipo_poliza, nombre, apellido, telefono, email, dpi, contE, telContE));
                        
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











