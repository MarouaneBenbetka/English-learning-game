package Exceptions;

public class motDePasseIncorrectException extends Exception{

    public motDePasseIncorrectException(){
        super("votre mot de passe est incorrect");
    }
}
