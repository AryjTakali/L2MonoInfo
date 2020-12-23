import java.util.*;

public class Nom{
	public static final char[] consonnes = "zrtpqsdfghjklmwxcvbn".toCharArray();
	public static final char[] voyelles = {'a', 'i', 'u', 'e', 'o', 'y'};

	private Nom(){}

	public static int rendAlea(int inf, int sup){
		Random r = new Random();
		return r.nextInt(sup - inf + 1) + inf;
	}

	public static boolean estPair(int n){
		return n % 2 == 0;
	}

	public static char rendVoyelles(){
		return voyelles[rendAlea(0, voyelles.length-1)];
	}

	public static char rendConsonnes(){
		return consonnes[rendAlea(0, consonnes.length - 1)];
	}

	public static String genererNom(){
		boolean button = true;
		int nb = rendAlea(3,6);
		String ret = "";

		for (int i = 0; i <= nb; i++){
			ret += button ? Nom.rendVoyelles() : Nom.rendConsonnes();	
			button = !button;
		}	
		return ret;
	}
	

}
