/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospital.ws;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author migue
 */
@Path("/callservice")
public class CallResource {
    
    @GET
    @Path("/calls")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Calls> getCalls(){
        List<Calls> callsList = new ArrayList<Calls>();
        Calls calls = new Calls("1","Hola","HolaHola");
        
        callsList.add(calls);
        
        return callsList;
    }
}
