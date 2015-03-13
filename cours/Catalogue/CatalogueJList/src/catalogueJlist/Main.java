/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogueJlist;

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
        
        Connection connection = null;
	PreparedStatement requete = null;
        ResultSet resultat = null; 
        
        try {
            Class.forName("org.postgresql.Driver"); // chargement du pilote (driver) permettant d'accéder au SGBDR
            connection = DriverManager.getConnection("jdbc:postgresql:db_catalogue", "administrator", "administrator"); // chemin de la base, utilisateur, mot de passe
	} catch(ClassNotFoundException e) {
            System.err.println("erreur driver non trouvé");
            System.exit(1);
        } catch(SQLException e) {
            System.err.println("erreur SQL au moment de la connection");
            System.exit(1);
        }
        
        try {
            requete = connection.prepareStatement("select * from listecode");
            resultat = requete.executeQuery();
		while (resultat.next()) {
                    String nomCode = resultat.getString("titre");
                    String code = resultat.getString("code");
                    titre.add(new TitreCode(nomCode, code));
		}
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("erreur lors de la suppression");
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

