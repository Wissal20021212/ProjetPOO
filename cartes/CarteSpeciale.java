package cartes;

public class CarteSpeciale extends Cartes {
    private int ptVie ;
    private int ptPopularite;
    public CarteSpeciale (nomCarte nom , String description , int numCarte , int ptPopularite , int ptVie){
        super(nom,description,numCarte);
        this.ptPopularite=ptPopularite;
        this.ptVie=ptVie;
    }
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        if(ptVie!=0){
            joueur.retirerVie(ptVie);
            if(ptPopularite != 0)
            {
                adversaire.ajouterPopularite(ptPopularite);
            }
    }
    }

}
