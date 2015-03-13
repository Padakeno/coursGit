package demo_encapsulation;

public class Main2 {

    public static void main(String args[]) {
        Personne2 p1 = new Personne2();
        Personne2 p2 = new Personne2();
        Personne2 p3 = new Personne2();
        p1.setNom("Jean");
        p1.setTaille(175);
        p2.setNom("Marie");
        p2.setTaille(163);
        p3.setNom("Christophe");
        p3.setTaille(183754); // ici, on glisse une erreur

        Personne2 tab[] = {p1, p2, p3};

        int total = 0;
        int nbPersonnes = 0;
        for (Personne2 p : tab) {
            total += p.getTaille();
            nbPersonnes++;
        }
        System.out.println("taille moyenne:" + total / nbPersonnes);
    }
}
