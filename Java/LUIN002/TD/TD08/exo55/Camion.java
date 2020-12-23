public class Camion extends VehiculeAMoteur implements Motorise{

    public void rouler() { 
        System.out.println("Le camion roule");
    }

    public void faireLePlein() {
        System.out.println("Le plein du camion est fait");
    }
}