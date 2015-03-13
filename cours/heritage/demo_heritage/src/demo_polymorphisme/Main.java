package demo_polymorphisme;

public class Main {
    public Main() {        
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        main.demarrer();// TODO code application logic here
    }
    
    private void demarrer() {
        Personne p = new Personne("DUPONT");
        p.afficher();

        p = new Salarie("MARTIN", 30100);
        // le type statique de p est Personne
        // le type dynamique de p est Salarie (Salarie étant une sous-classe de Personne)
        p.afficher();
        // ici c'est la méthode afficher de la classe Salarie qui est appelée
        System.out.println();
        
        p = new Apprenti("DUPONT", "Sabine", 5000, "BTS IG");
        // maintenant le type dynamique de p est Apprenti (Apprenti étant une sous-classe de Personne)
        p.afficher();
        // ici c'est la méthode afficher de la classe Apprenti qui est appelée
        System.out.println();
    }
}
