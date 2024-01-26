package mvn.cento.Noyeau;

public class CaseBonus extends Case{
    private static final int POINTS  = 10;
    private static final int DEPLACEMENT  = 2;


    public CaseBonus(){
        setCouleur(Couleur.VERT);
    }

    @Override
    public void traiter(Partie partie) {
        partie.ajouterPoints(POINTS);
        partie.getPlateau().deplacer(DEPLACEMENT);
    }

}
