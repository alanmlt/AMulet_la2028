/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.la2028.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author zakina
 */
public class Athlete {

    private int id;
    private String nom;
    private String prenom;
    private Pays pays;
    private Sport sport;
    private LocalDate dateNaiss;
    private ArrayList<Epreuve> lesEpreuves;


    public Athlete() {
    }

    public Athlete(int id, String nom, String prenom, LocalDate dateNaiss) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {this.sport = sport;}

    public String getPrenom() {return prenom;}

    public void setPrenom(String prenom) {this.prenom = prenom;}

    public LocalDate getDateNaiss() {return dateNaiss;}

    public void setDateNaiss(LocalDate dateNaiss) {this.dateNaiss = dateNaiss;}

    public Sport getLesAthletes() {
        return null;
    }

    public ArrayList<Epreuve> getLesEpreuves() {
        return lesEpreuves;
    }

    public void setLesEpreuves(ArrayList<Epreuve> lesEpreuves) {
        this.lesEpreuves = lesEpreuves;
    }

    public void addEpreuve(Epreuve e){

        if (lesEpreuves == null){
            lesEpreuves = new ArrayList<Epreuve>();
        }
        lesEpreuves.add(e);
    }
}
