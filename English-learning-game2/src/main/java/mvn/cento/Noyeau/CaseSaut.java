package mvn.cento.Noyeau;

import java.util.concurrent.ThreadLocalRandom;

public class CaseSaut extends Case{
    private int position ;

    public CaseSaut(){
        setCouleur(Couleur.ORANGE);
    }

    @Override
    public void traiter(Partie partie) {

        position = ThreadLocalRandom.current().nextInt(0, 99 + 1);
        partie.getPlateau().positioner(position );

    }
}
