public class TestPion {
    public static void main(String[] args) {
        Pion unPion = new Pion("Atchoum");
        Pion autrePion = new Pion(unPion);
        Pion dernierPion = autrePion.clone();

        // System.out.println("un pion");
        System.out.println(unPion.toString());
        // System.out.println("autre pion");
        System.out.println(autrePion.toString());
        autrePion.setNom("Dormeur");
        // System.out.println("dernier pion");
        System.out.println(dernierPion.toString());
        dernierPion.setNom("Farceur");
        autrePion.seDeplacer();
    }
}