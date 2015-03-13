import java.util.Scanner; 

public class DemoChrono {
    public static void main(String[] args) {
        
        Chrono monChrono = new Chrono();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.println("[d]émarrer le chrono\n[a]rreter le chrono\n[r]einitialiser\n[q]uitter le programme");
        String choix = scanner.next();
        
        while (choix.compareTo("q") != 0) {
            if (choix.compareTo("d") == 0) {
                System.out.println("Le chrono est démarré ...");
                monChrono.demarrer();
                try {
                    Thread.sleep(2000);
                } catch(Exception e) {}
            
            } else if ( choix.compareTo("a") == 0) {
                monChrono.arreter();
                System.out.println("temps écoulé: " + monChrono.donnerTemps());
            }
            
            choix = scanner.next();
        } 
    }
}