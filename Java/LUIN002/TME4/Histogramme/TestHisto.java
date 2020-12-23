public class TestHisto {

    public static void testBasic(){
        int [] t1 = {0,0,3,4,2,0,3,0,0,4,0,11};
        Histo h = new Histo(t1);
        h.ajoutNote(19);
        h.afficheHistrogrammeTableau();
        h.afficheHistrogramme(); 
    }

    /*cette premiere tentative que tableau de note aleatoire est certe plus rapide 
    mais tres irreguliere et a tendance a attribuer tout aux premiere case du tableau*/
    public static void test150Irreg(){
        int [] t1 = new int[21];
        int eleve = 150;
        for(int i = 0; i < t1.length; i++){
            t1[i] = (int)(Math.random()*(eleve + 1));
            eleve -= t1[i];
        }
        Histo h = new Histo(t1);
        h.ajoutNote(19);
        h.afficheHistrogrammeTableau();
        h.afficheHistrogramme(); 
    }

    /*Tandis que cette deuxieme tentative est beaucoup plus reguliere et donne une repartition coherente 
    neanmoins elle necessite plus de temps car elle fait appel a la fonction random pour chaque eleve*/
    public static void test150(){
        int [] t1 = new int[21];
        for(int i = 0; i < 150; i++){
            t1[(int)(Math.random()*21)]++;
        }
        Histo h = new Histo(t1);
        h.afficheHistrogrammeTableau();
        h.afficheHistrogramme(); 
    }


    public static void main(String args[]){
        // testBasic();
        test150();
    }
}