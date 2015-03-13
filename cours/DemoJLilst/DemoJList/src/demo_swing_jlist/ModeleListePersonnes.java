package demo_swing_jlist;

import java.util.List;
import javax.swing.AbstractListModel;

/**
 * le modèle est chargé de gérer les données
 *
 * @author A. FRANÇOIS 
 */
public class ModeleListePersonnes extends AbstractListModel {
    private List<Personne> personnes;

    public ModeleListePersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    public void ajouter(Personne p) {
        personnes.add(p);
        int index = personnes.indexOf(p);
        fireContentsChanged(this, index, index);
    }

    public void supprimer(Personne p) {
        int index = personnes.indexOf(p);
        personnes.remove(p);
        fireIntervalRemoved(this, index, index);
    }

    public void modifier(Personne p) {
        int index = personnes.indexOf(p);
        fireContentsChanged(this, index, index);
    }
    
    @Override
    public int getSize() {
        return personnes.size();
    }

    @Override
    public Object getElementAt(int index) {
        return personnes.get(index);
    }
}
