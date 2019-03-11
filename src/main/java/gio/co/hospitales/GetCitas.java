package gio.co.hospitales;

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
 * Servlet implementation class GetHistorial
 */
@WebServlet("/GetHistorial")
public class GetHistorial extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private static String hospitalNum = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHistorial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
                getInfoCookies(request,response);
                Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                try{
                    String sql = "select * from historial";
                    OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                    OracleResultSet rs = (OracleResultSet) pst.executeQuery();
                    String outPutTable = "<table><thead><tr><th>ID</th><th>Diagnostico</th><th>Resultados</th><th>Medicinas</th><th>Pasos a seguir</th><th>Observaciones</th><th>Fecha</th></tr></thead>";
                    while(rs.next()){
                        outPutTable += "<tr><td>"+rs.getString(1)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"<td>"+rs.getString(4)+"</td>"+"<td>"+rs.getString(5)+"</td>"+"<td>"+rs.getString(6)+"</td>"+"<td>"+rs.getString(7)+"</td>"+"<td>"+rs.getString(8)+"</td></tr>";
                    }
                    outPutTable+="</table>";
                    out.println(outPutTable);
                    conn.close();
                }catch(Exception e){
                    System.err.println(e);
                }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
