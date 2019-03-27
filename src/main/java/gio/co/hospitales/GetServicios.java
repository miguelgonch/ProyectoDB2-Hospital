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
 * Servlet implementation class AsegInfo
 */
@WebServlet("/getServicios")
public class GetServicios extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private static String hospitalNum = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetServicios() {
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
                sql = "select * from subcategoria";
                OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                OracleResultSet rs = (OracleResultSet) pst.executeQuery();                    
                //Array jsons
                JSONArray jArray = new JSONArray();
                int i = 0;
                while(rs.next()){
                    //obtener parametros
                    int subCatId = rs.getInt(1);
                    String subCatName = rs.getString(2);
                    int catId = rs.getInt(3);
                    int cost = rs.getInt(4);
                    //Crear objeto json
                    JSONObject arrayObj = new JSONObject();
                    arrayObj.put("subCatId",subCatId);
                    arrayObj.put("subCat",subCatName);
                    arrayObj.put("catId",catId);
                    arrayObj.put("cost",cost);
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
