public class TestCouple {
    public static void main(String[] args) {
        Couple cA = new Couple(1, 5);
        Couple cB = new Couple(3, 7);
        System.out.println(cA.toString());
        System.out.println(cB.toString());
        Couple cAPlusCB = cA.addition(cB);
        System.out.println(cAPlusCB.toString());
    }
}