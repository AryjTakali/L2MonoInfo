class Guitare extends Instrument{

    public Guitare(double poids, double prix){
        super(poids, prix);
    }

    public Guitare(){
        this(5., 200);
    }

    public String getInstruName(){
        return "Guitare";
    }

    public void jouer(){
        System.out.println("TRummmmmTRUmmmmmmm \nLa guitare joue.");
        }
}