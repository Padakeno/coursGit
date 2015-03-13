package demo_classe_abstraite;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SalarieCDI salarie1 = new SalarieCDI("DUPONT", "Fabienne");
        SalarieCDD salarie2 = new SalarieCDD("DURANT", "Jean");
        Apprenti apprenti1 = new Apprenti("TAUPIN", "Samuel");
        Stagiaire stagiaire1 = new Stagiaire("MARECHAL", "Francis");
        Intervenant intervenant1 = new Intervenant("DUPONT", "Bernard");
        // Personne personne = new Personne("BARROT", "Marie"); // impossible

        ArrayList<Personne> equipe = new  ArrayList<Personne>();
        equipe.add(salarie1);
        equipe.add(salarie2);
        equipe.add(apprenti1);
        equipe.add(stagiaire1);
        equipe.add(intervenant1);
    }
}
