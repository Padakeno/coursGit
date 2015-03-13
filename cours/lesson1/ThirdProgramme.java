public class ThirdProgramme {
    
    public static void main(String[] args) {

        int a = 2;
        
        if (a >= 0) {
            System.out.println(a + " est un nombre positif");
        }
        
        if (a % 2 == 0) {
            System.out.println(a + " est un nombre pair");
        } else {
            System.out.println(a + " est un nombre impair");
        }
        
        int compteur = 0;
        
        while (compteur < 10) {
            System.out.println(compteur);
            compteur++;
        }
        
        do {
            compteur--;
            System.out.println(compteur);
        } while (compteur > 0);
        
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
    }
}