public class Histo {
    int[] hist;

    public Histo(){
        hist = new int[21];
        for (int i = 0; i <hist.length; i++){
            hist[i] = 0;
        }
    }

    public Histo(int[] tab){
        hist = new int[21];
        for (int i = 0; i <hist.length && i < tab.length; i++){
            hist[i] = tab[i];
        }
    }

    public void ajoutNote(int note){
        hist[note]++;
    }

//bon je me suis un peu amusé a faire un tableau horizontal qui sera surement décalé s'il y a plus de 99 eleves qui ont une certaine note
    public void afficheHistrogrammeTableau(){
        for(int i = 0; i < hist.length; i++){
            System.out.print(i + (i < 10 && hist[i] > 9 ? " " : "") +  "  |  ");
        }
            System.out.print("\n");
        for(int i = 0; i < hist.length; i++){
            System.out.print(hist[i] + (i > 9 && hist[i] < 10 ? " " : "") + "  |  ");
        }
    }

    public void afficheHistrogramme(){
        System.out.println("\n");
        for(int i = 0; i<hist.length; i++){
            System.out.print(i + (i < 10  ? " " : "") +  "  |  ");
            for (int j = 0; j<hist[i]; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    } 
}