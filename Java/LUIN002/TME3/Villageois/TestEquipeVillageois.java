public class TestEquipeVillageois{

    public static void test(){
        Villageois[] v = new Villageois[10];
		double poidsSouleveTotal, rocher = 150;

		v[0] = new Villageois("Naruto");
		v[1] = new Villageois("Hinata");
		v[2] = new Villageois("Boruto");
        v[3] = new Villageois("Himawari");
        v[4] = new Villageois("Himawari");
        v[5] = new Villageois("Kushina");
        v[6] = new Villageois("Minato");
        Equipe e1 = new Equipe("parents");
        Equipe e2 = new Equipe("enfants");
        Equipe e3 = new Equipe("famille");

        e1.embaucher(v[0]);
        e1.embaucher(v[1]);
        e2.embaucher(v[2]);
        e2.embaucher(v[3]);
        e3.embaucher(e1);
        e3.embaucher(e2);
        e3.embaucher(v[5]);
        e3.embaucher(v[6]);

		System.out.println(e1.toString());
        System.out.println("L'equipe peut soulever le rocher de : " + rocher + " : " + e1.peutSoulever(rocher) + "\n\n");
		System.out.println(e2.toString());
        System.out.println("L'equipe peut soulever le rocher de : " + rocher + " : " + e2.peutSoulever(rocher)+ "\n\n");
        System.out.println(e3.toString());
        System.out.println("L'equipe peut soulever le rocher de : " + rocher + " : " + e3.peutSoulever(rocher)+ "\n\n");
        
		// System.out.printf("\nLe rocher 1 %s car %.1f %s %.1f  %s", canBeHold ? "peut etre souleve" : "ne peut pas etre soulever", poidsSouleveTotal, canBeHold ? ">" : "<",  rocher1, canBeHold ? ":)" : ":(");
		// canBeHold = poidsSouleveTotal >= rocher2; 
		// System.out.printf("\nLe rocher 2 %s car %.1f %s %.1f  %s", canBeHold ? "peut etre souleve" : "ne peut pas etre soulever", poidsSouleveTotal, canBeHold ? ">" : "<",  rocher2, canBeHold ? ":)" : ":(");
		
    }
    public static void main(String args[]){
        test();
    }


}