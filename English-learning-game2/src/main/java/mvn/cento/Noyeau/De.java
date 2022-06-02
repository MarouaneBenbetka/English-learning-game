package mvn.cento.Noyeau;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class De implements Serializable {
    private int numero  ;

    public int lancerDe(){
        this.numero = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        return numero;
    }


    public int getNumero(){return numero;}


}
