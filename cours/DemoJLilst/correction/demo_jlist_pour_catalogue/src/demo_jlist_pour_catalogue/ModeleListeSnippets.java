package demo_jlist_pour_catalogue;

import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author A. FRANÇOIS
 */
public class ModeleListeSnippets extends AbstractListModel<Snippet> {

    private final List<Snippet> snippets; // la variable snippets peut référencer n'importe quel objet qui implémente l'interface List (ArrayList convient donc)

    public ModeleListeSnippets(List<Snippet> snippets) {
        this.snippets = snippets;
    }

    public void ajouter(Snippet s) {
        snippets.add(s);
        int index = snippets.indexOf(s);
        fireContentsChanged(this, index, index); // la JList est prévenue du changement pour qu'elle se mette à jour
    }

    public void supprimer(Snippet s) {
        int index = snippets.indexOf(s);
        snippets.remove(s);
        fireIntervalRemoved(this, index, index); // la JList est prévenue du changement pour qu'elle se mette à jour
    }

    public void modifier(Snippet s) {
        int index = snippets.indexOf(s);
        fireContentsChanged(this, index, index); // la JList est prévenue du changement pour qu'elle se mette à jour
    }

    @Override
    public int getSize() {
        return snippets.size();
    }

    @Override
    public Snippet getElementAt(int index) {
        return snippets.get(index);
    }
}
