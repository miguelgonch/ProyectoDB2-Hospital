/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospital.ws.patient;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author migue
 */
@Path("/patient")
public class PatientResource {
    //Duda resolver con Gio (el dato lo tengo almacenado en una cookie, no se como leerlo desde el REST)
    private static String hospitalNum = "1";
    protected List<Patients> patientsList = new ArrayList<Patients>();

    //Realizar una consulta
    @GET
    @Path("/getPatient")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatient(@QueryParam("pId") String pId) {
        
        makeList(pId);
        return Response.status(200).entity(patientsList).build();
    }
    
    //Insertar un paciente
    @POST
    @Path("/addPatient")
    public Boolean addPatient(
        @FormParam("pId") String pId,
        @FormParam("nameP") String name,
        @FormParam("lastNameP") String lastName,
        @FormParam("dir") String dir,
        @FormParam("tel") String tel,
        @FormParam("bDate") String bDate,
        @FormParam("dpi") String dpi,
        @FormParam("segNum") String segNum,
        @FormParam("docId") String docId) {
        
        //Respuesta del addPatient
        Boolean respuesta = false;
        
        //Conexion con db oracle
        Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
        try{
            //var query sql
            String sql;
            //Armar el query
            if(pId!=null){
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
            rs.close ();
            pst.close ();
            conn.close();
            respuesta = true;
        }catch(Exception e){
            System.err.println(e);
            respuesta = false;
        }
        
        
        return respuesta;
    }
    
    
    
    
    
    protected void makeList(String pId){
        
        //Conexion con db oracle
        Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
            //Response info
            try{
                //var query sql
                String sql;
                //Revisar si hay un request
                if(pId!=null){
                    //Query con el filtro para seleccionar un paciente
                    sql = "select * from pacientes where paciente_id ="+pId+" order by paciente_id";
                }
                else{
                    //Query de todos los pacientes
                    sql = "select * from pacientes order by paciente_id";
                }
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
