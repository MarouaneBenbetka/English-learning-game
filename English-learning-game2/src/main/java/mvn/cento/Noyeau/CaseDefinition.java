package mvn.cento.Noyeau;

import java.util.Scanner;

public class CaseDefinition extends Case{

    private EnonceDefinition enonce;

    private final static int POINTS_PLUS = 20;
    private final static int DEPLACEMENT = 4 ;
    private final static int POINTS_MOINS = -10 ;



    public CaseDefinition(){
        setCouleur(Couleur.BLEU);
    }

    @Override
    public void traiter(Partie partie) {
        this.enonce =  Jeu.enonceDefinitions.poll();
        Jeu.enonceDefinitions.add(this.enonce);

        System.out.println("Traitement d'une case de definition :\n"+enonce.getQuestion());
        Scanner input = new Scanner(System.in);
        String  reponse = input.nextLine();

        if(reponse.equals(enonce.getQuestion())){

            //reponse juste
            System.out.println("Reponse juste");
            partie.ajouterPoints(POINTS_PLUS);
            partie.getPlateau().deplacer(DEPLACEMENT);
        }else {
            //reponse false
            System.out.println("Reponse fausse");
            partie.ajouterPoints(POINTS_MOINS);
        }


    }
}
