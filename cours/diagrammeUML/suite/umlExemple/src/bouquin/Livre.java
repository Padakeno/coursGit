/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouquin;

/**
 *
 * @author slam
 */
public class Livre {
    private String titre;
    private String auteur;
    private Editeur editeur;
    
    public Livre(String titre, String auteur, Editeur editeur) {
        this.auteur = auteur;
        this.titre = titre;
        this.editeur = editeur;
    }
    
    public String getTitre() {
        return titre;
    }
    
    public String getAuteur() {
        return auteur;
    }
    
    public void setAuteur(String a) {
        this.auteur = a;
    }
    
    public void setTitre(String t) {
        this.titre = t;
    }
}
