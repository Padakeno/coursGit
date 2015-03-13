package demo_jdbc;

import java.sql.*;

/**
 * Cet exemple montre le fonctionnement de JDBC.
 * On accède à la base de données "exempleJDBC" pour y insérer, mettre à jour, supprimer et récupérer des informations sur des personnes. 
 */
public class  DemoJDBC {
	public static void main(String args[]) {
		DemoJDBC DemoJDBC = new DemoJDBC();
		DemoJDBC.demarrer();		
	}

	/**
	 * constructeur par défaut
	 */
	public DemoJDBC () {
	}
	
	public void demarrer() {
            Connection connection = null;
            PreparedStatement requete = null;
            ResultSet resultat = null;
		
		// connexion a la base de donnees
            try {
		Class.forName("org.postgresql.Driver"); // chargement du pilote (driver) permettant d'accéder au SGBDR
		connection = DriverManager.getConnection("jdbc:postgresql:demo_jdbc", "uti_demo", "uti_demo"); // chemin de la base, utilisateur, mot de passe
            } catch(ClassNotFoundException e) {
		System.err.println("erreur driver non trouvé");
		e.printStackTrace();
		System.exit(1);
            } catch(SQLException e) {
		System.err.println("erreur SQL au moment de la connection");
		e.printStackTrace();
		System.exit(1);
            }

		// insertion
            try {
		requete = connection.prepareStatement("insert into personne(id, nom, prenom, dateNaissance) values (?, ?, ?, ?)");
		requete.setInt(1, 2); // 1 => 1er point d'interrogation
		requete.setString(2, "MARTIN"); // 2 => 2ème point d'interrogation
		requete.setString(3, "Paul"); // 3 => 3ème point d'interrogation
		requete.setDate(4, Date.valueOf("1981-05-23")); // 4 => 4ème point d'interrogation
		// attention, les dates qui sont manipulées ici sont des instances de la classe Date du paquetage java.sql
		// à ne pas confondre avec la classe Date du paquetage java.util
			
		requete.executeUpdate();
            }
		catch(SQLException e) {
		e.printStackTrace();
		System.err.println("erreur lors de l'insertion");
		System.exit(1);	
            }
		
		// mise à jour
            try {
		requete = connection.prepareStatement("update personne set prenom=? where nom=? and dateNaissance=?");
		requete.setString(1, "Romain");
		requete.setString(2, "MARTIN");
		requete.setDate(3, Date.valueOf("1981-05-23"));
		requete.executeUpdate();
            } catch(SQLException e) {
		e.printStackTrace();
		System.err.println("erreur lors de la mise à jour");
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
            } catch(SQLException e) {
		e.printStackTrace();
		System.err.println("erreur lors de la sélection");
		System.exit(1);	
            }

        // suppression
            try {
		requete = connection.prepareStatement("delete from personne where nom=? and dateNaissance=?");
		requete.setString(1, "MARTIN");
		requete.setDate(2, Date.valueOf("1981-05-23"));
		requete.executeUpdate();
            } catch(SQLException e) {
		e.printStackTrace();
		System.err.println("erreur lors de la mise à jour");
		System.exit(1);	
            }
		
	}
}
