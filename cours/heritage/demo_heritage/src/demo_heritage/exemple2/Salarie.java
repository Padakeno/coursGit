package demo_heritage.exemple2;

// la classe Salarie hérite, étend la classe Personne
public class Salarie extends Personne {

    private int salaireBrutAnnuel;

    public Salarie() {
        // implicitement, il y a appel au constructeur de la classe mère
    }

    public void setSalaireBrutAnnuel(int salaireBrutAnnuel) {
        this.salaireBrutAnnuel = salaireBrutAnnuel;
    }
}
