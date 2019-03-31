/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospital.ws.cobertura;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author C.V
 */

@Path("/cobertura")

public class coberturaResource {
    
    private static String hospitalNum = "1";                                //Este va a estar cambiado para cada hospital
    protected List<Coberturas> coberturasList = new ArrayList<Coberturas>();

    //Realizar una consulta
    @GET
    @Path("/getCobertura")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCobertura(
            @QueryParam("citaId") String citaId) {                                //Aquí uso @QueryParam para recibir los parametros como query
        
        makeList(citaId);                                                      //Crear la lista de la info solicitada
        return Response.status(200).entity(coberturasList).build();
    }
    
    protected void makeList(String citaId){
        //Conexion con db oracle
        Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(Integer.parseInt(hospitalNum));
            //Response info
            try{
                //var query sql
                String sql;
                //Revisar si hay un request
                if(citaId!=null){
                    //Query con el filtro para seleccionar un paciente
                    //sql = "select * from pacientes where paciente_id ="+pId+" order by paciente_id";
                    sql = "select * from coberturas_view  where cita_id ="+citaId+" order by cita_id";
                }
                else{
                    //Query de todos los pacientes
                    //sql = "select * from pacientes order by paciente_id";
                    sql = "select * from coberturas_view order by cita_id";
                }
                OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                OracleResultSet rs = (OracleResultSet) pst.executeQuery();                    
                while(rs.next()){
                    //obtener parametros
                    int paciente_id = rs.getInt("PACIENTE_ID");
                    int cita_id = rs.getInt("cita_id");
                    String aseguradora = rs.getString("aseguradora");
                    int id_subcat = rs.getInt("id_subcat");
                    String subcat = rs.getString("subcat");
                    int costo = rs.getInt("costo");
                    double pCobertura = rs.getDouble("p_cobertura");
                    String tipoSeguro = rs.getString("tipo_seguro");
                    int id_tipo_seguro = rs.getInt("id_tipo_seguro");
                    //Crear clase paciente
                    Coberturas coberturas = new Coberturas(paciente_id,cita_id,aseguradora,id_subcat,subcat,costo,pCobertura,tipoSeguro,id_tipo_seguro);
                    //Agregar paciente a la lista
                    coberturasList.add(coberturas);
                }
                rs.close ();
                pst.close ();
                conn.close();
            }catch(Exception e){
                System.err.println(e);
            }
    }
    
}



