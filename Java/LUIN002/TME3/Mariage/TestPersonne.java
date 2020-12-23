public class TestPersonne {
    public static void main(String[] args) {
        Personne p1 = new Personne();
        Personne p2 = new Personne();
        Personne p3 = new Personne();

        System.out.println("Les personnes : ");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println("Marriage de " + p1.toString() + " et de " + p2.toString());
        p1.epouser(p2);
        System.out.println("Les personnes apres marriage : ");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println("Essai de marriage de " + p2.toString() + " et de " + p3.toString());
        p2.epouser(p3);
        System.out.println("Essai de marriage de " + p3.toString() + " et de " + p3.toString());
        p3.epouser(p3);
        System.out.println("Divorce de " + p1.toString() + " et de " + p2.toString());
        p1.divorcer();
        System.out.println("Les personnes apres divorce : ");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}
