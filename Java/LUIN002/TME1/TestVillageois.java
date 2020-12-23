
public class TestVillageois{
	public static void main(String args[]){
		Villageois v1, v2, v3, v4;
		double poidsSouleveTotal, rocher1, rocher2;
		boolean canBeHold;

		v1 = new Villageois("Naruto");
		v2 = new Villageois("Hinata");
		v3 = new Villageois("Boruto");
		v4 = new Villageois("Himawari");
		poidsSouleveTotal = v1.poidsSouleve() + v2.poidsSouleve() + v3.poidsSouleve() + v4.poidsSouleve();
		rocher1 = 85.;
		rocher2 = 150.;

		System.out.println(v1.toString());
		System.out.println("\n" + v2.toString());
		System.out.println("\n" + v3.toString());
		System.out.println("\n" + v4.toString());
		System.out.printf("\nLes villageois peuvent soulever %.1f", poidsSouleveTotal);
		canBeHold = poidsSouleveTotal >= rocher1; 
		System.out.printf("\nLe rocher 1 %s car %.1f %s %.1f  %s", canBeHold ? "peut etre souleve" : "ne peut pas etre soulever", poidsSouleveTotal, canBeHold ? ">" : "<",  rocher1, canBeHold ? ":)" : ":(");
		canBeHold = poidsSouleveTotal >= rocher2; 
		System.out.printf("\nLe rocher 2 %s car %.1f %s %.1f  %s", canBeHold ? "peut etre souleve" : "ne peut pas etre soulever", poidsSouleveTotal, canBeHold ? ">" : "<",  rocher2, canBeHold ? ":)" : ":(");
		

	}
}
