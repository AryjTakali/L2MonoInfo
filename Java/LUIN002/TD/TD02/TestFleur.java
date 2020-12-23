public class TestFleur {
    public static void main(String[] args) {
        Fleur tulipe = new Fleur("Tulipe", "Jaune");
        Fleur rose = new Fleur();
        System.out.println(tulipe.getNom());
        System.out.println(tulipe.toString());
        System.out.println(rose.getNom());
        System.out.println(rose.toString());
    }
}