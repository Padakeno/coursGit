import java.util.Scanner;
/*
    Creer une classe Menu
    
    - un constructeur qui permet de spécifier les items du menu (sauf 'quitter' car on doit toujours avoir la possibilité de quitter un menu
    => utilisation d'un tableau String
    - une méthode "gérer" qui a pour fonction
    - 1. afficher le menu
    - 2. saisir la réponse de l'utilisateur
    - 3. elle renvoie le choix de l'utilisateur sous la forme d'un entier

    exemple : 
    
    1 - Démarrer
    2 - Afficher
    3 - Arrêter
    4 - Mettre à jour
    0 - Quitter
    
    Votre choix : ? 
    
*/

public class Menu {
    // variable d'instance 
    private String[] items;
    
    public Menu(String[] items) {
        this.items = items;
    }
    
    /**
        * renvoyer le choix de l'utilisateur 
    */
    
    public int gerer() {
        int resultat = 0;
        
        //afficher
        for(int i=0; i<items.length; i++) {
            System.out.println((i+1) + " - " + items[i]);
        }
        System.out.println("0 - Quitter");
        
        //saisir
        System.out.println("Choix : ?");
        Scanner scanner = new Scanner(System.in);
        do {
            resultat = scanner.nextInt();
        } while(resultat < 0 || resultat > items.length);
        
        return resultat;
    }
    
    
}