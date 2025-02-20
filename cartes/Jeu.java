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
        pioche.add(new CartePopularite(nomCarte.Discours_Inspirant, 1, 2));
        pioche.add(new CartePopularite(nomCarte.Main_de_Fer, 2, 3));
        pioche.add(new CartePopularite(nomCarte.Coupde_Sabre, 3, 5));
        pioche.add(new CarteAttaque(nomCarte.Abordage_Réussi, 2, 2));
        pioche.add(new CarteAttaque(nomCarte.Sabotage, 2, 1));
        pioche.add(new CartePopularite(nomCarte.Discours_Héroïque, 4 , 1));
        pioche.add(new CartePopularite(nomCarte.Sauvetage_en_Mer, 5,2));
        pioche.add(new CartePopularite(nomCarte.Tresor_Partage, 6 , 1));
        pioche.add(new CartePopularite(nomCarte.Chanson_de_Pirate, 7 , 1));
        pioche.add(new CartePopularite(nomCarte.Amitié_Forgée, 8 , 2));


        Collections.shuffle(pioche);


    }

    private Cartes piocherCarte() {
        return pioche.isEmpty() ? null : pioche.remove(0);
    }
    private void distribuerCartes(Joueur joueur) {
        for (int i = 0; i < 3; i++) {
            Cartes carte = piocherCarte();
            if (carte != null) {
                joueur.ajouterCarte(carte);
            }
        }
    }

    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        Joueur joueurActuel = joueur1;
        Joueur adversaire = joueur2;

        distribuerCartes(joueur1);
        distribuerCartes(joueur2);



        while (!joueur1.estElimine() && !joueur2.estElimine() && !joueur1.aGagne() && !joueur2.aGagne()) {
            System.out.println("\nC'est au tour de " + joueurActuel.getNom());
            joueurActuel.afficherEtat();
            adversaire.afficherEtat();


            System.out.println("Les cartes disponibles sont : ");
            for(int i = 0 ; i<pioche.size(); i++){
                System.out.println(pioche.get(i).getNom());

            }

            Cartes cartePiochee = piocherCarte();
            if (cartePiochee != null) {
                joueurActuel.ajouterCarte(cartePiochee);
                joueurActuel.afficherMain();
            }

            System.out.println("Choisissez une carte à jouer : ");
            int choix = scanner.nextInt();
            joueurActuel.jouerCarte(choix, adversaire);

            System.out.println(joueurActuel.getPopularite());
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

    }
}
