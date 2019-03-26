/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospital.ws.cita;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
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
import java.net.URI;
import javax.ws.rs.PUT;


/**
 * ESTE WS TODAVIA NO ESTA TERMINADO SE ESTRA TRABAJANDO
 * @author migue
 */
@Path("/cita")
public class CitasResource {
    private static String hospitalNum = "1";                                //Este va a estar cambiado para cada hospital
    protected List<Citas> citasList = new ArrayList<Citas>();

    //Realizar una consulta
    @GET
    @Path("/getCita")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCita(
            @QueryParam("pId") String pId,
            @QueryParam("citaId") String citaId) {                                    //Aquí uso @QueryParam para recibir los parametros como query
        
        makeList(pId,citaId);                                                      //Crear la lista de la info solicitada
        return Response.status(200).entity(citasList).build();
    }
    
    //Insertar una cita
    @POST
    @Path("/addCita")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addCita(
        @FormParam("pId") int pId,                                          //Aquí obtengo los parametros del formulario
        @FormParam("fechaCita") String dateCita,                                    //Aquí uso @FormParam para recibir los parametros de un form
        @FormParam("hora") String hora,
        @FormParam("servicioId") int sId,
        @FormParam("citaId") int citaId,
        @FormParam("docId") int docId){
        
        Boolean answ;                                                       //Respuesta del addUpdateCita
        answ = false;
        answ = addUpdateCita(pId,dateCita,hora,sId,docId,citaId);
        if(answ){
            return Response.temporaryRedirect(URI.create("http://localhost:8080/proyectoDB2-Hospitales/citas_h.jsp?in=1")).build();
        }
        else{
            return Response.temporaryRedirect(URI.create("http://localhost:8080/proyectoDB2-Hospitales/citas_h.jsp?in=0")).build();
        }
        
    }
    
    //Insertar una cita
    @POST
    @Path("/updateCita")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateCita(
        @FormParam("citaId") int citaId,                                          //Aquí obtengo los parametros del formulario
        @FormParam("fechaCita") String dateCita,                                    //Aquí uso @FormParam para recibir los parametros de un form
        @FormParam("hora") String hora,
        @FormParam("servicioId") int sId,
        @FormParam("diag") String diag,
        @FormParam("pasosASeguir") String pasos,
        @FormParam("res") String res,
        @FormParam("obsrv") String obsrv,
        @FormParam("meds") String meds,
        @FormParam("docId") int docId){
        
        Boolean answ;                                                       //Respuesta del addUpdateCita
        answ = false;
        answ = addUpdateCita(citaId,dateCita,hora,sId,diag,pasos,res,obsrv,meds,docId);
        if(answ){
            return Response.temporaryRedirect(URI.create("http://localhost:8080/proyectoDB2-Hospitales/citas_h.jsp?up=1")).build();
        }
        else{
            return Response.temporaryRedirect(URI.create("http://localhost:8080/proyectoDB2-Hospitales/citas_h.jsp?up=0")).build();
        }
    }
    
    //Eliminar un paciente
    @POST
    @Path("/deleteCita")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteCita(
        @FormParam("delId") int citaId){
        Boolean answ;                                                       //Respuesta del delCita
        answ = false;
        answ = delCita(citaId);
        if(answ){
            return Response.temporaryRedirect(URI.create("http://localhost:8080/proyectoDB2-Hospitales/citas_h.jsp?del=1")).build();
        }
        else{
            return Response.temporaryRedirect(URI.create("http://localhost:8080/proyectoDB2-Hospitales/citas_h.jsp?del=0")).build();
        }
    }
    /*
    @PUT                                                                    //Insertar un paciente pero jsp ni html5 funcionan con put
    @Path("/updateCita")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateCita(
        @QueryParam("pId") int pId,                                         //Aquí obtengo los parametros 
        @QueryParam("nameP") String name,                                   //Aquí uso @QueryParam para recibir los parametros como query
        @QueryParam("lastNameP") String lastName,
        @QueryParam("dir") String dir,
        @QueryParam("tel") int tel,
        @QueryParam("bDate") String bDate,
        @QueryParam("dpi") float dpi,
        @QueryParam("segNum") String segNum,
        @QueryParam("docId") int docId,
        @FormParam("asegNum") int asegNum){
        
        //Respuesta del addCita
        Boolean answ;
        answ = false;
        answ = addUpdateCita(pId,name,lastName,dir,tel,bDate,dpi,segNum,docId,asegNum);
        if(answ){
            //return Response.status(200).entity("Success").build();
            return Response.temporaryRedirect(URI.create("http://localhost:8080/proyectoDB2-Hospitales/pacientes_h.jsp?up=1")).build();
        }
        else{
            //return Response.status(200).entity("Failure").build();
            return Response.temporaryRedirect(URI.create("http://localhost:8080/proyectoDB2-Hospitales/pacientes_h.jsp?up=0")).build();
        }
    }*/

    //Metodo para crear la lista de citas
    protected void makeList(String pId,String citaId){
        //Conexion con db oracle
        Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
            //Response info
            try{
                //var query sql
                String sql;
                //Revisar si hay un request
                if(pId!=null){
                    //Query con el filtro
                    sql = "select * from citas_full where paciente_id ="+pId+" order by CITA_ID";
                }
                else if(citaId!=null){
                    //Query con el filtro
                    sql = "select * from citas_full where cita_id ="+citaId+" order by CITA_ID";
                }
                else{
                    //Query
                    sql = "select * from citas_full order by CITA_ID";
                }
                OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                OracleResultSet rs = (OracleResultSet) pst.executeQuery();                    
                //Array jsons
                while(rs.next()){
                    //obtener parametros
                        int id = rs.getInt("CITA_ID");
                        String diag = rs.getString("Diagnostico");
                        String res = rs.getString("resultados");
                        String meds = rs.getString("medicinas");
                        String pasos = rs.getString("pasosaseguir");
                        String observ = rs.getString("observaciones");
                        String fecha = rs.getString(7);
                        int docId = rs.getInt("doc_id");
                        String docName = rs.getString("nombre_doc");
                        String docLastName = rs.getString("apellido_doc");
                        int paId = rs.getInt("paciente_id");
                        String pName = rs.getString("nombre");
                        String pLastName = rs.getString("apellido");
                        int subCatId = rs.getInt("ID_SUBCAT");
                        String subCat = rs.getString("subcat");
                        int catId = rs.getInt("ID_CAT");
                        String cat = rs.getString("categoria");
                    //Crear clase paciente
                    Citas citas = new Citas(id,diag,res,meds,pasos,observ,fecha,docId,docName,docLastName,paId,pName,pLastName,subCatId,subCat,catId,cat);
                    //Agregar paciente a la lista
                    citasList.add(citas);
                }
                rs.close ();
                pst.close ();
                conn.close();
            }catch(Exception e){
                System.err.println(e);
            }
    }

    private Boolean delCita(int citaId) {
        Boolean respuesta = false;
        //Conexion con db oracle
        Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
        try{
            //var query sql
            String sql;
            //Query
            sql = "DELETE FROM CITAS WHERE cita_id="+citaId;
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

    //Metodo para realizar un insert o un update dependiendo del caso
    private Boolean addUpdateCita(int pId, String dateCita, String hora, int sId, int docId,int citaId) {
        Boolean respuesta = false;
        //Conexion con db oracle
        Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
        try{
            //var query sql
            String sql;
            //Armar el query
            if(citaId!=0){
                //Query con el filtro
                //sql = "UPDATE PACIENTES SET NOMBRE = '"+name+"', APELLIDO = '"+lastName+"', DIR = '"+dir+"', TEL = "+tel+", F_NACIMIENTO = TO_DATE('"+bDate+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), DPI = "+dpi+", NUM_SEGURO = "+segNum+", DOCTOR_ID = "+docId+",aseguradora_id = "+asegNum+" WHERE paciente_id = "+pId;
                sql = "UPDATE CITAS SET DIAGNOSTICO = '', RESULTADOS = 'resultados', MEDICINAS = 'panadol forte', PASOSASEGUIR = 'venir en 2 meses', OBSERVACIONES = 'consumir ibuprofeno', FECHA = TO_DATE('2019-03-25 13:00:00', 'YYYY-MM-DD HH24:MI:SS'), DOC_ID = '5', PACIENTE_ID = '45', ID_SUBCAT = '1' WHERE cita_id="+citaId;
            }
            else{
                //Query
                sql = "INSERT INTO CITAS (FECHA, DOC_ID, PACIENTE_ID, ID_SUBCAT) VALUES (TO_DATE('"+dateCita+" "+hora+"', 'YYYY-MM-DD HH24:MI:SS'), '"+docId+"', '"+pId+"', '"+sId+"')";
            }
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

    private Boolean addUpdateCita(int citaId, String dateCita, String hora, int sId, String diag, String pasos, String res, String obsrv, String meds, int docId) {
        Boolean respuesta = false;
        //Conexion con db oracle
        Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
        try{
            //var query sql
            String sql;
            //Armar el query
            sql = "UPDATE CITAS SET DIAGNOSTICO = '"+diag+"', RESULTADOS = '"+res+"', MEDICINAS = '"+meds+"', PASOSASEGUIR = '"+pasos+"', OBSERVACIONES = '"+obsrv+"', FECHA = TO_DATE('"+dateCita+" "+hora+"', 'YYYY-MM-DD HH24:MI:SS'), DOC_ID = '"+docId+"', ID_SUBCAT = '"+sId+"' WHERE cita_id="+citaId;
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
}