/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moviepicker;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
@XmlRootElement
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int length;
    @Column(name = "genre_id")
    private int genreId;
    private double rating;
    @Column(name = "age_restriction")
    private String ageRestriction;

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_moviepicker_war_1.0-SNAPSHOTPU");
    
    public Movie() {
    }

    public Movie(String title, int length, int genreId, double rating, String ageRestriction) {
        this.title = title;
        this.length = length;
        this.genreId = genreId;
        this.rating = rating;
        this.ageRestriction = ageRestriction;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public void addMovie(Movie movie) {
        EntityManager em = emf.createEntityManager();
        StoredProcedureQuery query = em.createStoredProcedureQuery("addMovie");
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(4, Double.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);

        query.setParameter(1, movie.getTitle());
        query.setParameter(2, movie.getLength());
        query.setParameter(3, movie.getGenreId());
        query.setParameter(4, movie.getRating());
        query.setParameter(5, movie.getAgeRestriction());

        query.execute();
    }

    public static Boolean deleteMovie(Movie movie) {
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteUser");

            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.setParameter("idIN", movie.getId());

            spq.execute();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
