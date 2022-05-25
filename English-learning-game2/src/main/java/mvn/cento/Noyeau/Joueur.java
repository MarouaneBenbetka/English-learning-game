package mvn.cento.Noyeau;

import java.io.Serializable;
import java.util.Objects;

public class Joueur  implements Comparable<Joueur> , Serializable {

    private String nom ;
    private String motDePasse;
    private int meilleurScore   ;







    public Joueur(String nom , String  motDePasse){
        this.nom = nom;
        this.motDePasse = motDePasse;
         meilleurScore = 0;
    }

    /**
    verifier si le mot de passe est correct
    */
    public boolean verifierMotDePasse(String motDePasse){
        return this.motDePasse.equals(motDePasse);
    }


    public int getMeilleurScore() {
        return meilleurScore;
    }

    public void majMeilleurScore(int Score) {
        if(Score > this.meilleurScore) this.meilleurScore = Score ;
    }




    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Joueur)) return false;
        Joueur joueur = (Joueur) o;
        return nom.equals(joueur.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    //getters -- setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int compareTo(Joueur joueur) {

        if(this.nom.equals(joueur.nom)) return 0;
        if(this.meilleurScore >= joueur.meilleurScore) return 1;
        return  -1 ;
    }
}
