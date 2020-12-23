public class TestNUplet {
    
public static void testQ4(){
    int [] t123 = {1,2,3};
    NUplet u3 = new NUplet(t123);
    System.out.println("\navant modif de t123 : " + u3.toString());
    t123[0] = 50;
    System.out.println("apres modif de t123 : " + u3.toString());

}

public static void testQ5(){
    NUplet u4 = new NUplet(4,5,6);
    int[] t456=u4.getTab();
    System.out.println("\navant modif de t456 : " + u4.toString());
    t456[0] = 70;
    System.out.println("apres modif de t456 : " + u4.toString());
}

public static void main(String[] args) {
    NUplet p = new NUplet(5, 3);
    NUplet t1 = new NUplet(7, 8, 9);
    NUplet t2 = new NUplet(7, 8, 9);

    System.out.println("p : " + p.toString());
    System.out.println("t1 : " + t1.toString());
    System.out.println("t2 : " + t2.toString());
    System.out.println("la somme de cet uplet p est : " + p.somme());
    System.out.println("la somme de cet uplet t1 est : " + t1.somme());
    System.out.println("t1 et p sont egaux : " +  p.egal(t1));
    System.out.println("t1 et t2 sont egaux : " +  t2.egal(t1));
    testQ4();
    testQ5();
    }

}