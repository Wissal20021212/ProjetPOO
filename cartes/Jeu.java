package cartes;

import java.util.*;

public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private List<Cartes> pioche;
    private Random random;

    public Jeu(String nomJoueur1, String nomJoueur2) {
        joueur1 = new Joueur(nomJoueur1);
        joueur2 = new Joueur(nomJoueur2);
        pioche = new ArrayList<>();
        random = new Random();
        initialiserCartes();
    }

    private void initialiserCartes() {
        pioche.add(new CartePopularite(nomCarte.DiscoursInspirant, 1,2));
        pioche.add(new CartePopularite(nomCarte.MaindeFer, 2,3));
        pioche.add(new CartePopularite(nomCarte.CoupdeSabre, 3 , 5));
        pioche.add(new CarteAttaque(nomCarte.AbordageRéussi, 2 , 2));
        pioche.add(new CarteAttaque(nomCarte.Sabotage, 2, 1));
        Collections.shuffle(pioche);


    }
    private Cartes piocherCarte() {
        return pioche.isEmpty() ? null : pioche.remove(0);
    }
    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        Joueur joueurActuel = joueur1;
        Joueur adversaire = joueur2;

        while (!joueur1.estElimine() && !joueur2.estElimine() && !joueur1.aGagne() && !joueur2.aGagne()) {
            System.out.println("\nC'est au tour de " + joueurActuel.getNom());
            joueurActuel.afficherEtat();
            adversaire.afficherEtat();

            Cartes cartePiochee = piocherCarte();
            if (cartePiochee != null) {
                joueurActuel.ajouterCarte(cartePiochee);
            }

            System.out.println("Choisissez une carte à jouer (0, 1, 2...):");
            int choix = scanner.nextInt();
            joueurActuel.jouerCarte(choix, adversaire);

            if (joueurActuel.aGagne()) {
                System.out.println(joueurActuel.getNom() + " a gagné en atteignant 5 points de popularité !");
                break;
            }

            if (adversaire.estElimine()) {
                System.out.println(joueurActuel.getNom() + " a gagné en éliminant son adversaire !");
                break;
            }

            // Changer de joueur
            Joueur temp = joueurActuel;
            joueurActuel = adversaire;
            adversaire = temp;
        }

        scanner.close();
    }
}
