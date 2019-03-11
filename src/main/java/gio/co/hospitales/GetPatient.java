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
 * Servlet implementation class GetPatient
 */
@WebServlet("/GetPatient")
public class GetPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private static String hospitalNum = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	// Generar jsons
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //Obtener # del hospital
            getInfoCookies(request,response);
            //Conexion con db oracle
            Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
            //Response info
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            try{
                //var query sql
                String sql;
                //Revisar si hay un request
                if(request.getParameter("pId")!=null){
                    String pId = request.getParameter("pId");
                    //Query con el filtro
                    sql = "select * from pacientes where paciente_id ="+pId;
                }
                else{
                    //Query
                    sql = "select * from pacientes order by paciente_id";
                }
                OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                OracleResultSet rs = (OracleResultSet) pst.executeQuery();                    
                //Array jsons
                JSONArray jArray = new JSONArray();
                int i = 0;
                while(rs.next()){
                    //obtener parametros
                    String id = rs.getString("PACIENTE_ID");
                    String name = rs.getString("Nombre");
                    String lastN = rs.getString("Apellido");
                    String tel = rs.getString("TEL");
                    String dpi = rs.getString("DPI");
                    String segNum = rs.getString("num_seguro");
                    String fNacimiento = rs.getString("f_nacimiento");
                    String dir = rs.getString("dir");
                    String asegNum = rs.getString("ASEGURADORA_ID");
                    //Crear objeto json
                    JSONObject arrayObj = new JSONObject();
                    arrayObj.put("id",id);
                    arrayObj.put("nombre",name);
                    arrayObj.put("apellido",lastN);
                    arrayObj.put("tel",tel);
                    arrayObj.put("dpi",dpi);
                    arrayObj.put("segNum",segNum);
                    arrayObj.put("fNacimiento",fNacimiento);
                    arrayObj.put("dir",dir);
                    arrayObj.put("asegNum",asegNum);
                    //insertar objeto a array jsons
                    jArray.add(i,arrayObj);
                    i++;
                }
                rs.close ();
                pst.close ();
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
