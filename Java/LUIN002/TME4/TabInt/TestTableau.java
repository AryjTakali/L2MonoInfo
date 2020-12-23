public class TestTableau {
    
    public static void main(String[] args) {
        TableauInt t1 = new TableauInt(1);
        TableauInt t2 = new TableauInt();
        TableauInt t3 = new TableauInt(1);
    
        System.out.println("t1 pour n = 1: " + t1.toString());
        System.out.println("t2 : " + t2.toString());
        System.out.println("t3 : " + t3.toString());
        System.out.println("\nrang max de t1 : " + t1.rangMax() + " et a pour valeur : " + t1.getMax());
        System.out.println("rang max de t2 : " + t2.rangMax() + " et a pour valeur : " + t2.getMax());
        System.out.println("\nt1 et t2 sont egaux : " +  t2.egal(t1));
        System.out.println("t1 et t3 sont egaux : " +  t3.egal(t1));
    }
}