package mvn.cento.Noyeau;



import mvn.cento.Noyeau.Exceptions.motDePasseIncorrectException;
import mvn.cento.Noyeau.Exceptions.utilisateurNonExistantException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws motDePasseIncorrectException, utilisateurNonExistantException {
        Jeu jeu = new Jeu();


        Scanner input = new Scanner(System.in);

                jeu.identifier("Marouane"  , "111");
                jeu.getPartie().creerPartie();



    }
}

