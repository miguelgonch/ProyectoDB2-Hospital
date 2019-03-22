package gio.co.hospitales.pacientes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 * Servlet implementation class AddPatient
 */
@WebServlet("/AddPatient")
public class AddPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private static String hospitalNum = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	// Generar jsons
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtener # del hospital
                getInfoCookies(request,response);
                //Conexion con db oracle
                Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
                //Response info
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                try{
                    //var query sql
                    String sql;
                    String name,lastName,dir,tel,bDate,dpi,segNum,docId;
                    name = request.getParameter("nameP");
                    lastName = request.getParameter("lastNameP");
                    dir = request.getParameter("dir");
                    tel = request.getParameter("tel");
                    bDate = request.getParameter("bDate");
                    dpi = request.getParameter("dpi");
                    segNum = request.getParameter("segNum");
                    docId = request.getParameter("docId");
                    //Armar el query
                    if(request.getParameter("pId")!=null){
                        String pId = request.getParameter("pId");
                        //Query con el filtro
                        sql = "UPDATE PACIENTES SET NOMBRE = '"+name+"', APELLIDO = '"+lastName+"', DIR = '"+dir+"', TEL = "+tel+", F_NACIMIENTO = TO_DATE('"+bDate+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), DPI = "+dpi+", NUM_SEGURO = "+segNum+", DOCTOR_ID = "+docId+" WHERE paciente_id = "+pId;
                    }
                    else{
                        //Query
                        sql = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DIR, TEL, F_NACIMIENTO, DPI, NUM_SEGURO, DOCTOR_ID) VALUES ('"+name+"', '"+lastName+"', '"+dir+"', '"+tel+"', TO_DATE('"+bDate+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '"+dpi+"', '"+segNum+"', '"+docId+"')";
                    }
                    //OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                    OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                    OracleResultSet rs = (OracleResultSet) pst.executeQuery();                    
                    //Redireccionar
                    response.sendRedirect("pacientes_h.jsp");
                    rs.close ();
                    pst.close ();
                    conn.close();
                }catch(Exception e){
                    System.err.println(e);
                }
	}
        
        protected void getInfoCookies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            Cookie[] cookiesInf = request.getCookies();
            if(cookiesInf !=null){
                for(Cookie cookie : cookiesInf){
                    if(cookie.getName().equals("hospNum")){
                        hospitalNum = cookie.getValue();
                    }
                }
            }
        }
}
