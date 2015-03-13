public class DemoMenu {
    public static void main(String[] args) {
        String[] items = {"Demarrer", "Arreter", "Mettre à zéro"};
        
        Menu monMenu = new Menu(items);
        Chrono monChrono = new Chrono();
        
        int choix = monMenu.gerer();
        
        while (choix != 0) {
            if(choix == 1) {
                monChrono.demarrer();
            } else if(choix == 2) {
                monChrono.arreter();
            } else if(choix == 3) {
                monChrono.mettreAZero();
            }
            
            choix = monMenu.gerer();
        }
        
    }
}