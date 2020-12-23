
public class Villageois{
	String nom;
	double poids;
	boolean malade;

	public Villageois(String nomVillageois){
		nom = nomVillageois;
		poids = Math.round((Math.random() * 100 + 50) * 10);
		poids /= 10;
		if (Math.random() <  0.20)
			malade = true;
		else
			malade = false;
	}

	public String getNom(){
		return nom;
	}

	public double getPoids(){
		return poids;
	}

	public boolean getMalade(){
		return malade;
	}

	public String toString(){
		String ret = "Ce villageois est " + getNom() + ", poids : " + getPoids() + "kg, malade : ";
		ret +=  getMalade() ? " oui, " : " non, ";
		ret += "poids souleve : " + poidsSouleve() + " kg\n";
		return ret;
	}

	public double poidsSouleve(){
		if (malade)
			return poids / 4;
		else
			return poids / 3;
	}
}
