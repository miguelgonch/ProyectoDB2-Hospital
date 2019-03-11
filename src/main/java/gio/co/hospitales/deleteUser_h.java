/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospitales;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
/**
 *
 * @author manu
 */

@WebServlet("/deleteUser_h")
public class deleteUser_h extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUser_h() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String hospnum;
                
                int id_usuario;
                
		
               
                
		hospnum = request.getParameter("hospNum");
                
                
                id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
                
                
		try {
			Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospnum));
			String sql = "DELETE FROM usuario WHERE usuario_id='"+id_usuario+"'";
			
                        
                        OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
			OracleResultSet rs = (OracleResultSet) pst.executeQuery();
			
                        
                       response.sendRedirect("exitoUpdateUser_h.jsp");
                        
                        /*if(rs.next()) {
                            //Agregar el nombre del usuario
                            Cookie cookieUsername = new Cookie("user",user);
                            cookieUsername.setMaxAge(5*6000);
                            response.addCookie(cookieUsername);
                            //Agregar su rol
                            Cookie cookieRol = new Cookie("rol",rs.getString(5));
                            cookieRol.setMaxAge(5*6000);
                            response.addCookie(cookieRol);
                            //Agregar el # de hospital
                            Cookie cookieHospNum = new Cookie("hospNum",hospnum);
                            cookieHospNum.setMaxAge(5*6000);
                            response.addCookie(cookieHospNum);
                            //Redireccionar
                            response.sendRedirect("home_h.jsp");
                            conn.close();
                            //RequestDispatcher rd = request.getRequestDispatcher("home_h.jsp");
                            //rd.forward(request, response);
			}else {
                            response.sendRedirect("index.jsp");
			}*/
		} catch (SQLException e) {
			response.sendRedirect("index.jsp?val="+id_usuario);
		}
	}

}









