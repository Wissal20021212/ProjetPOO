package cartes;

public abstract class  Cartes {
    private  nomCarte nom ;
    private int numCarte ;
    private String description ;

    protected Cartes (nomCarte nom , String description , int numCarte) {
        this.nom = nom;
        this.numCarte=numCarte;
    this.description = description ;
    }

    abstract void appliquerEffet(Joueur joueur, Joueur adversaire);
    public String getDescription(){
        return description;
    }

    public nomCarte getNom() {
        return nom ;
    }
    public int getNumCarte() {
        return numCarte;
    }

}