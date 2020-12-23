
public class Libelle {
	int nb;
	int mille, cent, dix, unite;

	public Libelle(int nbr) {
		nb = nbr;
	}

	public String toUnite(int n) {
		int comp = 0;
		String ret = "";

		if (n == 1)
			comp = unite;
		else if (n == 100)
			comp = cent;
		else if (n == 1000)
			comp = mille;

		if (n != 1 || (dix != 1 && dix != 7 && dix != 9)) {
			if (n == 1 && dix == 0 && (cent != 0 || mille != 0))
				ret += " ";
			if (comp == 1 && n == 1) {
				if (dix != 0 && n == 1)
					ret += " et ";
				ret += "un";
			}
			if (comp == 2)
				ret += "deux";
			if (comp == 3)
				ret += "trois";
			if (comp == 4)
				ret += "quatre";
			if (comp == 5)
				ret += "cinq";
			if (comp == 6)
				ret += "six";
		}
		if (comp == 7)
			ret += "sept";
		if (comp == 8)
			ret += "huit";
		if (comp == 9)
			ret += "neuf";
		if ((n == 100 && cent != 1 && cent != 0))
			ret += " ";
		return ret;
	}

	public String toDizaine() {

		String dizaine = "";

		if (mille != 0 || cent != 0)
			dizaine += " ";
		if (dix == 2)
			dizaine += "vingt";
		if (dix == 3)
			dizaine += "trente";
		if (dix == 4)
			dizaine += "quarante";
		if (dix == 5)
			dizaine += "cinquante";
		if (dix == 6 || dix == 7)
			dizaine += "soixante";
		if (dix == 8 || dix == 9) {
			dizaine += "quatre-vingt";
			if (dix == 8 && unite == 0)
				dizaine += "s";
		}
		if (dix > 1 && unite > 1)
			dizaine += "-";
		else if (cent > 0 || mille > 0)
			dizaine += " ";

		if (dix == 1 || dix == 7 || dix == 9) {
			if (unite == 1)
				dizaine += "onze";
			else if (unite == 2)
				dizaine += "douze";
			else if (unite == 3)
				dizaine += "treize";
			else if (unite == 4)
				dizaine += "quatorze";
			else if (unite == 5)
				dizaine += "quinze";
			else if (unite == 6)
				dizaine += "seize";
			else {
				dizaine += "dix";
				if (unite == 7 || unite == 8 || unite == 9)
					dizaine += "-" + toUnite(1);
			}
			return dizaine;
		} else
			return dizaine + toUnite(1);
	}

	public String traduction() {
		String nombre = "";
		mille = nb / 1000;
		nb %= 1000;
		cent = nb / 100;
		nb %= 100;
		dix = nb / 10;
		nb %= 10;
		unite = nb;

		if (mille == 0 && cent == 0 && dix == 0 && unite == 0)
			return "zero";
		if (mille > 0)
			nombre = toUnite(1000) + "mille ";
		if (cent > 0) {
			nombre += toUnite(100) + "cent";
			if (cent > 1 && dix == 0 && unite == 0)
				nombre += "s";
		}
		if (dix > 0)
			nombre += toDizaine();
		else
			nombre += toUnite(1);
		return nombre;
	}

	public static void main(String args[]) {
		Libelle nb1 = new Libelle(31);

		System.out.println(nb1.traduction());
	}
}