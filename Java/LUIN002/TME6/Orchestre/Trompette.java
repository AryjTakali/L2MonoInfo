class Trompette extends Instrument{

    public Trompette(double poids, double prix){
        super(poids,prix);
    }
    public Trompette(){
        this(3, 172);
    }

    public String getInstruName(){
        return "Trompette";
    }

    public void jouer(){
        System.out.println("TUTTURUTUTUTUTUTUUU  TURUTUTUTUTUTUTU\nLa Trompette joue.");
    }
}