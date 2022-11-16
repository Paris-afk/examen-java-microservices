package com.example.mymovie.model;
import io.swagger.annotations.ApiModelProperty;
public class Acteur {
    @ApiModelProperty(notes = "Name of the Acteur",name="nom",required=true,value="test name")
    private String nom;
    @ApiModelProperty(notes = "Prenom of the Acteur",name="prenom",required=true,value="test prenom")
    private String prenom;

    @ApiModelProperty(notes = "Date de Naissaince of the Acteur",name="dateDeNaissaince",required=true,value="test date")
    private String dateDeNaissaince;
    @ApiModelProperty(notes = "Film of the actor",name="film",required=true,value="test film")
    private Film film;


    public Acteur(String nom, String prenom, String dateDeNaissaince, Film film) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissaince = dateDeNaissaince;
        this.film = film;
    }
    public Acteur(String nom, String prenom, String dateDeNaissaince) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissaince = dateDeNaissaince;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateDeNaissaince() {
        return dateDeNaissaince;
    }

    public void setDateDeNaissaince(String dateDeNaissaince) {
        this.dateDeNaissaince = dateDeNaissaince;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
