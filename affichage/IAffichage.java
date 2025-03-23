package affichage;

public interface IAffichage {

    void afficherCarte(String titre, String description, int numCarte);
    void afficherEtat(String nom, int vie, int popularite);
    void afficherTour(String nom);
    void afficherGagnant(String nom);
    int choisirCarte( int nbMaxCarte);

    void afficherMain(String nom);
}