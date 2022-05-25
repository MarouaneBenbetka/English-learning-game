package Noyeau;

public class CaseMalus extends Case{
    private final int POINTS  = -10;
    private final int DEPLACEMENT  = -2;


    public CaseMalus(){
        setCouleur(Couleur.ROUGE);
    }

    @Override
    public void traiter(Partie partie) {
        partie.ajouterPoints(POINTS);
        partie.getPlateau().deplacer(DEPLACEMENT);
    }

}
