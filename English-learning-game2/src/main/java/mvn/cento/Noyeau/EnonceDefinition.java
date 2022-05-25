package mvn.cento.Noyeau;

import java.io.Serializable;

public class EnonceDefinition implements Serializable {

    private  String question ;
    private  String[]  reponses = new String[4];

    private int indiceBonneReponse ;

    public EnonceDefinition(String question , String[] reponses , int indiceBonneReponse) {
        this.question = question;
        this.reponses = reponses;
        this.indiceBonneReponse = indiceBonneReponse;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getReponses() {
        return reponses;
    }

    public int getIndiceBonneReponse() {
        return indiceBonneReponse;
    }
}
