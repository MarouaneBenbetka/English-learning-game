package mvn.cento.Noyeau;

public class CaseFin extends Case{

    public CaseFin(){
        setCouleur(Couleur.NOIR);
    }

    @Override
    public void traiter( Partie partie) {

        partie.getJoueur().majMeilleurScore(partie.getScore());
        partie.stopPartie();

        Jeu.majMeilleurScore(partie.getJoueur());
        Jeu.sauvgarderJoueurs();

        partie.sauvgarderPartie();


    }
}
