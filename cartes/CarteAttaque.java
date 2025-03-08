package cartes;

public class CarteAttaque extends Cartes {

    private int ptVie ;

    public CarteAttaque (nomCarte nom  , int numCarte , int ptVie ){
        super(nom,numCarte);
        this.ptVie = ptVie;

    }
    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        adversaire.retirerVie(ptVie);
        System.out.println("l'adversaire " + adversaire.getNom() + " a perdu " + ptVie + " points de vie .");
    }
}
