package demo_heritage.exemple3;

// la classe Salarie hérite, étend la classe Personne
public class Salarie extends Personne {

    private int salaireBrutAnnuel;

    public Salarie() {
        // implicitement, il y a appel au constructeur de la classe mère
    }

    public Salarie(String nom) {
        super(nom); //appel au constructeur qui a un paramètre de type String de la classe mère
    }

    public void setSalaireBrutAnnuel(int salaireBrutAnnuel) {
        this.salaireBrutAnnuel = salaireBrutAnnuel;
    }

    // redéfinition d'une méthode (à ne surtout pas confondre avec la surcharge)
    @Override
    public void afficher() {
        super.afficher(); // ici super représente la super classe (la classe mère)
        System.out.println(salaireBrutAnnuel);
    }
    // utiliser l'annotation @Override n'est pas obligatoire mais fortement conseillée :
    // en l'utilisant on signale explicitement au compilateur que l'on veut redéfinir uné méthode
    // il vérifiera donc qu'il existe une méthode de même nom et de même signature que celle que l'on veut redéfinir
    // si ce n'est pas le cas (mauvaise lecture de la documentation, faute de frappe, etc.) le compilateur nous informera de l'erreur
}
