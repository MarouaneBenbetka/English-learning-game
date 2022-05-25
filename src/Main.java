import Exceptions.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws utilisateurDejaExistantException {


        Jeu jeu = new Jeu();

        Scanner input = new Scanner(System.in);



        while (true){
            System.out.print("User Name :");
            String userName =  input.nextLine();
            System.out.print("Password :");
            String password = input.nextLine();

            try {
                jeu.identifier(userName  , password);
                jeu.getPartie().creerPartie();
                jeu.getPartie().lancerPartie();
                break;

            }catch (utilisateurNonExistantException | motDePasseIncorrectException e){
                System.out.println(e.getMessage());
            }

        }




    }
}
