package gestionnairedetaches; // pas de majuscules dans les noms de paquet

import java.util.Scanner;

/**
 * 
 * Le programme principal
 * (le code des quatre classes a été légèrement modifié par A. FRANÇOIS)
 *
 * @author Grégory Petit
 */
public class Main {

    public static void main(String[] args) {

        String[] items = {"Importer fichier", "Exporter fichier", "Afficher tâches", "Ajouter une tâche", "Ajouter une sous-tâche", "Supprimer une tâche", "Supprimer une sous tache", "Valider une tâche", "Valider une sous-tâche", "Modifier une tâche", "Modifier une sous-tâche"};
        Menu menu = new Menu(items);

        GestionnaireDeTaches gdt = new GestionnaireDeTaches();

        int choix = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("\033[32mAlcon\033[m");
        do {
            choix = menu.gerer();

            switch (choix) {

                case 1: {
                    System.out.println("Chemin du fichier à importer?");
                    gdt.importer(sc.nextLine());

                    break;
                }
                case 2: {
                    System.out.println("Chemin vers lequel exporter?");
                    gdt.exporter(sc.nextLine());
                    break;
                }
                case 3: {
                    System.out.println("");
                    gdt.afficher();
                    System.out.println("");
                    break;
                }
                case 4: {

                    System.out.println("Intitulé de la tâche?");
                    String title = sc.nextLine();

                    while (title.indexOf(";") != -1) {
                        System.out.println("Le nom ne peut contenir un point virgule.");
                        title = sc.nextLine();
                    }

                    System.out.println("Priorité de la tâche? [haute, moyenne, basse]");
                    int p = parsePriorite(sc.nextLine());

                    while (p == -1) {
                        System.out.println("Entrée erronée. Veuillez réessayer");
                        p = parsePriorite(sc.nextLine());
                    }

                    System.out.println("Etat de la tâche? [a faire, realisee]");
                    int e = parseEtat(sc.nextLine());

                    while (e == -1) {
                        System.out.println("Entrée erronée. Veuillez réessayer");
                        e = parseEtat(sc.nextLine());
                    }

                    gdt.ajouterTache(title, p, e);

                    break;
                }
                case 5: {
                    System.out.println("Numéro de la tâche à laquelle ajouter une sous-tâche?");
                    String input = sc.nextLine();
                    boolean inputOK = false;
                    boolean quitter = false;
                    while (!inputOK) {

                        if (input.equals("q")) {
                            quitter = true;
                            break;
                        }

                        while (!input.matches("\\d+")) {
                            System.out.println("Entrée erronée ; pas un chiffre");
                            input = sc.nextLine();
                        }

                        if (gdt.tacheExiste(Integer.parseInt(input))) {
                            inputOK = true;
                        } else {
                            System.out.println("Cette tâche n'existe pas.");
                            input = sc.nextLine();
                        }
                    }

                    if (!quitter) {

                        System.out.println("Intitulé de la tâche?");
                        String title = sc.nextLine();

                        while (title.indexOf(";") != -1) {
                            System.out.println("Le nom ne peut contenir un point virgule.");
                            title = sc.nextLine();
                        }

                        System.out.println("Priorité de la tâche? [haute, moyenne, basse]");
                        int p = parsePriorite(sc.nextLine());

                        while (p == -1) {
                            System.out.println("Entrée erronée. Veuillez réessayer");
                            p = parsePriorite(sc.nextLine());
                        }

                        System.out.println("Etat de la tâche? [a faire, realisee]");
                        int e = parseEtat(sc.nextLine());

                        while (e == -1) {
                            System.out.println("Entrée erronée. Veuillez réessayer");
                            e = parseEtat(sc.nextLine());
                        }

                        int index = Integer.parseInt(input);
                        gdt.ajouterSousTacheIndex(index, title, p, e);

                    }

                    break;
                }

                case 6: {
                    System.out.println("Numéro de la tâche que vous voulez supprimer?");
                    String input = sc.nextLine();

                    boolean inputOK = false;
                    boolean quitter = false;

                    while (!inputOK) {

                        if (input.equals("q")) {
                            quitter = true;
                            break;
                        }

                        while (!input.matches("\\d")) {
                            System.out.println("Entrée erronée ; pas un chiffre");
                            input = sc.nextLine();

                            if (input.equals("q")) {
                                quitter = true;
                                break;
                            }
                        }

                        if (input.equals("q")) {
                            quitter = true;
                            break;
                        }

                        if (gdt.tacheExiste(Integer.parseInt(input))) {
                            inputOK = true;
                        } else {
                            System.out.println("Cette tâche n'existe pas.");
                            input = sc.nextLine();
                        }
                    }

                    if (!quitter) {
                        gdt.supprimerTache(Integer.parseInt(input));
                    }

                    break;
                }

                case 7: {
                    System.out.println("Numéro de la sous-tâche que vous voulez supprimer?");
                    String input = sc.nextLine();

                    boolean inputOK = false;
                    boolean quitter = false;

                    while (!inputOK) {

                        if (input.equals("q")) {
                            quitter = true;
                            break;
                        }

                        while (!input.matches("^\\d+\\.\\d+$")) {
                            System.out.println("Entrée erronée");
                            input = sc.nextLine();
                        }

                        if (gdt.sousTacheExiste(input)) {
                            inputOK = true;
                        } else {
                            System.out.println("Cette sous-tâche n'existe pas.");
                            input = sc.nextLine();
                        }
                    }

                    if (!quitter) {
                        gdt.supprimerSousTache(input);
                    }
                }
                case 8: {
                    System.out.println("Numéro de la tâche que vous voulez supprimer?");
                    String input = sc.nextLine();

                    boolean inputOK = false;
                    boolean quitter = false;

                    while (!inputOK) {

                        if (input.equals("q")) {
                            quitter = true;
                            break;
                        }

                        while (!input.matches("\\d")) {
                            System.out.println("Entrée erronée ; pas un chiffre");
                            input = sc.nextLine();

                            if (input.equals("q")) {
                                quitter = true;
                                break;
                            }
                        }

                        if (input.equals("q")) {
                            quitter = true;
                            break;
                        }

                        if (gdt.tacheExiste(Integer.parseInt(input))) {
                            inputOK = true;
                        } else {
                            System.out.println("Cette tâche n'existe pas.");
                            input = sc.nextLine();
                        }
                    }

                    if (!quitter) {
                        gdt.validerTache(Integer.parseInt(input));
                    }
                    break;
                }

                case 9: {
                    System.out.println("Numéro de la sous-tâche que vous voulez valider?");
                    String input = sc.nextLine();

                    boolean inputOK = false;
                    boolean quitter = false;

                    while (!inputOK) {

                        if (input.equals("q")) {
                            quitter = true;
                            break;
                        }

                        while (!input.matches("^\\d+\\.\\d+$")) {
                            System.out.println("Entrée erronée");
                            input = sc.nextLine();
                        }

                        if (gdt.sousTacheExiste(input)) {
                            inputOK = true;
                        } else {
                            System.out.println("Cette sous-tâche n'existe pas.");
                            input = sc.nextLine();
                        }
                    }

                    if (!quitter) {
                        gdt.validerSousTache(input);
                    }
                    break;
                }
                case 10: {
                    System.out.println("Numéro de la tâche que vous voulez modifier?");
                    String input = sc.nextLine();

                    boolean inputOK = false;
                    boolean quitter = false;

                    while (!inputOK) {

                        if (input.equals("q")) {
                            quitter = true;
                            break;
                        }

                        while (!input.matches("\\d")) {
                            System.out.println("Entrée erronée ; pas un chiffre");
                            input = sc.nextLine();

                            if (input.equals("q")) {
                                quitter = true;
                                break;
                            }
                        }

                        if (input.equals("q")) {
                            quitter = true;
                            break;
                        }

                        if (gdt.tacheExiste(Integer.parseInt(input))) {
                            inputOK = true;
                        } else {
                            System.out.println("Cette tâche n'existe pas.");
                            input = sc.nextLine();
                        }
                    }

                    System.out.println("Nouvel intitulé?");
                    String nom = sc.nextLine();

                    if (!quitter) {
                        gdt.modifierTache(Integer.parseInt(input), nom);
                    }
                    break;
                }

                case 11: {
                    System.out.println("Numéro de la sous-tâche que vous voulez modifier?");
                    String input = sc.nextLine();

                    boolean inputOK = false;
                    boolean quitter = false;

                    while (!inputOK) {

                        if (input.equals("q")) {
                            quitter = true;
                            break;
                        }

                        while (!input.matches("^\\d+\\.\\d+$")) {
                            System.out.println("Entrée erronée");
                            input = sc.nextLine();
                        }

                        if (gdt.sousTacheExiste(input)) {
                            inputOK = true;
                        } else {
                            System.out.println("Cette sous-tâche n'existe pas.");
                            input = sc.nextLine();
                        }
                    }

                    System.out.println("Nouvel intitulé?");
                    String nom = sc.nextLine();

                    if (!quitter) {
                        gdt.modifierSousTache(input, nom);
                    }
                    break;
                }
            }

        } while (choix != 0);
    }

    public static int parsePriorite(String prio) {
        if (prio.toLowerCase().equals("haute") || prio.toLowerCase().equals("h")) {
            return 3;
        } else if (prio.toLowerCase().equals("moyenne") || prio.toLowerCase().equals("m")) {
            return 2;
        } else if (prio.toLowerCase().equals("basse") || prio.toLowerCase().equals("b")) {
            return 1;
        } else {
            return -1;
        }
    }

    public static int parseEtat(String etat) {
        if (etat.toLowerCase().equals("realise") || etat.toLowerCase().equals("r")) {
            return 1;
        } else if (etat.toLowerCase().equals("a faire") || etat.toLowerCase().equals("a")) {
            return 0;
        } else {
            return -1;
        }
    }
}
