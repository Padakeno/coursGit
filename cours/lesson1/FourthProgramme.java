public class FourthProgramme {
    
    public static void main(String[] args) {

            System.out.println(" Saisissez un entier : ");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            int a = scanner.nextInt();
            
            System.out.println("a = " + a);
            
            
            System.out.println(" Saisissez une chaine de caractères : ");
            String chaine = scanner.next();
            System.out.println("chaine = " + chaine);
            
            System.out.println(" Saisissez un double : ");
            Double d = scanner.nextDouble();
    }
}