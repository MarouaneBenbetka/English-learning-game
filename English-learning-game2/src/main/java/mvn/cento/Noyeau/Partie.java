package mvn.cento.Noyeau;
import mvn.cento.Noyeau.Exceptions.positionInvalideException;
import java.io.*;
import java.util.Scanner;



public class Partie implements Serializable {

    private  final Joueur joueur;
    private Plateau plateau ;
    private int score ;
    private boolean finPartie;

    public Partie(Joueur joueur){
        this.joueur = joueur;
        finPartie = false;
    }

    public void sauvgarderPartie() {
        try{

            FileOutputStream fos  = new FileOutputStream("./src/main/resources/parties/"+joueur.getNom());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void chargerAncienPartie() throws IOException, ClassNotFoundException {


            FileInputStream fis =  new FileInputStream("./src/main/resources/parties/"+joueur.getNom());
            ObjectInputStream ois = new ObjectInputStream(fis);

            Partie partie = (Partie) ois.readObject();
            this.plateau = partie.plateau;
            this.score = partie.score;
            this.finPartie = partie.finPartie;
            ois.close();

    }


    public void creerPartie(){
        plateau = new Plateau();
        score = 0 ;
        finPartie = false;
    }



    public Joueur getJoueur() {
        return joueur;
    }



    public int getMeilleurScoreJeu(){return  Jeu.getMeilleurScore();}

    public void ajouterPoints(int pts) {
         score+= pts;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void stopPartie(){
        finPartie = true;
    }

    public int getScore(){return score;}

    public boolean getFinPartie(){return finPartie;}

}
