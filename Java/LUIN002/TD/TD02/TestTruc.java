public class TestTruc {
    public static void main(String[] args) {
        Truc t = new Truc();
        // ne compile pas car il n'existe pas de constructeur qui prend un argument
        // Truc t2 = new Truc(2);
// ne compile pas car assigne un double a un int
        // int i = 2.5;
        double deux = 2;
        t.maMethode(2);
        t.maMethode(deux);
        t.maMethode(2.);
        t.maMethode(1, 2);
        t.maMethode(1,2,3);
        //ne compile pas car aucun methode ne prend un int et 2 double
        // t.maMethode(1.,2,3);
    }
}