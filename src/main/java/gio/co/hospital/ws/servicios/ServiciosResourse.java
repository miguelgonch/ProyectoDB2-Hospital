/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospital.ws.servicios;

import gio.co.hospital.ws.patient.Patients;
import gio.co.hospitales.JavaConnectDb;
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
import gio.co.hospitales.JavaConnectDb;
import java.net.URI;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

/**
 *
 * @author manu
 */
@Path("/servicios")
public class ServiciosResourse {
    
    private static final int hospitalNum = JavaConnectDb.getHospNum();
    //CAMBIADO PARA PRUBAS
    //private static String hospitalNum = "3";                                //Este va a estar cambiado para cada hospital
    
    protected List<Servicios> serviceList = new ArrayList<Servicios>();
    protected List<Servicios> serviceListNames = new ArrayList<Servicios>();
    
    
     //Realizar una consulta
    @GET
    @Path("/getServices")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServices(
            @QueryParam("servicioId") String sId) {                                //Aquí uso @QueryParam para recibir los parametros como query

        makeList(sId);                                                      //Crear la lista de la info solicitada
        return Response.status(200).entity(serviceList).build();
    }
    
    @GET
    @Path("/getServicesName")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServicesName(
            @QueryParam("servicioId") String sName) {                                //Aquí uso @QueryParam para recibir los parametros como query

        makeList2(sName);                                                      //Crear la lista de la info solicitada
        return Response.status(200).entity(serviceListNames).build();
    }
    
    //Metodo para crear la lista de servicios
    protected void makeList(String sId) {
        //Conexion con db oracle
        Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(hospitalNum);
        //Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
            //Response info
            try{
                //var query sql
                String sql;
                //Revisar si hay un request
                if(sId!=null){
                    //Query con el filtro para seleccionar un paciente
                    sql = "select * from subcategoria where id_subcat='"+sId+"' order by id_subcat";
                    
                }
                else{
                    //Query de todos los pacientes
                    //sql = "select * from pacientes order by paciente_id";
                    sql = "select * from subcategoria";
                }
                OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                OracleResultSet rs = (OracleResultSet) pst.executeQuery();                    
                while(rs.next()){
                    //obtener parametros
                    int id = rs.getInt("ID_SUBCAT");
                    String subcategoria = rs.getString("SUBCAT");
                    int categoria = rs.getInt("ID_CAT");
                    int costo = rs.getInt("COSTO");
                  
                    //Crear clase servicio
                    Servicios services = new Servicios(id, subcategoria, categoria, costo);
                    //Agregar paciente a la lista
                    serviceList.add(services);
                }
                rs.close ();
                pst.close ();
                conn.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    protected void makeList2(String sName) {
        //Conexion con db oracle
        Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(hospitalNum);
        //Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
            //Response info
            try{
                //var query sql
                String sql;
                //Revisar si hay un request
                if(sName!=null){
                    //Query con el filtro para seleccionar un paciente
                    sql = "select * from subcategoria where subcat='"+sName+"' order by subcat";
                    
                }
                else{
                    //Query de todos los pacientes
                    //sql = "select * from pacientes order by paciente_id";
                    sql = "select * from subcategoria";
                }
                OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                OracleResultSet rs = (OracleResultSet) pst.executeQuery();                    
                while(rs.next()){
                    //obtener parametros
                    int id = rs.getInt("ID_SUBCAT");
                    String subcategoria = rs.getString("SUBCAT");
                    int categoria = rs.getInt("ID_CAT");
                    int costo = rs.getInt("COSTO");
                  
                    //Crear clase servicio
                    Servicios services = new Servicios(id, subcategoria, categoria, costo);
                    //Agregar paciente a la lista
                    serviceListNames.add(services);
                }
                rs.close ();
                pst.close ();
                conn.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}



























