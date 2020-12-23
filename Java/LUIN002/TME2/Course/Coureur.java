public class Coureur {
    private int     numDossard;
    private double  tempsAu100;
    private boolean possedeTemoin;

    public Coureur(int numDossard){
        this.numDossard = numDossard;
        tempsAu100 = Math.random() * 4 + 12;
        possedeTemoin = false;
    }

    public Coureur(){
        numDossard = (int)(Math.random() * 1000 + 1);
        tempsAu100 = round(Math.random() * 4 + 12, 2);
        possedeTemoin = false;
    }

    public double round(double nb, int decimal){
        int div = 1;
        for (int i = 0; i < decimal; i++)
            div *= 10;
        nb = Math.round(nb*div);
        return nb / div;
    }
    public int getNumDossard(){
        return numDossard;
    }
    public double getTempsAu100(){
        return tempsAu100;
    }
    public boolean getPossedeTemoin(){
        return possedeTemoin;
    }
    
    public void setPossedeTemoin(boolean b){
        possedeTemoin = b;
    }
    public String YoN(){
        if (possedeTemoin)
            return "oui";
        else    
            return "non";
    }
    @Override
    public String toString(){
        return "Coureur : " + numDossard + ", temps au 100m ; " + tempsAu100 +" , possede le temoin " + YoN();
    }
    public void passeTemoin(Coureur c){
        System.out.println("moi coureur " + numDossard + ", je passe le temoin au coureur " + c.getNumDossard());
        possedeTemoin = false;
        c.setPossedeTemoin(true);
    }
    public void courir(){
        System.out.println("je suis le coureur " + numDossard + " et je cours");
    }

    public void finishRelay(double c1, double c2, double c3){
        double finishTime = c1 + c2 + c3 + tempsAu100;
        System.out.println("moi coureur " + numDossard + " j'ai fini la course!");
        System.out.println("Nous avons courru 400m en " + finishTime + " secondes");
    }

}