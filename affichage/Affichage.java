package affichage;

import java.util.Scanner;

public class Affichage implements IAffichage {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void afficherCarte(String nom, String description, int numCarte) {
        System.out.println( numCarte  + "\t -  " + nom + " : " + description + ". \n");
    }

    @Override
    public void afficherCartes(String nom) {
        System.out.println("les cartes dans la main de  " + nom + " : \n");
    }

    @Override
    public void afficherEtat(String nom, int vie, int popularite) {
        System.out.println("nom : " + nom + " | \t vie : " + vie + " | \t popularite : " + popularite + " \n");
    }



    @Override
    public void afficherTour(String nom) {
        System.out.println("C'est au tour de " + nom + " de jouer. \n");
    }

    @Override
    public void afficherGagnant(String nom) {
        System.out.println(nom + " a gagné en elimenant son adversaire  \n");
    }

    @Override
    public int choisirCarte( int nbMaxCarte) {
        int choix;
        do {
            System.out.println("Choisir une carte a jouer ( 1-5) : ");
            choix = scanner.nextInt();
        } while (choix < 1 || choix > nbMaxCarte);
        return choix;
    }






}