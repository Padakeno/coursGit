/*
    ici l'utilisateur saisira les différentes combinaisons possibles
*/
import java.util.scanner;
public class Combinaison {
    private String[] combinaison;
    Scanner scanner = new Scanner(System.in);
    
    public combinaison() {
        this.combinaison = combinaison;
    }
    
    public choix() {
        for(int i=0; i<combinaison.length; i++) {
            combinaison[i] = scanner.nextInt();
            if (combinaison[i] > 4 || combinaison[i] < 1) {
                while(combinaison[i] > 4 || combinaison[i] < 1) {
                    System.out.println("Chiffre incorrect veuillez retapez");
                    combinaison[i] = scanner.nextInt;
                }
            }   
        }
        return combinaison;
    }
    
    
}