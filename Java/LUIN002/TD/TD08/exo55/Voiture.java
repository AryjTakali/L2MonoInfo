public class Voiture extends VehiculeAMoteur implements Motorise{

    public void rouler() { 
        System.out.println("La voiture roule");
    }

    public void faireLePlein() {
        System.out.println("Le plein de la voiture est fait");
    }
}