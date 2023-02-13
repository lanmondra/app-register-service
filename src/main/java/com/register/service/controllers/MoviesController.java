package com.register.service.controllers;

import com.register.service.entities.MoviePart;
import com.register.service.entities.Movies;
import com.register.service.entities.PopularMovies;
import com.register.service.service.MoviesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Angel Mondragón
 */
@RestController
@RequestMapping("/api/v1/movie")
public class MoviesController {

    @Autowired
    private MoviesServices moviesServices;


    @GetMapping("getPopularMovies")
    public ResponseEntity<List<PopularMovies>> getMovies(){

        moviesServices.getMostPopularmovies();

        return ResponseEntity.ok(moviesServices.getMostPopularmovies());
    }

    @GetMapping("getMoviesPart")
    public ResponseEntity<List<MoviePart>> getMoviesPart(String name){


        return ResponseEntity.ok(moviesServices.getByMovieName(name));
    }






}
