package cartes;

public class CarteAttaque extends Cartes {

    private int ptVie ;

    public CarteAttaque (nomCarte nom  , int numCarte , int ptPopulatrité ){
        super(nom,numCarte);
        this.ptVie = ptVie;

    }
    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        adversaire.retirerVie(ptVie);
    }
}
