public class Tableaux{
    public static void main(String args[]){
        double[] tabD = new double[3];
        double[] tabDs = {1.,2.,3.};
        int[][] tabI = new int[4][3];
        int nbElmt = tabD.length; //taillel d'un dableau
        int[][] tabTriangle  = new int[3][];

        for (int i = 0; i < 3 ; i++){
            tabTriangle[i] = new int[i];
        }
        Bouteille[] tabB = {new Bouteille(3), new Bouteille(1.5)};
        System.out.println(tabB[0].toString());

    }
}