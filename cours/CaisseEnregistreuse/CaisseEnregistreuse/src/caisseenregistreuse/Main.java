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
import java.util.ArrayList;

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
        /*Produit p1 = new Produit(1, "legume", 1.20);
        Produit p2 = new Produit(2, "legume", 1.20);
        Produit p3 = new Produit(3, "legume", 1.20);
        Produit p4 = new Produit(4, "legume", 1.20);
        Produit p5 = new Produit(5, "legume", 1.20);
        Produit p6 = new Produit(6, "fruit", 1.00);*/
        
        ArrayList<Produit> produits = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();
        
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
            requete = connection.prepareStatement("drop table produit");
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
            requete = connection.prepareStatement("create table produit(id int, nomproduit varchar(30), libelle varchar(30), prix double, primary key(id))");
            requete.execute();
        } catch (SQLException e) {
            System.err.println("erreur lors de la création de la table \"produit\" dans le Main.java");
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            System.err.println(e.getSQLState());
            System.exit(1);
        }
        
        try {
            requete = connection.prepareStatement("insert into produit values (?, ?, ?, ?)");
            requete.setInt(1, 1);
            requete.setString(2, "legume");
            requete.setString(3, "legume frais pour vous");
            requete.setDouble(4, 15.90);
            requete.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("erreur lors de l'insertion");
            System.exit(1);	
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AffichageCaisse(produits).setVisible(true);
            }
        });
    }
}
