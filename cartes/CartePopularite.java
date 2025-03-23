package cartes;

public class CartePopularite extends Cartes {
    private int ptPopularite;

    public CartePopularite(nomCarte nom, String description, int numCarte, int ptPopularite) {
        super(nom, description, numCarte);
        this.ptPopularite = ptPopularite;
    }

    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        joueur.ajouterPopularite(ptPopularite);
        System.out.println("Le joueur " + joueur.getNom() + " a gagné " + ptPopularite + " points de popularité !");
    }
}

