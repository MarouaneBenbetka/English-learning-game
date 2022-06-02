package mvn.cento.Noyeau;

import mvn.cento.Main;
import mvn.cento.Noyeau.Exceptions.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class Jeu {

    private Partie partie ;
    private HashMap<String, Joueur> joueurs = new HashMap<>();


    // listes des enonces qui vont etre generer a partir d'un ficher
    public static LinkedList<EnonceDefinition> enonceDefinitions = new LinkedList<>();
    public static LinkedList<EnonceImage> enonceImages = new LinkedList<>();


    public Jeu(){

        chargerComptes();
        chargerEnonceDefinitions();
        chargerEnonceImages();

    }


    public void identifier(String nom, String motDePasse) throws utilisateurNonExistantException, motDePasseIncorrectException {

        Joueur joueur = joueurs.get(nom);

        if (joueur == null) throw new utilisateurNonExistantException();
        if (!joueur.verifierMotDePasse(motDePasse)) throw new motDePasseIncorrectException();

        this.partie = new Partie(joueur);
    }

    public void creerCompte(String nom, String motDePasse , String motDePasse2) throws utilisateurDejaExistantException , confirmMotDePasseException , nomUtilisateurVideException , confirmMotDePasseVideException, motDePasseVideException {

        if(nom.replace(" ","").equals("")) throw new nomUtilisateurVideException();

        if(motDePasse.equals("")) throw  new motDePasseVideException();
        if(motDePasse2.equals("")) throw  new confirmMotDePasseVideException();
        if (joueurs.containsKey(nom)) throw new utilisateurDejaExistantException();

        if(!motDePasse.equals(motDePasse2)) throw new confirmMotDePasseException() ;

        Joueur joueur = new Joueur(nom, motDePasse);
        joueurs.put(nom, joueur);

        this.partie = new Partie(joueur);
        sauvgarderJoueurs();

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

        Collections.shuffle(enonceDefinitions);
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
        Collections.shuffle(enonceImages);
        for (EnonceImage a : enonceImages){
            System.out.println(a.getQuestion() +"/"+a.getIndiceBonneReponse());
        }
    }


    public void chargerComptes(){

        try {


            URL resourceUrl = Main.class.getResource("data/comptes");

            File file = new File(resourceUrl.toURI());

            FileInputStream fis =  new FileInputStream(file);

            ObjectInputStream ois = new ObjectInputStream(fis);
            joueurs = (HashMap<String, Joueur> ) ois.readObject();

            for(Map.Entry<String,Joueur> entry : joueurs.entrySet()) {
                String key = entry.getKey();
                Joueur value = entry.getValue();

                System.out.println(key + " => " + value);
            }


            ois.close();
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


    }


    public void sauvgarderPartie(){}

    public void sauvgarderJoueurs(){

        /*

        Joueur marouane = new Joueur("Marouane","111"  );
        marouane.setMeilleurScore(201);
        joueurs.put("Marouane" ,marouane );
        Joueur islam =  new Joueur("Islam","111"  );
        islam.setMeilleurScore(1);
        joueurs.put("Islam" , islam);
        joueurs.put("Raid" , new Joueur("Raid","111"  ));
        joueurs.put("Houssam" , new Joueur("Houssam","111"  ));
*/

        try {
            URL resourceUrl = Main.class.getResource("data/comptes");
            File file = new File(resourceUrl.toURI());
            FileOutputStream fos =  new FileOutputStream(file)  ;
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(joueurs);
            oos.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}
