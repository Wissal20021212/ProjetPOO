import cartes.Jeu;
import cartes.Joueur;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Donner le nom de 1er joueur : ");
        String nom1 = scanner.nextLine();
        System.out.println("Donner le nom de 2eme joueur : ");
        String nom2 = scanner.nextLine();

        Jeu jeu = new Jeu(nom1, nom2);
        jeu.jouer();
    }
}