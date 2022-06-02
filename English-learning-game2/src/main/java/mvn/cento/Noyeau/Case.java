package mvn.cento.Noyeau;

import java.io.Serializable;

public abstract class Case implements Serializable {

    private Couleur couleur  ;


    public abstract void traiter( Partie partie);



    //getters - setters
    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
}
