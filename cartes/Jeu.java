package cartes;

import affichage.Affichage;
import java.util.Random;
import java.util.Scanner;

public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private Cartes[] pioche;
    private Random random;
    private Affichage affichage;

    public Jeu(String nomJoueur1, String nomJoueur2) {
        joueur1 = new Joueur(nomJoueur1);
        joueur2 = new Joueur(nomJoueur2);
        pioche = new Cartes[20];
        random = new Random();
        affichage = new Affichage();

        initialiserCartes();
        melangerPioche();
        distribuerCartes();
    }

    private void initialiserCartes() {
        pioche[0] = new CartePopularite(nomCarte.DISCOURS_INSPIRANT, " : Carte de Popularité : Le joueur gagne 2 points de popularité ", 1, 2);
        pioche[1] = new CartePopularite(nomCarte.REVOLTE_ORGANISEE, " : Carte de Popularité : Le Joueur gagne 1 point de popularité ", 2, 1);
        pioche[2] = new CartePopularite(nomCarte.MAIN_DE_FER, ": Carte de Popularité : Le Joueur gagne 3 points de popularité", 3, 3);
        pioche[3] = new CarteAttaque(nomCarte.COUP_DE_SABRE, ": Carte d'Attaque  : L'adversaire perd  2 points de vie ", 4, 2);
        pioche[4] = new CarteAttaque(nomCarte.ABORDAGE_REUSSI, ": Carte d'attaque : L'adversaire perd 2 points d'attaque ", 5, 2);
        pioche[5] = new CartePopularite(nomCarte.STRATEGIE_AUDACIEUSE, ": Carte de Popularité : Le Joueur gagne 2 points de popularité", 6, 2);
        pioche[6] = new CartePopularite(nomCarte.RENFORTS_PIRATES, ": Carte de Popularité : Le Joueur gagne 1 points de popularité", 7, 1);
        pioche[7] = new CarteAttaque(nomCarte.CANON_EN_FLAMMES, ": Carte d'1ttaque  : L'adversaire perd 2 points de vie.", 8, 2);
        pioche[8] = new CarteAttaque(nomCarte.TRAHISON, ": Carte d'attaque : L'adversaire perd 2 points de vie.", 9, 2);
        pioche[9] = new CartePopularite(nomCarte.MYSTIQUE_VOODOO, " : Carte de Popularité : Le Joueur gagne 2 points de popularité", 10, 2);
        pioche[10] = new CarteAttaque(nomCarte.EXPLOSION_DE_POUDRE, " Carte d'Attaque : L'adversaire perd 3 points de vie", 11, 3);
        pioche[11] = new CartePopularite(nomCarte.TBALLADE_PIRAE, " : Carte de Popularité : Le joueur gagne 1 point de popularité", 12, 1);
        pioche[12] = new CartePopularite(nomCarte.ALLIANCE_DES_MARINS, " : Carte de Popularité : Le joueur gagne 2 points de popularité", 13, 2);
        pioche[13] = new CarteAttaque(nomCarte.EMBUSCADE_EN_MER, " : Carte d'Attaque : L'adversaire perd 2 points de vie", 14, 2);
        pioche[14] = new CarteAttaque(nomCarte.TOURMENT_DES_ABYSSES, " : Carte d'Attaque : L'adversaire perd 3 points de vie", 15, 3);
        pioche[15] = new CarteAttaque(nomCarte.FEU_DES_CANONS, " : Carte d'Attaque : L'adversaire perd 2 points de vie", 16, 2);
        pioche[16] = new CartePopularite(nomCarte.LEGENDE_DES_OCÉANS, " : Carte de Popularité : Le joueur gagne 3 points de popularité", 17, 3);
        pioche[17] = new CarteInverse(nomCarte.EFFET_INVERSE, " : Carte  spéciale : échanger les points de vie et de popularité entre les deux joueurs", 18);
        pioche[18]= new CarteDoublePopularite(nomCarte.DOUBLE_POPULARITE," Carte Speciale : Doubler les points de popularité du joueur actuel", 19);
        pioche[19]= new CarteVolPopularite(nomCarte.VOL_POPULARITE,"Carte Speciale : Voler des points de popularité à l'adversaire",20);

    }

    private void melangerPioche() {
        Random rand = new Random();
        for (int i = pioche.length - 1; i > 0; i--) {
            int indexAleatoire = rand.nextInt(i + 1);
            Cartes temp = pioche[i];
            pioche[i] = pioche[indexAleatoire];
            pioche[indexAleatoire] = temp;
        }
    }

    private void distribuerCartes() {
        Cartes[] cartesJoueur1 = {pioche[0], pioche[1], pioche[2], pioche[3], pioche[4]};
        Cartes[] cartesJoueur2 = {pioche[5], pioche[6], pioche[7], pioche[8], pioche[9]};

        joueur1.recevoirCartes(cartesJoueur1);
        joueur2.recevoirCartes(cartesJoueur2);
    }

    private Cartes piocherCarte(Joueur joueur) {
        Random rand = new Random();
        int tentative = 0;
        while (tentative < pioche.length) {
            int index = rand.nextInt(pioche.length);
            if (pioche[index] != null && !joueur.possedeCarte(pioche[index])) {
                Cartes cartePiochee = pioche[index];

                for (int i = index; i < pioche.length - 1; i++) {
                    pioche[i] = pioche[i + 1];
                }
                pioche[pioche.length - 1] = null;

                return cartePiochee;
            }
            tentative++;
        }
        return null;
    }

    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        Joueur joueurActuel = joueur1;
        Joueur adversaire = joueur2;

        while (!joueur1.estElimine() && !joueur2.estElimine() && !joueur1.aGagne() && !joueur2.aGagne()) {
            affichage.afficherTour(joueurActuel.getNom());
            joueurActuel.afficherEtat();
            adversaire.afficherEtat();

            Cartes cartePiochee = piocherCarte(joueurActuel);
            if (cartePiochee != null) {
                joueurActuel.ajouterCarte(cartePiochee);
            }

            joueurActuel.afficherMain();

            int choix = affichage.choisirCarte( 5);
            joueurActuel.jouerCarte(choix, adversaire);

            if (joueurActuel.aGagne()) {
                affichage.afficherGagnant(joueurActuel.getNom());
                break;
            }

            if (adversaire.estElimine()) {
                affichage.afficherGagnant(joueurActuel.getNom());
                break;
            }

            Joueur temp = joueurActuel;
            joueurActuel = adversaire;
            adversaire = temp;
        }
    }
}