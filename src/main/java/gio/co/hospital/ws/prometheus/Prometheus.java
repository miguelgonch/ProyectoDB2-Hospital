/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospital.ws.prometheus;

import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author migue
 */
@Path("/")
public class Prometheus {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Prometheus
     */
    public Prometheus() {
        //todavia no se ha configurado esta funcion
    }

    /**
     * Retrieves representation of an instance of gio.co.hospital.ws.prometheus.Prometheus
     * @return Response type
     */
    @GET
    @Path("/get")
    @Produces(MediaType.TEXT_HTML)
    public Response getPrometheus() {
        PrometheusMeterRegistry prometheusRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        return Response.status(200).entity(prometheusRegistry.scrape()).build();

    }
}
