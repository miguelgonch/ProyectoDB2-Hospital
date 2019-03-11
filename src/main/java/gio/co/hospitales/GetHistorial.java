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
                    sql = "select cita_id,diagnostico,resultados,medicinas,pasosaseguir,observaciones,fecha,paciente_id,doc_id,subcat,nombre,apellido from citas join usuario on usuario_id = doc_id where paciente_id ="+pId+" order by fecha";
                }
                if(request.getParameter("cId")!=null){
                    String cId = request.getParameter("pId");
                    //Query con el filtro
                    sql = "select cita_id,diagnostico,resultados,medicinas,pasosaseguir,observaciones,fecha,paciente_id,doc_id,subcat,nombre,apellido from citas join usuario on usuario_id = doc_id where cita_id ="+cId+" order by fecha";
                }
                else{
                    //Query
                    sql = "select cita_id,diagnostico,resultados,medicinas,pasosaseguir,observaciones,fecha,paciente_id,doc_id,subcat,nombre,apellido from citas join usuario on usuario_id = doc_id where paciente_id =1 order by fecha";
                }
                OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                OracleResultSet rs = (OracleResultSet) pst.executeQuery();                    
                //Array jsons
                JSONArray jArray = new JSONArray();
                int i = 0;
                while(rs.next()){
                    //obtener parametros
                        String id = rs.getString("CITA_ID");
                        String diag = rs.getString("Diagnostico");
                        String res = rs.getString("resultados");
                        String meds = rs.getString("medicinas");
                        String pasos = rs.getString("pasosaseguir");
                        String observ = rs.getString("observaciones");
                        String fecha = rs.getString("fecha");
                        String docName = rs.getString("nombre");
                        String docLastName = rs.getString("apellido");
                        String pId = rs.getString("paciente_id");
                        //Crear objeto json
                        JSONObject arrayObj = new JSONObject();
                        arrayObj.put("id",id);
                        arrayObj.put("diag",diag);
                        arrayObj.put("res",res);
                        arrayObj.put("meds",meds);
                        arrayObj.put("pasos",pasos);
                        arrayObj.put("observ",observ);
                        arrayObj.put("fecha",fecha);
                        arrayObj.put("docName",docName+" "+docLastName);
                        arrayObj.put("pId",pId);
                       
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
