package gestionnairedetaches;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Permet de créer une liste des tâches à faire
 *
 * @author Grégory petit
 */
public class GestionnaireDeTaches {

    private ArrayList<Tache> taches;

    /**
     * Constructeur par défaut
     */
    public GestionnaireDeTaches() {
        taches = new ArrayList<Tache>(); 
        // commodité d'écriture : on peut aussi écrire : taches = new ArrayList<>();
        // sans rien à l'intérieur des chevrons
        // en effet, taches étant de type "ArrayList<Tache>" le compilateur déduit automatiquement
        // le type qui doit être utilisé pour le constructeur (ici Tache)
    }

    public void supprimerTache(int index) {
        taches.remove(index - 1);
    }

    public boolean tacheExiste(int nbTache) {
        return nbTache > 0 && nbTache <= taches.size();
    }

    public void ajouterSousTacheIndex(int indexTache, String nom, int prio, int etat) {
        Tache t = new Tache(nom, prio, etat);
        t.setNumeroExterne(indexTache);
        t.setNumeroInterne(taches.get(taches.size() - 1).nombreDeTaches() + 1);
        t.setEstSousTache(true);
        taches.get(indexTache - 1).ajouterSousTache(t);
    }

    public void modifierTache(int index, String nom) {
        taches.get(index - 1).modifier(nom);
    }

    public void modifierSousTache(String st, String nom) {
        String[] split = st.split("\\.");

        int maj = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);

        taches.get(maj - 1).modifierSousTache(min, nom);
    }

    public void ajouterTache(Tache t) {
        t.setNumeroExterne(taches.size());
        t.setNumeroInterne(taches.get(taches.size() - 1).nombreDeTaches());
        t.setEstSousTache(false);
        taches.add(t);
    }

    public void supprimerSousTache(String st) {
        String[] split = st.split("\\.");

        int maj = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);

        taches.get(maj - 1).supprimerTache(min);
    }

    public boolean sousTacheExiste(String st) {
        String[] split = st.split("\\.");

        int maj = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);

        if (!tacheExiste(maj)) {
            return false;
        }
        
        return taches.get(maj - 1).sousTacheExiste(min);
        /*if (taches.get(maj - 1).sousTacheExiste(min)) {
            return true;
        } else {
            return false;
        }*/
    }

    public void ajouterTache(String nom, int priorite, int etat) {
        Tache t = new Tache(nom, priorite, etat);
        
        t.setNumeroExterne(taches.size() + 1);
        t.setNumeroInterne(0);
        t.setEstSousTache(false);
        
        taches.add(t);
    }

    public void ajouterSousTache(String nom, int prio, int etat) {
        Tache t = new Tache(nom, prio, etat);
        
        t.setNumeroExterne(taches.size());
        t.setNumeroInterne(taches.get(taches.size() - 1).nombreDeTaches() + 1);

        t.setEstSousTache(true);

        taches.get(taches.size() - 1).ajouterSousTache(t);
    }

    public void afficher() {
        for (Tache tache : taches) {
            tache.afficher(false);
        }
    }

    public void validerTache(int index) {
        taches.get(index - 1).valider();
    }

    public void validerSousTache(String st) {
        String[] split = st.split("\\.");

        int maj = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);

        taches.get(maj - 1).validerSousTache(min);
    }

    public void importer(String path) {
        try {
            BufferedReader entree = new BufferedReader(new FileReader(path));
            String ligne = entree.readLine();

            while (ligne != null) {
                String[] str = ligne.split(";");

                String nom = str[0];
                int priorite = Integer.parseInt(str[1]);
                int etat = Integer.parseInt(str[2]);

                String sousTache = str[3];

                if (sousTache.equals("S")) { // sous-tache
                    ajouterSousTache(nom, priorite, etat);
                } else { // tâche
                    ajouterTache(nom, priorite, etat);
                }
                ligne = entree.readLine();
            }
        } catch (IOException e) {
            System.err.println("erreur");
        }
    }

    public void exporter(String path) {
        try {
            PrintWriter sortie = new PrintWriter(path);

            for (Tache tache : taches) {
                tache.ecrire(sortie);                
            }

            sortie.close();
        } catch (IOException e) {
            System.err.println("erreur IO");
            e.printStackTrace();
        }
    }
}
