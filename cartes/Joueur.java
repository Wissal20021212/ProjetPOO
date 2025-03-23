package cartes;

import affichage.Affichage;

public class Joueur {
    private String nom;
    public int vie;
    public int popularite;
    public Cartes[] main;
    private static final int MAX_CARTES = 5;
    private Affichage affichage;

    public Joueur(String nom) {
        this.nom = nom;
        this.vie = 5;
        this.popularite = 0;
        this.main = new Cartes[MAX_CARTES];
        this.affichage = new Affichage();
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

    public void recevoirCartes(Cartes[] cartesInitiales) {
        for (int i = 0; i < cartesInitiales.length; i++) {
            main[i] = cartesInitiales[i];
        }
    }

    public void ajouterCarte(Cartes carte) {
        for (int i = 0; i < MAX_CARTES; i++) {
            if (main[i] == null) {
                main[i] = carte;
                break;
            }
        }
    }

    public boolean possedeCarte(Cartes carte) {
        for (Cartes c : main) {
            if (c != null && c.getNom() == carte.getNom()) {
                return true;
            }
        }
        return false;
    }

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

    public void retirerPopularite(int valeur){
        popularite -= valeur ;
    }

    public void afficherMain() {
        affichage.afficherCartes(this.nom);
        for (int i = 0; i < MAX_CARTES; i++) {
            if (main[i] != null) {
                affichage.afficherCarte(main[i].getNom(), main[i].getDescription(), i + 1);
            }
        }
    }

    public void afficherEtat() {
        affichage.afficherEtat(this.nom, this.vie, this.popularite);
    }



    public void jouerCarte(int index, Joueur adversaire) {
        if (index >= 1 && index < (main.length + 1) && main[index - 1] != null) {
            Cartes carte = main[index - 1];
            main[index - 1] = null;
            carte.appliquerEffet(this, adversaire);
        }
    }
}