package mvn.cento.Noyeau.Exceptions;

public class utilisateurDejaExistantException extends Exception {
    public utilisateurDejaExistantException(){
        super("nom utilisateur deja existant");
    }
}
