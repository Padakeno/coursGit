/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogue_java_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

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
        List<TitreCode> titre = new ArrayList<>();
        List<String> tags = new ArrayList<>();
        Connection connection = null;
        PreparedStatement requete = null;
        ResultSet resultat = null;
        
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); // chargement du pilote (driver) permettant d'accéder au SGBDR            
            connection = DriverManager.getConnection("jdbc:derby:bd_listecode;create=true");     // création et connexion à la base bd_listecode
        } catch (ClassNotFoundException e) {
            System.err.println("erreur driver non trouvé table personne ne peut pas être créee");
            System.err.println("erreur 1"+ e.getMessage());
            System.exit(1);
        } catch (SQLException e) {
            System.err.println("erreur SQL au moment de la connection Main");
            System.err.println("erreur 2 : " + e.getMessage());
            System.exit(1);
        }


        // création d'une table
        try {
            requete = connection.prepareStatement("drop table listecode");
            requete.execute();
        } catch (SQLException e) {
            if (e.getSQLState().compareTo("42Y55") != 0) {
                // le code d'erreur n'est pas 42Y55 : il y a un problème
                System.err.println("erreur lors de la destruction de la table \"listecode\"");
                System.err.println(e.getMessage());
                System.err.println(e.getErrorCode());
                System.err.println(e.getSQLState());
                System.exit(1);
            }
        }
        try {
            requete = connection.prepareStatement("create table listecode(titre varchar(20) not null,code varchar(200),tag1 varchar(30),tag2 varchar(30),tag3 varchar(30),tag4 varchar(30),primary key(titre))");
            requete.execute();
        } catch (SQLException e) {
            System.err.println("erreur lors de la création de la table \"listecode\"");
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            System.err.println(e.getSQLState());
            System.exit(1);
        }
        
        //insertion
        try {
            requete = connection.prepareStatement("insert into listecode(titre, code, tag1, tag2, tag3, tag4) values ('Testcode1', 'code', 'tag1', 'tag2', 'tag3', 'tag4')");
            
            requete.executeUpdate();
        } catch (SQLException e) {
            System.err.println("erreur lors de l'insertion");
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            System.err.println(e.getSQLState());
            System.exit(1);
        }
        
        try {
            requete = connection.prepareStatement("select * from listecode");
            resultat = requete.executeQuery();
		while (resultat.next()) {
                    String nomCode = resultat.getString("titre");
                    String code = resultat.getString("code");
                    titre.add(new TitreCode(nomCode, code));
                    
                    for (int i=0; i<4; i++) {
                        String variable = "tag"+i;
                        variable = resultat.getString("tag"+i);
                        tags.add(variable);
                    }
		}
        } catch (SQLException e) {
            System.err.println("erreur lors de la selection");
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            System.err.println(e.getSQLState());
            System.exit(1);
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // affichage de l'interface graphique                
                FenetreMain fm = new FenetreMain(titre);
                fm.setLocationRelativeTo(null);  // centrage de la fenêtre
                fm.setVisible(true);
                fm.setSize(600, 500);
            }
        });
    }
    
}

