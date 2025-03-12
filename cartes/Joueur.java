package cartes;

import cartes.Cartes;



public class Joueur {
    private String nom;
    public int vie;
    private int nbCartes;

    public int popularite;
    public Cartes[] main;
    private static final int MAX_CARTES = 5 ;


    public Joueur(String nom) {
        this.nom = nom;
        this.vie = 5 ;
        this.popularite = 0;

        this.main = new Cartes[MAX_CARTES];

    }


    public int getVie() {
        return vie;
    }

    public int getPopularite() {
        return popularite;
    }

    public String getNom() {
        return nom;
    }

   /* public void ajouterCarte(Cartes carte) {
        for (int i = 1; i < main.length; i++) {
            if (main[i] == null) {
                main[i] = carte;
                break;
            }
        }
    } */
    public void recevoirCartes(Cartes[] cartesInitiales) { // les cartes que chaque joueur va les recevoir au debut
        for (int i = 0; i < cartesInitiales.length; i++) {
            main[i] = cartesInitiales[i];
        }
    }
    public void piocherCarte(Cartes carte) {    // carte a ajouter apres etre piocher
        for (int i = 0; i < MAX_CARTES; i++) {
            if (main[i] == null) {
                main[i] = carte;
                break;
            }
        }
    }
    public boolean possedeCarte(Cartes carte) { // fonction pour verifier si la carte est deja dans la main de joueur
        for (Cartes c : main) {
            if (c != null && c.getNom() == carte.getNom()) {
                return true; // carte déjà présente
            }
        }
        return false;
    }
    // public void jouer(Joueur joueur) {
    //System.out.print("C'est au joueur " + joueur.getNom() + " avec " + joueur.getVie() + " coeurs et de popularité " + joueur.getPopularite() + " de jouer.");
    //}

    //public void afficherEtat() {
        //System.out.println(nom + " | Vie: " + getVie() + " | Popularité: " + getPopularite());
    //}

    public boolean estElimine() {
        return vie <= 0;
    }

    public boolean aGagne() {

        return popularite >= 5;
    }

    public void retirerVie(int valeur) {
        vie -= valeur;
    }

    public void ajouterPopularite(int valeur) {
        popularite += valeur;
    }



    public void afficherMain() {
        System.out.println(nom + " possède les cartes :");
        for (int i = 0; i < MAX_CARTES; i++) {
            if (main[i] != null) {
                System.out.println((i+1) + ". " + main[i].getNom() + main[i].getDescription() );
            }
        }
    }
    public void afficherEtat() {
        System.out.println(nom + " | Vie: " + vie + " | Popularité: " + popularite);
    }




    public void jouerCarte(int index, Joueur adversaire) {
        if (index >= 1 && index < (main.length+1) && main[index-1] != null) {
            Cartes carte = main[index-1];
            main[index-1] = null;
            carte.appliquerEffet(this, adversaire);
        }
    }

}