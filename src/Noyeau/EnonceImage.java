package Noyeau;

import java.io.Serializable;

public class EnonceImage implements Serializable {

    private final String question ;
    private  String[]  imagesUrl = new String[4];
    private final int indiceBonneReponse ;


    public EnonceImage(String question , String[] imagesUrl , int indiceBonneReponse) {
        this.question = question;
        this.imagesUrl = imagesUrl;
        this.indiceBonneReponse = indiceBonneReponse;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getImagesUrl() {
        return imagesUrl;
    }

    public int getIndiceBonneReponse() {
        return indiceBonneReponse;
    }
}
