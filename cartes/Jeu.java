package cartes;

import java.util.*;

public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private Cartes[] pioche;
    private int indexPioche;
    private Random random;


    public Jeu(String nomJoueur1, String nomJoueur2) {
        joueur1 = new Joueur(nomJoueur1);
        joueur2 = new Joueur(nomJoueur2);
        pioche = new Cartes[10];
        initialiserCartes();
        distribuerCartes();
    }
    private void initialiserCartes() {
        pioche[0] = new CartePopularite(nomCarte.DISCOURS_INSPIRANT, 1, 1);
        pioche[1] = new CartePopularite(nomCarte.REVOLTE_ORGANISEE, 2, 1);
        pioche[2] = new CartePopularite(nomCarte.MAIN_DE_FER, 3, 2);
        pioche[3] = new CarteAttaque(nomCarte.COUP_DE_SABRE, 4, 2);
        pioche[4] = new CarteAttaque(nomCarte.ABORDAGE_REUSSI, 5, 2);
        pioche[5] = new CartePopularite(nomCarte.STRATEGIE_AUDACIEUSE, 6, 2);
        pioche[6] = new CartePopularite(nomCarte.RENFORTS_PIRATES, 7, 3);
        pioche[7] = new CarteAttaque(nomCarte.CANON_EN_FLAMMES, 8, 3);
        pioche[8] = new CarteAttaque(nomCarte.TRAHISON, 9, 4);
        pioche[9] = new CartePopularite(nomCarte.MYSTIQUE_VOODOO, 10, 3);


        indexPioche = 0;
    }


private Cartes piocherCarte() {
    return (indexPioche < pioche.length) ? pioche[indexPioche++] : null;
}



    private void distribuerCartes() {
        Cartes[] cartesJoueur1 = {pioche[0], pioche[1], pioche[2], pioche[3], pioche[4]};
        Cartes[] cartesJoueur2 = {pioche[1], pioche[2], pioche[3], pioche[4], pioche[5]};

        joueur1.recevoirCartes(cartesJoueur1);
        joueur2.recevoirCartes(cartesJoueur2);}
    private Cartes piocherCartes() {
        if (indexPioche < pioche.length) {
            return pioche[indexPioche++];
        }
        return null;
    }


    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        Joueur joueurActuel = joueur1;
        Joueur adversaire = joueur2;

        while (!joueur1.estElimine() && !joueur2.estElimine() && !joueur1.aGagne() && !joueur2.aGagne()) {
            System.out.println("\nC'est au tour de " + joueurActuel.getNom());
            joueurActuel.afficherEtat();
            adversaire.afficherEtat();

            Cartes cartePiochee = piocherCartes();
            if (cartePiochee != null) {
                joueurActuel.piocherCarte(cartePiochee);
            }

            joueurActuel.afficherMain();
            System.out.println("Choisissez une carte à jouer (0 à 4):");
            int choix = scanner.nextInt();
            System.out.println(" le joueur a choisit la carte " + joueurActuel.main[choix-1].getNom());
            joueurActuel.jouerCarte(choix, adversaire);

            if (joueurActuel.aGagne()) {
                System.out.println(joueurActuel.getNom() + " a gagné en atteignant 5 points de popularité !");
                break;
            }

            if (adversaire.estElimine()) {
                System.out.println(joueurActuel.getNom() + " a gagné en éliminant son adversaire !");
                break;
            }

            Joueur temp = joueurActuel;
            joueurActuel = adversaire;
            adversaire = temp;
        }

        scanner.close();
    }}