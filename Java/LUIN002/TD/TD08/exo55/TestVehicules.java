public class TestVehicules {
 public static void main(String[] args ){

        Vehicule[] tab= {new Velo(), new Voiture(), new Moto() }; 
        Object[] tab1= {new Velo(), new Voiture(), new Tondeuse() }; 
        StationService station=new StationService() ;


        for(Vehicule v : tab) {
            v.rouler();
            station.remplirReservoir(v);
        }
        System.out.println("\nLe tableau 2 :");
        for(int i=0;i<tab.length;i++) {
            System.out.println(tab1[i].getClass());
            station.remplirReservoir(tab1[i]);
        }
    }
}