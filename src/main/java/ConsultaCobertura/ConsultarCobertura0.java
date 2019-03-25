/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaCobertura;

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

@WebServlet("/ConsultarCobertura0")

/**
 *
 * @author C.V
 */
public class ConsultarCobertura0 extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    public ConsultarCobertura0() {
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
		String dpi;
		dpi = request.getParameter("dpi").toString();
                response.sendRedirect(String.format("confirmarSeguroB.jsp?dpi=%s", dpi));


	}
    
}



