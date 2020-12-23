class Piano extends Instrument{

    public Piano(double poids, double prix){
        super(poids, prix);
    }
    public Piano(){
        this(100, 400);
    }

    public String getInstruName(){
        return "Piano";
    }

    public void jouer(){
        System.out.println("nananaaananananananaananananaanana\nLe piano joue.");
    }
}