package demo_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.demarrer();
    }
    
    private void demarrer() {
        ArrayList<Personne> personnes = new ArrayList<Personne>();
        // ArrayList<Personne> personnes = new ArrayList<>(); // écriture simplifiée permise par Java 8
        
        Personne SandrineROBERT = new Personne("ROBERT", "Sandrine");
        
        personnes.add(new Personne("MARTIN", "Paul"));
        personnes.add(SandrineROBERT);
        personnes.add(new Personne("DURAND", "Valérie"));
        personnes.add(new Personne("MARECHAL", "Virginie"));
        personnes.add(new Personne("MARTIN", "Christine"));
        personnes.add(SandrineROBERT); // un même élément peut apparaître plusieurs fois
        
        // parcours de la liste avec la nouvelle boucle for
        for(Personne p : personnes) { // pour chaque p (de type Personne) de (la collection) personnes
            p.afficher();
            System.out.println();
        }
        
        // tri de la liste
        System.out.println("\n----- la liste triée -----");
        Collections.sort(personnes);
        
        // parcours de la liste avec un itérateur
        Iterator<Personne> it = personnes.iterator();
        while(it.hasNext()) {
            it.next().afficher();
            System.out.println();
        }
                
        // dictionnaire (ici, un cache ARP => couple adresse IP, adresse MAC)
        Hashtable<String, String> cacheARP = new Hashtable<String, String>();
        cacheARP.put("172.20.197.11", "0A:45:1E:48:9B:CB");
        cacheARP.put("172.20.197.23", "0A:45:1E:48:5A:97");
        cacheARP.put("172.20.197.42", "0A:45:1E:48:C7:32");

        System.out.println();
        System.out.println("récupération d'une valeur à partir d'une clé");
        System.out.println(cacheARP.get("172.20.197.23"));        
    }
}
