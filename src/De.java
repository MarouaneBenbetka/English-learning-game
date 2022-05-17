import java.util.concurrent.ThreadLocalRandom;

public class De {
    int numero  ;

    public int lancerDe(){
        this.numero = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        return numero;
    }




}
