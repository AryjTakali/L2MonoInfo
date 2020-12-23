
public class TestSegment{

	public static void main(String args[]){
		Segment seg1 = new Segment(6, 8);
		Segment seg2 = new Segment(12, 5);
		
		if (seg1.longueur() == seg2.longueur())
			System.out.println(seg1.toString() + " et " + seg1.toString() + "sont de la meme taille" );
		else if (seg1.longueur() > seg2.longueur()){
			System.out.println(seg1.toString() + " est plus long que " + seg1.toString());
			System.out.printf( "En effet: %d > %d", seg1.longueur(), seg2.longueur());
		}
		else if (seg1.longueur() < seg2.longueur()){
			System.out.println(seg2.toString() + " est plus long que " + seg1.toString());
			System.out.printf( "En effet: %d > %d", seg2.longueur(), seg1.longueur());
		}
	}
}
