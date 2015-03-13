package demo_jlist_pour_catalogue;

/**
 *
 * @author A. FRANÇOIS
 */
public class Snippet implements Comparable<Snippet> {

    private String titre;
    private String contenu;
    private String[] tags;

    Snippet(String titre) {
        this.titre = titre;
        this.tags = new String[5];
    }

    @Override
    public int compareTo(Snippet s) {
        int resultat = 0;

        resultat = this.titre.compareTo(s.titre);

        return resultat;
    }

    @Override
    public String toString() {
        return this.titre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

}
