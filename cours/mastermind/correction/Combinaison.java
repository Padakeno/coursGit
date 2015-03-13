import java.util.Scanner;

/**
 * une combinaison comporte 4 couleurs différentes
 */
public class Combinaison {
    private int case1;
    private int case2;
    private int case3;
    private int case4;

    // constructeur par défaut (sans paramètre)
    public Combinaison() {
    }

    public Combinaison(int case1, int case2, int case3, int case4) {
        this.case1 = case1;
        this.case2 = case2;
        this.case3 = case3;
        this.case4 = case4;
    }


    public void afficher() {
        String chaine = null;

        for(int i=0; i<4; i++) {
            switch(getCases()[i]) {
                case Main.ROUGE : chaine = "rouge"; break;
                case Main.BLEU : chaine = "bleu"; break;
                case Main.JAUNE : chaine = "jaune"; break;
                case Main.VERT : chaine = "vert"; break;
                case Main.ORANGE : chaine = "orange"; break;
                case Main.BLANC : chaine = "blanc"; break;
                case Main.VIOLET : chaine = "violet"; break;
                case Main.FUCHSIA : chaine = "fuchsia"; break;
            }
            System.out.print(chaine + " ");
        }
    }

    public boolean estEgale(Combinaison c) {
        boolean resultat = false;

        if (this.case1 == c.case1 &&
            this.case2 == c.case2 &&
            this.case3 == c.case3 &&
            this.case4 == c.case4) {
            resultat = true;
        }

        return resultat;
    }

    public int nbBienPlaces(Combinaison c) {
        int resultat = 0;

        if (this.case1 == c.case1) resultat++;
        if (this.case2 == c.case2) resultat++;
        if (this.case3 == c.case3) resultat++;
        if (this.case4 == c.case4) resultat++;    
           
        return resultat;
    }

    public int nbMalPlaces(Combinaison c) {
        int resultat = 0;

        if (this.case1 == c.case2 ||
            this.case1 == c.case3 ||
            this.case1 == c.case4) resultat++;

        if (this.case2 == c.case1 ||
            this.case2 == c.case3 ||
            this.case2 == c.case4) resultat++;

        if (this.case3 == c.case1 ||
            this.case3 == c.case2 ||
            this.case3 == c.case4) resultat++;

        if (this.case4 == c.case1 ||
            this.case4 == c.case2 ||
            this.case4 == c.case3) resultat++;

        return resultat;
    }

    public void saisir() {
        // on suppose (dans un premier temps) que l'on ne se trompe pas dans la saisie
        // nous utiliserons plus tard les expressions rationnelles pour gérer la validation des données
        System.out.println("1-Rouge  2-Bleu  3-Jaune  4-Vert  5-Orange  6-Blanc  7-Violet  8-Fuchsia");
        System.out.print("Votre choix :");
        Scanner scanner = new Scanner(System.in);
        this.case1 = scanner.nextInt();
        this.case2 = scanner.nextInt();
        this.case3 = scanner.nextInt();
        this.case4 = scanner.nextInt();
    }
    

    public void generer() {
        boolean[] couleurs = new boolean[9]; // par défaut un tableau de booléens est initialisé à "false"
        int[] tirage = new int[4];
        int i = 0;
        while (i<4) {
            int nb = nbAleatoire(1, 8);
            if (!couleurs[nb]) {
                // la couleur n'a pas encore été tirée
                couleurs[nb] = true;
                tirage[i] = nb;
                i++;
            }
        }
        this.case1 = tirage[0];
        this.case2 = tirage[1];
        this.case3 = tirage[2];
        this.case4 = tirage[3];
    }

    // Écrire une fonction qui renvoie un nombre entier compris entre deux nombres entiers passés en paramètre
    // voir méthodes "round" et "random"
    /**
     * renvoie un nombre entier (de type int) compris entre min (inclus) et max (inclus)
     */
    private int nbAleatoire(int min, int max) {
        return ((int)Math.round(Math.random()*(max-min))) + min;
    }

    private int[] getCases() {
        int[] resultat = {this.case1, this.case2, this.case3, this.case4};
        return resultat;
    }
}