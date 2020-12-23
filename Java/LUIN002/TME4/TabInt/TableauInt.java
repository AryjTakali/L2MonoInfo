public class TableauInt {
    int[] tab;

    public TableauInt(){
        tab = new int[10];
        for (int i = 0; i < tab.length; i++){
            tab[i] = (int)(Math.random()*101);
        }
    }
    public TableauInt(int n){
        tab = new int[10];
        for (int i = 0; i < tab.length; i++){
            tab[i] = n + i;
        }
    }
    @Override
    public String toString(){
        String s = "[";
        for (int i = 0; i < tab.length; i++) {
            if (i == tab.length - 1)
                s += tab[i] + "]";
            else
                s += tab[i] + ", ";
        }
        return s;
    }

    //attention le rang renvoyé est l'indice du tableau (commencant a 0)
    public int rangMax(){
        int max = tab[0], rang = 0;

        for (int i = 0; i < tab.length; i++){
            if (max < tab[i]){
                max = tab[i];
                rang = i;
            }
        }
        return rang;
    }

    //rend le int maximum
    public int getMax(){
        return tab[rangMax()];
    }

    public int somme(){
        int s = 0;

        for (int i = 0; i < tab.length; i++){
            s += tab[i]; 
        }
        return s;
    }

    public boolean egal(TableauInt n2){
        for (int i = 0; i < tab.length; i++){
            if (i >= n2.tab.length || tab[i] != n2.tab[i]){
                return false;
            }
        }
        return true;
    }
}