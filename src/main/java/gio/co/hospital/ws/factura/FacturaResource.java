/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospital.ws.factura;

import gio.co.hospital.ws.cobertura.Coberturas;
import gio.co.hospitales.JavaConnectDb;
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

@Path("/factura")
public class FacturaResource {
    
    private static int hospitalNum = JavaConnectDb.getHospNum();;
    protected List<Factura> facturaList = new ArrayList<Factura>();
    
    //Realizar una consulta
    @GET
    @Path("/getFactura")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatient(
            @QueryParam("cId") String cId) {                                //Aquí uso @QueryParam para recibir los parametros como query

        makeList(cId);                                                      //Crear la lista de la info solicitada
        return Response.status(200).entity(facturaList).build();
    }
    
    protected void makeList(String citaId){
        //Conexion con db oracle
        Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(hospitalNum);
            //Response info
            try{
                //var query sql
                String sql;
                //Revisar si hay un request
                if(citaId!=null){
                    //Query con el filtro para seleccionar un paciente
                    //sql = "select * from pacientes where paciente_id ="+pId+" order by paciente_id";
                    sql = "select * from FACTURA_FULL where cita_id ="+citaId+" order by cita_id";
                }
                else{
                    //Query de todos los pacientes
                    //sql = "select * from pacientes order by paciente_id";
                    sql = "select * from FACTURA_FULL order by cita_id";
                }
                OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                OracleResultSet rs = (OracleResultSet) pst.executeQuery();                    
                while(rs.next()){
                    //obtener parametros
                    int id = rs.getInt("ID_FACTURA");
                    int auth = rs.getInt("AUTORIZACION");
                    int cobroCliente = rs.getInt("COBRO_CLIENTE");
                    int cita = rs.getInt("CITA_ID");
                    String fecha = rs.getString("FECHA");
                    String nombre = rs.getString("NOMBRE");
                    String apellido = rs.getString("APELLIDO");
                    String subcat = rs.getString("SUBCAT");
                    String cat = rs.getString("CATEGORIA");
                    int costo = rs.getInt("COSTO");
                    //Crear clase paciente
                    Factura factura = new Factura(id, auth, cobroCliente, cita, fecha, nombre, apellido, subcat, cat, costo);
                    //Agregar paciente a la lista
                    facturaList.add(factura);
                }
                rs.close ();
                pst.close ();
                conn.close();
            }catch(Exception e){
                System.err.println(e);
            }
    }
    
}



