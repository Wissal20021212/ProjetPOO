package cartes;

public class CarteDoublePopularite extends Cartes {

    public CarteDoublePopularite(nomCarte nom, String description, int numCarte) {
        super(nom, description, numCarte);
    }

    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {

        int populariteActuelle = joueur.getPopularite();
        joueur.ajouterPopularite(populariteActuelle);

        System.out.println("Effet spécial appliqué : " + this.getDescription());
        System.out.println(joueur.getNom() + " a maintenant " + joueur.getPopularite() + " points de popularité.");
    }
}