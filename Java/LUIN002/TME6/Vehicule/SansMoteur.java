class SansMoteur extends Vehicule{

    public SansMoteur(){
        super();
    }

    public String toString(){
        return "Il s'agit d'un vehicule sans moteur.\nNumero d'identification = " + myNumId + "\nDistance parcouru : " + getDistance() + "km.";
    }
}