public class NUplet {
    int[] tab;

    public NUplet(int n) {
        tab = new int[n];
    }

    public NUplet(int n, int x) {
        this(n);
        for (int i = 0; i < tab.length; i++) {
            tab[i] = x;
        }
    }

    public NUplet(int a, int b, int c) {
        this(3);
        tab[0] = a;
        tab[1] = b;
        tab[2] = c;
    }
   
    //le constructeur donné ne créait pas de nouvelle instance il donnait juste la reference de t a tab 
    public NUplet(int[] t){
        this(t.length);
        for (int i = 0; i < t.length; i++){
            tab[i] = t[i];
        }
    }

    //la methode donné envoyait seulemnt la reference de tab au lieu instance il donnait juste la reference de t a tab 
    public int[] getTab(){
        int[] ret = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            ret[i] = tab[i];
        } 
        return ret;
    }

    @Override
    public String toString() {
        String s = "(";
        for (int i = 0; i < tab.length; i++) {
            if (i == tab.length - 1)
                s += tab[i] + ")";
            else
                s += tab[i] + ", ";
        }
        return s;
    }

    public int somme(){
        int s = 0;

        for (int i = 0; i < tab.length; i++){
            s += tab[i]; 
        }
        return s;
    }

    public boolean egal(NUplet n2){
        for (int i = 0; i < tab.length; i++){
            if (i >= n2.tab.length || tab[i] != n2.tab[i]){
                return false;
            }
        }
        return true;
    }
}