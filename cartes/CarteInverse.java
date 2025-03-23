package cartes;

public class CarteInverse extends Cartes {


    public CarteInverse(nomCarte nom, String description, int numCarte) {
        super(nom, description, numCarte);

    }

    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {

        int vieJoueur = joueur.getVie();
        int populariteJoueur = joueur.getPopularite();

        joueur.retirerVie(vieJoueur - adversaire.getVie());
        adversaire.retirerVie(adversaire.getVie() - vieJoueur);

        joueur.ajouterPopularite(adversaire.getPopularite() - populariteJoueur);
        adversaire.ajouterPopularite(populariteJoueur - adversaire.getPopularite());

        System.out.println("Effet spécial appliqué : " + this.getDescription());
        System.out.println("Les points de vie et de popularité ont été échangés entre " + joueur.getNom() + " et " + adversaire.getNom() + ".");
    }
}
