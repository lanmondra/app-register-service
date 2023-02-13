package com.register.service.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Angel Mondragón
 */

@Data
public class PopularMovies implements Serializable {

    private int id ;

    private String idImdb;

    private String rank;

    private String rankUpDown;

    private String title;

    private String year ;

    private String image;

    private String crew;

    private String imDbRating;

    private String fullTitle;


}
