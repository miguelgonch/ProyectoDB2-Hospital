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
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 * Servlet implementation class DocInfo
 */
@WebServlet("/SpecialTypeInfo")
public class SpecialTypeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private static int hospitalNum = JavaConnectDb.getHospNum();;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpecialTypeInfo() {
        super();
        
    }

	// Generar jsons
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //Obtener # del hospital
            getInfoCookies(request,response);
            //Conexion con db oracle
            Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(hospitalNum);
            //Response info
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            try{
                //var query sql
                String sql, sql2;
                sql = "select * from especialidad order by id_especialidad";
                sql2 = "select * from tipo_user order by id_tipo";
                OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                OracleResultSet rs = (OracleResultSet) pst.executeQuery();   
                
                OraclePreparedStatement pst2 = (OraclePreparedStatement) conn.prepareStatement(sql2);
                OracleResultSet rs2 = (OracleResultSet) pst2.executeQuery();   
                //Array jsons
                JSONArray jArray = new JSONArray();
                int i = 0;
                while(rs.next() && rs2.next() ){
                    //obtener parametros
                    String idspecial = rs.getString("id_especialidad");
                    String especialidad = rs.getString("especialidad");
                    String idtype = rs2.getString("id_tipo");
                    String tipo = rs2.getString("tipo");
                    //Crear objeto json
                    JSONObject arrayObj = new JSONObject();
                    arrayObj.put("idspecial",idspecial);
                    arrayObj.put("especialidad",especialidad);
                    arrayObj.put("idType",idtype);
                    arrayObj.put("tipo",tipo);
                    //insertar objeto a array jsons
                    jArray.add(i,arrayObj);
                    i++;
                }
                /*
                while(rs2.next()){
                    //obtener parametros
                    String idtype = rs2.getString("id_tipo");
                    String tipo = rs2.getString("tipo");
                    //Crear objeto json
                    JSONObject arrayObj = new JSONObject();
                    arrayObj.put("idType",idtype);
                    arrayObj.put("tipo",tipo);
                    //insertar objeto a array jsons
                    jArray.add(i,arrayObj);
                    i++;
                }*/
                rs.close ();
                pst.close ();
                rs2.close ();
                pst2.close ();
                conn.close();
                out.print(jArray);
            }catch(Exception e){
                System.err.println(e);
            }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
        
        protected void getInfoCookies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            Cookie[] cookiesInf = request.getCookies();
            if(cookiesInf !=null){
                for(Cookie cookie : cookiesInf){
                    if(cookie.getName().equals("hospNum")){
                        hospitalNum = Integer.parseInt(cookie.getValue());
                    }
                }
            }
        }
}






















