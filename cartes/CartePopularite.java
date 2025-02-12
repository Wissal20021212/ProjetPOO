package cartes;

public class CartePopularite extends Cartes {
 private int ptPopulatrite ;

    public CartePopularite (nomCarte nom , String description , int numCarte , int ptPopulatrité ){
        super(nom,description,numCarte);
        this.ptPopulatrite = ptPopulatrité;

    }
    @Override
    public int effet(Joueur joueur) {
        joueur.popularite += ptPopulatrite;
        return (joueur.popularite);
    }



    }

