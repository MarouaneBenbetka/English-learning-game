package mvn.cento.Noyeau;

import mvn.cento.Main;
import mvn.cento.Noyeau.Exceptions.*;
import java.io.*;
import java.util.*;

public class Jeu {

    private Partie partie ;
    private TreeMap<String, Joueur> joueurs = new TreeMap<>();


    // listes des enonces qui vont etre generer a partir d'un ficher
    public static Queue<EnonceDefinition> enonceDefinitions = new LinkedList<>();
    public static Queue<EnonceImage> enonceImages = new LinkedList<>();


    public Jeu(){
        //sauvgarderJoueurs();
       // sauvgarderQuestionsImage();
        chargerEnonceDefinitions();
        chargerEnonceImages();
       // chargerComptes();
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

        Scanner input = new Scanner(Objects.requireNonNull(Main.class.getResourceAsStream("data/definitionsQuestions.txt")));
        String question = "" ;
        String reponse = "";
           while (input.hasNextLine()){
               String line = input.nextLine();

               if(line.startsWith("Question:")){
                   question = line.substring(9);
               }else if(line.startsWith("Reponse:")){
                   reponse = line.substring(8)  ;
                   enonceDefinitions.add(new EnonceDefinition(question,reponse));
               }

           }

        Collections.shuffle((LinkedList) enonceDefinitions);
           for (EnonceDefinition a : enonceDefinitions){
               System.out.println(a.getQuestion() + "/"+a.getReponse());
           }
    }


    public void chargerEnonceImages(){

        Scanner input = new Scanner(Objects.requireNonNull(Main.class.getResourceAsStream("data/imageQuestions.txt")));
        String question = "" ;
        String[] reponses = new String[4];
        int bonneReponse ;
        while (input.hasNextLine()){
            String line = input.nextLine();
            if(line.startsWith("definition:")){
                question = line.substring(11);
            }else if(line.startsWith("path1:")){
                reponses[0] = line.substring(6);
            }else if(line.startsWith("path2:")){
                reponses[1] = line.substring(6);
            }else if(line.startsWith("path3:")){
                reponses[2] = line.substring(6);
            }else if(line.startsWith("path4:")){
                reponses[3] = line.substring(6);
            }else if(line.startsWith("reponse:")){
                bonneReponse = Integer.parseInt(line.substring(8));
                enonceImages.add(new EnonceImage(question,reponses,bonneReponse));
            }
        }
        Collections.shuffle((LinkedList) enonceImages);
        for (EnonceImage a : enonceImages){
            System.out.println(a.getQuestion() +"/"+a.getIndiceBonneReponse());
        }
    }


    public void chargerComptes(){

        try {
            FileInputStream fis = new FileInputStream("./src/Donnes/comptes");
            ObjectInputStream ois = new ObjectInputStream(fis);
            joueurs = (TreeMap<String, Joueur> ) ois.readObject();
            ois.close();
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }


    }


    public void sauvgarderPartie(){}

    public void sauvgarderJoueurs(){

    }


}
