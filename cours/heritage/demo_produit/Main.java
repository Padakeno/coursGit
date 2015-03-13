package demo_produit;

public class Main {
    /**
     * le constructeur par défaut (sans paramètre)
     */
    public Main() {
    }

    /**
     * point d'entrée du programme
     */  
    public static void main(String[] args) {   
        Main main = new Main(); // l'objet représentant l'application est créé
        main.demarrer();
    }

    private void demarrer() {
        Produit p=new Produit("cd", 18.0);
        Produit p2=new Produit("casque", 99.0);
        System.out.println(p);
        System.out.println(p2);

        /* ***************************** */

        Produit p3=new ProduitTVAReduite("Playstation", 199.0);
        // type statique de p3 : Produit
        // type dynamique de p3 : ProduitTVAReduite
        Produit p4=new ProduitTVAReduite("Epee", 349.0);
        System.out.println(p3);
        System.out.println(p4);
        
        /* ***************************** */
        Produit p5 = new ProduitPetrolier("gazole",0.50);
        System.out.println(p5);
        
        
        /* tableau de 10 produits (produit, produit pétrolier, produit à TVA réduite) */

        Produit[] tab = new Produit[10];

        tab[0] = p;
        tab[1] = p2;
        tab[2] = p3;
        tab[3] = p4;
        tab[4] = p5;
        tab[5] = new Produit("dvd", 20.0);
        tab[6] = new ProduitTVAReduite("Coca-Cola", 15.0);
        tab[7] = new ProduitPetrolier("e85",0.50 );
        tab[8] = new Produit("Windows 8", 250.0);
        tab[9] = new ProduitTVAReduite("Pizza", 7.50);

        for(Produit pr : tab){
            System.out.println(pr);//Println va appeler la methode toString() correspondant au type de l'objet pointé par pr(polymorphisme).
        }
        







    }

}