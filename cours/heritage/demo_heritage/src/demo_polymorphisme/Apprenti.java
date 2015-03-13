package demo_polymorphisme;

/**
 * La classe <code>Apprenti</code> représente un apprenti. Cette classe hérite de la classe <code>Salarie</code>.
 * @author Arnaud FRANÇOIS
 */
public class Apprenti extends Salarie {
    private String diplome;

    /**
     * Constructeur
     * @param nom le nom de l'apprenti. <strong>Il est conseillé d'utiliser des majuscules</strong>.
     * @param prenom le prénom de l'apprenti
     * @param salaireBrutAnnuel le salaire brut annuel
     * @param diplome le dernier diplôme obtenu par l'apprenti
     */
    public Apprenti(String nom, String prenom, int salaireBrutAnnuel, String diplome) {
        super(nom, salaireBrutAnnuel);
        this.diplome = diplome;        
    }

    /**
     * Cette procédure permet d'afficher sur la sortie standard les informations
     * concernant l'apprenti.
     */
    @Override
    public void afficher() {
        super.afficher();
        System.out.print("[" + diplome + "]");
    }
}

