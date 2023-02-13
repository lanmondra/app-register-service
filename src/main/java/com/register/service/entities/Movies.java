package com.register.service.entities;

import lombok.Data;

/**
 * @author Angel Mondragón
 */
@Data
public class Movies {

    private int id ;

    private String idImdb;

    private String title;

    private String type;

    private String img ;

    private String year;

    private String releaseDate;

    private String runtimeStr;

    private String awards;

    private String directors;

    private String stars;

    private String writers;


}
