/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package controller;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author bzhal
 */
@Path("/rs")
public class RolesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RolesResource
     */
    public RolesResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.mavenproject3.entity.RolesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * Sub-resource locator method for {name}
     */
    @Path("{name}")
    public RoleResource getRoleResource(@PathParam("name") String name) {
        return RoleResource.getInstance(name);
    }
}
