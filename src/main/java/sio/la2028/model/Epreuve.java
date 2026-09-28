package sio.la2028.model;

import java.util.ArrayList;

public class Epreuve {
    private int id;
    private String nom ;
    private ArrayList<Athlete> lesAthletes ;

    public Epreuve() {
    }

    public Epreuve(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Epreuve(int id) {
        this.id = id;
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

    public ArrayList<Athlete> getLesAthletes() {
        return lesAthletes;
    }

    public void setLesAthletes(ArrayList<Athlete> lesAthletes) {
        this.lesAthletes = lesAthletes;
    }

    public void addAthlete(Athlete a){

        if (lesAthletes == null){
            lesAthletes = new ArrayList<Athlete>();
        }
        lesAthletes.add(a);
    }

}


