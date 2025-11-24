/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mycompany.moviepicker.Movie;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.json.JSONObject;
import serrvice.MovieService;

/**
 *
 * @author szabi
 */

@Path("movie")
public class MovieController {
    
    @Context
    private UriInfo context;

    private MovieService layer = new MovieService();

    public MovieController() {
    }
    
    @GET
    @Path("getMovieById")
    @Consumes(MediaType.APPLICATION_JSON)
        public Response getUserById(@QueryParam("id") Integer id) {
        JSONObject toReturn = layer.getMovieById(id);

        return Response.status(Integer.parseInt(toReturn.get("statusCode").toString())).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
    }
        
    @DELETE
    @Path("deleteMovie")
    @Consumes()
    public Response deleteUserById(@QueryParam("id") Integer id) {
        JSONObject toReturn = layer.deleteMovie(id);
        return Response.status(Integer.parseInt(toReturn.get("statusCode").toString())).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
    }
    
    @PUT
    @Path("updateMovie")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMovie(@QueryParam("id") Integer id, String movieJson) {
        JSONObject movieData = new JSONObject(movieJson);
        JSONObject toReturn = layer.updateMovie(id, movieData);
        return Response.status(toReturn.getInt("statusCode"))
                       .entity(toReturn.toString())
                       .type(MediaType.APPLICATION_JSON)
                       .build();
    }

    
}
