package gestionnairedetaches;

import java.util.Scanner;

/**
 * Classe pratique permettant de créer un menu
 */
public class Menu {

    private String[] items;
    private Scanner scanner;

    /**
     * Constructeur
     */
    public Menu(String[] items) {

        this.items = items;
        scanner = new Scanner(System.in);

    }

    public int gerer() {
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + " - " + items[i]);
        }

        int input = -1;

        System.out.println("0 - Quitter");

        do {
            input = -1;

            System.out.println("Votre choix ?");
            String sc = scanner.next();

            if (!sc.matches("\\d{1,2}")) {
                input = -1;
            } else {
                input = Integer.parseInt(sc);
            }

        } while (input < 0 || input > items.length);

        return input;
    }
}
