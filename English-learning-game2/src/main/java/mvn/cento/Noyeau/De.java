package mvn.cento.Noyeau;

import java.util.concurrent.ThreadLocalRandom;

public class De {
    private int numero  ;

    public int lancerDe(){
        this.numero = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        return numero;
    }


    public int getNumero(){return numero;}
    public void setNumero(int numero){this.numero = numero;}


}
