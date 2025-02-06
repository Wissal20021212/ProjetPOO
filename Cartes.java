public abstract class  Cartes {
    private  String nom ;
    private String description ;
    private int numCarte ;

    protected Cartes (String nom , String description , int numCarte ) {
        this.nom = nom;
        this.description = description;
        this.numCarte=numCarte;

    }
}