package cartes;

import cartes.Cartes;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;
    public int vie;
    public int popularite;
    private List<Cartes> main;


    public Joueur(String nom) {
        this.nom = nom;
        this.vie = 5;
        this.popularite = 0;
        this.main = new ArrayList<>();
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

    public void ajouterCarte(Cartes carte) {
        main.add(carte);
    }

    public void jouer(Joueur joueur) {
        System.out.print("C'est au joueur " + joueur.getNom() + " avec " + joueur.getVie() + " coeurs et de popularité " + joueur.getPopularite() + " de jouer.");
    }

    public void afficherEtat() {
        System.out.println(nom + " | Vie: " + vie + " | Popularité: " + popularite);
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



    public void afficherMain() {
        System.out.println(nom + " a les cartes suivantes en main :");
        for (int i = 0; i < main.size(); i++) {
            System.out.println((i+1) + " - " + main.get(i).getNom());
        }
    }


    public void jouerCarte(int index, Joueur adversaire) {
        if (index >= 0 && index < main.size()) {
            Cartes carte = main.remove(index);
            carte.appliquerEffet(this, adversaire);
        }
    }

}