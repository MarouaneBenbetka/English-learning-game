package mvn.cento.Noyeau;

import mvn.cento.Noyeau.Exceptions.*;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Plateau implements Serializable {

    private final Case[] cases = new Case[100];
    private final De[] des = {new De() , new De()};
    private int positionCourante ;

    private  final static  int nbCaseBonus = 5;
    private  final static  int nbCaseMalus = 5 ;
    private  final static  int nbCaseSaut =5  ;
    private  final static  int nbCaseDefinition  = 5;
    private  final static  int nbCaseImage =5 ;


    /**
     * generer un plateau totlement aleatoire avec 100 cases
     */
    public Plateau(){
        positionCourante = 0 ;

        cases[0] = new CaseDepart();


        // 0:bonus-1:malus-2:saut-3:definition-4:image-5:parcours
        int caseType ;


        int[] nbCaseParType = {nbCaseBonus ,nbCaseMalus,nbCaseSaut ,nbCaseDefinition ,nbCaseImage , 98-(25) };


        cases[0] = new CaseDepart();
        System.out.println(cases[0].getClass());


        int lastSpecialCasePosition =0;
        int lastSpecialCaseType = -1 ;
        int posInsideGroupe = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        for(int i = 1 ; i <= 3 ; i++){


            if((i)%4 == posInsideGroupe){
                do{
                    caseType = ThreadLocalRandom.current().nextInt(0, 4 + 1);

                }while( nbCaseParType[caseType] == 0);

                if(caseType == 1 && posInsideGroupe==1){
                    posInsideGroupe++;
                    caseType = 5 ;
                }else{
                    nbCaseParType[caseType]--;
                    lastSpecialCasePosition=i;
                    lastSpecialCaseType = caseType;
                }




            }else {
                caseType = 5;
                nbCaseParType[5]--;
            }

            switch (caseType) {
                case 0 -> cases[i] = new CaseBonus();
                case 1 -> cases[i] = new CaseMalus();
                case 2 -> cases[i] = new CaseSaut();
                case 3 -> cases[i] = new CaseDefinition();
                case 4 -> cases[i] = new CaseImage();
                case 5 -> cases[i] = new CaseParcours();

            }
            System.out.println(i+":"+cases[i].getClass());
        }



        //groupes de milieu
        for(int j=1 ; j< 24; j++) {

                posInsideGroupe = ThreadLocalRandom.current().nextInt(0, 3 + 1);

            for (int i = j * 4; i <= j * 4 + 3; i++) {


                    if ((i) % 4 == posInsideGroupe) {
                        do {
                            caseType = ThreadLocalRandom.current().nextInt(0, 4 + 1);

                        } while (nbCaseParType[caseType] == 0);
                        nbCaseParType[caseType]--;




                        if(caseType == 1 && i-2 == lastSpecialCasePosition && lastSpecialCaseType == 0){

                                posInsideGroupe++;
                                nbCaseParType[caseType]++;
                                caseType =5 ;


                        }else{
                            lastSpecialCaseType = caseType;
                            lastSpecialCasePosition = i ;
                        }


                    } else {
                        caseType = 5;
                    }








                switch (caseType) {
                    case 0 -> cases[i] = new CaseBonus();
                    case 1 -> cases[i] = new CaseMalus();
                    case 2 -> cases[i] = new CaseSaut();
                    case 3 -> cases[i] = new CaseDefinition();
                    case 4 -> cases[i] = new CaseImage();
                    case 5 -> cases[i] = new CaseParcours();

                }
                System.out.println(i+":"+cases[i].getClass());

            }

        }



        //dernier groupe
        posInsideGroupe = ThreadLocalRandom.current().nextInt(0, 2 + 1);
        for(int i = 96 ; i <= 98 ; i++){


            if(i%4 == posInsideGroupe){

                do{
                    caseType = ThreadLocalRandom.current().nextInt(0, 4 + 1);

                }while( nbCaseParType[caseType] == 0 );
                nbCaseParType[caseType]--;

//cas speciale
                if(caseType == 1 && i-2 == lastSpecialCasePosition && lastSpecialCaseType == 0){
                    posInsideGroupe++;
                    nbCaseParType[caseType]++;
                    caseType =5 ;
                }


            }else {
                caseType = 5;

            }

            switch (caseType) {
                case 0 -> cases[i] = new CaseBonus();
                case 1 -> cases[i] = new CaseMalus();
                case 2 -> cases[i] = new CaseSaut();
                case 3 -> cases[i] = new CaseDefinition();
                case 4 -> cases[i] = new CaseImage();
                case 5 -> cases[i] = new CaseParcours();

            }
            System.out.println(i+":"+cases[i].getClass());
        }


        cases[99] = new CaseFin();
        System.out.println("99:"+cases[99].getClass());


    }



    //getters-setters

    public int lancerDes(){
        return this.des[0].lancerDe() +  this.des[1].lancerDe() ;
    }

    public int getDe1(){return des[0].getNumero();}
    public int getDe2(){return des[1].getNumero();}
    public void positioner(int pos , int posCorrect) throws positionInvalideException {
        if(  pos != posCorrect)  throw  new positionInvalideException() ;

        this.positionCourante = pos ;
    }


    public void positioner(int pos ) {
        this.positionCourante = pos ;
    }

    public int deplacer(int dep){
        positionCourante+= dep ;
        return positionCourante;
    }

    public int getPositionCourante() {
        return positionCourante;
    }


    public Case getCaseCourante(){
        return cases[positionCourante] ;
    }

    public Case getCaseParPosition(int pos){return  cases[pos] ;}
}
