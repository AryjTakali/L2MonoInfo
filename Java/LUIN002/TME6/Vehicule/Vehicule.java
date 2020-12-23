class Vehicule{
    private static int numId = 0;
    protected final int myNumId;
    private double distance = 0;

    public Vehicule(){
        numId++;
        myNumId = numId;
    }
    
    public double getDistance(){
        return distance;
    }

    public void rouler(double d){
        distance += d;
    }
    
    public String toString(){
        return "Il s'agit d'un vehicule de numero d'identification :" + myNumId + " qui a parcouru " + distance + "km";
    }
}