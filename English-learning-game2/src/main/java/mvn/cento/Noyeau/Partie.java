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
            FileOutputStream fos  = new FileOutputStream("./src/Donnes/Parties/"+joueur.getNom());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void chargerAncienPartie(){
        try{
            FileInputStream fis = new FileInputStream("./src/Donnes/Parties/"+joueur.getNom());
            ObjectInputStream ois = new ObjectInputStream(fis);
            Partie partie = (Partie) ois.readObject();
            this.plateau = partie.plateau;
            this.score = partie.score;
            this.finPartie = partie.finPartie;
            ois.close();
        }catch (Exception e){ //@Todo
            System.out.println(e.getMessage());
        }
    }


    public void creerPartie(){
        plateau = new Plateau();
        score = 0 ;

    }






    public void lancerPartie(){

        int deplacement ;

        finPartie = false;
        while(!finPartie){

            deplacement = plateau.lancerDes();
            System.out.println("Deplacement ="+deplacement);

           if(plateau.getPositionCourante()+deplacement <= 99)
           {
               //user input
               while(true){
                   try{
                       Scanner input = new Scanner(System.in);
                       int pos = input.nextInt();
                       input.nextLine();
                       plateau.positioner(pos,deplacement);
                       break;

                   }catch (positionInvalideException e){
                       System.out.println(e.getMessage());
                   }
               }


               System.out.println("Position : "+plateau.getPositionCourante()+" , Type"+plateau.getCaseCourante().getClass() +" Score "+score);

               plateau.getCaseCourante().traiter(this);
           }

           else{
               System.out.println("not exact");
               plateau.deplacer(99-(plateau.getPositionCourante()+deplacement));
           }

            System.out.println("Position : "+plateau.getPositionCourante()+" , Type"+plateau.getCaseCourante().getClass() +" Score "+score);


        }

    }



    //getters - setters

    public Joueur getJoueur() {
        return joueur;
    }


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
