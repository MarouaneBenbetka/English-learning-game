package mvn.cento.Noyeau;

import java.util.Scanner;

public class CaseImage extends Case{

    private EnonceImage enonce;

    private final static int POINTS_PLUS = 20;
    private final static int DEPLACEMENT = 2 ;

    public CaseImage(){
        setCouleur(Couleur.ROSE);
    }

    @Override
    public void traiter(Partie partie) {
        this.enonce =  Jeu.enonceImages.poll();
        Jeu.enonceImages.add(this.enonce);

        System.out.println("Traitement d'une case d'image :\n"+enonce.getQuestion());

        Scanner input = new Scanner(System.in);
        int indiceSelectione = input.nextInt();

        if(indiceSelectione == this.enonce.getIndiceBonneReponse()){

            //reponse juste
            System.out.println("Reponse juste");
            partie.ajouterPoints(POINTS_PLUS);
            partie.getPlateau().deplacer(DEPLACEMENT);
        }else {
            //reponse false
            System.out.println("Reponse fausse");
        }


    }
}
