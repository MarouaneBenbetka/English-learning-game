public abstract class Case {

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
