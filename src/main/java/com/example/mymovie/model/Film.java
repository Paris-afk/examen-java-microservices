package com.example.mymovie.model;
import io.swagger.annotations.ApiModelProperty;
public class Film {
    @ApiModelProperty(notes = "Titre of the movie",name="titre",required=true,value="test titre")
    private String titre;
    @ApiModelProperty(notes = "realisateur of the movie",name="realisateur",required=true,value="test realisateur")
    private String realisateur;
    @ApiModelProperty(notes = "Acteur of the movie",name="acteurPrincipal",required=true,value="test acteurPrincipal")
    private Acteur[] acteurPrincipal;
    @ApiModelProperty(notes = "dateDeSortie of the movie",name="dateDeSortie",required=true,value="test dateDeSortie")
    private String dateDeSortie;

    public Film(String titre, String realisateur, Acteur[] acteurPrincipal, String dateDeSortie) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.acteurPrincipal = acteurPrincipal;
        this.dateDeSortie = dateDeSortie;
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public Acteur[] getActeurPrincipal() {
        return acteurPrincipal;
    }

    public void setActeurPrincipal(Acteur[] acteurPrincipal) {
        this.acteurPrincipal = acteurPrincipal;
    }

    public String getDateDeSortie() {
        return dateDeSortie;
    }

    public void setDateDeSortie(String dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }
}

