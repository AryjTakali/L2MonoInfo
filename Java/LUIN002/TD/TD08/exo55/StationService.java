public class StationService {

    public void remplirReservoir(Object o) {
        if (o instanceof Motorise)
            ((Motorise)o).faireLePlein();
        else
            System.out.println("Il n'y a pas de moteur");
    }
}