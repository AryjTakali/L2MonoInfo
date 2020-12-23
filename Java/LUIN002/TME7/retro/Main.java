public class Main{

    public static void main(String args[]){
        Expression v1 = new Valeur(4.);
        Expression v2 = new Valeur(1.);
        Expression v3 = new Valeur(7.);
        Expression v4 = new Valeur(5.);
        Expression v5 = new Valeur(3.);
        Expression v6 = v5;
        Operation p1 = new Plus(v1, v2); 
        // Operation m2 = new Moins(v3,v4);
        // Operation mult = new Multiplie(p1, v5);
        // Operation p2 = new Plus(v6, mult);
        // Operation d = new Divise(v6, mult);
        // System.out.println(d + "=" + d.getVal());
    }
}