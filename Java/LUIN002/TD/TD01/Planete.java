public class Planete{

	private String nom ;
	private double rayon ; // en k i l o m e t r e

	public Planete(String n , double r){
		nom = n ;
		rayon = r ;
	}

	public Planete(String n){
		nom = n;
		rayon = 1000.;
	}

	public String toString() {
		String s = " Planete " + nom ;
		s += " de rayon " + rayon ;
		return s ;
	}

	public double getRayon () {
		return rayon ;
	}
	
	public static void main(String args[]){
		Planete mercure = new Planete("Mercure", 2439.7);
		Planete terre = new Planete("Terre", 6378.137);
		Planete meteore = new Planete("ajax"); 

		System.out.println(mercure.toString());
		System.out.println(terre.getRayon());
		System.out.println(meteore.toString());
	
	}
}
