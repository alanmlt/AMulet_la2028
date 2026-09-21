package sio.la2028.database;

import sio.la2028.model.Athlete;
import sio.la2028.model.Pays;
import sio.la2028.model.Sport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoSport {

    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    public static ArrayList<Sport> getLesSports(Connection cnx){

        ArrayList<Sport> lesSports = new ArrayList<Sport>();
        try{
            requeteSql = cnx.prepareStatement("select * from sport");
            //System.out.println("REQ="+ requeteSql);
            resultatRequete = requeteSql.executeQuery();

            while (resultatRequete.next()){

                Sport s = new Sport();
                s.setId(resultatRequete.getInt("id"));
                s.setNom(resultatRequete.getString("nom"));

                lesSports.add(s);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLessports e généré une erreur");
        }
        return lesSports;

    }

    public static ArrayList<Athlete> getSportByAthleteById(Connection cnx, int idSport) {

        ArrayList<Athlete> lesAthletes = new ArrayList<Athlete>();
        try {
            requeteSql = cnx.prepareStatement(
                    "select a.id as a_id, a.prenom as a_prenom, a.nom as a_nom, s.id as s_id, s.nom as s_nom " +
                            "from athlete a inner join sport s " +
                            "on a.sport_id = s.id " +
                            "where s.id = ?"
            );

            requeteSql.setInt(1, idSport);
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
