package cartes;

public class CarteVolPopularite extends Cartes {


    public CarteVolPopularite(nomCarte nom, String description, int numCarte) {
        super(nom, description, numCarte);
    }

    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        joueur.ajouterPopularite(adversaire.getPopularite());
        adversaire.retirerPopularite(adversaire.getPopularite());


        System.out.println("Effet spécial appliqué : " + this.getDescription());
        System.out.println(joueur.getNom() + " a volé les points de popularité à " + adversaire.getNom() + ".");
    }
}