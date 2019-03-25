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
            @QueryParam("cId") String cId) {                                //Aquí uso @QueryParam para recibir los parametros como query
        
        makeList(pId,cId);                                                      //Crear la lista de la info solicitada
        return Response.status(200).entity(citasList).build();
    }
    
   /* //Insertar o Actualizar una cita
    @POST
    @Path("/addCita")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addCita(
        @FormParam("pId") int pId,                                          //Aquí obtengo los parametros del formulario
        @FormParam("nameP") String name,                                    //Aquí uso @FormParam para recibir los parametros de un form
        @FormParam("lastNameP") String lastName,
        @FormParam("dir") String dir,
        @FormParam("tel") int tel,
        @FormParam("bDate") String bDate,
        @FormParam("dpi") float dpi,
        @FormParam("segNum") String segNum,
        @FormParam("docId") int docId,
        @FormParam("asegNum") int asegNum){
        
        Boolean answ;                                                       //Respuesta del addUpdateCita
        answ = false;
        answ = addUpdateCita(pId,name,lastName,dir,tel,bDate,dpi,segNum,docId,asegNum);
        if(pId!=1){
            if(answ){
                return Response.temporaryRedirect(URI.create("http://localhost:8080/proyectoDB2-Hospitales/pacientes_h.jsp?in=1")).build();
            }
            else{
                return Response.temporaryRedirect(URI.create("http://localhost:8080/proyectoDB2-Hospitales/pacientes_h.jsp?in=0")).build();
            }
        }
        else{
            if(answ){
                return Response.temporaryRedirect(URI.create("http://localhost:8080/proyectoDB2-Hospitales/pacientes_h.jsp?up=1")).build();
            }
            else{
                return Response.temporaryRedirect(URI.create("http://localhost:8080/proyectoDB2-Hospitales/pacientes_h.jsp?up=0")).build();
            }
        }
    }
    
    //Eliminar un paciente
    @POST
    @Path("/deleteCita")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteCita(
        @FormParam("delId") int pId){
        Boolean answ;                                                       //Respuesta del delCita
        answ = false;
        answ = delCita(pId);
        if(answ){
            return Response.temporaryRedirect(URI.create("http://localhost:8080/proyectoDB2-Hospitales/pacientes_h.jsp?del=1")).build();
        }
        else{
            return Response.temporaryRedirect(URI.create("http://localhost:8080/proyectoDB2-Hospitales/pacientes_h.jsp?del=0")).build();
        }
    }
    
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
    protected void makeList(String pId,String cId){
        //Conexion con db oracle
        Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
            //Response info
            try{
                //var query sql
                String sql;
                //Revisar si hay un request
                if(pId!=null){
                    //Query con el filtro
                    sql = "select c.cita_id ,c.diagnostico,c.resultados,c.medicinas,c.pasosaseguir,c.observaciones,c.fecha,c.paciente_id,pa.nombre,pa.apellido,doc_id,id_subcat,u.nombre,u.apellido from citas c join usuario u on u.usuario_id = c.doc_id join pacientes pa on c.paciente_id = pa.paciente_id where pa.paciente_id ="+pId+" order by fecha";
                }
                else if(cId!=null){
                    //Query con el filtro
                    sql = "select c.cita_id ,c.diagnostico,c.resultados,c.medicinas,c.pasosaseguir,c.observaciones,c.fecha,c.paciente_id,pa.nombre,pa.apellido,doc_id,id_subcat,u.nombre,u.apellido from citas c join usuario u on u.usuario_id = c.doc_id join pacientes pa on c.paciente_id = pa.paciente_id where c.cita_id ="+cId+" order by fecha";
                }
                else{
                    //Query
                    sql = "select c.cita_id ,c.diagnostico,c.resultados,c.medicinas,c.pasosaseguir,c.observaciones,c.fecha,c.paciente_id,pa.nombre,pa.apellido,doc_id,id_subcat,u.nombre,u.apellido from citas c join usuario u on u.usuario_id = c.doc_id join pacientes pa on c.paciente_id = pa.paciente_id order by fecha";
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
                        String docName = rs.getString(13);
                        String docLastName = rs.getString(14);
                        int paId = rs.getInt("paciente_id");
                        String pName = rs.getString("nombre");
                        String pLastName = rs.getString("apellido");
                    //Crear clase paciente
                    Citas citas = new Citas(id,diag,res,meds,pasos,observ,fecha,docName,docLastName,paId,pName,pLastName);
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

    //Metodo para realizar un insert o un update dependiendo del caso
    private Boolean addUpdateCita(int pId, String name, String lastName, String dir, int tel, String bDate, float dpi, String segNum, int docId, int asegNum) {
        Boolean respuesta = false;
        //Conexion con db oracle
        Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
        try{
            //var query sql
            String sql;
            //Armar el query
            if(pId!=0){
                //Query con el filtro
                sql = "UPDATE PACIENTES SET NOMBRE = '"+name+"', APELLIDO = '"+lastName+"', DIR = '"+dir+"', TEL = "+tel+", F_NACIMIENTO = TO_DATE('"+bDate+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), DPI = "+dpi+", NUM_SEGURO = "+segNum+", DOCTOR_ID = "+docId+",aseguradora_id = "+asegNum+" WHERE paciente_id = "+pId;
            }
            else{
                //Query
                sql = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DIR, TEL, F_NACIMIENTO, DPI, NUM_SEGURO, DOCTOR_ID,aseguradora_id) VALUES ('"+name+"', '"+lastName+"', '"+dir+"', '"+tel+"', TO_DATE('"+bDate+" 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '"+dpi+"', '"+segNum+"', '"+docId+"','"+asegNum+"')";
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

    private Boolean delCita(int pId) {
        Boolean respuesta = false;
        //Conexion con db oracle
        Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
        try{
            //var query sql
            String sql;
            //Query
            sql = "DELETE FROM PACIENTES WHERE paciente_id="+pId;
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
