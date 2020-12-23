public class TestCones{
	public static void main(String args[]){
		
		System.out.println("nombre de Cones : " + Cone.getNbCones());
		System.out.println("\nCreation des 2 instances de cones :");
		Cone c1 = new Cone();
		System.out.println(c1.toString());
		Cone c2 = new Cone(5.4,7.2);
		System.out.println(c2.toString());
		System.out.println("nombre de Cones : " + Cone.getNbCones());
	}

}
