/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogue_java_db;

import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author slam
 */
public class ModelListeCode extends AbstractListModel<TitreCode>{
    private List<TitreCode> listeCode;
    
    public ModelListeCode(List<TitreCode> listeCode) {
        this.listeCode = listeCode;
    }
    
    public void ajouter(TitreCode t) {
        listeCode.add(t);
        int index = listeCode.indexOf(t);
        fireContentsChanged(this, index, index); // la JList est prévenue du changement pour qu'elle se mette à jour
    }

    public void supprimer(ModelListeCode l) {
        int index = listeCode.indexOf(l);
        listeCode.remove(l);
        fireIntervalRemoved(this, index, index); // la JList est prévenue du changement pour qu'elle se mette à jour
    }

    public void modifier(ModelListeCode l) {
        int index = listeCode.indexOf(l);
        fireContentsChanged(this, index, index); // la JList est prévenue du changement pour qu'elle se mette à jour
    }

    @Override
    public int getSize() {
        return listeCode.size();
    }

    @Override
    public TitreCode getElementAt(int index) {
        return listeCode.get(index);
    }
    
    
    
}
