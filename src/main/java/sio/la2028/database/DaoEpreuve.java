package sio.la2028.database;

import sio.la2028.model.Athlete;
import sio.la2028.model.Epreuve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEpreuve {

    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    public static ArrayList<Epreuve> getLesEpreuves(Connection cnx){

        ArrayList<Epreuve> lesEpreuves = new ArrayList<Epreuve>();
        try{
            requeteSql = cnx.prepareStatement("select * from Epreuve");
            //System.out.println("REQ="+ requeteSql);
            resultatRequete = requeteSql.executeQuery();

            while (resultatRequete.next()){

                Epreuve e = new Epreuve();
                e.setId(resultatRequete.getInt("id"));
                e.setNom(resultatRequete.getString("nom"));

                lesEpreuves.add(e);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesEpreuves e généré une erreur");
        }
        return lesEpreuves;

    }

    public static Epreuve getEpreuveById(Connection cnx, int idEpreuve){

        Epreuve ep = new Epreuve();
        try{
            requeteSql = cnx.prepareStatement("select e.id as e_id, e.nom as e_nom" +
                    " from Epreuve e " +
                    " where e.id = ? ");
            //System.out.println("REQ="+ requeteSql);
            requeteSql.setInt(1, idEpreuve);
            resultatRequete = requeteSql.executeQuery();

            if (resultatRequete.next()){

                ep.setId(resultatRequete.getInt("e_id"));
                ep.setNom(resultatRequete.getString("e_nom"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ep;
    }

    public static ArrayList<Athlete> getEpreuveByAthleteById(Connection cnx, int idEpreuve) {

        ArrayList<Athlete> lesAthletes = new ArrayList<Athlete>();
        try {
            requeteSql = cnx.prepareStatement(
                    "select a.id as a_id, a.prenom as a_prenom, a.nom as a_nom, e.id as e_id, e.nom as e_nom " +
                            "from athlete a " +
                            "inner join epreuve e ON a.epreuve_id = e.id " +
                            "inner join sport s ON s.id = e.sport_id" +
                            " where e.id = ?"
            );

            requeteSql.setInt(1, idEpreuve);
            resultatRequete = requeteSql.executeQuery();

            while (resultatRequete.next()) {
                Athlete a =  new Athlete();
                a.setId(resultatRequete.getInt("a_id"));
                a.setNom(resultatRequete.getString("a_nom"));
                a.setPrenom(resultatRequete.getString("a_prenom"));

                lesAthletes.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return  lesAthletes;
    }
}