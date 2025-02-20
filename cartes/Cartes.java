package cartes;

public abstract class  Cartes {
    private  nomCarte nom ;
    private int numCarte ;

    protected Cartes (nomCarte nom , int numCarte ) {
        this.nom = nom;
        this.numCarte=numCarte; }

    abstract void appliquerEffet(Joueur joueur, Joueur adversaire);
}