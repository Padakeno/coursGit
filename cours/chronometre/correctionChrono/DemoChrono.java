/**
 * Cette classe permet de tester la classe Chrono
 *
 * @author Arnaud FRANCOIS
 */
 public class DemoChrono {
    public static void main(String[] args) {
        Chrono monChrono = new Chrono();
        
        monChrono.demarrer();
 
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
    }
    
    
    private static void attendre(int duree) {
        try {
            Thread.sleep(duree); // mise en sommeil pendant "duree" millisecondes
        } catch (Exception e) {
            // on ne fait rien en cas d'imprévu
        }
    }
}