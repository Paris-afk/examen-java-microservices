package com.example.mymovie.controller;

import com.example.mymovie.model.Acteur;
import com.example.mymovie.model.Film;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(value = "Swagger2DemoRestController", description = "REST Apis related to Film Entity!!!!")
@RestController
public class FilmController {

    @ApiOperation(value = "Get list of Films in the System ", response = Film.class, tags = "getFilms")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })


    @RequestMapping("/films")
    public List<Film> getAllFilms() {
        ArrayList<Acteur> acteurs = new ArrayList<>();
        ArrayList<Film> films = new ArrayList<>();
        Acteur Paris = new Acteur("Lopez", "Paris", "12/01/1998");
        Film pelicula = new Film("Monster", "Per", new Acteur[]{Paris}, "11/11/2022");
        acteurs.add(new Acteur("Henry", "Alz", "10/01/1893", pelicula));
        films.add(pelicula);
        acteurs.add(Paris);
        Acteur Obed = new Acteur("Lopez", "Paris", "12/01/1998", new Film("peligro", "Pa", new Acteur[]{Paris}, "15/03/1999"));
        films.add(new Film("Accion", "Director", new Acteur[]{Obed}, "12/12/1998"));
        return films;
    }
    @ApiOperation(value = "Get Film by title", response = Film.class, tags = "getFilms By title")
    @RequestMapping(value = "/films/{titre}", method = RequestMethod.GET)
    public List<Film> getFilmsByTitle(@PathVariable String titre){

        ArrayList<Acteur> acteurs = new ArrayList<>();
        ArrayList<Film> films = new ArrayList<>();
        Acteur Paris = new Acteur("Lopez", "Paris", "12/01/1998");
        Film pelicula = new Film("Monster", "Per", new Acteur[]{Paris}, "11/11/2022");
        acteurs.add(new Acteur("Henry", "Alz", "10/01/1893", pelicula));
        films.add(pelicula);
        acteurs.add(Paris);
        Acteur Obed = new Acteur("Lopez", "Paris", "12/01/1998", new Film("peligro", "Pa", new Acteur[]{Paris}, "15/03/1999"));
        films.add(new Film("Accion", "Director", new Acteur[]{Obed}, "12/12/1998"));

        var result = films.stream().filter(film -> film.getTitre().equals(titre)).collect(Collectors.toList());


        System.out.println("result" + result);
        return  result;
    }
    @ApiOperation(value = "Get Film by date", response = Film.class, tags = "getFilms By date")
    @RequestMapping(value = "/films/date/{date}", method = RequestMethod.GET)
    public List<Film> getFilmsByDate(@PathVariable String date){

        ArrayList<Acteur> acteurs = new ArrayList<>();
        ArrayList<Film> films = new ArrayList<>();
        Acteur Paris = new Acteur("Lopez", "Paris", "12/01/1998");
        Film pelicula = new Film("Monster", "Per", new Acteur[]{Paris}, "11-11-2022");
        acteurs.add(new Acteur("Henry", "Alz", "10/01/1893", pelicula));
        films.add(pelicula);
        acteurs.add(Paris);
        Acteur Obed = new Acteur("Lopez", "Paris", "12/01/1998", new Film("peligro", "Pa", new Acteur[]{Paris}, "15/03/1999"));
        films.add(new Film("Accion", "Director", new Acteur[]{Obed}, "12-12-1998"));
        Film pelicula2 = new Film("Indiana", "Per", new Acteur[]{Obed}, "11-11-2022");
        films.add(pelicula2);
        var result = films.stream().filter(film -> film.getDateDeSortie().equals(date)).collect(Collectors.toList());


        System.out.println("result" + result);
        return  result;
    }
}
