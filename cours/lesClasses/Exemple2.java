public class Exemple2 {
    /**
        * point d'entrée de l'application
    */
    
    public static void main(String[] args) {
        Personne p1 = new Personne("MARTIN", "Paul");
        p1.setAdresse("5", "rue des Alouettes", "REIMS");
        
        Personne p2 = new Personne("MERCIER", "Anne");
        p2.setAdresse("8", "avenue Roberspierre", "EPERNAY");
        
        Personne p3 = p2;
        
        p1.afficher();
        p2.afficher();
        p3.afficher();
        System.out.println("----------------------");
        
        p2.setNom("BOUCHOT");
        p1.afficher();
        p2.afficher();
        p3.afficher();
        
        System.out.println("----------------");
        System.out.println("références mémoires");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        
        p1 = null; // l'objet précédement référencé
                   // n'est plus accessible 
                   // l'objet sera détruit par le ramasse miette
        
        p2 = null;
        p3.afficher();
    }
}