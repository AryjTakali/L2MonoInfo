public class Hanoi {
    private int nbCoups;
    private Tour[] t;

    public Hanoi(int nbDisque){
        t= new Tour[3];
        t[0] = new Tour("Tour 1 ", nbDisque);
        t[1] = new Tour("Tour 2 ", 0);
        t[2] = new Tour("Tour 3 ", 0);
    }

    public Tour getTour(int i){
        if (i == 1 || i == 2)
            return t[i - 1];
        else
            return t[2];
    }

    public boolean deplacer(int i, int j){
        if (i >= 1 || i <= 3 || j >= 1 || j <= 3){
            if (t[i - 1].bougerVers(t[j - 1])){
                nbCoups++;
                return true;
            }
        }
        return false;
    }
    
    public String toString(){
        return "vous avez joué " + nbCoups + " coups.\n" + t[0].toString() + t[1].toString() + t[2].toString();
    }

    public boolean aGagne(){
        if (t[0].estVide() && t[1].estVide())
            return true;
        else
            return false;
    }
}