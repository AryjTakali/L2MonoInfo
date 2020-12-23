public class TestTrianglePascal {
    public static void main(String args[]){
        TrianglePascal t0 = new TrianglePascal(-1);//int non valide
        TrianglePascal t1 = new TrianglePascal();
        TrianglePascal t2 = new TrianglePascal(10);
    
        t1.remplirTriangle();
        System.out.print(t1.toString());
        t2.remplirTriangle();
        System.out.print(t2.toString());
        System.out.print(t0.toString());
    }
}