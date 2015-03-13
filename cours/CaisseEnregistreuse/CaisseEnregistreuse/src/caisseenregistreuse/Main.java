/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caisseenregistreuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author slam
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.demarrer();
    }
    
    public void demarrer() {
        Connection connection = null;
        PreparedStatement requete = null;
        ResultSet resultat = null;
        
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); // chargement du pilote (driver) permettant d'accéder au SGBDR            
            connection = DriverManager.getConnection("jdbc:derby:db_produit;create=true");     // création et connexion à la base db_produit
        } catch (ClassNotFoundException e) {
            System.err.println("erreur driver non trouvé table produit ne peut pas être créee");
            System.err.println("erreur 1"+ e.getMessage());
            System.exit(1);
        } catch (SQLException e) {
            System.err.println("erreur SQL au moment de la connection Main");
            System.err.println("erreur 2 : " + e.getMessage());
            System.exit(1);
        }
        
        try {
            requete = connection.prepareStatement("drop table if exists produit");
            requete.execute();
        } catch (SQLException e) {
            if (e.getSQLState().compareTo("42Y55") != 0) {
                // le code d'erreur n'est pas 42Y55 : il y a un problème
                System.err.println("erreur lors de la destruction de la table \"produit\"");
                System.err.println(e.getMessage());
                System.err.println(e.getErrorCode());
                System.err.println(e.getSQLState());
                System.exit(1);
            }
        }
        
        try {
            requete = connection.prepareStatement("create table produit(id int, nomproduit varchar(30), libelle varchar(30), prix float, primary key(id))");
            requete.execute();
        } catch (SQLException e) {
            System.err.println("erreur lors de la création de la table \"produit\" dans le Main.java");
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            System.err.println(e.getSQLState());
            System.exit(1);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AffichageCaisse().setVisible(true);
            }
        });
    }
}
