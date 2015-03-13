/**
 * Cette classe permet de tester la classe Chrono
 *
 * @author Arnaud FRANCOIS
 */
 public class DemoChrono {
    public static void main(String[] args) {
        String[] items = {"Demarrer", "Arreter", "Afficher", "Mettre à zéro"};
        Chrono monChrono = new Chrono();
        Menu monMenu = new Menu(items);
        
        int choix = monMenu.gerer();
        while (choix != 0) {
            if(choix == 1) {
                System.out.println("Le chrono est démarrer ...");
                monChrono.demarrer();
            } else if(choix == 2) {
                System.out.println("Le chrono est arrêté ...");
                monChrono.arreter();
            } else if(choix == 3) {
                attendre(3456);
                System.out.println("temps : " + monChrono.getTempsEcoule());
                System.out.println("temps : " + monChrono.getTempsEcouleFormate());
                
                attendre(1000);
                monChrono.arreter();
                System.out.println("temps : " + monChrono.getTempsEcoule());
                System.out.println("temps : " + monChrono.getTempsEcouleFormate());

                monChrono.mettreAZero();
                monChrono.demarrer();
                
                attendre(1500);
                System.out.println("temps : " + monChrono.getTempsEcoule());
                System.out.println("temps : " + monChrono.getTempsEcouleFormate());
            } else if(choix == 4) {
                monChrono.mettreAZero();
            }
            
            choix = monMenu.gerer();
        }
        
 
        
    }
    
    
    private static void attendre(int duree) {
        try {
            Thread.sleep(duree); // mise en sommeil pendant "duree" millisecondes
        } catch (Exception e) {
            // on ne fait rien en cas d'imprévu
        }
    }
}