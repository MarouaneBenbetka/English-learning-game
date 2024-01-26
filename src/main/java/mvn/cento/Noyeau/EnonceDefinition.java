package mvn.cento.Noyeau;

import java.io.Serializable;

public class EnonceDefinition implements Serializable{

    private  String question ;
    private String reponse;


    public EnonceDefinition(String question , String reponse ) {
        this.question = question;
        this.reponse = reponse;
    }

    public String getQuestion() {
        return question;
    }
    public String getReponse(){return reponse;}

}
