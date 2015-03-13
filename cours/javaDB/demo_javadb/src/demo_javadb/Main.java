package demo_javadb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Ce programme démontre l'utilisation de JavaDB (Derby).
 * Un dossier portant le nom de la base utilisée ainsi qu'un fichier derby.log sont créés sur le disque à l'endroit
 * où la machine virtuelle est lancée.
 * @author A. FRANÇOIS
 */
public class Main {

    /**
     * @param args paramètres de la ligne de commande
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.demarrer();
    }

    private void demarrer() {
        Connection connection = null;
        PreparedStatement requete = null;
        ResultSet resultat = null;

        // connexion a la base de données (bd_personne)
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); // chargement du pilote (driver) permettant d'accéder au SGBDR            
            connection = DriverManager.getConnection("jdbc:derby:bd_personne;create=true");     // création et connexion à la base bd_personne
            // create=true indique que si la base n'existe pas alors elle sera créée
        } catch (ClassNotFoundException e) {
            System.err.println("erreur driver non trouvé table personne ne peut pas être créee");
            System.exit(1);
        } catch (SQLException e) {
            System.err.println("erreur SQL au moment de la connection");
            System.err.println(e.getMessage());
            System.exit(1);
        }


        // création d'une table
        try {
            // si la table existe déjà, il faut la détruire au préalable
            requete = connection.prepareStatement("drop table personne");
            requete.execute();
        } catch (SQLException e) {
            // 42Y55 correspond au code d'erreur signalant que la table n'existe pas
            if (e.getSQLState().compareTo("42Y55") != 0) {
                // le code d'erreur n'est pas 42Y55 : il y a un problème
                System.err.println("erreur lors de la destruction de la table \"personne\"");
                System.err.println(e.getMessage());
                System.err.println(e.getErrorCode());
                System.err.println(e.getSQLState());
                System.exit(1);
            }
            // la table n'existe pas on peut continuer
        }

        try {
            requete = connection.prepareStatement("create table personne(id integer not null generated always as identity, nom varchar(30), prenom varchar(30), dateNaissance date, primary key(id))");
            requete.execute();
        } catch (SQLException e) {
            System.err.println("erreur lors de la création de la table \"personne\"");
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            System.err.println(e.getSQLState());
            System.exit(1);
        }

        // insertion
        try {
            requete = connection.prepareStatement("insert into personne(nom, prenom, dateNaissance) values (?, ?, ?)");
            requete.setString(1, "MARTIN"); // 1 => 1er point d'interrogation
            requete.setString(2, "Paul"); // 2 => 2ème point d'interrogation
            requete.setDate(3, Date.valueOf("1981-05-23")); // 3 => 3ème point d'interrogation
            // attention, les dates qui sont manipulées ici sont des instances de la classe Date du paquetage java.sql
            // à ne pas confondre avec la classe Date du paquetage java.util

            requete.executeUpdate();
        } catch (SQLException e) {
            System.err.println("erreur lors de l'insertion");
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            System.err.println(e.getSQLState());
            System.exit(1);
        }

        // mise à jour
        try {
            requete = connection.prepareStatement("update personne set prenom=? where nom=? and dateNaissance=?");
            requete.setString(1, "Romain");
            requete.setString(2, "MARTIN");
            requete.setDate(3, Date.valueOf("1981-05-23"));

            requete.executeUpdate();
        } catch (SQLException e) {
            System.err.println("erreur lors de la mise à jour");
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            System.err.println(e.getSQLState());
            System.exit(1);
        }

        // sélection
        try {
            requete = connection.prepareStatement("select * from personne where datenaissance > ?");
            requete.setDate(1, Date.valueOf("1945-01-01"));

            resultat = requete.executeQuery();
            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String dateNaissance = resultat.getDate("datenaissance").toString();

                System.out.println(nom + "   " + prenom + " " + dateNaissance);
            }
        } catch (SQLException e) {
            System.err.println("erreur lors de la sélection");
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            System.err.println(e.getSQLState());
            System.exit(1);
        }

        // suppression
        try {
            requete = connection.prepareStatement("delete from personne where nom=? and dateNaissance=?");
            requete.setString(1, "MARTIN");
            requete.setDate(2, Date.valueOf("1981-05-23"));

            requete.executeUpdate();
        } catch (SQLException e) {
            System.err.println("erreur lors de la mise à jour");
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            System.err.println(e.getSQLState());
            System.exit(1);
        }
    }
}
