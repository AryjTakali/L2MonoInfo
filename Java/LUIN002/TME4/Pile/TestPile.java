public class TestPile {
    public static void main(String args[]){
        Machin m1 = new Machin("un", 1);
        Machin m2 = new Machin("deux", 2);
        Machin m3 = new Machin("trois", 3);
        Pile p1 = new Pile(4);

        System.out.print("\nPremier Test : \n");
        p1.empiler(m1);
        System.out.print(m1.toString() + " a ete empile\n");
        p1.empiler(m2);
        System.out.print(m2.toString() + " a ete empile\n");
        p1.empiler(m3);
        System.out.print(m3.toString() + " a ete empile\n");
        System.out.print("\nPile est de valeur : \n");
        System.out.print(p1.toString());

        System.out.print("\nDeuxieme Test : \n");
        System.out.print(p1.depiler().toString() + " a ete depile\n");
        System.out.print(p1.depiler().toString() + " a ete depile\n");
        System.out.print("\nPile est de valeur : \n");
        System.out.print(p1.toString());

        System.out.print("\nTroisieme Test : \n");
        p1.empiler(m3);
        System.out.print(m3.toString() + " a ete empile\n");
        System.out.print("\nPile est de valeur : \n");
        System.out.print(p1.toString());

    }
}