public class TrianglePascal {
    private int[][] t;
    
    //le constructeur prend un int en parametre 
    //et reserve la memoire suffisante pour nb lignes
    public TrianglePascal(int nb){
        if (nb < 1){
            System.out.println("Le nombre rentré en parametre n'est pas valide.");
            nb = 0 ;
        }
        t = new int[nb + 1][];
        for (int i = 0; i < t.length; i++){
            t[i] = new int[i];
            //on remplit instancie toutes les cases a 0
            for (int index : t[i]){
                index = 0;
            }
        }
    }

    //si aucun int n'est rentré en parametre cela va creer un triangle a 5 ligne par defaut
    public TrianglePascal(){
        this(5);
    }
    public void remplirTriangle(){
        for (int i = 0; i < t.length; i++){
            for (int j = 0; j < t[i].length; j++){
                if (j == 0 || j + 1 == t[i].length)
                    t[i][j] = 1;
                else if (t[i-1][j-1] != 0 && t[i-1][j] != 0)
                    t[i][j] = t[i - 1][j - 1] + t[i - 1][j];
            }
        }
    }

    @Override
    public String toString(){
        String s = "";
        for (int[] i  : t){
            for (int j : i){
                s += j + " ";
            }
            s += "\n";
        }
        return s;
    }
}