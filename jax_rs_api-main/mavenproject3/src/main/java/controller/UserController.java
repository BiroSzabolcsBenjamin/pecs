package controller;

import com.mycompany.mavenproject3.entity.User;
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
import service.UserService;

@Path("user")
public class UserController {

    @Context
    private UriInfo context;

    private UserService layer = new UserService();

    public UserController() {
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

    @GET
    @Path("getUserById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUserById(@QueryParam("id") Integer id) {
        JSONObject toReturn = layer.getUserById(id);

        return Response.status(Integer.parseInt(toReturn.get("statusCode").toString())).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("registerUser")
    @Consumes()
    public Response register(String body) {
        JSONObject bodyObject = new JSONObject(body);

        User registeredUser = new User(
                bodyObject.getString("firstName"),
                bodyObject.getString("lastName"),
                bodyObject.getString("email"),
                bodyObject.getString("password"),
                bodyObject.getString("phone")
        );

        JSONObject toReturn = layer.registerUser(registeredUser);
        return Response.status(Integer.parseInt(toReturn.get("statusCode").toString())).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("updateUser")
    @Consumes()
    public Response updateUserBy(String body) {
        JSONObject bodyObject = new JSONObject(body);

        User updatedUser = new User(
                bodyObject.getInt("id"),
                bodyObject.getString("firstName"),
                bodyObject.getString("lastName"),
                bodyObject.getString("email"),
                bodyObject.getString("phone")
        );

        JSONObject toReturn = layer.updateUser(updatedUser);
        return Response.status(Integer.parseInt(toReturn.get("statusCode").toString())).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("deleteUser")
    @Consumes()
    public Response deleteUserById(@QueryParam("id") Integer id) {
        User deletedUser = new User(id);
        JSONObject toReturn = layer.deleteUser(deletedUser);
        return Response.status(Integer.parseInt(toReturn.get("statusCode").toString())).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("getAllUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllUser() {
        JSONObject toReturn = layer.getAllUser();
        return Response.status(Integer.parseInt(toReturn.get("statusCode").toString())).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(String body) {
        JSONObject bodyObject = new JSONObject(body);
        User loggedUser = new User(bodyObject.getString("email"), bodyObject.getString("password"));

        JSONObject toReturn = layer.login(loggedUser);
        return Response.status(Integer.parseInt(toReturn.get("statusCode").toString())).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
    }
}
