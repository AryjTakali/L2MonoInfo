class Batterie extends Instrument{

    public Batterie(double poids, double prix){
        super(poids, prix);
    }

    public Batterie(){
        this(50, 500);
    }

    public String getInstruName(){
        return "Batterie";
    }

    public void jouer(){
        System.out.println("Tatatataatatatatatat \nLa Batterie joue.");
        }
}