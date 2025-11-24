/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serrvice;

import com.mycompany.moviepicker.Movie;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.json.JSONObject;

/**
 *
 * @author szabi
 */
public class MovieService {

    @PersistenceContext(unitName = "moviePU")
    private EntityManager em;

    public JSONObject getMovieById(Integer id) {
        JSONObject toReturn = new JSONObject();
        String status = "succes";
        Integer statusCode = 200;

        Movie movie = em.find(Movie.class, id);
        if (id > 0) {
            JSONObject result = new JSONObject();
            result.put("id", movie.getId());
            result.put("title", movie.getTitle());
            result.put("lenght", movie.getLength());
            result.put("genre_id", movie.getGenreId());
            result.put("rating", movie.getRating());
            result.put("age_restriction", movie.getAgeRestriction());
            toReturn.put("result", result);
        } else {
            status = "InvalidParamValue";
            statusCode = 417;
        }

        toReturn.put("satus", status);
        toReturn.put("statusCode", statusCode);

        return toReturn;
    }

    public JSONObject deleteMovie(Integer id) {
        JSONObject toReturn = new JSONObject();
        String status = "succes";
        Integer statusCode = 200;

        Movie movie = em.find(Movie.class, id);
        if (movie.equals(null)) {
            status = "invalidUser";
            statusCode = 417;
        } else {
            try {
                em.remove(movie);
                toReturn.put("result", true);
            } catch (Exception e) {
                status = "serverError";
                statusCode = 500;
                toReturn.put("result", false);
            }
        }

        toReturn.put("satus", status);
        toReturn.put("statusCode", statusCode);

        return toReturn;
    }

    public JSONObject updateMovie(Integer id, JSONObject movieData) {
        JSONObject toReturn = new JSONObject();
        String status = "success";
        Integer statusCode = 200;

        Movie movie = em.find(Movie.class, id);
        if (movie == null) {
            status = "invalidMovie";
            statusCode = 417;
            toReturn.put("result", false);
        } else {
            try {
                if (movieData.has("title")) {
                    movie.setTitle(movieData.getString("title"));
                }
                if (movieData.has("length")) {
                    movie.setLength(movieData.getInt("length"));
                }
                if (movieData.has("genre_id")) {
                    movie.setGenreId(movieData.getInt("genre_id"));
                }
                if (movieData.has("rating")) {
                    movie.setRating(movieData.getDouble("rating"));
                }
                if (movieData.has("age_restriction")) {
                    movie.setAgeRestriction(movieData.getString("age_restriction"));
                }

                em.merge(movie); // Frissítjük az entitást
                toReturn.put("result", true);
            } catch (Exception e) {
                status = "serverError";
                statusCode = 500;
                toReturn.put("result", false);
            }
        }

        toReturn.put("status", status);
        toReturn.put("statusCode", statusCode);
        return toReturn;
    }
}
