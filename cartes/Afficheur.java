package cartes;
import java.util.Scanner;


public class Afficheur {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Afficheur afficheur = new Afficheur();
        afficheur.jouer();
    }

    public void afficherNomJoueur(String nomJoueur) {
        System.out.println("Le nom du joueur est " + nomJoueur);
    }

    public void afficherEtatJoueur(String nomJoueur, int numVie, int numPopularite) {
        System.out.println(
                "l'etat du joueur " + nomJoueur + " : " + numVie + " coeurs et " + numPopularite + " de popularite ");
    }

    public void afficherCarte(String[] carte) {

        for (int i = 0; i < carte.length; i++) {
            System.out.println(" la " + (i + 1) + " eme carte est " + carte[i]);
        }
    }

    public int choisirCarte() {
        System.out.println("Entrer le numero de la carte : ");
        int numCarte = scanner.nextInt();
        return numCarte;
    }

    private void jouer() {

        String[] carte = { "carte 1 ", "carte 2 ", "carte 3" };
        afficherNomJoueur("Bill");
        afficherEtatJoueur("Bill", 5, 0);
        afficherCarte(carte);
        int numCarte = choisirCarte();

    }
}
