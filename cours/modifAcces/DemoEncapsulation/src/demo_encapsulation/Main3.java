package demo_encapsulation;

public class Main3 {

    public static void main(String args[]) {
        Personne3 p1 = new Personne3();
        Personne3 p2 = new Personne3();
        Personne3 p3 = new Personne3();
        p1.setNom("Jean");
        p1.setTaille(175);
        p2.setNom("Marie");
        p2.setTaille(163);
        p3.setNom("Christophe");
        p3.setTaille(183754); // ici, on glisse une erreur

        Personne3 tab[] = {p1, p2, p3};

        int total = 0;
        int nbPersonnes = 0;
        for (Personne3 p : tab) {
            if (p.isTailleValide()) {
                total += p.getTaille();
                nbPersonnes++;
            }
        }
        System.out.println("taille moyenne:" + total / nbPersonnes);
    }
}
