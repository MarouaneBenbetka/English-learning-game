import Exceptions.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Jeu {

    private Partie partie ;
    private TreeMap<String, Joueur> joueurs = new TreeMap<>();


    // listes des enonces qui vont etre generer a partir d'un ficher
    public static Queue<EnonceDefinition> enonceDefinitions = new LinkedList<>();
    public static Queue<EnonceImage> enonceImages = new LinkedList<>();


    public Jeu(){
        //sauvgarderJoueurs();
        chargerEnonceDefinitions();
        chargerEnonceImages();
        chargerComptes();
    }


    public void identifier(String nom, String motDePasse) throws utilisateurNonExistantException, motDePasseIncorrectException {

        Joueur joueur = joueurs.get(nom);

        if (joueur == null) throw new utilisateurNonExistantException();
        if (!joueur.verifierMotDePasse(motDePasse)) throw new motDePasseIncorrectException();

        this.partie = new Partie(joueur);
    }

    public void creerCompte(String nom, String motDePasse) throws utilisateurDejaExistantException {

        if (joueurs.containsKey(nom)) throw new utilisateurDejaExistantException();

        Joueur joueur = new Joueur(nom, motDePasse);
        joueurs.put(nom, joueur);

        this.partie = new Partie(joueur);

    }




    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public void chargerEnonceDefinitions(){

        try{

            FileInputStream fis = new FileInputStream("./src/Donnes/enoncesDefinitions");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.enonceDefinitions = (Queue<EnonceDefinition>) ois.readObject();
            ois.close();

            /*for(EnonceDefinition e : this.enonceDefinitions){
                System.out.println("Question"+e.getQuestion());
            }*/


        }catch (Exception e){
            System.out.println(e.getMessage()+e.getStackTrace());
        }


    }
    public void chargerEnonceImages(){


        try{

            FileInputStream fis = new FileInputStream("./src/Donnes/enoncesImages");
            ObjectInputStream ois = new ObjectInputStream(fis);
            enonceImages = (Queue<EnonceImage>) ois.readObject();
            ois.close();
           /* for(EnonceImage e : enonceImages){
                System.out.println("Question Image"+e.getQuestion());
            }*/


        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }


    }
    public void chargerComptes(){

        try {
            FileInputStream fis = new FileInputStream("./src/Donnes/comptes");
            ObjectInputStream ois = new ObjectInputStream(fis);
            joueurs = (TreeMap<String, Joueur> ) ois.readObject();
            ois.close();



        }catch (IOException | ClassNotFoundException e){
            System.out.println("Compte :"+e.getMessage());
        }


    }


    public void sauvgarderPartie(){}

    public void sauvgarderJoueurs(){
        //uncomment this code if you want to generate a new file
        joueurs.put("Marouane" , new Joueur("Marouane","111"  ));
        joueurs.put("Islam" , new Joueur("Islam","111"  ));
        joueurs.put("Raid" , new Joueur("Raid","111"  ));
        joueurs.put("Houssam" , new Joueur("Houssam","111"  ));


        //write to a file
        try {
            FileOutputStream fos = new FileOutputStream("./src/Donnes/comptes");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(joueurs);
            oos.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



        try {
            FileOutputStream fos = new FileOutputStream("./src/Donnes/comptes");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(joueurs);
            oos.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void sauvgarderQuestionsText(){

        /*        String[] urls = new String[] {"aa" , "bb" , "cc" , "dd"} ;


        EnonceDefinition enonceDefinition = new EnonceDefinition("Question def 1 ?" , urls , 1) ;

        enonceDefinitions.add(enonceDefinition);
        enonceDefinition = new EnonceDefinition("Question def 2 ?" , urls , 1);
        enonceDefinitions.add(enonceDefinition);
        enonceDefinition = new EnonceDefinition("Question def 3 ?" , urls , 1);

        enonceDefinitions.add(enonceDefinition);
        enonceDefinition = new EnonceDefinition("Question def 4 ?" , urls , 1);

        enonceDefinitions.add(enonceDefinition);*/


        try
        {
            FileOutputStream fos = new FileOutputStream("./src/Donnes/enoncesDefinitions");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(enonceDefinitions);
            oos.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public void sauvgarderQuestionsImage(){
       /*     String[] urls = new String[] {"aa" , "bb" , "cc" , "dd"} ;


        EnonceImage enonceImage = new EnonceImage("Question image 1?" , urls , 1) ;
        enonceImages.add(enonceImage);
        enonceImage = new EnonceImage("Question image 2?" , urls , 1);
        enonceImages.add(enonceImage);
        enonceImage = new EnonceImage("Question image 3?" , urls , 1);
        enonceImages.add(enonceImage);
        enonceImage = new EnonceImage("Question image 4?" , urls , 1);
        enonceImages.add(enonceImage);*/



        try {
            FileOutputStream fos = new FileOutputStream("./src/Donnes/enoncesImages");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(enonceImages);
            oos.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }



}
