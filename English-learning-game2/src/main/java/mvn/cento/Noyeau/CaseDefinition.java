package mvn.cento.Noyeau;

import java.util.Scanner;

public class CaseDefinition extends Case{

    private EnonceDefinition enonce;
    private  boolean result ;

    private final static int POINTS_PLUS = 20;
    private final static int DEPLACEMENT = 4 ;
    private final static int POINTS_MOINS = -10 ;



    public CaseDefinition(){
        setCouleur(Couleur.BLEU);
    }

    @Override
    public void traiter(Partie partie) {
        if(result){
            partie.ajouterPoints(POINTS_PLUS);
            partie.getPlateau().deplacer(DEPLACEMENT);
        }else {
            partie.ajouterPoints(POINTS_MOINS);
        }

    }




    public EnonceDefinition getEnonce() {
        this.enonce =  Jeu.enonceDefinitions.poll();
        Jeu.enonceDefinitions.add(this.enonce);
        return enonce;
    }

    public boolean verifyerReponse(String reponse){
        result = reponse.equals(enonce.getReponse());
        return  result;
    }




}
