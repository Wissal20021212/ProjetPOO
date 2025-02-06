package cartes;

public abstract class  Cartes {
    private  nomCarte nom ;
    private String description ;
    private int numCarte ;

    protected Cartes (nomCarte nom , String description , int numCarte ) {
        this.nom = nom;
        this.description = description;
        this.numCarte=numCarte; }
    public abstract void effet();




}