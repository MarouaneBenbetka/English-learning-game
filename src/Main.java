import Exceptions.*;

public class Main {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        try {
            jeu.creerCompte("Marouane99" , "blabla");
        }catch (utilisateurDejaExistantException e){
            System.out.println(e.getMessage());
        }



        jeu.getPartie().creerPartie();
        jeu.getPartie().lancerPartie();

    }
}

