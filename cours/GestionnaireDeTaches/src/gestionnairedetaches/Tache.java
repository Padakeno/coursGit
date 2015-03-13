package gestionnairedetaches;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Classe permettant de représenter une tâche / sous-tâche
 * 
 * @author Grégory Petit
 */
public class Tache {

    private static final int HAUTE = 3;
    private static final int MOYENNE = 2;
    private static final int BASSE = 1;

    private static final int A_FAIRE = 0;
    private static final int REALISE = 1;

    private int numeroExterne;
    private int numeroInterne;

    /** libellé de la tâche */
    private String libelle;
    /** priorité de la tâche (haute, moyenne, basse) */
    private int priorite;
    /** état de la taĉhe () */
    private int etat;

    private ArrayList<Tache> sousTaches;
    private boolean estSousTache;

    public Tache(String nom, int priorite, int etat) {
        sousTaches = new ArrayList<Tache>();
        this.libelle = nom;
        this.priorite = priorite;
        this.etat = etat;
    }

    public void ecrire(PrintWriter sortie) {
        // on utilise la lettre T pour indiquer une tâche et S pour une sous-tâche       
        if (this.estSousTache) {
            sortie.println(this.libelle + ";" + this.priorite + ";" + this.etat + ";S");
        } else {
            // cas d'une tâche
            sortie.println(this.libelle + ";" + this.priorite + ";" + this.etat + ";" + "T");
            for (Tache sousTache : this.sousTaches) {
                sousTache.ecrire(sortie);
            }
        }
    }

    public void afficher(boolean fini) {
        //String num = ((numeroInterne > 0) ? "\t" : "") + numeroExterne + ((numeroInterne > 0) ? "." + numeroInterne : "");

        String num;
        if (this.numeroInterne > 0)
            num = "\t" + this.numeroExterne + ".";
        else
            num = "" + this.numeroExterne;
        
        int couleur = 0;

        if (priorite == HAUTE) {
            couleur = 31;
        } else if (priorite == MOYENNE) {
            couleur = 33;
        } else if (priorite == BASSE) {
            couleur = 32;
        }

        String code = "";

        if (this.etat == REALISE) {
            code = "\033[9;" + couleur + "m";
        } else {
            code = "\033[" + couleur + "m";
        }

        String txt = " - " + code + libelle + "\033[0m";
        System.out.println(num + txt);

        if (!fini) {
            for (Tache t : sousTaches) {
                t.afficher(true);
            }
        }
    }

    public void valider() {
        this.etat = REALISE;
        for (Tache t : sousTaches) {
            t.valider();
        }
    }

    public void validerSousTache(int index) {
        sousTaches.get(index - 1).valider();
    }

    public void modifier(String chaine) {
        this.libelle = chaine;
    }

    public void modifierSousTache(int index, String ch) {
        sousTaches.get(index - 1).modifier(ch);
    }

    public boolean sousTacheExiste(int index) {
        return (index > 0 && index <= sousTaches.size());
    }

    public boolean aSousTaches() {
        return (this.sousTaches.size() > 0);
    }

    public void ajouterSousTache(Tache t) {
        sousTaches.add(t);
    }

    public void supprimerTache(int index) {
        sousTaches.remove(index - 1);
    }

    public Tache getTache(int index) {
        if (index < 0 || index > sousTaches.size()) {
            return null;
        } else {
            return sousTaches.get(index);
        }
    }

    public int nombreDeTaches() {
        return this.sousTaches.size();
    }

    public void setNumeroExterne(int numero) {
        this.numeroExterne = numero;
    }

    public int getNumeroExterne() {
        return this.numeroExterne;
    }

    public void setNumeroInterne(int numero) {
        this.numeroInterne = numero;
    }

    public int getNumeroInterne() {
        return this.numeroInterne;
    }

    public ArrayList<Tache> getSousTaches() {
        return this.sousTaches;
    }

    public void setNom(String nom) {
        this.libelle = nom;
    }

    public String getNom() {
        return this.libelle;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public int getPriorite() {
        return this.priorite;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getEtat() {
        return this.etat;
    }

    public boolean getEstSousTache() {
        return this.estSousTache;
    }

    public void setEstSousTache(boolean b) {
        this.estSousTache = b;
    }

}
