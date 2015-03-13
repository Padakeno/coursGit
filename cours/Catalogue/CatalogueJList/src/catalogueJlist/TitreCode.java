/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogueJlist;

import java.util.ArrayList;

/**
 *
 * @author slam
 */
public class TitreCode {
    private String titre;
    private String code;
    private ArrayList<String> tags;
    
    public TitreCode(String titre, String code) {
        this.titre = titre;
        this.code = code;
        this.tags = new ArrayList<>();
    }
    @Override 
    public String toString() {
        return titre;
    }
    
    public void afficher() {
        System.out.print(titre + " " + code);
    }
    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public String getCode() {
        return code;
    }
    
    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList tags) {
        this.tags = tags;
    }
}