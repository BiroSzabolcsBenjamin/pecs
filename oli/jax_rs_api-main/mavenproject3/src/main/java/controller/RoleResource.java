/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericItemResource.java to edit this template
 */
package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author bzhal
 */
public class RoleResource {

    private String name;

    /**
     * Creates a new instance of RoleResource
     */
    private RoleResource(String name) {
        this.name = name;
    }

    /**
     * Get instance of the RoleResource
     */
    public static RoleResource getInstance(String name) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of RoleResource class.
        return new RoleResource(name);
    }

    /**
     * Retrieves representation of an instance of com.mycompany.mavenproject3.entity.RoleResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of RoleResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    /**
     * DELETE method for resource RoleResource
     */
    @DELETE
    public void delete() {
    }
}
