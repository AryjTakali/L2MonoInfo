public class TestComplexe {
    public static void main(String[] args) {
        Complexe c1 = new Complexe(1., 1.);
        Complexe c2 = c1.addition(c1);
        Complexe c3 = c1.multiplication(c2);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println("\n" + c3.toString() + " est reelle : " + c3.estReel());
        System.out.println(c3.toString() + " est imaginaire : " + c3.estImaginaire());

    }
}