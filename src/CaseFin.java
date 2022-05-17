public class CaseFin extends Case{

    public CaseFin(){
        setCouleur(Couleur.NOIR);
    }

    @Override
    public void traiter( Partie partie) {
        partie.stopPartie();
    }
}
