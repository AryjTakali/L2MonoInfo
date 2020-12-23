public class TestTriangle{

	public static void main(String args[]){
		Point A = new Point();
		Point B = new Point();
		Point C = new Point();
		Triangle t1 = new Triangle(A, B, C);
		Triangle t2 = new Triangle(A, B, C);
		Triangle t3 = new Triangle();

		System.out.println("A : " + A.toString());
		System.out.println("B : " + B.toString());
		System.out.println("C : " + C.toString());
		System.out.println("distance A - B: " );
		System.out.printf("%.2f\n", A.distance(B));
		System.out.println("distance A - C: " );
		System.out.printf("%.2f\n", A.distance(C));
		System.out.println("distance B - C: " );
		System.out.printf("%.2f\n", C.distance(B));
		System.out.println(t1.toString());
		System.out.println("Comparer t1 et t2");
		System.out.println("t1 : " + t1.toString());
		System.out.println("t2 : "+ t2.toString());
		System.out.println("t1 = t2 : " + t1.equals(t2));
		System.out.println("Comparer t1 et t3");
		System.out.println("t1 : " + t1.toString());
		System.out.println("t3 : "+ t3.toString());
		System.out.println("t1 = t3 : " + t1.equals(t3));
	
	}

}
