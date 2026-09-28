package sio.la2028.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Site {

    private int id;
    private String nom;
    private ArrayList<Sport> lesSports;

    public Site(){
    }

    public Site(int id, String nom){
        this.id = id;
        this.nom = nom;
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

    public ArrayList<Sport> getLesSports() {
        return lesSports;
    }

    public void setLesSports(ArrayList<Sport> lesSports) {
        this.lesSports = lesSports;
    }

    public void addSport(Sport e){

        if (lesSports == null){
            lesSports = new ArrayList<Sport>();
        }
        lesSports.add(e);
    }
}
