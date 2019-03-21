/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospital.ws.patient;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author migue
 */
@Path("/patient")
public class PatientResource {
    private static String hospitalNum = "1";
    protected List<Patients> patientsList = new ArrayList<Patients>();
    
    @GET
    @Path("/getPatient")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patients> getPatients(){
        //Obtener # del hospital
        makeList();
        
        return patientsList;
    }
    
    @GET
    @Path("/getPatient/{pId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMsg(@PathParam("pId") String name) {
        String output = "<html> " + "<title>" + "Java WebService Example" + "</title>"  + "<body><h1><div style='font-size: larger;'>"
                + "Hello <span style='text-transform: capitalize; color: green;'>" + name + "</span></div></h1></body>" + "</html>";
        return Response.status(200).entity(output).build();
    }
    
    protected void makeList(){
        
        //Conexion con db oracle
            Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
            //Response info
            try{
                //var query sql
                String sql;
                sql = "select * from pacientes order by paciente_id";
                OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                OracleResultSet rs = (OracleResultSet) pst.executeQuery();                    
                while(rs.next()){
                    //obtener parametros
                    int id = rs.getInt("PACIENTE_ID");
                    String name = rs.getString("Nombre");
                    String lastN = rs.getString("Apellido");
                    int tel = rs.getInt("TEL");
                    float dpi = rs.getFloat("DPI");
                    String segNum = rs.getString("num_seguro");
                    String fNacimiento = rs.getString("f_nacimiento");
                    String dir = rs.getString("dir");
                    //id de la aseguradora
                    int asegNum = rs.getInt("ASEGURADORA_ID");
                    //Crear clase paciente
                    //Patients patients = new Patients(1,"Miguel","Gonzalez",45454545,654654,"asdfasdf","25-12-1997","Mi casa",1);
                    Patients patients = new Patients(id,name,lastN,tel,dpi,segNum,fNacimiento,dir,asegNum);
                    //Agregar paciente a la lista
                    patientsList.add(patients);
                }
                rs.close ();
                pst.close ();
                conn.close();
            }catch(Exception e){
                System.err.println(e);
            }
    }
    
}
