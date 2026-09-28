package sio.la2028.database;

import sio.la2028.model.Athlete;
import sio.la2028.model.Site;
import sio.la2028.model.Sport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoSite {

    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    public static ArrayList<Site> getLesSites(Connection cnx) {

        ArrayList<Site> lesSites = new ArrayList<Site>();
        try {
            requeteSql = cnx.prepareStatement("select * from Site");
            //System.out.println("REQ="+ requeteSql);
            resultatRequete = requeteSql.executeQuery();

            while (resultatRequete.next()) {

                Site si = new Site();
                si.setId(resultatRequete.getInt("id"));
                si.setNom(resultatRequete.getString("nom"));

                lesSites.add(si);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLesSites e généré une erreur");
        }
        return lesSites;

    }

    public static Site getSiteById(Connection cnx, int idSite) {

        Site si = new Site();
        try {
            requeteSql = cnx.prepareStatement("select si.id as si_id, si.nom as si_nom" +
                    " from Site si " +
                    " where si.id = ? ");
            //System.out.println("REQ="+ requeteSql);
            requeteSql.setInt(1, idSite);
            resultatRequete = requeteSql.executeQuery();

            if (resultatRequete.next()) {

                si.setId(resultatRequete.getInt("si_id"));
                si.setNom(resultatRequete.getString("si_nom"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return si;
    }

    public static ArrayList<Sport> getSportBySiteById(Connection cnx, int idSport) {

        ArrayList<Sport> lesSports = new ArrayList<Sport>();
        try {
            requeteSql = cnx.prepareStatement(
                    "select s.id as s_id, s.nom as s_nom, si.id as si_id, si.nom as si_nom " +
                            "from sport s " +
                            "inner join site si ON s.site_id = si.id " +
                            " where si.id = ?"
            );

            requeteSql.setInt(1, idSport);
            resultatRequete = requeteSql.executeQuery();

            while (resultatRequete.next()) {
                Sport s =  new Sport();
                s.setId(resultatRequete.getInt("s_id"));
                s.setNom(resultatRequete.getString("s_nom"));

                lesSports.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return  lesSports;
    }
}
