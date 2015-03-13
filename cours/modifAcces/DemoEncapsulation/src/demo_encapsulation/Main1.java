package demo_encapsulation;

public class Main1 {

    public static void main(String args[]) {
        Personne1 p1 = new Personne1();
        Personne1 p2 = new Personne1();
        Personne1 p3 = new Personne1();
        p1.nom = "Jean";
        p1.t = 175;
        p2.nom = "Marie";
        p2.t = 163;
        p3.nom = "Christophe";
        p3.t = 183754; // ici, on glisse une erreur

        Personne1 tab[] = {p1, p2, p3};

        int total = 0;
        int nbPersonnes = 0;
        for (Personne1 p : tab) {
            total += p.t;
            nbPersonnes++;
        }
        System.out.println("taille moyenne:" + total / nbPersonnes);
    }
}
