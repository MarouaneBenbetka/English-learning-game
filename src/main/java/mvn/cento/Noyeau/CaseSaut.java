package mvn.cento.Noyeau;

import java.util.concurrent.ThreadLocalRandom;

public class CaseSaut extends Case{
    private int position ;

    public CaseSaut(){
        setCouleur(Couleur.ORANGE);
    }

    @Override
    public void traiter(Partie partie) {

        do{

            position = ThreadLocalRandom.current().nextInt(0, 99 + 1);

        }while (position == partie.getPlateau().getPositionCourante());

        partie.getPlateau().positioner(position );

    }
}
