package com.example.mymovie.controller;

import com.example.mymovie.model.Acteur;
import com.example.mymovie.model.Film;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Swagger2DemoRestController", description = "REST Apis related to Acteur Entity!!!!")

@RestController
public class ActeurController {
    @RequestMapping("/acteurs")
    public List<Acteur> getAllActeurs(){
        ArrayList<Acteur> acteurs = new ArrayList<>();

        Acteur Paris = new Acteur("Lopez","Paris","12/01/1998" );
        Film pelicula = new Film("Monster","Per", new Acteur[]{Paris}, "11/11/2022");
        acteurs.add(new Acteur("Henry","Alz","10/01/1893", pelicula));

        acteurs.add(Paris);
        return acteurs;
    }
    @ApiOperation(value = "Get acteur by name", response = Film.class, tags = "get Acteur By name")
    @RequestMapping(value = "/acteurs/{name}", method = RequestMethod.GET)
    public List<Acteur> getActeursByName(@PathVariable String name){
        ArrayList<Acteur> acteurs = new ArrayList<>();
        System.out.println("name" + name);
        Acteur Paris = new Acteur("Lopez","Paris","12/01/1998" );
        Film pelicula = new Film("Monster","Per", new Acteur[]{Paris}, "11/11/2022");
        acteurs.add(new Acteur("Henry","Alz","10/01/1893", pelicula));

        acteurs.add(Paris);

        var result = acteurs.stream().filter(person -> person.getNom().equals(name)).collect(Collectors.toList());


        System.out.println("result" + result);
        return  result;
    }
    @ApiOperation(value = "Get acteur by film name", response = Film.class, tags = "get Acteur By film name")
    @RequestMapping(value = "/acteurs/films/{name}", method = RequestMethod.GET)
    public List<Acteur> getActeursByFilm(@PathVariable String name){
        ArrayList<Acteur> acteurs = new ArrayList<>();
        System.out.println("name" + name);
        Acteur Paris = new Acteur("Lopez","Paris","12/01/1998" );
        Acteur Obed = new Acteur("Lopez","Paris","12/01/1998", new Film("peligro","Pa", new Acteur[]{Paris},"15/03/1999"));
        Film pelicula = new Film("Monster","Per", new Acteur[]{Paris}, "11/11/2022");
        acteurs.add(new Acteur("Henry","Alz","10/01/1893", pelicula));

        acteurs.add(Obed);
        ArrayList<Film> films = new ArrayList<>();
        films.add(pelicula);

        var result = acteurs.stream().filter(acteur -> acteur.getFilm().getTitre().equals(name)).collect(Collectors.toList());
        //var result = films.stream().filter(film -> Arrays.stream(film.getActeurPrincipal()).filter(acteur -> acteur.getNom() == name ).isParallel()).collect(Collectors.toList());


        System.out.println("result" + result);
        return  result;
    }







}
