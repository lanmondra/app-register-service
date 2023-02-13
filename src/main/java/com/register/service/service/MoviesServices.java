package com.register.service.service;


import com.register.service.entities.MoviePart;
import com.register.service.entities.Movies;
import com.register.service.entities.PopularMovies;
import liquibase.repackaged.net.sf.jsqlparser.expression.operators.relational.MinorThanEquals;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Angel Mondragón
 */

@Service
public class MoviesServices extends AbstractService {


    public List<Movies> getMovies() {

        List<Movies> movies = new ArrayList<>();
        String apikey = "k_j7pf3kr8";

        List<String> pelis = new ArrayList<>();
        pelis.add("athena");
        pelis.add("jaula");


        for (String peli : pelis) {
            List<MoviePart> m = getByMovieName(peli);

            for (MoviePart parts : m) {
                if (parts != null) {
                    Movies movie = getComplitMovies(parts.getIdImdb());
                    movies.add(movie);
                }
            }

        }


        return movies;

    }


    public List<PopularMovies> getMostPopularmovies() {

        List<PopularMovies> movies = new ArrayList<>();

        String url = "https://imdb-api.com/en/API/MostPopularMovies/k_j7pf3kr8";

        OkHttpClient cliente = new OkHttpClient();
        Request solicitud = new Request.Builder().url(url).build();

        try (Response respuesta = cliente.newCall(solicitud).execute()) {
            log.info("codigo 200 dreamlove api : " + respuesta.code());

            if (respuesta.isSuccessful()) {
                String resultString = respuesta.body().string();

                //log.info(respuesta.body().string());

                JSONObject jsonObject = new JSONObject(resultString);

                JSONArray array = jsonObject.getJSONArray("items");
                PopularMovies movie = new PopularMovies();
                for (int i = 0; i < array.length(); i++) {
                    movie.setImDbRating(array.getJSONObject(i).getString("rankUpDown"));
                    movie.setTitle(array.getJSONObject(i).getString("title"));
                    movie.setFullTitle(array.getJSONObject(i).getString("fullTitle"));
                    movie.setYear(array.getJSONObject(i).getString("year"));
                    movie.setImage(array.getJSONObject(i).getString("image"));
                    movie.setCrew(array.getJSONObject(i).getString("crew"));
                    movie.setRank(array.getJSONObject(i).getString("rank"));
                    movie.setIdImdb(array.getJSONObject(i).getString("id"));
                    movie.setImDbRating(array.getJSONObject(i).getString("imDbRating"));
                    movies.add(movie);
                }

            }
        } catch (IOException ex) {

        }

        return movies;

    }

    public Movies getComplitMovies(String idImdb) {


        //https://imdb-api.com/en/API/Title/k_m52sztmc/tt1375666/FullActor,
        StringBuilder url = new StringBuilder();
        url.append("https://imdb-api.com/en/API/Title/");
        url.append("k_j7pf3kr8/");
        url.append(idImdb);
        url.append("/FullActor,");


        OkHttpClient cliente = new OkHttpClient();
        Request solicitud = new Request.Builder().url(url.toString()).build();
        Movies movie = new Movies();
        try (Response respuesta = cliente.newCall(solicitud).execute()) {
            log.info("codigo 200 imdb : " + respuesta.code());

            if (respuesta.isSuccessful()) {
                String resultString = respuesta.body().string();

                if (resultString != null) {

                    JSONObject jsonObject = new JSONObject(resultString);
                    String erroMje = (String) jsonObject.get("errorMessage");
                    if (erroMje.equals("")) {

                        if (jsonObject.get("type").equals("Movie")) {
                            movie.setIdImdb((String) jsonObject.get("id") != null ? (String) jsonObject.get("id") : "");
                            movie.setYear((String) jsonObject.get("year") != null ? (String) jsonObject.get("year") : "");
                            movie.setTitle((String) jsonObject.get("title") != null ? (String) jsonObject.get("title") : "");
                            movie.setImg((String) jsonObject.get("image") != null ? (String) jsonObject.get("image") : "");
                            movie.setDirectors((String) jsonObject.get("directors") != null ? (String) jsonObject.get("directors") : "");
                            movie.setReleaseDate((String) jsonObject.get("releaseDate") != null ? (String) jsonObject.get("releaseDate") : "");
                            movie.setType((String) jsonObject.get("type") != null ? (String) jsonObject.get("type") : "");
                            movie.setRuntimeStr((String) jsonObject.get("runtimeStr") != null ? (String) jsonObject.get("runtimeStr") : "");
                            movie.setStars((String) jsonObject.get("stars") != null ? (String) jsonObject.get("stars") : "");
                            movie.setWriters((String) jsonObject.get("writers") != null ? (String) jsonObject.get("writers") : "");
                            movie.setAwards((String) jsonObject.get("awards") != null ? (String) jsonObject.get("awards") : "");
                        }
                    } else {
                        log.info("Error al obtner datos : " + erroMje);
                    }

                }


            }
        } catch (IOException ex) {

        }

        return movie;

    }

    /**
     * @param name
     * @return
     */
    public List<MoviePart> getByMovieName(String name) {

        List<MoviePart> movies = new ArrayList<>();
        //https://imdb-api.com/en/API/SearchMovie/k_j7pf3kr8/jaula
        StringBuilder url = new StringBuilder();
        url.append("https://imdb-api.com/en/API/SearchMovie/");
        url.append("k_j7pf3kr8/");
        url.append(name);

        OkHttpClient cliente = new OkHttpClient();
        Request solicitud = new Request.Builder().url(url.toString()).build();

        try (Response respuesta = cliente.newCall(solicitud).execute()) {
            log.info("codigo 200 de imdb : " + respuesta.code());

            if (respuesta.isSuccessful()) {
                String resultString = respuesta.body().string();

                JSONObject jsonObject = new JSONObject(resultString);
                String erroMje = (String) jsonObject.get("errorMessage");
                if (erroMje.equals("")) {
                    JSONArray array = jsonObject.getJSONArray("results");
                    if (array != null) {
                        for (int i = 0; i < array.length(); i++) {
                            MoviePart movie = new MoviePart();
                            movie.setTitle(array.getJSONObject(i).getString("title") != null ? array.getJSONObject(i).getString("title") : "");
                            movie.setIdImdb(array.getJSONObject(i).getString("id") != null ? array.getJSONObject(i).getString("id") : "");
                            movies.add(movie);
                        }

                    }
                } else {
                    log.info("Error al obtner datos : " + erroMje);
                }


            }
        } catch (IOException ex) {

        }

        return movies;

    }


}
