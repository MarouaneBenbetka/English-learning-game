package mvn.cento.Noyeau;

public class CaseImage extends Case{

    private EnonceImage enonce;
    private  boolean result ;

    private final static int POINTS_PLUS = 20;
    private final static int DEPLACEMENT = 2 ;

    public CaseImage(){
        setCouleur(Couleur.ROSE);
    }

    @Override
    public void traiter(Partie partie) {

        if(result){
            partie.ajouterPoints(POINTS_PLUS);
            partie.getPlateau().deplacer(DEPLACEMENT);
        }


    }

    public EnonceImage getEnonce() {
        this.enonce =  Jeu.enonceImages.poll();
        Jeu.enonceImages.add(this.enonce);
        return enonce;
    }


    public boolean verifyerReponse(int index){
        result = enonce.getIndiceBonneReponse() == index ;
        return  result;
    }


}
