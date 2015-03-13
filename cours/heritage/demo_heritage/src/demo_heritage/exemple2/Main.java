package demo_heritage.exemple2;

public class Main {

    public static void main(String[] args) {
        Salarie s1 = new Salarie();
        s1.setSalaireBrutAnnuel(20000);
        s1.afficher(); // la classe Salarie a hérité de la méthode afficher de la classe Personne

        Salarie s2 = new Salarie();
        s2.afficher();

    }
}
