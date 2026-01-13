package controller;

import com.mycompany.mavenproject3.entity.Role;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import service.RoleService;

@Path("role")
public class RoleController {

    @Context
    private UriInfo context;

    private RoleService layer = new RoleService();

    public RoleController() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    //getRoleById
    @GET
    @Path("getRoleById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRoleById(@QueryParam("id") Integer id) {
        JSONObject toReturn = layer.getRoleById(id);
        return Response.status(Integer.parseInt(toReturn.get("statusCode").toString())).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
    }

    //getAllRole
    @GET
    @Path("getAllRole")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllRole() {
        JSONObject toReturn = layer.getAllRole();
        return Response.status(Integer.parseInt(toReturn.get("statusCode").toString())).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
    }

    //addRole
    @POST
    @Path("addRole")
    @Consumes()
    public Response addRole(String body) {
        JSONObject bodyObject = new JSONObject(body);
        Role addedRole = new Role(bodyObject.getString("name"));
        JSONObject toReturn = layer.addRole(addedRole);
        return Response.status(Integer.parseInt(toReturn.get("statusCode").toString())).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
    }
    
    //deleteRole
    @DELETE
    @Path("deleteRole")
    @Consumes()
    public Response deleteRole(@QueryParam("id") Integer id){
        Role deletedRole = new Role(id);
        JSONObject toReturn = layer.deleteRole(deletedRole);
        return Response.status(Integer.parseInt(toReturn.get("statusCode").toString())).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
    }
    
    //updateRole
    @PUT
    @Path("updateRole")
    @Consumes()
    public Response updateRole(String body){
        JSONObject bodyObject = new JSONObject(body);
        
        Role updatedRole = new Role(
                bodyObject.getInt("id"),
                bodyObject.getString("name")
        );
        
        JSONObject toReturn = layer.updateRole(updatedRole);
        return Response.status(Integer.parseInt(toReturn.get("statusCode").toString())).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
    }
    
    //login
}
