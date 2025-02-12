package cartes;

public class CarteAttaque extends Cartes {

    private int ptVie ;

    public CarteAttaque (nomCarte nom , String description , int numCarte , int ptPopulatrité ){
        super(nom,description,numCarte);
        this.ptVie = ptVie;

    }
    @Override
    public int effet(Joueur joueur) {
        joueur.vie -= ptVie;
        return (joueur.vie);
    }
}
