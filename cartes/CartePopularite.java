package cartes;

public class CartePopularite extends Cartes {
 private int ptPopularite ;

    public CartePopularite (nomCarte nom , int numCarte , int ptPopularite ){
        super(nom,numCarte);
        this.ptPopularite = ptPopularite;

    }
    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        joueur.ajouterPopularite(ptPopularite);
        System.out.println("Le joueur " + joueur.getNom() + " a gagné " + ptPopularite +" points de popularite ! " );
    }



    }

