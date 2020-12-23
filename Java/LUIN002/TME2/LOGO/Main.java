import java.util.Vector;

public class Main {

    public static void testVecteur() {
        Vecteur v1 = new Vecteur(1, 2);
        Vecteur v2 = new Vecteur(0, 0);
        Vecteur v3 = new Vecteur(11, 3);

        v3.setVecteur(v1.addition(v2));
        System.out.println("Addition de [1,2] avec [0, 0] donne " + v3.toString());
        v2.setVecteur(new Vecteur(10, 1));
        v3.setVecteur(v1.addition(v2));
        System.out.println("Addition de [1,2] avec [10, 1] donne " + v3.toString());
        v1.setVecteur(new Vecteur(0, 1));
        v2.setVecteur(v1.rotation(Math.PI / 2));
        System.out.println("Rotation de Math.PI/2 sur [0,1] donne " + v2.toString());
        v1.setVecteur(new Vecteur(1, 1));
        v2.setVecteur(v1.rotation(Math.PI / 2));
        System.out.println("Rotation de Math.PI/2 sur [1,1] donne " + v2.toString());

    }

    public static void main(String[] args) {
         testVecteur();
    }
}
