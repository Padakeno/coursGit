package caisseenregistreuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JList;

/**
 *
 * @author slam
 */
public class AffichageCaisse extends javax.swing.JFrame {
    private ArrayList<Produit> produits;
    private ListeProduit lp;
    private int numeroProduit;
    
    Connection connection = null;
    PreparedStatement requete = null;
    ResultSet resultat = null;
    
    public AffichageCaisse(ArrayList<Produit> produits) {
        this.produits = produits;
        /*this.lp = new ListeProduit(produits);*/
        initComponents();
        
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); // chargement du pilote (driver) permettant d'accéder au SGBDR
            connection = DriverManager.getConnection("jdbc:derby:db_produit;create=true"); // chemin de la base, utilisateur, mot de passe
	} catch(ClassNotFoundException e) {
            System.err.println("erreur driver non trouvé dans AffichageCaisse");
            System.exit(1);
        } catch(SQLException e) {
            System.err.println("erreur SQL au moment de la connection dans AffichageMain");
            System.exit(1);
        }
    }
    
    public void envoyer(String s) {
        numeroProduit = Integer.parseInt(s);
        
        try {
            requete = connection.prepareStatement("select * from produit where id = ?");
            requete.setInt(1, numeroProduit);
            resultat = requete.executeQuery();
            while (resultat.next()) {
                String nomProduit = resultat.getString("nomProduit");
                double prix = resultat.getDouble("prix");
                try {
                    requete = connection.prepareStatement("insert into recupProduit values (?, ?, ?)");
                    requete.setInt(1, numeroProduit);
                    requete.setString(2, nomProduit);
                    requete.setDouble(3, prix);
                    requete.execute();
                } catch(SQLException e) {
                    e.printStackTrace();
                    System.err.println("erreur lors de l'insertion");
                    System.exit(1);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("erreur lors de l'insertion");
            System.exit(1);	
        }
    }
    
    
    /**
     *  NE PAS OUBLIER !! Lorsque l'on tape un produit avec les numéros, ces produits sont stokés dans ListeProduit, et cette même liste de produit est stocké dans Client
     * qui est lui même stoké dans listClient 
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
